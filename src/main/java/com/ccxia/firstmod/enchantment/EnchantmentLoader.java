package com.ccxia.firstmod.enchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentArrowDamage;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
@Mod.EventBusSubscriber(modid = "firstmod")
public class EnchantmentLoader {
	public static EntityEquipmentSlot[] equipment= new EntityEquipmentSlot[] {EntityEquipmentSlot.CHEST,EntityEquipmentSlot.FEET,EntityEquipmentSlot.HEAD,EntityEquipmentSlot.LEGS};
	
	
	public static Enchantment witherpower=new EnchantmentWitherPower(Enchantment.Rarity.RARE, new EntityEquipmentSlot[] {EntityEquipmentSlot.MAINHAND});
	public static Enchantment redlotus=new RedLotus(Enchantment.Rarity.RARE, equipment);
	
	
	
	
	@SubscribeEvent
	public static void registerEnchantment(RegistryEvent.Register<Enchantment> event)
	{
		
		event.getRegistry().registerAll(redlotus,witherpower);
	}

}
