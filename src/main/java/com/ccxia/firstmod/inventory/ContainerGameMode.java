package com.ccxia.firstmod.inventory;

import com.ccxia.firstmod.item.ItemLoader;

import client.KeyLoader;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerGameMode extends Container{
	
	 public ContainerGameMode()
	    {
	        super();
	    }
	 
	 
	  @Override
	  @SideOnly(Side.CLIENT)
	    public boolean canInteractWith(EntityPlayer playerIn)
	    {
	        return true;
	    }
	    
	    @Override
	    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
	    {
	        return null;
	    }

}
