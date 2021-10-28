package site.urandom.otplogin.listeners;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;

public class CommandBlocker implements Listener {
    private JavaPlugin plugin;

    private final Set<Player> affectedPlayers = new HashSet<>();
    private final Set<String> commandWhitelist;

    public CommandBlocker(JavaPlugin plugin, Set<String> commandWhitelist) {
        this.plugin = plugin;
        this.commandWhitelist = commandWhitelist;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onCommand(PlayerCommandPreprocessEvent event){
        String command = event.getMessage().split(" ")[0].substring(1);
        if(!commandWhitelist.contains(command) && affectedPlayers.contains(event.getPlayer())){
            event.setCancelled(true);
        }
    }

    public void addPlayer(Player player){
        affectedPlayers.add(player);
    }

    public void removePlayer(Player player){
        affectedPlayers.remove(player);
        player.setGameMode(GameMode.SURVIVAL);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerDisconnect(PlayerQuitEvent event){
        affectedPlayers.remove(event.getPlayer());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoin(PlayerJoinEvent event){
        affectedPlayers.add(event.getPlayer());
        event.getPlayer().sendMessage(ChatColor.YELLOW + "Please login using /otp login <code>");
        Bukkit.getScheduler().runTaskLater(plugin, () -> event.getPlayer().setGameMode(GameMode.SPECTATOR), 3L);
    }
}
