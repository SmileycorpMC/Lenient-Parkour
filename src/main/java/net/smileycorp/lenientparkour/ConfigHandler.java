package net.smileycorp.lenientparkour;

import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {
    
    public static int coyoteTicks = 5;
    
    public static void syncConfig(Configuration config) {
        try {
            config.load();
            coyoteTicks = config.getInt("coyoteTicks", "General", 5, 0, Integer.MAX_VALUE, "Amount of ticks after leaving a ledge players can jump for.");
        } catch (Exception e) {
        } finally {
            config.save();
        }
    }
    
}
