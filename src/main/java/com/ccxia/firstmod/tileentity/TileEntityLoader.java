package com.ccxia.firstmod.tileentity;
import com.ccxia.firstmod.Firstmod;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
public class TileEntityLoader {
	 public TileEntityLoader(FMLPreInitializationEvent event)
	    {
	        registerTileEntity(TileEntityBatteryBox.class, "BatteryBox");
	        registerTileEntity(TileEntityCraftStation.class, "CraftStation");
	    }

	    public void registerTileEntity(Class<? extends TileEntity> tileEntityClass, String id)
	    {
	        GameRegistry.registerTileEntity(tileEntityClass, Firstmod.MODID + ":" + id);
	    }

}
