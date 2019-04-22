package com.ccxia.firstmod.tileentity;
import com.ccxia.firstmod.block.BlockBatteryBox;
import com.ccxia.firstmod.block.BlockLoader;
import com.ccxia.firstmod.item.ItemLoader;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;
public class TileEntityCraftStation extends TileEntity implements ITickable{
	public int power=0;
	public int count=0;
	public int load=0;
	public ItemStackHandler upInventory = new ItemStackHandler();
	public ItemStackHandler downInventory = new ItemStackHandler();
	public ItemStackHandler sideInventory = new ItemStackHandler();
	
	@Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing)
    {
        if (CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.equals(capability))
        {
            return true;
        }
        return super.hasCapability(capability, facing);
    }
	
	@Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing)
    {
        if (CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.equals(capability))
        {
            // return your IItemHandler
        	 @SuppressWarnings("unchecked")
             T result;
        	 if(facing==EnumFacing.DOWN)
        	 {
        		 result=(T)downInventory;
        		 return result;
        	 }
        	 else if(facing==EnumFacing.UP)
        	 {
        		 result=(T)upInventory;
        		 return result;
        	 }
        	 else
        	 {
        		 result=(T)sideInventory;
        		 return result;
        	 }
        }
        return super.getCapability(capability, facing);
    }
	
	public void update()
	{
		if(!this.world.isRemote)
		{
			count++;
			ItemStack itemStack1 = upInventory.extractItem(0, 1, true);
			if(itemStack1.getItem()==ItemLoader.items[1])
        	{
        		if(power<200000)
        		{
        			upInventory.extractItem(0, 1, false);
        			power+=25000;
        			if(power>200000)
        				power=200000;
        			this.markDirty();
        		}
        	}
			ItemStack itemStack2=sideInventory.extractItem(0, 1, true);
			ItemStack dyeStack=new ItemStack(Items.DYE,3,15);
			if(power>50&&itemStack2.getItem()==Items.BONE&&downInventory.insertItem(0,dyeStack, true)==ItemStack.EMPTY)
			{
				load=count;
				if(count==10)
				{
				sideInventory.extractItem(0, 1, false);
				downInventory.insertItem(0, dyeStack, false);
				power-=50;
				load=0;
				this.markDirty();
				}
			}
			else
			{
				load=0;
			}
			if(count==10)
			{
				count=0;
			}
			
			Block upblock=this.world.getBlockState(this.getPos().up(1)).getBlock(); //当合成站上方是电池盒时开始执行充电
			if(upblock instanceof BlockBatteryBox)
			{
				//BlockBatteryBox upcontainer=(BlockBatteryBox)upblock;
				TileEntityBatteryBox uptileEntity=(TileEntityBatteryBox)this.world.getTileEntity(this.getPos().up(1));
				int battery_box_power=uptileEntity.getPower();
				if(battery_box_power>50&&power<200000)
				{
					power+=50;
					if(power>200000)
						power=200000;
					this.markDirty();
				}
			}

			
			
			
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
	 @Override
	    public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState)
	    {
	        return oldState.getBlock() != newState.getBlock();
	    }
	    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
