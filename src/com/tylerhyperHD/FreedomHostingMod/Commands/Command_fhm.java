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

import com.tylerhyperHD.FreedomHostingMod.FreedomHostingMod;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_fhm extends F_Command {

    public FreedomHostingMod plugin;

    public Command_fhm(FreedomHostingMod plugin) {
        this.plugin = plugin;
    }

    public boolean runCommand(CommandSender sender, Player sender_p, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            senderMsg("You must be a player to execute this command.", sender);
        }

        senderMsg(ChatColor.GREEN + "FreedomHostingMod developed and written by tylerhyperHD", sender);

        return true;
    }
}
