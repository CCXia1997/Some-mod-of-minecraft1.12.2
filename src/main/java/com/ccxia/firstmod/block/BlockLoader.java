package com.ccxia.firstmod.block;
import com.ccxia.firstmod.creativetab.CreativeTabsRedo;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
@Mod.EventBusSubscriber(modid = "firstmod")
public class BlockLoader {
	public static Block[] blocks = {
			new Block(Material.ROCK).setUnlocalizedName("ccxiaBlock").setRegistryName("ccx_block").setCreativeTab(CreativeTabsRedo.tabRedo),
			new TestBlock(Material.ROCK).setUnlocalizedName("testBlock").setRegistryName("test_block").setCreativeTab(CreativeTabsRedo.tabRedo),
	        new DaughterFlower(Material.PLANTS).setUnlocalizedName("daughterFlower").setRegistryName("daughter_flower").setCreativeTab(CreativeTabsRedo.tabRedo),
	        new NumberBlock(Material.ROCK,false).setUnlocalizedName("numberBlock").setRegistryName("number_block").setCreativeTab(CreativeTabsRedo.tabRedo),
	        new WoolChooser(Material.IRON).setUnlocalizedName("woolChooser").setRegistryName("wool_chooser").setCreativeTab(CreativeTabsRedo.tabRedo),
	        new BlockBatteryBox(Material.IRON).setUnlocalizedName("batteryBox").setRegistryName("battery_box").setCreativeTab(CreativeTabsRedo.tabRedo),
	        new BlockCraftStation(Material.IRON).setUnlocalizedName("craftStation").setRegistryName("craft_station").setCreativeTab(CreativeTabsRedo.tabRedo)
			};
	public static Block getByName(String name){
		for(Block block:blocks)
		if(block.getUnlocalizedName().equals(name))
		return block;
		return Blocks.AIR;
		}
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register< Block> event) {
	for(Block block : blocks){
	ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block),0,new ModelResourceLocation(block.getRegistryName(), "inventory"));
	event.getRegistry().register(block);
	}
	blocks[0].setHarvestLevel("pickaxe",3);
	blocks[0].setHardness(4.0f);
	blocks[0].setResistance(6000.0f);
	blocks[0].setLightLevel(0.75f);
	}
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register< Item> event) {
	for(Block block : blocks){
	Item itemBlock = new ItemBlock(block).setRegistryName(block.getRegistryName());
	ModelLoader.setCustomModelResourceLocation(itemBlock,0,new ModelResourceLocation(block.getRegistryName(), "inventory"));
	event.getRegistry().register(itemBlock);
	}
	}


}
