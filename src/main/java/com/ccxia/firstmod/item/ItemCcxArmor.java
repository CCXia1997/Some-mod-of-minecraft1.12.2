package com.ccxia.firstmod.item;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;
public class ItemCcxArmor extends ItemArmor{
	public static final ItemArmor.ArmorMaterial CCX_ARMOR=EnumHelper.addArmorMaterial("ccx_ingot","firstmod:ccx", 35, new int[]{3,6,8,3}, 15, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);

	public ItemCcxArmor(EntityEquipmentSlot equipmentSlotIn) {
		super(CCX_ARMOR, 0, equipmentSlotIn);
		// TODO Auto-generated constructor stub
	}

}
