package com.ccxia.firstmod.tileentity;
import com.ccxia.firstmod.block.BlockCraftStation;
import com.ccxia.firstmod.item.ItemLoader;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;
public class TileEntityBatteryBox extends TileEntity implements ITickable{
	
	 public int power=0;
	 public ItemStackHandler upInventory = new ItemStackHandler();
	 public ItemStackHandler downInventory = new ItemStackHandler(); 
	
	
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
	             T result = (T) (facing == EnumFacing.DOWN ? downInventory : upInventory);
	             return result;
	        }
	        return super.getCapability(capability, facing);
	    }
	    
	   
	    @Override
	    public void update()
	    {
	        if (!this.world.isRemote)
	        {
	        	
	        	this.world.rand.setSeed(49501);
	        	ItemStack itemStack1 = upInventory.extractItem(0, 1, true);
	        	if(itemStack1.getItem()==ItemLoader.items[1])
	        	{
	        		if(power<400000)
	        		{
	        			upInventory.extractItem(0, 1, false);
	        			power+=25000;
	        			if(power>400000)
	        				power=400000;
	        			this.markDirty();
	        		}
	        	}
	        	ItemStack itemStack2=downInventory.extractItem(0, 1, true);
	        	if((itemStack2.getItem()==Items.ELYTRA||itemStack2.getItem()==ItemLoader.items[0])&&(itemStack2.getItemDamage()>0))
	        	{
	        		if(power>400)
	        		{
	        			power-=400;
	        			itemStack2.setItemDamage(itemStack2.getItemDamage()-2);
	        			this.markDirty();
	        		}
	        	}
	        	Block downblock=this.world.getBlockState(this.getPos().down(1)).getBlock(); //当电池盒下方是合成站时开始执行放电
	        	if(downblock instanceof BlockCraftStation)
	        	{
	        		TileEntityCraftStation downtileEntity=(TileEntityCraftStation)this.world.getTileEntity(this.getPos().down(1));
	        		int craft_station_power=downtileEntity.getPower();
	        		if(craft_station_power<200000&&power>50)
	        		{
	        			power-=50;
	        			this.markDirty();
	        		}
	        	}
	        	
	        	
	        }
	    }
	    
	    public int getPower()
	    {
	    	return this.power;
	    }
	  
	    @Override
	    public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState)
	    {
	        return oldState.getBlock() != newState.getBlock();
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    

}
