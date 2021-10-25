package site.urandom.otplogin.commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import site.urandom.otplogin.models.LoginSecret;
import site.urandom.otplogin.models.PlayerApproved;
import site.urandom.otplogin.models.VerificationRequired;
import site.urandom.otplogin.models.serializers.PlayerApprovedDataType;

import java.util.UUID;

public class Approve implements CommandExecutor {
    private final JavaPlugin plugin;

    public Approve(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(args.length==1){
            UUID playerId = UUID.fromString(args[0]);
            if(sender instanceof Player && !((Player)sender).isOp()){
                sender.sendMessage(ChatColor.RED+"Only OPs have permission to execute this command.");
                return false;
            }

            OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(playerId);
            Player player = offlinePlayer.getPlayer();
            if(player != null){
                if(player.getPersistentDataContainer().has(PlayerApproved.getPersistentKey(plugin), PlayerApprovedDataType.getInstance())){
                    player.getPersistentDataContainer().remove(PlayerApproved.getPersistentKey(plugin));
                    player.getPersistentDataContainer().remove(LoginSecret.getPersistentKey(plugin));
                    player.getPersistentDataContainer().remove(VerificationRequired.getPersistentKey(plugin));

                    sender.sendMessage(String.format(ChatColor.GREEN + "Player %s(%s) unapproved",
                            player.getPlayerListName(), playerId));

                    player.kickPlayer("Account unapproved");


                    return true;
                }
                player.getPersistentDataContainer().set(PlayerApproved.getPersistentKey(plugin),
                        PlayerApprovedDataType.getInstance(), new PlayerApproved());

                sender.sendMessage(String.format(ChatColor.GREEN + "Player %s(%s) approved",
                        player.getPlayerListName(), playerId));
            }else{
                sender.sendMessage(ChatColor.RED+"Player is not online");
                return false;
            }

            return true;
        }

        sender.sendMessage(ChatColor.RED + "invalid arguments");
        return false;
    }
}
