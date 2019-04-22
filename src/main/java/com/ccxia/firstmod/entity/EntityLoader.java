package com.ccxia.firstmod.entity;
import com.ccxia.firstmod.Firstmod;

import client.entity.EntityRenderFactory;
import client.entity.render.RenderGoldenPig;
import client.entity.render.RenderTwoCreeper;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityLoader {
	
	private static int id=0;
	public EntityLoader()
	{
		
	    
		registerEntity(new ResourceLocation("golden_pig"),EntityGoldenPig.class,"GoldenPig",64,3,true);
		registerEntityEgg(new ResourceLocation("golden_pig"), 0xffff66,0x660000);
		registerEntity(new ResourceLocation("two_creeper"),EntityTwoCreeper.class,"TwoCreeper",64,3,true);
		registerEntityEgg(new ResourceLocation("two_creeper"), 0xffff66,0x660000);
	}
	
	
	

	private static void registerEntity(ResourceLocation resource,Class<? extends Entity> entityClass, String name, int trackingRange,
            int updateFrequency, boolean sendsVelocityUpdates)
	{
		EntityRegistry.registerModEntity(resource,entityClass, name,id++, Firstmod.instance, trackingRange, updateFrequency,
                sendsVelocityUpdates);
	}
	 private static void registerEntityEgg(ResourceLocation resource,int eggPrimary, int eggSecondary)
	    {
	        EntityRegistry.registerEgg(resource, eggPrimary, eggSecondary);
	    }
	 
	  @SideOnly(Side.CLIENT)
	    public static void registerRenders()
	    {
	        // TODO
		  registerEntityRender(EntityGoldenPig.class, RenderGoldenPig.class);
		  registerEntityRender(EntityTwoCreeper.class, RenderTwoCreeper.class);
	    }

	    @SideOnly(Side.CLIENT)
	    private static <T extends Entity> void registerEntityRender(Class<T> entityClass, Class<? extends Render<T>> render)
	    {
	        RenderingRegistry.registerEntityRenderingHandler(entityClass,  new EntityRenderFactory<T>(render));
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
