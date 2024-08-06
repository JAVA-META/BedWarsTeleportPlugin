package com.example;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class BedWarsTeleportPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("BedWarsTeleportPlugin has been enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("BedWarsTeleportPlugin has been disabled.");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("pvp")) {
            if (args.length > 0 && args[0].equalsIgnoreCase("start")) {
                if (sender instanceof Player) {
                    Player player = (Player) sender;
                    Location pvpLocation = new Location(Bukkit.getWorld("world"), 10000, 100, 10000);
                    player.teleport(pvpLocation);
                    player.sendMessage("§a你已被传送到 PvP 区域。");
                } else {
                    sender.sendMessage("§c此命令只能由玩家执行。");
                }
                return true;
            }
        }
        return false;
    }
}
