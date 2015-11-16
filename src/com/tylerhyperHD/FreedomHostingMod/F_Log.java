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
