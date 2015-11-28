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
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_smite extends C_Command implements CommandExecutor {

    private final FreedomHostingMod plugin;

    public Command_smite(FreedomHostingMod plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {

        if (F_Debug.isDebugOn()) {
            F_Log.info("Server ran command successfully");
        }

        if (!(sender instanceof Player)) {
            senderMsg("You must be in-game to use this command.", sender);
            return true;
        }

        if (args.length == 0) {
            senderMsg("Usage: /smite <player> <reason>", sender);
            return true;
        }
        else if (args.length == 1) {
            Player player = Bukkit.getPlayer(args[0]);
            Bukkit.broadcastMessage(ChatColor.RED + player.getName() + " has been naughty.");
            Bukkit.broadcastMessage(ChatColor.RED + "They have thus been smitten!");
            
            final Location targetPos = player.getLocation();
            final World world = player.getWorld();
            for (int x = -1; x <= 1; x++) {
                for (int z = -1; z <= 1; z++) {
                    final Location strike_pos = new Location(world, targetPos.getBlockX() + x, targetPos.getBlockY(), targetPos.getBlockZ() + z);
                    world.strikeLightning(strike_pos);
                }
            }
            
            player.setGameMode(GameMode.SURVIVAL);
            player.getInventory().clear();
            player.setHealth(0.0);
        }
        else if (args.length > 1) {
            final String reason = StringUtils.join(ArrayUtils.subarray(args, 1, args.length), " ");
            Player player = Bukkit.getPlayer(args[0]);

            Bukkit.broadcastMessage(ChatColor.RED + player.getName() + " has been naughty.");
            Bukkit.broadcastMessage(ChatColor.RED + "They have thus been smitten!");
            Bukkit.broadcastMessage(ChatColor.GOLD + "Reason: " + reason);
            
            

            final Location targetPos = player.getLocation();
            final World world = player.getWorld();
            for (int x = -1; x <= 1; x++) {
                for (int z = -1; z <= 1; z++) {
                    final Location strike_pos = new Location(world, targetPos.getBlockX() + x, targetPos.getBlockY(), targetPos.getBlockZ() + z);
                    world.strikeLightning(strike_pos);
                }
            }
            
            player.setGameMode(GameMode.SURVIVAL);
            player.getInventory().clear();
            player.setHealth(0.0);
        }
        return true;
    }
}
