package com.ccxia.firstmod;
import com.ccxia.firstmod.block.BlockLoader;
import com.ccxia.firstmod.item.ItemLoader;

import common.CommonProxy;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
@Mod(modid = Firstmod.MODID,name = Firstmod.NAME, version = Firstmod.VERSION, acceptedMinecraftVersions = "1.12.2")
public class Firstmod {
public static final String MODID = "firstmod";
public static final String NAME = "First Mod";
public static final String VERSION = "1.0.1";
@SidedProxy(clientSide = "client.ClientProxy",serverSide = "common.CommonProxy")
public static CommonProxy proxy;
@Instance(Firstmod.MODID)
public static Firstmod instance;
@EventHandler
public static void preInit(FMLPreInitializationEvent event){
proxy.preInit(event);
}
@EventHandler
public static void init(FMLInitializationEvent event){
proxy.init(event);
GameRegistry.addSmelting(BlockLoader.blocks[0], new ItemStack(ItemLoader.items[1]), 1.0f);
}
@EventHandler
public static void postInit(FMLPostInitializationEvent event){
proxy.postInit(event);
}
}
