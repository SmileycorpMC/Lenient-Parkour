package net.smileycorp.lenientparkour.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class JumpMessage implements IMessage {
	
	@Override
	public void fromBytes(ByteBuf buf) {
	}
	
	@Override
	public void toBytes(ByteBuf buf) {
	}
	
	public IMessage process(MessageContext ctx) {
		System.out.println("pckt");
		if (ctx.side.isServer()) {
			EntityPlayerMP player = ctx.getServerHandler().player;
			player.getServerWorld().addScheduledTask(() -> {
				System.out.println("jump");
				player.jump();
			});
		}
		return null;
	}
	
}
