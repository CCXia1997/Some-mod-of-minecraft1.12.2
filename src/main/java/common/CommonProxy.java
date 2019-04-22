package common;
import com.ccxia.firstmod.entity.EntityLoader;
import com.ccxia.firstmod.event.CcxSwordEvent;
import com.ccxia.firstmod.event.KillAllEvent;
import com.ccxia.firstmod.event.RedLotusEvent;
import com.ccxia.firstmod.event.WildEvent;
import com.ccxia.firstmod.event.WildEvent1;
import com.ccxia.firstmod.event.WitherPowerEvent;
import com.ccxia.firstmod.inventory.GuiElementLoader;
import com.ccxia.firstmod.tileentity.TileEntityLoader;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
public class CommonProxy {
public void preInit(FMLPreInitializationEvent event){
	new EntityLoader();
	new TileEntityLoader(event);
}
public void init(FMLInitializationEvent event){
	GameRegistry.registerWorldGenerator(new com.ccxia.firstmod.block.OreGenerate(), 0);
	new WitherPowerEvent();
	new RedLotusEvent();
	new WildEvent();
	new WildEvent1();
	new GuiElementLoader();
	new CcxSwordEvent();
	
}
public void postInit(FMLPostInitializationEvent event){}
}
