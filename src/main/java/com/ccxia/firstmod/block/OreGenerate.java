package com.ccxia.firstmod.block;
import java.util.Random;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;
public class OreGenerate implements IWorldGenerator{
	WorldGenMinable ore_generate = new WorldGenMinable(BlockLoader.blocks[0].getDefaultState(), 6);
public void generateMainWorld(Random random, int chunk_x, int chunk_z, World world)
{
    for(int i=0;i<5;i++)    //生成矿脉的概率
    {
        //随机一个地点，作为生成矿脉的中心
        BlockPos genPos = new BlockPos(
            chunk_x*16 + random.nextInt(16),
            random.nextInt(64),
            chunk_z*16 + random.nextInt(16));
        ore_generate.generate(world, random, genPos);
    }
}
public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
{
	switch(world.provider.getDimension())
	{
	case 0:generateMainWorld(random,chunkX,chunkZ,world);
	case 1:break;
	case -1:break;
	}
}
}
