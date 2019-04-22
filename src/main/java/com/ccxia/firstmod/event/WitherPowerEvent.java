package com.ccxia.firstmod.event;
import com.ccxia.firstmod.Firstmod;
import com.ccxia.firstmod.enchantment.EnchantmentLoader;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
@EventBusSubscriber(modid=Firstmod.MODID)
public class WitherPowerEvent {
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void attackEntity(AttackEntityEvent event)
	{
		if (!event.getEntityPlayer().getEntityWorld().isRemote&&event.getEntityPlayer()!=null)
		{
			ItemStack stack=event.getEntityPlayer().getHeldItem(EnumHand.MAIN_HAND);
			EntityPlayer player=event.getEntityPlayer();
			Entity entity=event.getTarget();
			if(EnchantmentHelper.getEnchantmentLevel(EnchantmentLoader.witherpower, stack)>0&&
					entity instanceof EntityLivingBase)
			{
				EntityLivingBase entity1=(EntityLivingBase)entity;
				float health=player.getHealth();
				float health_1=entity1.getMaxHealth()/8;
				player.setHealth(health+health_1);
				
			}
		}
	}

}
