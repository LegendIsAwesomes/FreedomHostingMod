package com.tylerhyperHD.FreedomHostingMod;

import java.util.logging.Logger;

public class F_Log {
    
    public static final Logger log = Logger.getLogger("Minecraft");
    
    public static void info(String args) {
        log.info(args);
    }
    
    public static void severe(String args) {
        log.severe(args);
    }

    static void severe(Exception ex) {
        log.severe(ex.toString());
    }
}
