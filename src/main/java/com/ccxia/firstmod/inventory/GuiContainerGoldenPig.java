package com.ccxia.firstmod.inventory;
import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
@SideOnly(Side.CLIENT)
public class GuiContainerGoldenPig extends GuiContainer{
	
	private static final ResourceLocation TEXTURE = new ResourceLocation("firstmod","textures/gui/container/golden_pig.png");
	
	public static final int BUTTON_0=0;
	public static final int BUTTON_1=1;
	public static final int BUTTON_2=2;
	public static final int BUTTON_RETURN=3;
	
	public GuiContainerGoldenPig(Container inventorySlotsIn) {
		super(inventorySlotsIn);
		// TODO Auto-generated constructor stub
		this.xSize=120;
		this.ySize=130;
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
	    	String title_0 = I18n.format("container.firstmod.golden_pig_0");
	    	String title_1 = I18n.format("container.firstmod.golden_pig_1");
	    	String button_0_0=I18n.format("container.firstmod.golden_pig.button_0_0");
	    	String button_0_1=I18n.format("container.firstmod.golden_pig.button_0_1");
	    	String button_1_0=I18n.format("container.firstmod.golden_pig.button_1_0");
	    	String button_1_1=I18n.format("container.firstmod.golden_pig.button_1_1");
	    	String button_2=I18n.format("container.firstmod.golden_pig.button_2");
	    	this.fontRenderer.drawString(title_0, (this.xSize - this.fontRenderer.getStringWidth(title_0)) / 2, 6, 0x404040);
	    	this.fontRenderer.drawString(title_1, (this.xSize - this.fontRenderer.getStringWidth(title_1)) / 2, 16, 0x404040);
	    	this.fontRenderer.drawString(button_0_0, (this.xSize - this.fontRenderer.getStringWidth(button_0_0)) / 2, 35, 0x404040);
	    	this.fontRenderer.drawString(button_0_1, (this.xSize - this.fontRenderer.getStringWidth(button_0_1)) / 2, 45, 0x404040);
	    	this.fontRenderer.drawString(button_1_0, (this.xSize - this.fontRenderer.getStringWidth(button_1_0)) / 2, 70, 0x404040);
	    	this.fontRenderer.drawString(button_1_1, (this.xSize - this.fontRenderer.getStringWidth(button_1_1)) / 2, 80, 0x404040);
	    	this.fontRenderer.drawString(button_2, (this.xSize - this.fontRenderer.getStringWidth(button_2)) / 2, 105, 0x404040);
	    	
	    	
	    }
	    
	    @Override
	    public void initGui()
	    {
	    	super.initGui();
	        int offsetX = (this.width - 51) / 2, offsetY = (this.height-this.ySize) / 2;
	        
	        this.buttonList.add(new GuiButton(BUTTON_0, offsetX ,offsetY+30, 51, 25, "")
	        {
	        	
	        	@Override
	            public void drawButton(Minecraft mc, int mouseX, int mouseY,float partialTicks)
	            {
	                if (this.visible)
	                {
	                    GlStateManager.color(1.0F, 1.0F, 1.0F);

	                    mc.getTextureManager().bindTexture(TEXTURE);
	                    this.drawTexturedModalRect(offsetX,offsetY+ 30,140,0,51,25);
	                    
	                   
	                }
	            }
	        });
	    
	    
	    this.buttonList.add(new GuiButton(BUTTON_1, offsetX , offsetY+65, 51, 25, "")
     {
     	
     	@Override
         public void drawButton(Minecraft mc, int mouseX, int mouseY,float partialTicks)
         {
             if (this.visible)
             {
                 GlStateManager.color(1.0F, 1.0F, 1.0F);

                 mc.getTextureManager().bindTexture(TEXTURE);
                 this.drawTexturedModalRect(offsetX,offsetY+ 65,140,0,51,25);
                 
                
             }
         }
     });
	    this.buttonList.add(new GuiButton(BUTTON_2, offsetX , offsetY+100, 51, 25, "")
     {
     	
     	@Override
         public void drawButton(Minecraft mc, int mouseX, int mouseY,float partialTicks)
         {
             if (this.visible)
             {
                 GlStateManager.color(1.0F, 1.0F, 1.0F);

                 mc.getTextureManager().bindTexture(TEXTURE);
                 this.drawTexturedModalRect(offsetX, offsetY+100,140,0,51,25);
                 
                
             }
         }
     });
	    }
	    
	    
	    @Override
	    protected void actionPerformed(GuiButton button) throws IOException
	    {
	    	int offsetX = (this.width - this.xSize) / 2, offsetY = (this.height - this.ySize) / 2;
	    	switch(button.id)
	    	{
	    	case BUTTON_0:
	    		Minecraft.getMinecraft().displayGuiScreen(new GuiGoldenPig0());
	    		
	    		break;
	    	case BUTTON_1:
	    		
	    		break;
	    	case BUTTON_2:
	    		
	    		break;
	    		default:
	    			break;
	    			
	    	}
	    }

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	

}
