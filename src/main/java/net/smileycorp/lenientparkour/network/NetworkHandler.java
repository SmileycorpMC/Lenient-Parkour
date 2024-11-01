package net.smileycorp.lenientparkour.network;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import net.smileycorp.lenientparkour.Constants;

public class NetworkHandler {
    
    private static final SimpleNetworkWrapper NETWORK_INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Constants.MODID);
    
    public static void init() {
        NETWORK_INSTANCE.registerMessage(JumpMessage::process, JumpMessage.class, 0, Side.SERVER);
    }
    
    public static void jump() {
        System.out.println("jc");
        NETWORK_INSTANCE.sendToServer(new JumpMessage());
    }
    
}
