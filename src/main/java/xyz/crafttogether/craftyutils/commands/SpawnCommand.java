package xyz.crafttogether.craftyutils.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import xyz.crafttogether.craftcore.minecraft.utils.WarmupHandler;

public class SpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (!(commandSender instanceof Player player)) {
            commandSender.sendMessage(ChatColor.RED + "You must run this command as a player");
            return true;
        }
        player.sendMessage(ChatColor.GREEN + "Please stand still for 5 seconds...");
        WarmupHandler.schedule(player.getUniqueId(), 5, (successful) -> {
            if (successful) {
                World world = Bukkit.getWorld("world");
                assert world != null;
                player.teleport(world.getSpawnLocation());
                player.sendMessage(ChatColor.GREEN + "Successfully teleported you to spawn");
            } else {
                player.sendMessage(ChatColor.RED + "You have moved, warmup cancelled");
            }
        });
        return true;
    }
}
