package com.ccxia.firstmod.inventory;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiContainerDemo extends GuiContainer{
	
	private static final ResourceLocation TEXTURE = new ResourceLocation("firstmod","textures/gui/container/gui_demo.png");
	
	
	public GuiContainerDemo(ContainerDemo inventorySlotsIn) {
		super(inventorySlotsIn);
		// TODO Auto-generated constructor stub
		this.xSize=176;
		this.ySize=166;
	}
	
	
	 @Override
	    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	    {
		    GlStateManager.color(1.0F, 1.0F, 1.0F);

	        this.mc.getTextureManager().bindTexture(TEXTURE);
	        int offsetX = (this.width - this.xSize) / 2, offsetY = (this.height - this.ySize) / 2;

	        this.drawTexturedModalRect(offsetX, offsetY, 0, 0, this.xSize, this.ySize);
	    }

	    @Override
	    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	    {
	    	String title = I18n.format("container.firstmod.demo");
	    	 this.fontRenderer.drawString(title, (this.xSize - this.fontRenderer.getStringWidth(title)) / 2, 6, 0x404040);
	    }
	

}
