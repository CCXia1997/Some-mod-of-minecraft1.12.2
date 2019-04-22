package com.ccxia.firstmod.inventory;
import com.ccxia.firstmod.tileentity.TileEntityBatteryBox;
import com.ccxia.firstmod.tileentity.TileEntityCraftStation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
public class ContainerCraftStation extends Container{
	
	private IItemHandler upItems;
	private IItemHandler downItems;
	private IItemHandler sideItems;
	
	private int power;
	private int load;
	private TileEntityCraftStation tileEntity;
	
	public ContainerCraftStation(EntityPlayer player,TileEntity tileEntity)
	{
		super();
		this.upItems = tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.UP);
	    this.downItems = tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.DOWN);
	    this.sideItems= tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
	    
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
	    
	    this.addSlotToContainer(new SlotItemHandler(this.sideItems,0,56,53) {
			
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
	    
	    this.addSlotToContainer(new SlotItemHandler(this.downItems,0,109,53) {
			
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
        this.tileEntity=(TileEntityCraftStation)tileEntity;
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
	        	if(index==0||index==1||index==2)
	        	{
	        		if(!this.mergeItemStack(itemstack1,3,39, true)) //注意第三个参数不包括自身的id，例如这边仅检测3~38号
	        		{
	        			return ItemStack.EMPTY;
	        		}
	        	}
	        	else if(!this.mergeItemStack(itemstack1,0,3, false))
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
	    	this.load=tileEntity.getLoad();
	    	 for (IContainerListener i : this.listeners)
	         {
	    		 //i.sendProgressBarUpdate(this, 0, this.power);
	    		 i.sendWindowProperty(this, 0,this.power);
	    		 i.sendWindowProperty(this, 1, this.load);
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
	          case 1:
	        	  this.load=data;
	        	  break;
	          default:
	              break;
	          }
	    }
	    
	    public int getPower()
	    {
	    	return this.power;
	    }
	    
	    public int getLoad()
	    {
	    	return this.load;
	    }
	    
	    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
