package com.tylerhyperHD.FreedomHostingMod.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;

public abstract class C_Command {
    
    public void playerMsg(String args, Player player) {
        player.sendMessage(args);
    }
    
    public void senderMsg(String args, CommandSender sender) {
        sender.sendMessage(args);
    }
    
    public static void broadMessage(String message, ChatColor color) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendMessage((color == null ? "" : color) + message);
        }
    }
    
    public static void utilityAction(String adminName, String action, boolean isRed) {
        broadMessage(adminName + " - " + action, (isRed ? ChatColor.RED : ChatColor.AQUA));
    }
}