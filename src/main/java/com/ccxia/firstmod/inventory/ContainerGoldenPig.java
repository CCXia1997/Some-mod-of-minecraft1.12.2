package com.ccxia.firstmod.inventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
public class ContainerGoldenPig extends Container{
	
	public ContainerGoldenPig()
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
