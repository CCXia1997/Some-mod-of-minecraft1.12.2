package com.ccxia.firstmod.event;

import com.ccxia.firstmod.Firstmod;
import com.ccxia.firstmod.inventory.ContainerGameMode;
import com.ccxia.firstmod.inventory.GuiContainerGameMode;
import com.ccxia.firstmod.inventory.GuiElementLoader;

import client.KeyLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
@EventBusSubscriber(modid=Firstmod.MODID)
public class GuiGameModeEvent {
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void GameModeOpen(InputEvent.KeyInputEvent event)
	{
		if(KeyLoader.gui_gamemode.isPressed())
		{
			World worldIn=Minecraft.getMinecraft().player.world;
			EntityPlayer playerIn=Minecraft.getMinecraft().player;
		
	           
	                BlockPos pos = playerIn.getPosition();
	                int id = GuiElementLoader.GUI_GAMEMODE;
	                playerIn.openGui(Firstmod.instance, id, worldIn, pos.getX(), pos.getY(), pos.getZ());
	                playerIn.sendMessage(new TextComponentString("你打开了模式调整页面！"));
	           
	       
			
			 
		}
	}

}
