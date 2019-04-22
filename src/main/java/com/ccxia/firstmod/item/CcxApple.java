package com.ccxia.firstmod.item;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
public class CcxApple extends ItemFood{
		public CcxApple(int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		this.setAlwaysEdible();
		// TODO Auto-generated constructor stub
	}
		protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
	    {
	        if (!worldIn.isRemote)
	        {
	            player.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 2400, 0));
	            player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 2400, 0));
                player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 2400, 1));
                player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 2400, 1));
	        }

	        if (stack.getMetadata() > 0)
	        {
	            if (!worldIn.isRemote)
	            {
	                
	            }
	        }
	        else
	        {
	            super.onFoodEaten(stack, worldIn, player);
	        }
	    }
}


