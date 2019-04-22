package com.ccxia.firstmod.block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
public class WoolChooser extends BlockHorizontal {
	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	protected WoolChooser(Material materialIn) {
		super(materialIn);
		// TODO Auto-generated constructor stub
		 this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
	}
	 private void setDefaultFacing(World worldIn, BlockPos pos, IBlockState state)
	    {
	        if (!worldIn.isRemote)
	        {
	            IBlockState iblockstate = worldIn.getBlockState(pos.north());
	            IBlockState iblockstate1 = worldIn.getBlockState(pos.south());
	            IBlockState iblockstate2 = worldIn.getBlockState(pos.west());
	            IBlockState iblockstate3 = worldIn.getBlockState(pos.east());
	            EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);

	            if (enumfacing == EnumFacing.NORTH && iblockstate.isFullBlock() && !iblockstate1.isFullBlock())
	            {
	                enumfacing = EnumFacing.SOUTH;
	            }
	            else if (enumfacing == EnumFacing.SOUTH && iblockstate1.isFullBlock() && !iblockstate.isFullBlock())
	            {
	                enumfacing = EnumFacing.NORTH;
	            }
	            else if (enumfacing == EnumFacing.WEST && iblockstate2.isFullBlock() && !iblockstate3.isFullBlock())
	            {
	                enumfacing = EnumFacing.EAST;
	            }
	            else if (enumfacing == EnumFacing.EAST && iblockstate3.isFullBlock() && !iblockstate2.isFullBlock())
	            {
	                enumfacing = EnumFacing.WEST;
	            }

	            worldIn.setBlockState(pos, state.withProperty(FACING, enumfacing), 2);
	        }
	    }
	 @Override
	 protected BlockStateContainer createBlockState()
	    {
		 	return new BlockStateContainer(this, new IProperty[] {FACING});
	    }
	 @Override
	 public IBlockState getStateFromMeta(int meta)
	    {
		 EnumFacing enumfacing = EnumFacing.getFront(meta);

	        if (enumfacing.getAxis() == EnumFacing.Axis.Y)
	        {
	            enumfacing = EnumFacing.NORTH;
	        }

	        return this.getDefaultState().withProperty(FACING, enumfacing);
	    }
	 @Override
	 public int getMetaFromState(IBlockState state)
	    {
		 return ((EnumFacing)state.getValue(FACING)).getIndex();
	    }
	 public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	    {
	        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	    }
	  public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
	    {
	        worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);

	    }
	  public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
		 {
			 if (!playerIn.capabilities.allowEdit)
		        {
		            return false;
		        }
			 else if(!worldIn.isRemote)
			 {
				 if(((EnumFacing)state.getValue(FACING)==EnumFacing.NORTH&&hitX>0.75&&hitX<=1.0&&hitY>0.75&&hitY<=1.0&&hitZ==0)
						 ||((EnumFacing)state.getValue(FACING)==EnumFacing.SOUTH&&hitX>0.0&&hitX<=0.25&&hitY>0.75&&hitY<=1.0&&hitZ==1.0)
						||((EnumFacing)state.getValue(FACING)==EnumFacing.WEST&&hitZ>0.0&&hitZ<=0.25&&hitY>0.75&&hitY<=1.0&&hitX==0.0)
						||((EnumFacing)state.getValue(FACING)==EnumFacing.EAST&&hitZ>0.75&&hitZ<=1.0&&hitY>0.75&&hitY<=1.0&&hitX==1.0))
					 	Minecraft.getMinecraft().player.sendChatMessage("/give @p wool 64 14");
				 if(((EnumFacing)state.getValue(FACING)==EnumFacing.NORTH&&hitX>0.50&&hitX<=0.75&&hitY>0.75&&hitY<=1.0&&hitZ==0)
						 ||((EnumFacing)state.getValue(FACING)==EnumFacing.SOUTH&&hitX>0.25&&hitX<=0.50&&hitY>0.75&&hitY<=1.0&&hitZ==1.0)
						||((EnumFacing)state.getValue(FACING)==EnumFacing.WEST&&hitZ>0.25&&hitZ<=0.50&&hitY>0.75&&hitY<=1.0&&hitX==0.0)
						||((EnumFacing)state.getValue(FACING)==EnumFacing.EAST&&hitZ>0.50&&hitZ<=0.75&&hitY>0.75&&hitY<=1.0&&hitX==1.0))
					 	Minecraft.getMinecraft().player.sendChatMessage("/give @p wool 64 1");
				 if(((EnumFacing)state.getValue(FACING)==EnumFacing.NORTH&&hitX>0.25&&hitX<=0.50&&hitY>0.75&&hitY<=1.0&&hitZ==0)
						 ||((EnumFacing)state.getValue(FACING)==EnumFacing.SOUTH&&hitX>0.50&&hitX<=0.75&&hitY>0.75&&hitY<=1.0&&hitZ==1.0)
						||((EnumFacing)state.getValue(FACING)==EnumFacing.WEST&&hitZ>0.50&&hitZ<=0.75&&hitY>0.75&&hitY<=1.0&&hitX==0.0)
						||((EnumFacing)state.getValue(FACING)==EnumFacing.EAST&&hitZ>0.25&&hitZ<=0.50&&hitY>0.75&&hitY<=1.0&&hitX==1.0))
					 	Minecraft.getMinecraft().player.sendChatMessage("/give @p wool 64 4");
				 if(((EnumFacing)state.getValue(FACING)==EnumFacing.NORTH&&hitX>0.0&&hitX<=0.25&&hitY>0.75&&hitY<=1.0&&hitZ==0)
						 ||((EnumFacing)state.getValue(FACING)==EnumFacing.SOUTH&&hitX>0.75&&hitX<=1.0&&hitY>0.75&&hitY<=1.0&&hitZ==1.0)
						||((EnumFacing)state.getValue(FACING)==EnumFacing.WEST&&hitZ>0.75&&hitZ<=1.0&&hitY>0.75&&hitY<=1.0&&hitX==0.0)
						||((EnumFacing)state.getValue(FACING)==EnumFacing.EAST&&hitZ>0.0&&hitZ<=0.25&&hitY>0.75&&hitY<=1.0&&hitX==1.0))
					 	Minecraft.getMinecraft().player.sendChatMessage("/give @p wool 64 5");
				 
				 
				 if(((EnumFacing)state.getValue(FACING)==EnumFacing.NORTH&&hitX>0.75&&hitX<=1.0&&hitY>0.50&&hitY<=0.75&&hitZ==0)
						 ||((EnumFacing)state.getValue(FACING)==EnumFacing.SOUTH&&hitX>0.0&&hitX<=0.25&&hitY>0.50&&hitY<=0.75&&hitZ==1.0)
						||((EnumFacing)state.getValue(FACING)==EnumFacing.WEST&&hitZ>0.0&&hitZ<=0.25&&hitY>0.50&&hitY<=0.75&&hitX==0.0)
						||((EnumFacing)state.getValue(FACING)==EnumFacing.EAST&&hitZ>0.75&&hitZ<=1.0&&hitY>0.50&&hitY<=0.75&&hitX==1.0))
					 	Minecraft.getMinecraft().player.sendChatMessage("/give @p wool 64 13");
				 if(((EnumFacing)state.getValue(FACING)==EnumFacing.NORTH&&hitX>0.50&&hitX<=0.75&&hitY>0.50&&hitY<=0.75&&hitZ==0)
						 ||((EnumFacing)state.getValue(FACING)==EnumFacing.SOUTH&&hitX>0.25&&hitX<=0.50&&hitY>0.50&&hitY<=0.75&&hitZ==1.0)
						||((EnumFacing)state.getValue(FACING)==EnumFacing.WEST&&hitZ>0.25&&hitZ<=0.50&&hitY>0.50&&hitY<=0.75&&hitX==0.0)
						||((EnumFacing)state.getValue(FACING)==EnumFacing.EAST&&hitZ>0.50&&hitZ<=0.75&&hitY>0.50&&hitY<=0.75&&hitX==1.0))
					 	Minecraft.getMinecraft().player.sendChatMessage("/give @p wool 64 3");
				 if(((EnumFacing)state.getValue(FACING)==EnumFacing.NORTH&&hitX>0.25&&hitX<=0.50&&hitY>0.50&&hitY<=0.75&&hitZ==0)
						 ||((EnumFacing)state.getValue(FACING)==EnumFacing.SOUTH&&hitX>0.50&&hitX<=0.75&&hitY>0.50&&hitY<=0.75&&hitZ==1.0)
						||((EnumFacing)state.getValue(FACING)==EnumFacing.WEST&&hitZ>0.50&&hitZ<=0.75&&hitY>0.50&&hitY<=0.75&&hitX==0.0)
						||((EnumFacing)state.getValue(FACING)==EnumFacing.EAST&&hitZ>0.25&&hitZ<=0.50&&hitY>0.50&&hitY<=0.75&&hitX==1.0))
					 	Minecraft.getMinecraft().player.sendChatMessage("/give @p wool 64 9");
				 if(((EnumFacing)state.getValue(FACING)==EnumFacing.NORTH&&hitX>0.0&&hitX<=0.25&&hitY>0.50&&hitY<=0.75&&hitZ==0)
						 ||((EnumFacing)state.getValue(FACING)==EnumFacing.SOUTH&&hitX>0.75&&hitX<=1.0&&hitY>0.50&&hitY<=0.75&&hitZ==1.0)
						||((EnumFacing)state.getValue(FACING)==EnumFacing.WEST&&hitZ>0.75&&hitZ<=1.0&&hitY>0.50&&hitY<=0.75&&hitX==0.0)
						||((EnumFacing)state.getValue(FACING)==EnumFacing.EAST&&hitZ>0.0&&hitZ<=0.25&&hitY>0.50&&hitY<=0.75&&hitX==1.0))
					 	Minecraft.getMinecraft().player.sendChatMessage("/give @p wool 64 11");
				 
				 
				 if(((EnumFacing)state.getValue(FACING)==EnumFacing.NORTH&&hitX>0.75&&hitX<=1.0&&hitY>0.25&&hitY<=0.50&&hitZ==0)
						 ||((EnumFacing)state.getValue(FACING)==EnumFacing.SOUTH&&hitX>0.0&&hitX<=0.25&&hitY>0.25&&hitY<=0.50&&hitZ==1.0)
						||((EnumFacing)state.getValue(FACING)==EnumFacing.WEST&&hitZ>0.0&&hitZ<=0.25&&hitY>0.25&&hitY<=0.50&&hitX==0.0)
						||((EnumFacing)state.getValue(FACING)==EnumFacing.EAST&&hitZ>0.75&&hitZ<=1.0&&hitY>0.25&&hitY<=0.50&&hitX==1.0))
					 	Minecraft.getMinecraft().player.sendChatMessage("/give @p wool 64 6");
				 if(((EnumFacing)state.getValue(FACING)==EnumFacing.NORTH&&hitX>0.50&&hitX<=0.75&&hitY>0.25&&hitY<=0.50&&hitZ==0)
						 ||((EnumFacing)state.getValue(FACING)==EnumFacing.SOUTH&&hitX>0.25&&hitX<=0.50&&hitY>0.25&&hitY<=0.50&&hitZ==1.0)
						||((EnumFacing)state.getValue(FACING)==EnumFacing.WEST&&hitZ>0.25&&hitZ<=0.50&&hitY>0.25&&hitY<=0.50&&hitX==0.0)
						||((EnumFacing)state.getValue(FACING)==EnumFacing.EAST&&hitZ>0.50&&hitZ<=0.75&&hitY>0.25&&hitY<=0.50&&hitX==1.0))
					 	Minecraft.getMinecraft().player.sendChatMessage("/give @p wool 64 2");
				 if(((EnumFacing)state.getValue(FACING)==EnumFacing.NORTH&&hitX>0.25&&hitX<=0.50&&hitY>0.25&&hitY<=0.50&&hitZ==0)
						 ||((EnumFacing)state.getValue(FACING)==EnumFacing.SOUTH&&hitX>0.50&&hitX<=0.75&&hitY>0.25&&hitY<=0.50&&hitZ==1.0)
						||((EnumFacing)state.getValue(FACING)==EnumFacing.WEST&&hitZ>0.50&&hitZ<=0.75&&hitY>0.25&&hitY<=0.50&&hitX==0.0)
						||((EnumFacing)state.getValue(FACING)==EnumFacing.EAST&&hitZ>0.25&&hitZ<=0.50&&hitY>0.25&&hitY<=0.50&&hitX==1.0))
					 	Minecraft.getMinecraft().player.sendChatMessage("/give @p wool 64 10");
				 if(((EnumFacing)state.getValue(FACING)==EnumFacing.NORTH&&hitX>0.0&&hitX<=0.25&&hitY>0.25&&hitY<=0.50&&hitZ==0)
						 ||((EnumFacing)state.getValue(FACING)==EnumFacing.SOUTH&&hitX>0.75&&hitX<=1.0&&hitY>0.25&&hitY<=0.50&&hitZ==1.0)
						||((EnumFacing)state.getValue(FACING)==EnumFacing.WEST&&hitZ>0.75&&hitZ<=1.0&&hitY>0.25&&hitY<=0.50&&hitX==0.0)
						||((EnumFacing)state.getValue(FACING)==EnumFacing.EAST&&hitZ>0.0&&hitZ<=0.25&&hitY>0.25&&hitY<=0.50&&hitX==1.0))
					 	Minecraft.getMinecraft().player.sendChatMessage("/give @p wool 64 12");
				 
				 
				 if(((EnumFacing)state.getValue(FACING)==EnumFacing.NORTH&&hitX>0.75&&hitX<=1.0&&hitY>0.0&&hitY<=0.25&&hitZ==0)
						 ||((EnumFacing)state.getValue(FACING)==EnumFacing.SOUTH&&hitX>0.0&&hitX<=0.25&&hitY>0.0&&hitY<=0.25&&hitZ==1.0)
						||((EnumFacing)state.getValue(FACING)==EnumFacing.WEST&&hitZ>0.0&&hitZ<=0.25&&hitY>0.0&&hitY<=0.25&&hitX==0.0)
						||((EnumFacing)state.getValue(FACING)==EnumFacing.EAST&&hitZ>0.75&&hitZ<=1.0&&hitY>0.0&&hitY<=0.25&&hitX==1.0))
					 	Minecraft.getMinecraft().player.sendChatMessage("/give @p wool 64 8");
				 if(((EnumFacing)state.getValue(FACING)==EnumFacing.NORTH&&hitX>0.50&&hitX<=0.75&&hitY>0.0&&hitY<=0.25&&hitZ==0)
						 ||((EnumFacing)state.getValue(FACING)==EnumFacing.SOUTH&&hitX>0.25&&hitX<=0.50&&hitY>0.0&&hitY<=0.25&&hitZ==1.0)
						||((EnumFacing)state.getValue(FACING)==EnumFacing.WEST&&hitZ>0.25&&hitZ<=0.50&&hitY>0.0&&hitY<=0.25&&hitX==0.0)
						||((EnumFacing)state.getValue(FACING)==EnumFacing.EAST&&hitZ>0.50&&hitZ<=0.75&&hitY>0.0&&hitY<=0.25&&hitX==1.0))
					 	Minecraft.getMinecraft().player.sendChatMessage("/give @p wool 64 7");
				 if(((EnumFacing)state.getValue(FACING)==EnumFacing.NORTH&&hitX>0.25&&hitX<=0.50&&hitY>0.0&&hitY<=0.25&&hitZ==0)
						 ||((EnumFacing)state.getValue(FACING)==EnumFacing.SOUTH&&hitX>0.50&&hitX<=0.75&&hitY>0.0&&hitY<=0.25&&hitZ==1.0)
						||((EnumFacing)state.getValue(FACING)==EnumFacing.WEST&&hitZ>0.50&&hitZ<=0.75&&hitY>0.0&&hitY<=0.25&&hitX==0.0)
						||((EnumFacing)state.getValue(FACING)==EnumFacing.EAST&&hitZ>0.25&&hitZ<=0.50&&hitY>0.0&&hitY<=0.25&&hitX==1.0))
					 	Minecraft.getMinecraft().player.sendChatMessage("/give @p wool 64 15");
				 if(((EnumFacing)state.getValue(FACING)==EnumFacing.NORTH&&hitX>0.0&&hitX<=0.25&&hitY>0.0&&hitY<=0.25&&hitZ==0)
						 ||((EnumFacing)state.getValue(FACING)==EnumFacing.SOUTH&&hitX>0.75&&hitX<=1.0&&hitY>0.0&&hitY<=0.25&&hitZ==1.0)
						||((EnumFacing)state.getValue(FACING)==EnumFacing.WEST&&hitZ>0.75&&hitZ<=1.0&&hitY>0.0&&hitY<=0.25&&hitX==0.0)
						||((EnumFacing)state.getValue(FACING)==EnumFacing.EAST&&hitZ>0.0&&hitZ<=0.25&&hitY>0.0&&hitY<=0.25&&hitX==1.0))
					 	Minecraft.getMinecraft().player.sendChatMessage("/give @p wool 64 0");
					 	
					 
			
		        }
			 return true;
		 }
}



