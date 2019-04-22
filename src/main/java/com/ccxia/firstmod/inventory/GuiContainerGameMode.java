package com.ccxia.firstmod.inventory;

import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiContainerGameMode extends GuiContainer{
	
	private static final ResourceLocation TEXTURE = new ResourceLocation("firstmod","textures/gui/container/gui_gamemode.png");
	
	private static final int BUTTON_CREATIVE=0;
	private static final int BUTTON_SURVIVAL=1;
	private static final int BUTTON_SPECTATOR=2;

	public GuiContainerGameMode(Container inventorySlotsIn) {
		super(inventorySlotsIn);
		// TODO Auto-generated constructor stub
		this.xSize=80;
		this.ySize=120;
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
	    	String title = I18n.format("container.firstmod.gamemode");
	    	String creative=I18n.format("container.firstmod.gamemode.creative");
	    	String survival=I18n.format("container.firstmod.gamemode.survival");
	    	String spectator=I18n.format("container.firstmod.gamemode.spectator");
	    	this.fontRenderer.drawString(title, (this.xSize - this.fontRenderer.getStringWidth(title)) / 2, 6, 0x404040);
	    	this.fontRenderer.drawString(creative, (this.xSize - this.fontRenderer.getStringWidth(creative)) / 2, 35, 0x404040);
	    	this.fontRenderer.drawString(survival, (this.xSize - this.fontRenderer.getStringWidth(survival)) / 2, 60, 0x404040);
	    	this.fontRenderer.drawString(spectator, (this.xSize - this.fontRenderer.getStringWidth(spectator)) / 2, 85, 0x404040);
	    	
	    	
	    }
	    
	    @Override
	    public void initGui()
	    {
	    	super.initGui();
	        int offsetX = (this.width - 49) / 2, offsetY = (this.height-this.ySize) / 2;
	        
	        this.buttonList.add(new GuiButton(BUTTON_CREATIVE, offsetX ,offsetY+30, 49, 15, "")
	        {
	        	
	        	@Override
	            public void drawButton(Minecraft mc, int mouseX, int mouseY,float partialTicks)
	            {
	                if (this.visible)
	                {
	                    GlStateManager.color(1.0F, 1.0F, 1.0F);

	                    mc.getTextureManager().bindTexture(TEXTURE);
	                    this.drawTexturedModalRect(offsetX,offsetY+ 30,100,4,49,15);
	                    
	                   
	                }
	            }
	        });
	    
	    
	    this.buttonList.add(new GuiButton(BUTTON_SURVIVAL, offsetX , offsetY+55, 49, 15, "")
        {
        	
        	@Override
            public void drawButton(Minecraft mc, int mouseX, int mouseY,float partialTicks)
            {
                if (this.visible)
                {
                    GlStateManager.color(1.0F, 1.0F, 1.0F);

                    mc.getTextureManager().bindTexture(TEXTURE);
                    this.drawTexturedModalRect(offsetX,offsetY+ 55,100,4,49,15);
                    
                   
                }
            }
        });
	    this.buttonList.add(new GuiButton(BUTTON_SPECTATOR, offsetX , offsetY+80, 49, 15, "")
        {
        	
        	@Override
            public void drawButton(Minecraft mc, int mouseX, int mouseY,float partialTicks)
            {
                if (this.visible)
                {
                    GlStateManager.color(1.0F, 1.0F, 1.0F);

                    mc.getTextureManager().bindTexture(TEXTURE);
                    this.drawTexturedModalRect(offsetX, offsetY+80,100,4,49,15);
                    
                   
                }
            }
        });
	    }
	    
	    @Override
	    protected void actionPerformed(GuiButton button) throws IOException
	    {
	    	switch(button.id)
	    	{
	    	case BUTTON_CREATIVE:
	    		Minecraft.getMinecraft().player.sendChatMessage("/gamemode 1 @p");
	    		break;
	    	case BUTTON_SURVIVAL:
	    		Minecraft.getMinecraft().player.sendChatMessage("/gamemode 0 @p");
	    		break;
	    	case BUTTON_SPECTATOR:
	    		Minecraft.getMinecraft().player.sendChatMessage("/gamemode 3 @p");
	    		break;
	    	}
	    }
    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    

	
	
	
	
	
	
	
	
	

}
