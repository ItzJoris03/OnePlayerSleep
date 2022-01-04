package me.itzjoris03.oneplayersleep;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public final class OnePlayerSleep extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        String prefix = "OnePlayerSleep";
        prefix = ChatColor.GREEN + "[" + ChatColor.WHITE + prefix + ChatColor.GREEN + "] ";
        String message = "OnePlayerSleep has started!";
        getServer().getConsoleSender().sendMessage(prefix + ChatColor.AQUA + message);

        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onBedEnter(PlayerBedEnterEvent e) {
        Player player = e.getPlayer();
        World world = player.getWorld();
        if(!e.isCancelled()) {
            String message = player.getDisplayName() + " went to bed. Goodnight!";
            Bukkit.broadcastMessage(ChatColor.YELLOW + message);
            new BukkitRunnable() {

                @Override
                public void run() {
                    world.setTime(0);
                }

            }.runTaskLater(this, 101);
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        String prefix = "OnePlayerSleep";
        prefix = ChatColor.GREEN + "[" + ChatColor.WHITE + prefix + ChatColor.GREEN + "] ";
        String message = "OnePlayerSleep has stopped!";
        getServer().getConsoleSender().sendMessage(prefix + ChatColor.AQUA + message);
    }
}
