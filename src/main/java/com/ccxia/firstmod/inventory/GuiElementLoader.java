package com.ccxia.firstmod.inventory;
import com.ccxia.firstmod.Firstmod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
public class GuiElementLoader implements IGuiHandler {
	
	 public static final int GUI_DEMO = 1;
	 public static final int GUI_GAMEMODE=2;
	 public static final int GUI_GOLDENPIG=3;
	 public static final int GUI_BATTERYBOX=4;
	 public static final int GUI_CRAFTSTATION=5;
	 
	 public GuiElementLoader()
	    {
	        NetworkRegistry.INSTANCE.registerGuiHandler(Firstmod.instance, this);
	    }

	    @Override
	    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	    {
	    	switch (ID)
	        {
	        case GUI_DEMO:
	            return new ContainerDemo(player);
	        case GUI_GAMEMODE:
	        	return new ContainerGameMode();
	        case GUI_GOLDENPIG:
	        	return new ContainerGoldenPig();
	        case GUI_BATTERYBOX:
	        	return new ContainerBatteryBox(player,world.getTileEntity(new BlockPos(x, y, z)));
	        case GUI_CRAFTSTATION:
	        	return new ContainerCraftStation(player,world.getTileEntity(new BlockPos(x, y, z)));
	            
	        default:
	            return null;
	        }

	    	
	    }

	    @Override
	    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	    {
	    	 switch (ID)
	         {
	         case GUI_DEMO:
	             return new GuiContainerDemo(new ContainerDemo(player));
	         case GUI_GAMEMODE:
	        	 return new GuiContainerGameMode(new ContainerGameMode());
	         case GUI_GOLDENPIG:
	        	 return new GuiContainerGoldenPig(new ContainerGoldenPig());
	         case GUI_BATTERYBOX:
	        	 return new GuiContainerBatteryBox(new ContainerBatteryBox(player,world.getTileEntity(new BlockPos(x, y, z))));
	         case GUI_CRAFTSTATION:
	             return new GuiContainerCraftStation(new ContainerCraftStation(player,world.getTileEntity(new BlockPos(x, y, z))));
	         default:
	             return null;
	    	
	    }
	 }
}

