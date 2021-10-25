package site.urandom.otplogin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import site.urandom.otplogin.commands.Approve;
import site.urandom.otplogin.commands.Login;

public final class OTPLogin extends JavaPlugin {
    private static OTPLogin instance;

    public OTPLogin getInstance() {
        return instance;
    }

    private Login login;
    private Approve approve;

    @Override
    public void onEnable() {
        instance = this;

        login = new Login(this);
        approve = new Approve(this);

        Bukkit.getPluginCommand("otp").setExecutor(login);
        Bukkit.getPluginCommand("otpapprove").setExecutor(approve);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
