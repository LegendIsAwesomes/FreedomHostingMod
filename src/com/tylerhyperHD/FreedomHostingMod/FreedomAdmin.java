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

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class FreedomAdmin {
    
    private static FileConfiguration configuration;
    
    public FreedomAdmin() {
        FreedomHostingMod.plugin.config = configuration;
    }
    
    public static boolean isOwner(Player player) {
        if(player.getName().contains(configuration.getString("server_owners"))) {
            F_Log.info("Owner joined the game, config is correct.");
            return true;
        }
        else {
            return false;
        }
    }
    
}
