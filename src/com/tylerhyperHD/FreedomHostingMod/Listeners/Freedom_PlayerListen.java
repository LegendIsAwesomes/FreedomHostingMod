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
package com.tylerhyperHD.FreedomHostingMod.Listeners;

import com.tylerhyperHD.FreedomHostingMod.F_Debug;
import com.tylerhyperHD.FreedomHostingMod.F_Log;
import com.tylerhyperHD.FreedomHostingMod.FreedomAdmin;
import com.tylerhyperHD.FreedomHostingMod.Permissive;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;

public class Freedom_PlayerListen implements Listener {
    
    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        final String ip = player.getAddress().getAddress().getHostAddress().trim();
        
        
        if (FreedomAdmin.isOwner(player)) {
            if (F_Debug.isDebugOn()) {
                F_Log.info("Owner joined the game");
            }
            // Commented out due to testing with another server
            // Bukkit.broadcastMessage(player.getName + " is the Owner of " + FreedomHostingMod.config.getString("server_name"));
        }
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerLoginEvent(PlayerLoginEvent event) {
        Permissive.onPlayerLogin(event);
    }
}
