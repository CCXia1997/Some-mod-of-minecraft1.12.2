package com.ccxia.firstmod.potion;
import net.minecraft.client.gui.Gui;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
public class PotionWild extends Potion {
	private ResourceLocation wild;

	protected PotionWild() {
		super(false, 0x7F0000);
		// TODO Auto-generated constructor stub
		this.setPotionName("effect.wild");
		this.setRegistryName("wild");
		//this.setIconIndex(0,0);
	    this.wild=new ResourceLocation("firstmod", "textures/gui/potion/" + "wild" + ".png");
	}
	 

	  @SideOnly(Side.CLIENT)
	    public void renderInventoryEffect(int x, int y, PotionEffect effect, net.minecraft.client.Minecraft mc)
	    {
		    mc.getTextureManager().bindTexture(this.wild);
	        Gui.drawModalRectWithCustomSizedTexture(x+6,y+7, 0, 0,18, 18, 256, 256);
	    }
	  
	    @SideOnly(Side.CLIENT)
	    public void renderHUDEffect(int x, int y, PotionEffect effect, net.minecraft.client.Minecraft mc, float alpha) 
	    {

		    mc.getTextureManager().bindTexture(this.wild);
	       Gui.drawModalRectWithCustomSizedTexture(x+3,y+3, 0, 0, 18, 18, 256, 256);
	    	
	    }

		 
	 


}
