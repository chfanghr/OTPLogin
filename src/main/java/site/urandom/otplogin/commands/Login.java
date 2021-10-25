package site.urandom.otplogin.commands;

import com.bastiaanjansen.otp.TOTPGenerator;
import com.google.zxing.WriterException;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.*;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import site.urandom.otplogin.commands.grammars.OTPLoginRulesBaseListener;
import site.urandom.otplogin.commands.grammars.OTPLoginRulesLexer;
import site.urandom.otplogin.commands.grammars.OTPLoginRulesParser;
import site.urandom.otplogin.listeners.CommandBlocker;
import site.urandom.otplogin.models.LoginSecret;
import site.urandom.otplogin.models.PlayerApproved;
import site.urandom.otplogin.models.VerificationRequired;
import site.urandom.otplogin.models.serializers.LoginSecretDataType;
import site.urandom.otplogin.models.serializers.PlayerApprovedDataType;
import site.urandom.otplogin.models.serializers.VerificationRequiredDataType;
import site.urandom.otplogin.utils.QRCodeUtils;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;

public class Login implements CommandExecutor {
    private final JavaPlugin plugin;
    private final CommandBlocker commandBlocker;

    public Login(JavaPlugin plugin) {
        this.plugin = plugin;
        commandBlocker = new CommandBlocker(plugin, new HashSet<>(Collections.singletonList("otp")));
        Bukkit.getPluginManager().registerEvents(commandBlocker, plugin);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        String input = String.join(" ", args);
        OTPLoginRulesLexer lexer = new OTPLoginRulesLexer(CharStreams.fromString(input));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        OTPLoginRulesParser parser = new OTPLoginRulesParser(tokenStream);

        ParseTree tree = parser.subcommand();
        ParseTreeWalker walker = new ParseTreeWalker();
        CommandHandler handler = new CommandHandler(plugin, sender);
        walker.walk(handler, tree);

        return handler.noUnexpectedError();
    }


    class CommandHandler extends OTPLoginRulesBaseListener {
        private final JavaPlugin plugin;
        private final CommandSender sender;

        public boolean noUnexpectedError() {
            return !unexpectedError;
        }

        private boolean unexpectedError = false;

        public CommandHandler(JavaPlugin plugin, CommandSender sender) {
            this.plugin = plugin;
            this.sender = sender;
        }

        private Player getPlayer() {
            return (Player) sender;
        }

        private boolean isPlayer() {
            return sender instanceof Player;
        }

        private boolean requirePlayer() {
            if (!isPlayer()) {
                sender.sendMessage(ChatColor.RED + "This command can only be executed by player");
                return false;
            }
            return true;
        }

        private PersistentDataContainer getPlayerDataContainer() {
            return getPlayer().getPersistentDataContainer();
        }

        private boolean isAccountApproved() {
            return getPlayerDataContainer().has(PlayerApproved.getPersistentKey(plugin),
                    PlayerApprovedDataType.getInstance());
        }

        private boolean doesSecretExist() {
            return getPlayerDataContainer().has(LoginSecret.getPersistentKey(plugin),
                    LoginSecretDataType.getInstance());
        }

        private void storeSecret(LoginSecret secret) {
            getPlayerDataContainer().set(LoginSecret.getPersistentKey(plugin),
                    LoginSecretDataType.getInstance(), secret);
        }

        private boolean isVerificationRequired() {
            return getPlayerDataContainer().has(VerificationRequired.getPersistentKey(plugin),
                    VerificationRequiredDataType.getInstance());
        }

        private void storeVerificationRequired() {
            getPlayerDataContainer().set(VerificationRequired.getPersistentKey(plugin),
                    VerificationRequiredDataType.getInstance(), new VerificationRequired());
        }

        private void removeVerificationRequired() {
            getPlayerDataContainer().remove(VerificationRequired.getPersistentKey(plugin));
        }

        private LoginSecret getSecret() {
            return getPlayerDataContainer().get(
                    LoginSecret.getPersistentKey(plugin),
                    LoginSecretDataType.getInstance());
        }

        @Override
        public void exitSetup(OTPLoginRulesParser.SetupContext ctx) {
            if (!requirePlayer())
                return;

            if (!isAccountApproved()) {
                String playerId = getPlayer().getUniqueId().toString();

                BaseComponent[] components = new
                        ComponentBuilder("Your account should be approved by one of the operators.").color(ChatColor.RED)
                        .append("Request approval with your uuid: ").color(ChatColor.RED)
                        .append(new TextComponent(playerId))
                        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Click to copy")))
                        .event(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, playerId))
                        .color(ChatColor.GREEN)
                        .create();

                getPlayer().spigot().sendMessage(components);
                getPlayer().sendMessage("Please stay online for operator to approve your account.");
                return;
            }

            if (doesSecretExist()) {
                getPlayer().sendMessage(ChatColor.RED + "You had already setup the otp. use /otp login to login");
                return;
            }

            LoginSecret secret = new LoginSecret();
            TOTPGenerator generator = secret.getTOTPGenerator();

            URI otpURI;
            List<String> image;

            try {
                otpURI = generator.getURI(Bukkit.getServer().getName(), getPlayer().getName());
                image = QRCodeUtils.URI2ASCIIQRCode(otpURI);
            } catch (URISyntaxException exception) {
                plugin.getLogger().log(Level.SEVERE, "Cannot create otp uri");
                exception.printStackTrace();
                unexpectedError = true;
                return;
            } catch (WriterException exception) {
                plugin.getLogger().log(Level.SEVERE, "Cannot create qr code");
                exception.printStackTrace();
                unexpectedError = true;
                return;
            }

            for (String row: image) {
                getPlayer().sendMessage(row);
            }

            String secretStr = new String(secret.secret, StandardCharsets.UTF_8);

            getPlayer().sendMessage("Scan the QR code above using an otp app, like Authy/Raivo otp");
            getPlayer().sendMessage("Or setup your otp app manually:");
            getPlayer().spigot().sendMessage(new ComponentBuilder()
                    .append("Secret:")
                    .append(secretStr).color(ChatColor.GREEN)
                    .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Click to copy")))
                    .event(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, secretStr))
                    .create());
            getPlayer().sendMessage("Algorithm: SHA256");
            getPlayer().sendMessage("Then verify using this command: /otp verify <otp code>");

            storeSecret(secret);
            storeVerificationRequired();
        }

        private boolean checkSecret() {
            if (!doesSecretExist()) {
                getPlayer().sendMessage(ChatColor.RED + "Setup the otp using command /otp setup first");
                return false;
            }
            return true;
        }

        @Override
        public void exitVerify(OTPLoginRulesParser.VerifyContext ctx) {
            if (!requirePlayer()) return;

            if (!checkSecret())
                return;

            if (!isVerificationRequired()) {
                getPlayer().sendMessage(ChatColor.RED + "Your otp had been verified already.");
                getPlayer().sendMessage(ChatColor.RED + "Login using command: /otp login <code>");
                return;
            }

            TOTPGenerator generator = getSecret().getTOTPGenerator();
            String userGivenCode = ctx.code.getText();
            if (generator.verify(userGivenCode)) {
                getPlayer().sendMessage(ChatColor.GREEN + "OTP verified!");
                getPlayer().sendMessage("Now you can login using command: /otp login <code>");
                removeVerificationRequired();
            } else {
                getPlayer().sendMessage(ChatColor.RED + "Wrong otp code, verification failed");
            }
        }

        @Override
        public void exitLogin(OTPLoginRulesParser.LoginContext ctx) {
            if (!requirePlayer())
                return;

            if (!checkSecret())
                return;

            if (isVerificationRequired()) {
                getPlayer().sendMessage(ChatColor.RED + "Verify using command /otp verify <code> first");
                return;
            }

            TOTPGenerator generator = getSecret().getTOTPGenerator();
            String userGivenCode = ctx.code.getText();
            if (generator.verify(userGivenCode)) {
                // TODO: login
                commandBlocker.removePlayer(getPlayer());
                getPlayer().sendMessage(ChatColor.GREEN + "Welcome " + getPlayer().getName());
            } else {
                getPlayer().sendMessage(ChatColor.RED + "Bad otp. Please try again.");
            }
        }
    }
}
