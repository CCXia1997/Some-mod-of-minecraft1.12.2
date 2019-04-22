package com.ccxia.firstmod.event;
import com.ccxia.firstmod.Firstmod;
import com.ccxia.firstmod.potion.PotionLoader;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
@EventBusSubscriber(modid=Firstmod.MODID)
public class WildEvent1 {
	@SubscribeEvent
	public static void WildAttack(LivingHurtEvent event)
	{
		if(!event.getEntityLiving().world.isRemote)
		{
			EntityLivingBase entity=event.getEntityLiving();
			Entity source=event.getSource().getTrueSource();
			if(source instanceof EntityPlayer)
			{
				EntityPlayer player=(EntityPlayer)source;
				PotionEffect effect=player.getActivePotionEffect(PotionLoader.wild);
				if(effect!=null)
				{
					float attack=event.getAmount();
					event.setAmount(attack*2);
				}
			}
		}
	}
	

}
