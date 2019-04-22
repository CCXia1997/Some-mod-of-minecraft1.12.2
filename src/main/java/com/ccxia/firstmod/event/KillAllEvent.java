package com.ccxia.firstmod.event;
import com.ccxia.firstmod.Firstmod;
import client.KeyLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
@EventBusSubscriber(modid=Firstmod.MODID)
public class KillAllEvent {
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void killAll(InputEvent.KeyInputEvent event)
	{
		if(KeyLoader.kill_all.isPressed())
		{
			Minecraft.getMinecraft().player.sendChatMessage("/kill @e[type=!Player]");
		}
	}

}
