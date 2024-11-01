package net.smileycorp.lenientparkour;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.smileycorp.lenientparkour.client.CoyoteTimeHandler;
import net.smileycorp.lenientparkour.network.NetworkHandler;

@Mod(modid = Constants.MODID, name = Constants.NAME, version = Constants.VERSION)
@Mod.EventBusSubscriber(modid = Constants.MODID)
public class LenientParkour {
    
    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        NetworkHandler.init();
        ConfigHandler.syncConfig(new Configuration(event.getSuggestedConfigurationFile()));
        if (FMLCommonHandler.instance().getSide().isClient()) MinecraftForge.EVENT_BUS.register(new CoyoteTimeHandler());
    }
    
}
