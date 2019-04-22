package com.ccxia.firstmod.inventory;
import com.ccxia.firstmod.item.ItemLoader;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
public class ContainerDemo extends Container{
	
	private ItemStackHandler items = new ItemStackHandler(9);
	
	protected Slot Bag_0;
	
	 public ContainerDemo(EntityPlayer player)
	    {
	        super();
	        
		    for (int i = 0; i < 3; ++i)
	        {
	            for (int j = 0; j < 9; ++j)
	            {
	                this.addSlotToContainer(new Slot(player.inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
	            }
	        }

	        for (int i = 0; i < 9; ++i)
	        {
	            this.addSlotToContainer(new Slot(player.inventory, i, 8 + i * 18, 142));
	        }
	        
	        for(int i=0;i<3;i++)
	        {
	        	for(int j=0;j<3;j++)
	        	{
	        		this.addSlotToContainer(new SlotItemHandler(items,j+3*i,62+18*j,17+i*18) {
	        			
	        			 @Override
	        	            public boolean isItemValid(ItemStack stack)
	        	            {
	        	                return stack != null  && super.isItemValid(stack);
	        	            }

	        	            @Override
	        	            public int getItemStackLimit(ItemStack stack)
	        	            {
	        	                return 64;
	        	            }
	        		});
	        	}
	        }
	        
	        
		    
	        
	        
	        
	        
	    }

	    @Override
	    public boolean canInteractWith(EntityPlayer playerIn)
	    {
	        return new ItemStack(ItemLoader.items[0]).isItemEqual(playerIn.getHeldItemMainhand());
	    }
	    
	    @Override
	    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
	    {
	        return null;
	    }
	    
	    @Override
	    public void onContainerClosed(EntityPlayer playerIn)
	    {
	        super.onContainerClosed(playerIn);
	        
	    }

	
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
}


