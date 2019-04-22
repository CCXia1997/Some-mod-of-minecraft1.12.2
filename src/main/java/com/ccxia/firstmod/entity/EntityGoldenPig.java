package com.ccxia.firstmod.entity;
import javax.annotation.Nullable;

import com.ccxia.firstmod.Firstmod;
import com.ccxia.firstmod.inventory.GuiElementLoader;

import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;
public class EntityGoldenPig extends EntityPig {
	public static final ResourceLocation GOLDENPIG=new ResourceLocation("firstmod","entities/golden_pig");

	public EntityGoldenPig(World worldIn) {
		super(worldIn);
		// TODO Auto-generated constructor stub
	}
	@Override
    public void onLivingUpdate()
    {
        super.onLivingUpdate();
    }
	

	public ResourceLocation getLootTable()
    {
        return GOLDENPIG;
    }
	

    public boolean processInteract(EntityPlayer player, EnumHand hand)
    {
    	
    	
    	
    	 if (!super.processInteract(player, hand))
         {
    		 ItemStack itemstack = player.getHeldItemMainhand();

             
              if(itemstack.getItem()==Items.AIR)
             {
            	  if(!this.world.isRemote)
            	  {
            	  
       		  player.sendMessage(new TextComponentString("你打开了金猪对话页面！"));
       		  BlockPos pos = player.getPosition();
	          int id = GuiElementLoader.GUI_GOLDENPIG;
       		  player.openGui(Firstmod.instance, id, player.world, pos.getX(), pos.getY(), pos.getZ());
       		      		  
                
             }
            	  return true;
             }

             else
             {
            	 return false;
             }
         }
         else
         {
             return true;
         }
    }
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
 
    
    
    
    
    
    
    
    
    
    
    
    

}
