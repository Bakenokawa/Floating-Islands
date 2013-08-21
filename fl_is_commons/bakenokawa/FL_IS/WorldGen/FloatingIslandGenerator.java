package bakenokawa.FL_IS.WorldGen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class FloatingIslandGenerator implements IWorldGenerator 
{
    public FloatingIslandGenerator()
    {
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world,
            IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {

        if ( GeneratorCommon.canSpawn() )
        {
            /*This gets us a useful XZ co-ord, plus some jitter for the center of the island */
            int i = chunkX * 8 + random.nextInt(16);
            int k = chunkZ * 8 + random.nextInt(16);

            if ( GeneratorCommon.findGround(world,i,k) !=-999 )
            {
                // TODO Fill in standard Island Generator.
            }
        }

    }

}
