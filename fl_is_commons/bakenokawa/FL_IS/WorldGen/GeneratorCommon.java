package bakenokawa.FL_IS.WorldGen;

import java.util.Random;

import net.minecraft.world.World;

import bakenokawa.FL_IS.configuration.ConfigurationSettings;

public class GeneratorCommon
{


    public static boolean canSpawn(Random rand)
    {
        if ( ConfigurationSettings.ENABLE_ISLAND_SPAWN )
        {
            if ( rand.nextInt(4*ConfigurationSettings.ISLAND_SPAWN_RATE) == 0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    public  static int findGround(World world, int i, int k) {
        /*
         * Purpose: given the world, and X,Z co-ord, find a suitable Y for
         * island Generation Returns: int>0 :: valid Y co-ord found, used in
         * Place function int=-999 :: flag value for non-valid spawn point.
         */

        int temp = 256;
        int ID;
        /*
        // check biome
        curBiome = world.getBiomeGenForCoords(i, k);
        if (curBiome.biomeID == 0
                || (curBiome.biomeID >= 7 || curBiome.biomeID <= 11)) {
            // this negates generation in ocean, river, sky, frozen
            // ocean,frozen river, hell
            return -999;
        //}
         */
        for (; temp > 0; temp--) 
        {
            // literally iterate downward from skylimit until a block is
            // encountered.
            ID = world.getBlockId(i, temp, k);
            if (ID == 8 || ID == 9) {
                
                return -999;
            }
            if (((ID >= 1) && (ID <= 4)) || ID == 12)
            {
                
                ID = world.getBlockId(i, temp + 1, k);
                if (ID == 0) 
                {
                   
                    // ensures ( more or less) that the block @i,temp,k is a
                    // surface block
                    return temp;
                }
            } 
            else 
            {
                continue;
            }
        }
        System.out.println("Error!!! findGround kicked due reaching bedrock");
        return -999;
    }

    public static boolean isLevel_Round(World world, int i, int k, int inputHeight, int Radius)
    {
        // checking for levelness of the area;
        for (int x = -Radius; x <= Radius; x++)
        {
            for (int z = -Radius; z <= Radius; z++)
            {
                if ((x * x + z * z) > Radius * Radius)
                {
                    continue; // prevents execution if current position is out of bounds
                   
                }
                else if (world.getBlockId(i + x, inputHeight - 1, k + z) == 0)
                {
                    return false; // ground is uneven.
                }
            }
        }
        return true;
    }
}

