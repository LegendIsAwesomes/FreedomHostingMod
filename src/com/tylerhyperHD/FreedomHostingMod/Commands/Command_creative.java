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
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import static org.bukkit.Bukkit.getPlayer;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Command_creative extends C_Command implements CommandExecutor {
    
    private final FreedomHostingMod plugin;

    public Command_creative(FreedomHostingMod plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
        final Player player = getPlayer(args[0]);
        
        if (F_Debug.isDebugOn()) {
            F_Log.info("Server ran command successfully");
        }
        Bukkit.broadcastMessage(ChatColor.AQUA + sender.getName() + "has changed his gamemode to creative.");
        player.setGameMode(GameMode.CREATIVE);
    
    
    
        return true;
    }
}
