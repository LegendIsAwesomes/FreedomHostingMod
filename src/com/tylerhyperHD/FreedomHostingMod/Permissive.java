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
package com.tylerhyperHD.FreedomHostingMod;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerLoginEvent;

public class Permissive { 
    public static void onPlayerLogin(PlayerLoginEvent event) {
        final Player player = event.getPlayer();
        final String username = player.getName();
        final String ip = event.getAddress().getHostAddress().trim();
        
        for (String testIp : FreedomHostingMod.permbannedIps) {
            if (FreedomHostingMod.fuzzyIpMatchHandler(testIp, ip, 4)) {
                event.disallow(PlayerLoginEvent.Result.KICK_OTHER, ChatColor.RED + "You have been hardcoded to a permban list, fuck off you twat.");
                return;
            }
        }
    }
}
