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

import com.tylerhyperHD.FreedomHostingMod.F_Debug;
import com.tylerhyperHD.FreedomHostingMod.F_Log;
import com.tylerhyperHD.FreedomHostingMod.FreedomHostingMod;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_opall extends C_Command implements CommandExecutor {
        
    private final FreedomHostingMod plugin;

    public Command_opall(FreedomHostingMod plugin) {
        this.plugin = plugin;
    }
    
     @Override
    public boolean onCommand(CommandSender sender, Command command, String string, String[] args) {
            if (!(sender instanceof Player)) {
            senderMsg("You must be a player to execute this command.", sender);
            return true;
        }
            
            if (F_Debug.isDebugOn()) {
            F_Log.info("Server ran command successfully");
        }
            Bukkit.broadcastMessage(ChatColor.AQUA + "Opping all current online players.");
            
            boolean doChangeGamemode = false;
            GameMode playerGamemode = GameMode.CREATIVE;
            
            if (args[0].equals("-c"))
            {
                doChangeGamemode = true;
                playerGamemode = GameMode.CREATIVE;
            }
            
            else if (args[0].equals("-s"))
            {
                doChangeGamemode = true;
                playerGamemode = GameMode.SURVIVAL;
            }
            
            else if (args[0].equals("-a"))
            {
                doChangeGamemode = true;
                playerGamemode = GameMode.ADVENTURE;
            }
            
            for (Player player : Bukkit.getOnlinePlayers())
            {
                player.setOp(true);
                player.sendMessage(ChatColor.YELLOW + "You have been opped!");
                
                if (doChangeGamemode)
                {
                    player.setGameMode(playerGamemode);
                }
                
        }
        return true;
    }         
}
