package client;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
public class KeyLoader {
	public static KeyBinding kill_all=new KeyBinding("key.kill_all",KeyConflictContext.UNIVERSAL, 82, "key.special_skills");
	public static KeyBinding gui_gamemode= new KeyBinding("key.gui_gamemode",KeyConflictContext.UNIVERSAL, 82, "key.special_skills");
	
	
	public KeyLoader()
	{
		ClientRegistry.registerKeyBinding(kill_all);
		ClientRegistry.registerKeyBinding(gui_gamemode);

		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
