package com.ccxia.firstmod.event;
import com.ccxia.firstmod.Firstmod;
import com.ccxia.firstmod.item.ItemLoader;
import com.ccxia.firstmod.potion.PotionLoader;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
@EventBusSubscriber(modid=Firstmod.MODID)
public class CcxSwordEvent {
	@SubscribeEvent
	public static void CcxSwordHurt(LivingHurtEvent event)
	{
		if(!event.getEntityLiving().world.isRemote&&(event.getSource().getTrueSource() instanceof EntityPlayer))
		{
			EntityPlayer player=(EntityPlayer)event.getSource().getTrueSource();
			ItemStack stack=player.getHeldItemMainhand();
			if(stack.getItem()==ItemLoader.items[0]&&(stack.getItemDamage()>=stack.getMaxDamage()-2))
			{
				player.sendMessage(new TextComponentString("剑已经没能量了，只能造成很少的伤害，请及时充电！"));
				event.setAmount(2);
			}

			}
	}

}
