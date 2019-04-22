package com.ccxia.firstmod.inventory;

import java.util.Arrays;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
@SideOnly(Side.CLIENT)
public class GuiGoldenPig0 extends GuiScreen{
	private static final ResourceLocation TEXTURE = new ResourceLocation("firstmod","textures/gui/container/golden_pig.png");
	
	  public void drawDefaultBackground()
	    {
	        super.drawDefaultBackground();
	        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
	        this.mc.getTextureManager().bindTexture(TEXTURE);
	        int i = (this.width - 120) / 2;
	        int j = (this.height - 130) / 2;
	        this.drawTexturedModalRect(i, j, 0, 0, 120, 130);
	    }
	  
	  public void drawScreen(int mouseX, int mouseY, float partialTicks)
	  {
		  int i = (this.width - 120) / 2;
	      int j = (this.height - 130) / 2;
		  this.drawDefaultBackground();
		  String title = I18n.format("screen.golden_pig_0");
		  this.fontRenderer.drawString(title, i+10, j+6, 0x404040);
		  super.drawScreen(mouseX, mouseY, partialTicks);
		  
		  
	  }
	  
	  
	

}



























