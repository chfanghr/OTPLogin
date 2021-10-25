package site.urandom.otplogin.models;

import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.Serializable;

public class PlayerApproved implements Serializable {
    private static final long serialVersionUID = 1;

    private static final String persistentKey = PlayerApproved.class.getName();

    public static NamespacedKey getPersistentKey(JavaPlugin plugin){
        return new NamespacedKey(plugin, persistentKey);
    }
}
