package client.entity.render;

import com.ccxia.firstmod.entity.EntityGoldenPig;
import com.ccxia.firstmod.entity.EntityTwoCreeper;
import com.ccxia.firstmod.entity.model.ModelTwoCreeper;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
@SideOnly(Side.CLIENT)
public class RenderTwoCreeper extends RenderLiving<EntityTwoCreeper>{
	
	//定义双头爬行者材质地址
	private static final ResourceLocation TWO_CREEPER=new ResourceLocation("firstmod","textures/entity/creeper/two_creeper.png");

	public RenderTwoCreeper(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelTwoCreeper(), 0.5F);
		// TODO Auto-generated constructor stub
	}
	
	//用于制定生物的放大倍数，原版的小中大史莱姆就是使用这个方法
		@Override
	    protected void preRenderCallback(EntityTwoCreeper entity, float partialTickTime)
	    {
	        GlStateManager.scale(1.0F, 1.0F, 1.0F);
	    }
		
		//制定渲染的材质
	    @Override
	    protected ResourceLocation getEntityTexture(EntityTwoCreeper entity)
	    {
	        return RenderTwoCreeper.TWO_CREEPER;
	    }

	    //渲染的核心，传入实体、实体坐标、转动角度以及tick值
	    @Override
	    public void doRender(EntityTwoCreeper entity, double x, double y, double z, float entityYaw, float partialTicks)
	    {
	        super.doRender(entity, x, y, z, entityYaw, partialTicks);
	    }

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
