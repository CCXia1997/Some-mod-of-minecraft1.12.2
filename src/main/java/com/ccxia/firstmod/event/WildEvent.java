package com.ccxia.firstmod.event;
import com.ccxia.firstmod.Firstmod;
import com.ccxia.firstmod.potion.PotionLoader;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
@EventBusSubscriber(modid=Firstmod.MODID)
public class WildEvent {
	@SubscribeEvent
	public static void WildHurt(LivingHurtEvent event)
	{
		if(!event.getEntityLiving().world.isRemote&&(event.getEntityLiving() instanceof EntityPlayer))
		{
			PotionEffect effect=event.getEntityLiving().getActivePotionEffect(PotionLoader.wild);
			if(effect!=null)
			{
			float hurt=event.getAmount();
			event.setAmount(2*hurt);
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
