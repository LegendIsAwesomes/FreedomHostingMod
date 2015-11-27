/*
 * Copyright 2015 tylerhyperHD
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tylerhyperHD.FreedomHostingMod.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class F_Command {
    
    
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
