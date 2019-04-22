package com.ccxia.firstmod.potion;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.potion.Potion;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
@Mod.EventBusSubscriber(modid = "firstmod")
public class PotionLoader {
	public static Potion wild=new PotionWild();
	
	
	@SubscribeEvent
	public static void registerEnchantment(RegistryEvent.Register<Potion> event)
	{
		
		event.getRegistry().registerAll(wild);
	}

}
