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

import com.tylerhyperHD.FreedomHostingMod.Commands.Command_ban;
import com.tylerhyperHD.FreedomHostingMod.Commands.Command_fhm;
import com.tylerhyperHD.FreedomHostingMod.Commands.Command_purple;
import com.tylerhyperHD.FreedomHostingMod.Listeners.Freedom_PlayerListen;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class FreedomHostingMod extends JavaPlugin {
    
    public static FreedomHostingMod plugin;
    File configFile;
    public static FileConfiguration config;
    FileConfiguration groups;
    FileConfiguration history;
    public static List<String> ownernames;
    
    // Command runs through service
    public Command_ban ban;
    public Command_fhm fhm;
    public Command_purple purple;
    
    @Override
    public void onLoad() {
        FreedomHostingMod.plugin = this;
        fhm = new Command_fhm(this);
//        ban = new Command_ban(this);
    }
    
    @Override
    public void onEnable() {
        long l = System.currentTimeMillis();
        final int startup = (int) l;
        configFile = new File(getDataFolder(), "config.yml");
        try {
            firstRun();
        } catch (Exception ex) {
            F_Log.severe(ex);
        }
        config = new YamlConfiguration();
        loadYamls();
        ownernames = this.getConfig().getStringList("server_owners");
        F_Log.info("FreedomHostingMod by tylerhyperHD");
        F_Log.info("Made for " + config.getString("server_name") + ", an all-op server.");
        
        if (F_Debug.isDebugOn()) {
            F_Log.info("Starting up listeners...");
        }
        Bukkit.getServer().getPluginManager().registerEvents(new Freedom_PlayerListen(), plugin);
        if (F_Debug.isDebugOn()) {
            F_Log.info("Calculating time taken to start...");
        }
        long y = System.currentTimeMillis();
        final int finish = (startup - (int) y) / 1000;
        F_Log.info("Startup finished in " + finish + " seconds");
    }
    
    private void firstRun() throws Exception {
        if (!configFile.exists()) {
            configFile.getParentFile().mkdirs();
            copy(getResource("config.yml"), configFile);
        }
    }
    
    @SuppressWarnings("ConvertToTryWithResources")
    private void copy(InputStream in, File file) {
        try {
            OutputStream out = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            out.close();
            in.close();
        } catch (Exception ex) {
            F_Log.severe(ex);
        }
    }
    
    @Override
    public void onDisable() {
        saveYamls();
    }
    
    public void saveYamls() {
        try {
            config.save(configFile);
        } catch (IOException ex) {
            F_Log.severe(ex);
        }
    }
    
    public void loadYamls() {
        try {
            config.load(configFile);
        } catch (IOException | InvalidConfigurationException ex) {
            F_Log.severe(ex);
        }
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        final Player sender_p = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("fhm")) {
            return fhm.runCommand(sender, sender_p, cmd, label, args);
        }
//        else if (cmd.getName().equalsIgnoreCase("ban")) {
//            ban.runCommand(sender, sender_p, cmd, label, args);
//        }
        else if (cmd.getName().equalsIgnoreCase("purple")) {
            return purple.runCommand(sender, sender_p, cmd, label, args);
        }
        
        return false;
    }
}
