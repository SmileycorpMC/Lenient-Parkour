package net.smileycorp.lenientparkour.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.smileycorp.lenientparkour.ConfigHandler;
import net.smileycorp.lenientparkour.network.NetworkHandler;
import scala.collection.parallel.ParIterableLike;

public class CoyoteTimeHandler {
    
    private int ticks = 0;
    private boolean leftGround;
    
    @SubscribeEvent
    public void logIn(PlayerEvent.PlayerLoggedInEvent event) {
        refresh();
    }
    
    @SubscribeEvent
    public void tick(TickEvent.ClientTickEvent event) {
        EntityPlayerSP player = Minecraft.getMinecraft().player;
        if (player == null || event.phase != TickEvent.Phase.END) return;
        if (player.isAirBorne || player.isOnLadder() || player.isInWater() || player.isInLava()) return;
        if (player.world.collidesWithAnyBlock(player.getEntityBoundingBox().expand(0, -0.001, 0))) {
            refresh();
            return;
        }
        if (!leftGround()) startTimer();
        if (player.movementInput.jump && canJump()) {
            player.jump();
            System.out.println("j");
        }
        if (ticks > 0) ticks--;
    }
    
    public void startTimer() {
        ticks = 20;
        leftGround = true;
    }
    
    public boolean canJump() {
        return ticks > 0;
    }
    
    public boolean leftGround() {
        return leftGround;
    }
    
    public void refresh() {
        leftGround = false;
        ticks = 0;
    }
    
}
