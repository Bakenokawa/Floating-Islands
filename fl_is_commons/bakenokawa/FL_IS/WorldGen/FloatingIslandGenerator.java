package bakenokawa.FL_IS.WorldGen;

import java.util.Random;

import bakenokawa.FL_IS.configuration.ConfigurationSettings;

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

       
        if (GeneratorCommon.canSpawn(random))
        {
            /*
             * This gets us a useful XZ co-ord, plus some jitter for the center
             * of the island
             */
            int i = chunkX * 8 + random.nextInt(16);
            int k = chunkZ * 8 + random.nextInt(16);
            int j = GeneratorCommon.findGround(world, i, k);
            

            if ( j != -999)
            {
                System.out.println("Now Generating your Island at X: "+i+" Z: "+k); 
                original(world,random,i,j,k);
            }
        }

    }

    public static boolean original(World world, Random random, int i, int inputHeight, int k)
    {

        int Radius = ConfigurationSettings.MIN_ISLAND_SIZE
                + random.nextInt(ConfigurationSettings.ISLAND_SIZE_VAR);
        int heightBuffer = ConfigurationSettings.MIN_ISLAND_HEIGHT
                + random.nextInt(ConfigurationSettings.ISLAND_HEIGHT_VAR);

        int ID = 0;
        int replaceID = ConfigurationSettings.REPLACE_BLOCK_ID;
        int sphereHeight = inputHeight - 6; // Different between "island height" and sphere cap.
        boolean areaLvl = true;

        // checking for levelness of the area;
        areaLvl = GeneratorCommon.isLevel_Round(world, i, k, inputHeight, Radius);

        // iterating through the 2Radius x 2Radius square, only acting on the circle itself.
       
        for (int x = -Radius; x <= Radius; x++)
        {
            for (int z = -Radius; z <= Radius; z++)
            {
                if ((x * x + z * z) > Radius * Radius)
                {
                    continue; // prevents execution if current position is out of bounds
                }
                // Cylinder move - literally moves a column of blocks upwards.
                /* Author note: It is possible to pick sphereHeight here, which creates a jittering, messing bottom of the island. May be used in future implementation. */
                for (int y = sphereHeight; y < inputHeight; y++)
                {
                    // set block
                    ID = world.getBlockId(i + x, y, k + z);
                    if (ID == 8 || ID == 9)
                    {
                        world.setBlockMetadataWithNotify(i + x, y + heightBuffer, k + z, ID, world.getBlockMetadata(i + x, y, k + z));
                    }
                    else
                    {
                        world.setBlock(i + x, y + heightBuffer, k + z, ID);
                    }

                    if (areaLvl)
                    {
                        world.setBlock(i + x, y, k + z, replaceID);
                    }
                    else
                    {
                        world.setBlock(i + x, y, k + z, 0);
                    }
                }
                // Cap move - introducing a Y co-ord now iterate through the Ys
                // to create a sphereical cap to the islands

                for (int sphereCap = 1; sphereCap <= Radius; sphereCap++)
                {
                    if (x * x + z * z + sphereCap * sphereCap > Radius * Radius)
                    {
                        continue; // prevents execution when out-of-bounds (out
                        // of sphere)
                    }
                    ID = world.getBlockId(i + x, sphereHeight - sphereCap, k + z);
                    world.setBlock(i + x, sphereHeight + heightBuffer - sphereCap, k + z, ID); // Change Air Block
                    world.setBlock(i + x, sphereHeight - sphereCap, k + z, replaceID); // Replace old block.

                }
            }
        }
        return true;
    }

}
