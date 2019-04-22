package com.ccxia.firstmod.enchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;
public class EnchantmentWitherPower extends Enchantment{

	protected EnchantmentWitherPower(Rarity rarityIn, EntityEquipmentSlot[] slots) {
		super(rarityIn, EnumEnchantmentType.WEAPON, slots);
		// TODO Auto-generated constructor stub
		this.setName("wither_power");
		this.setRegistryName("wither_power");
	}
	 public int getMaxLevel()
	    {
	        return 1;
	    }
	 public int getMinEnchantability(int enchantmentLevel)
	    {
	        return enchantmentLevel * 20;
	    }

	    /**
	     * Returns the maximum value of enchantability nedded on the enchantment level passed.
	     */
	    public int getMaxEnchantability(int enchantmentLevel)
	    {
	        return this.getMinEnchantability(enchantmentLevel) + 50;
	    }

}
