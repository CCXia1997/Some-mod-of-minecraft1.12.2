package client.entity.render;
import com.ccxia.firstmod.entity.EntityGoldenPig;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelPig;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
@SideOnly(Side.CLIENT)
public class RenderGoldenPig extends RenderLiving<EntityGoldenPig>{
	
	//制定金猪材质的PNG图片地址
	private static final ResourceLocation GOLDEN_PIG_TEXTURE=new ResourceLocation("firstmod","textures/entity/pig/golden_pig.png");
	
	//构造方法，第二个参数先使用猪的模型，后期需要学习如何自定义模型
	public RenderGoldenPig(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelPig(),0.5F);
		// TODO Auto-generated constructor stub
	}
	
	//用于制定生物的放大倍数，原版的小中大史莱姆就是使用这个方法
	@Override
    protected void preRenderCallback(EntityGoldenPig entity, float partialTickTime)
    {
        GlStateManager.scale(1.0F, 1.0F, 1.0F);
    }
	
	//制定渲染的材质
    @Override
    protected ResourceLocation getEntityTexture(EntityGoldenPig entity)
    {
        return RenderGoldenPig.GOLDEN_PIG_TEXTURE;
    }

    //渲染的核心，传入实体、实体坐标、转动角度以及tick值
    @Override
    public void doRender(EntityGoldenPig entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

	
	

}
