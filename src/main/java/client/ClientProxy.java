package client;
import com.ccxia.firstmod.event.GuiGameModeEvent;
import com.ccxia.firstmod.event.KillAllEvent;

import client.entity.EntityRenderLoader;
import common.CommonProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
public class ClientProxy extends CommonProxy{
@Override
public void preInit(FMLPreInitializationEvent event){
super.preInit(event);

new EntityRenderLoader();

}
@Override
public void init(FMLInitializationEvent event){
super.init(event);
new KeyLoader();

}
@Override
public void postInit(FMLPostInitializationEvent event){
super.postInit(event);
}
}

