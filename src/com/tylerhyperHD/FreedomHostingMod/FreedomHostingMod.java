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
import com.tylerhyperHD.FreedomHostingMod.Commands.Command_opall;
import com.tylerhyperHD.FreedomHostingMod.Commands.Command_purple;
import com.tylerhyperHD.FreedomHostingMod.Commands.Command_smite;
import static com.tylerhyperHD.FreedomHostingMod.F_HardcodeBanList.HARDCODE;
import static com.tylerhyperHD.FreedomHostingMod.F_HardcodeBanList.HARDCODE_IPS;
import com.tylerhyperHD.FreedomHostingMod.Listeners.Freedom_PlayerListen;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class FreedomHostingMod extends JavaPlugin {

    public static FreedomHostingMod plugin;
    File configFile;
    public static FileConfiguration config;
    FileConfiguration groups;
    FileConfiguration history;
    public static List<String> ownernames;
    public static final List<String> permbannedNames = HARDCODE;
    public static final List<String> permbannedIps = HARDCODE_IPS;

    @Override
    public void onLoad() {
        FreedomHostingMod.plugin = this;
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
        this.register();
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

    /* Publicly used code */
    public static String getFuzzyIpAddressHandler(String ip) {
        final String[] ipParts = ip.split("\\.");
        if (ipParts.length == 4) {
            return String.format("%s.%s.*.*", ipParts[0], ipParts[1]);
        }

        return ip;
    }

    /* Publicly used code */
    public static boolean fuzzyIpMatchHandler(String a, String b, int octets) {
        boolean match = true;

        String[] aParts = a.split("\\.");
        String[] bParts = b.split("\\.");

        if (aParts.length != 4 || bParts.length != 4) {
            return false;
        }

        if (octets > 4) {
            octets = 4;
        } else if (octets < 1) {
            octets = 1;
        }

        for (int i = 0; i < octets && i < 4; i++) {
            if (aParts[i].equals("*") || bParts[i].equals("*")) {
                continue;
            }

            if (!aParts[i].equals(bParts[i])) {
                match = false;
                break;
            }
        }

        return match;
    }
    
    
    public void register() {
        //this.getCommand("ban").setExecutor(new Command_ban(this));
        this.getCommand("fhm").setExecutor(new Command_fhm(this));
        this.getCommand("purple").setExecutor(new Command_purple(this));
        this.getCommand("smite").setExecutor(new Command_smite(this));
        this.getCommand("opall").setExecutor(new Command_opall(this));
    }
}
