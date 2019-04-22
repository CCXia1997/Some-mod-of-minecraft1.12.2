package com.ccxia.firstmod.inventory;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
@SideOnly(Side.CLIENT)
public class GuiContainerCraftStation extends GuiContainer{
	private static final ResourceLocation TEXTURE = new ResourceLocation("firstmod","textures/gui/container/craft_station.png");

	public GuiContainerCraftStation(Container inventorySlotsIn) {
		super(inventorySlotsIn);
		// TODO Auto-generated constructor stub
		this.xSize=175;
		this.ySize=160;
		this.inventorySlots=inventorySlotsIn;
	}
	
	 @Override
	    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	    {
		    GlStateManager.color(1.0F, 1.0F, 1.0F);

	        this.mc.getTextureManager().bindTexture(TEXTURE);
	        int offsetX = (this.width - this.xSize) / 2, offsetY = (this.height - this.ySize) / 2;
	        int power=(int)((ContainerCraftStation)this.inventorySlots).getPower();
	        int load=(int)((ContainerCraftStation)this.inventorySlots).getLoad();
	        this.drawTexturedModalRect(offsetX, offsetY, 0, 0, this.xSize, this.ySize);
	        this.drawTexturedModalRect(offsetX+79, offsetY+38, 176, 18,(24*power)/200000, 9);
	        this.drawTexturedModalRect(offsetX+76, offsetY+57, 180, 39,(27*load)/10, 7);
	    }
	 
	 @Override
	 protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	 {
		 String title = I18n.format("container.firstmod.craft_station");
		 this.fontRenderer.drawString(title, (this.xSize - this.fontRenderer.getStringWidth(title)) / 2, 6, 0x404040);
		 String data = I18n.format("container.firstmod.craft_station.data");
		 this.fontRenderer.drawString(data,80, 18, 0x404040);
		 int power=(int)((ContainerCraftStation)this.inventorySlots).getPower();
		 this.fontRenderer.drawString(String.valueOf(power), 120, 18,0x404040);
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	

}
