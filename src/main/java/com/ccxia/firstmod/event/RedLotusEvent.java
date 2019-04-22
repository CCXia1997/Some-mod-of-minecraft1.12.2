package com.ccxia.firstmod.event;
import com.ccxia.firstmod.Firstmod;
import com.ccxia.firstmod.enchantment.EnchantmentLoader;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
@EventBusSubscriber(modid=Firstmod.MODID)
public class RedLotusEvent {
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void nearEntity(TickEvent.PlayerTickEvent event) {
		if(!event.player.getEntityWorld().isRemote&&event.player!=null)
		{
		event.player.world.rand.setSeed(49501);
		ItemStack stack1=event.player.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
		ItemStack stack2=event.player.getItemStackFromSlot(EntityEquipmentSlot.FEET);
		ItemStack stack3=event.player.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
		ItemStack stack4=event.player.getItemStackFromSlot(EntityEquipmentSlot.LEGS);
		EntityPlayer player=event.player;
		int a1=EnchantmentHelper.getEnchantmentLevel(EnchantmentLoader.redlotus, stack1);
		int a2=EnchantmentHelper.getEnchantmentLevel(EnchantmentLoader.redlotus, stack2);
		int a3=EnchantmentHelper.getEnchantmentLevel(EnchantmentLoader.redlotus, stack3);
		int a4=EnchantmentHelper.getEnchantmentLevel(EnchantmentLoader.redlotus, stack4);
		int a5=a1+a2+a3+a4;
		if(a5>0)
		{
			for(EntityLivingBase entity:player.world.getEntitiesWithinAABB(EntityLivingBase.class,new AxisAlignedBB(player.posX-1,player.posY-1,player.posZ-1,player.posX+1,player.posY+1,player.posZ+1)))
			{
				if(entity!=player)
				entity.attackEntityFrom(DamageSource.HOT_FLOOR,a5*1.0F);
			}
		}
		
		
		
		
		}
		
	}
	

}
