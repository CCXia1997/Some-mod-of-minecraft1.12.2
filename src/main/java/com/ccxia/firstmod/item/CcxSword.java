package com.ccxia.firstmod.item;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.annotation.Nullable;

import com.ccxia.firstmod.Firstmod;
import com.ccxia.firstmod.inventory.GuiElementLoader;

import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemElytra;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
public class CcxSword extends ItemSword{

	public CcxSword(ToolMaterial material) {
		super(material);
		// TODO Auto-generated constructor stub
		 this.addPropertyOverride(new ResourceLocation("broken"), new IItemPropertyGetter()
	        {
	            @SideOnly(Side.CLIENT)
	            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
	            {
	                return CcxSword.isUsable(stack) ? 0.0F : 1.0F;
	            }
	        });
	}
		 public static boolean isUsable(ItemStack stack)
		    {
		        return stack.getItemDamage() < stack.getMaxDamage() - 2;
		    }
		 public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
		 {
			 if(stack.getItemDamage()>=stack.getMaxDamage()-2)
			 {
				 stack.setItemDamage(stack.getMaxDamage()-2);
				 
			 }
		 }
		 
		 
		 public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
		 {
		        if (!worldIn.isRemote)
		        {
		            if (playerIn.isSneaking())
		            {
		            	/*
		            	int xpseed=playerIn.getXPSeed();
		            	playerIn.sendMessage(new TextComponentString("Xspeed"+xpseed));
		                Random rand=new Random();
		                rand.setSeed((long)xpseed);
		                int j1=rand.nextInt(8)+8+rand.nextInt(16);
		                int j2=rand.nextInt(8)+8+rand.nextInt(16);
		                int j3=rand.nextInt(8)+8+rand.nextInt(16);
		                int i1=j1/3;
		                int i2=j2*2/3+1;
		                int i3=30;
		                playerIn.sendMessage(new TextComponentString("当前需要的附魔等级：  "+i1+"  "+i2+"  "+i3));
		                rand.setSeed((long)xpseed);
		                i1=i1+1+rand.nextInt(1)+rand.nextInt(1);
		                float f = (rand.nextFloat() + rand.nextFloat() - 1.0F) * 0.15F;
		                i1=MathHelper.clamp(Math.round((float)i1 + (float)i1 * f), 1, Integer.MAX_VALUE);
		                int level1=0,level2=0,level3=0;
		                int a1=0,a2=0,a3=0;
		                int b1=0,b2=0,b3=0;
		                if(i1>=5&&i1<13)
		                	level1=1;
		                if(i1>=13&&i1<21)
		                	level1=2;
		                if(i1>=1&&i1<11)
		                	level2=1;
		                if(i1>=11&&i1<21)
		                	level2=2;
		                if(i1>=12)
		                	level3=1;
		                if(level1!=0)
		                	a1=1;
		                if(level2!=0)
		                	a2=1;
		                if(level3!=0)
		                	a3=1;
		                int weight=rand.nextInt(a1*5+a2*10+a3*2);
		                int k=rand.nextInt(50);
		                playerIn.sendMessage(new TextComponentString("耐久"+level1+"  力量"+level2+"  冲击"+level3));
		                playerIn.sendMessage(new TextComponentString("i1:"+i1));
		                playerIn.sendMessage(new TextComponentString("weight:"+weight));
		                playerIn.sendMessage(new TextComponentString("k:"+k));
		                if((a1==1&&a2==1&&weight<5&&k>i1)||(a1==1&&a2==0))
		                	 playerIn.sendMessage(new TextComponentString("当前预测的附魔：耐久"+level1));
		                if((a1==1&&a2==1&&weight>=5&&k>i1)||(a1==0&&a2==1))
		                	 playerIn.sendMessage(new TextComponentString("当前预测的附魔：力量"+level2));
		                if(a1==1&&a2==1&&k<=i1)
		                	 playerIn.sendMessage(new TextComponentString("当前预测的附魔：耐久"+level1+"  力量"+level2));
		                playerIn.sendMessage(new TextComponentString("玩家的专有ID："+playerIn.getCachedUniqueIdString()));
		                UUID uuid=playerIn.getUniqueID();
		                long mostSigBits=uuid.getMostSignificantBits();
		                long leastSigBits=uuid.getLeastSignificantBits();
		                playerIn.sendMessage(new TextComponentString("mostSigBits:"+mostSigBits+"   leastSigBits:"+leastSigBits));
		            }
		           BlockPos blockpos=playerIn.getPosition();
		           
		           int light1=worldIn.getLight(blockpos);
		           int light2=worldIn.getLight(blockpos,true);
		           int light3=worldIn.getLightFor(EnumSkyBlock.SKY, blockpos);
		           
		           int light4=worldIn.getLightFromNeighbors(blockpos);  
		           playerIn.sendMessage(new TextComponentString("light1:"+light1));
		           playerIn.sendMessage(new TextComponentString("light2:"+light2));
		           playerIn.sendMessage(new TextComponentString("light3:"+light3));
		           playerIn.sendMessage(new TextComponentString("light4:"+light4));
		           */
		            	
		        }
		            //worldIn.rand.setSeed(49501);
		            //playerIn.sendMessage(new TextComponentString("已将世界种子设置为49501！"));
		            long seed=worldIn.getWorldInfo().getSeed();
		            playerIn.sendMessage(new TextComponentString("当前种子为："+seed));
		            int a1=worldIn.rand.nextInt(100000);
		            playerIn.sendMessage(new TextComponentString("a1:"+a1));
		        }
		        return new ActionResult<ItemStack>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
		 }
		
		 
		 
		 
		 
		 
}
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
	
	


