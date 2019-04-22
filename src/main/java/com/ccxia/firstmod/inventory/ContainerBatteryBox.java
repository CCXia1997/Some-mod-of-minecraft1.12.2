package com.ccxia.firstmod.inventory;
import java.util.List;

import com.ccxia.firstmod.tileentity.TileEntityBatteryBox;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
public class ContainerBatteryBox extends Container{
	
	 private IItemHandler upItems;
	 private IItemHandler downItems;
	 
	 private int power;
	
	private TileEntityBatteryBox tileEntity;
	
	public ContainerBatteryBox(EntityPlayer player,TileEntity tileEntity)
	{
		 super();
		 this.upItems = tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.UP);
	     this.downItems = tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.DOWN);
		 
		
	        
	       this.addSlotToContainer(new SlotItemHandler(this.upItems,0,56,17) {
    			
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
	        
	        this.addSlotToContainer(new SlotItemHandler(this.downItems,0,56,53) {
    			
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
	        
	        for (int i = 0; i < 3; ++i)
	        {
	            for (int j = 0; j < 9; ++j)
	            {
	                this.addSlotToContainer(new Slot(player.inventory, j + i * 9 + 9, 8 + j * 18, 79 + i * 18));
	            }
	        }

	        for (int i = 0; i < 9; ++i)
	        {
	            this.addSlotToContainer(new Slot(player.inventory, i, 8 + i * 18, 137));
	        }
	        
	        this.tileEntity=(TileEntityBatteryBox)tileEntity;
	        
	}
	
	 
	  @Override
	  public boolean canInteractWith(EntityPlayer playerIn)
	    {
	        return true;
	    }
	    
	    @Override
	    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
	    {
	    	ItemStack itemstack = ItemStack.EMPTY;
	        Slot slot = this.inventorySlots.get(index);
	        
	        if (slot != null && slot.getHasStack())
	        {
	        	ItemStack itemstack1 = slot.getStack();
	            itemstack = itemstack1.copy();
	        
	        	if(index==0||index==1)
	        	{
	        		if(!this.mergeItemStack(itemstack1,2,38, true))
	        		{
	        			return ItemStack.EMPTY;
	        		}
	        	}
	        	else if(!this.mergeItemStack(itemstack1,0,2, false))
	        	{
	        		return ItemStack.EMPTY;
	        	}
	        	if (itemstack1.isEmpty())
	            {
	                slot.putStack(ItemStack.EMPTY);
	            }
	            else
	            {
	                slot.onSlotChanged();
	            }
	        } 
	        return itemstack;
	    }
	    
	    @Override
	    public void onContainerClosed(EntityPlayer playerIn)
	    {
	        super.onContainerClosed(playerIn);
	        
	    }
	    
	    @Override
	    public void detectAndSendChanges()
	    {
	    	super.detectAndSendChanges();
	    	this.power=tileEntity.getPower();
	    	 for (IContainerListener i : this.listeners)
	         {
	    		 //i.sendProgressBarUpdate(this, 0, this.power);
	    		 i.sendWindowProperty(this, 0,this.power);
	         }
	    }
	    
	    @SideOnly(Side.CLIENT)
	    @Override
	    public void updateProgressBar(int id, int data)
	    {
	    	super.updateProgressBar(id, data);
	    	  switch (id)
	          {
	          case 0:
	              this.power = data;
	              break;
	          default:
	              break;
	          }
	    }
	    
	    public int getPower()
	    {
	    	return this.power;
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    

}
