package com.ccxia.firstmod.block;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
public class NumberBlock extends Block{
	 public static final PropertyInteger NUMBER = PropertyInteger.create("number", 0, 15);
	 private final boolean isOn;
	 public NumberBlock(Material materialIn,boolean isOn) {
		super(materialIn);
		// TODO Auto-generated constructor stub
		this.isOn=isOn;
	}
	 public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	 {
		 if (!playerIn.capabilities.allowEdit)
	        {
	            return false;
	        }
	        else
	        {
	            worldIn.setBlockState(pos, state.cycleProperty(NUMBER), 3);
	            return true;
	        }
	 }
	 @Override
	 protected BlockStateContainer createBlockState()
	    {
	        return new BlockStateContainer(this, new IProperty[] {NUMBER});
	    }
	 @Override
	 public IBlockState getStateFromMeta(int meta)
	    {
	        return getDefaultState().withProperty(NUMBER, Integer.valueOf(meta));
	    }
	 @Override
	 public int getMetaFromState(IBlockState state)
	    {
	        return ((Integer)state.getValue(NUMBER)).intValue();
	    }
	
	   /* public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
	    {
	        if (!worldIn.isRemote)
	        {
	            if (this.isOn && !worldIn.isBlockPowered(pos))
	            {
	                worldIn.setBlockState(pos, ModBlocks.NUMBERBLOCK.getDefaultState(), 2);
	            }
	            else if (!this.isOn && worldIn.isBlockPowered(pos))
	            {
	                worldIn.setBlockState(pos, state.cycleProperty(NUMBER), 3);
	            }
	        }
	    }

	 
	    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
	    {
	        if (!worldIn.isRemote)
	        {
	            if (this.isOn && !worldIn.isBlockPowered(pos))
	            {
	                worldIn.scheduleUpdate(pos, this, 4);
	            }
	            else if (!this.isOn && worldIn.isBlockPowered(pos))
	            {
	            	worldIn.setBlockState(pos, state.cycleProperty(NUMBER), 3);
	            }
	        }
	    }

	    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	    {
	        if (!worldIn.isRemote)
	        {
	            if (this.isOn && !worldIn.isBlockPowered(pos))
	            {
	                worldIn.setBlockState(pos,ModBlocks.NUMBERBLOCK.getDefaultState(), 2);
	            }
	        }
	    }

	  
	    public Item getItemDropped(IBlockState state, Random rand, int fortune)
	    {
	        return Item.getItemFromBlock(ModBlocks.NUMBERBLOCK);
	    }

	    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
	    {
	        return new ItemStack(ModBlocks.NUMBERBLOCK);
	    }

	    protected ItemStack getSilkTouchDrop(IBlockState state)
	    {
	        return new ItemStack(ModBlocks.NUMBERBLOCK);
	    }
	    */
	 public int getComparatorInputOverride(IBlockState blockState, World worldIn, BlockPos pos)
	    {
	        return (Integer)blockState.getValue(NUMBER).intValue();
	    }
	  public boolean hasComparatorInputOverride(IBlockState state)
	    {
	        return true;
	    }


}



