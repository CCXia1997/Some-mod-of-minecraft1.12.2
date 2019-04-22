package com.ccxia.firstmod.item;
import com.ccxia.firstmod.creativetab.CreativeTabsRedo;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
@Mod.EventBusSubscriber(modid = "firstmod")
public class ItemLoader {
	public static Item[] items = {
			new CcxSword(EnumHelper.addToolMaterial("CHROME", 3, 1817, 2.0F, 8.0F, 15)).setUnlocalizedName("rubble").setRegistryName("rubble").setCreativeTab(CreativeTabsRedo.tabRedo),
			new Item().setUnlocalizedName("ccxIngot").setRegistryName("ccx_ingot").setCreativeTab(CreativeTabsRedo.tabRedo),
			new CcxApple(7,14.4f,false).setUnlocalizedName("ccxApple").setRegistryName("ccx_apple").setCreativeTab(CreativeTabsRedo.tabRedo),
			new CcxHelmet().setUnlocalizedName("ccxHelmet").setRegistryName("ccx_helmet").setCreativeTab(CreativeTabsRedo.tabRedo),
			new CcxChestplate().setUnlocalizedName("ccxChestplate").setRegistryName("ccx_chestplate").setCreativeTab(CreativeTabsRedo.tabRedo),
			new CcxLeggings().setUnlocalizedName("ccxLeggings").setRegistryName("ccx_leggings").setCreativeTab(CreativeTabsRedo.tabRedo),
			new CcxBoots().setUnlocalizedName("ccxBoots").setRegistryName("ccx_boots").setCreativeTab(CreativeTabsRedo.tabRedo)
			};
	public static Item getByName(String name){
		for(Item item:items)
		if(item.getUnlocalizedName().equals(name))
		return item;
		return Items.AIR;
		}
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register< Item> event) {
	for(Item item : items){
		ModelLoader.setCustomModelResourceLocation(item,0,new ModelResourceLocation(item.getRegistryName(), "inventory"));
	event.getRegistry().register(item);
	}
	}
	}

