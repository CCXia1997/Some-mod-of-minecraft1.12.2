package com.ccxia.firstmod.enchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;
public class RedLotus extends Enchantment{

	protected RedLotus(Rarity rarityIn, EntityEquipmentSlot[] slots) {
		super(rarityIn, EnumEnchantmentType.ARMOR, slots);
		// TODO Auto-generated constructor stub
		this.setName("red_lotus");
		this.setRegistryName("red_lotus");
		
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
