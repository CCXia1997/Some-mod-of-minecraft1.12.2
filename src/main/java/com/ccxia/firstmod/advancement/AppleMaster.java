package com.ccxia.firstmod.advancement;
import java.util.Map;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
public class AppleMaster extends Advancement{

	public AppleMaster(Advancement parentIn, DisplayInfo displayIn, AdvancementRewards rewardsIn,
			Map<String, Criterion> criteriaIn, String[][] requirementsIn) {
		super(new ResourceLocation("firstmod","advancements/apple_master.json"),parentIn, displayIn, rewardsIn, criteriaIn, requirementsIn);
		// TODO Auto-generated constructor stub
	}

}
