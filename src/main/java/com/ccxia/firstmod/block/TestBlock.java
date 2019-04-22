package com.ccxia.firstmod.block;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
public class TestBlock extends Block{
    public static final PropertyInteger COLOR = PropertyInteger.create("color", 0, 1);
	protected TestBlock(Material materialIn) {
		super(materialIn);
		// TODO Auto-generated constructor stub
		this.setDefaultState(this.blockState.getBaseState().withProperty(COLOR,Integer.valueOf(0)));
	}
	 public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	 {
		 if (!playerIn.capabilities.allowEdit)
	        {
	            return false;
	        }
	        else
	        {
	            worldIn.setBlockState(pos, state.cycleProperty(COLOR), 3);
	            if(!worldIn.isRemote)
	            playerIn.sendMessage(new TextComponentString("Äãµã»÷µÄÎ»ÖÃ      "+"  hitX:"+hitX+"    hitY:"+hitY+"    hitZ:"+hitZ));
	            return true;
	        }
	 }
	 @Override
	 protected BlockStateContainer createBlockState()
	    {
	        return new BlockStateContainer(this, new IProperty[] {COLOR});
	    }
	 @Override
	 public IBlockState getStateFromMeta(int meta)
	    {
	        return getDefaultState().withProperty(COLOR, Integer.valueOf(meta));
	    }
	 @Override
	 public int getMetaFromState(IBlockState state)
	    {
	        return ((Integer)state.getValue(COLOR)).intValue();
	    }

}
