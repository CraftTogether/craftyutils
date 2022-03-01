package xyz.crafttogether.craftyutils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CraftyUtils extends JavaPlugin {
    private static final Logger logger = LoggerFactory.getLogger(CraftyUtils.class);
    private static JavaPlugin plugin;

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "CraftyUtils enabled");
        plugin = this;
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "CraftyUtils disabled");
    }

    public static JavaPlugin getPlugin() {
        return plugin;
    }
}
