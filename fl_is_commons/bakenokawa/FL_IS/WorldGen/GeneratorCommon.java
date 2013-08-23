package bakenokawa.FL_IS.WorldGen;

import java.util.Random;

import net.minecraft.world.World;
import bakenokawa.FL_IS.configuration.ConfigurationSettings;

public class GeneratorCommon
{

    public static boolean canSpawn(Random rand)
    {
        if (ConfigurationSettings.ENABLE_ISLAND_SPAWN)
        {
            if (rand.nextInt(4 * ConfigurationSettings.ISLAND_SPAWN_RATE) == 0)
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

    public static int findGround(World world, int i, int k)
    {
        /*
         * Purpose: given the world, and X,Z co-ord, find a suitable Y for
         * island Generation Returns: int>0 :: valid Y co-ord found, used in
         * Place function int=-999 :: flag value for non-valid spawn point.
         */

        int temp = 256;
        int ID;
        /*
         * // check biome curBiome = world.getBiomeGenForCoords(i, k); if
         * (curBiome.biomeID == 0 || (curBiome.biomeID >= 7 || curBiome.biomeID
         * <= 11)) { // this negates generation in ocean, river, sky, frozen //
         * ocean,frozen river, hell return -999; //}
         */
        for (; temp > 0; temp--)
        {
            // literally iterate downward from skylimit until a block is
            // encountered.
            ID = world.getBlockId(i, temp, k);
            if (ID == 8 || ID == 9)
            {

                return -999;
            }
            if (((ID >= 1) && (ID <= 4)) || ID == 12)
            {

                ID = world.getBlockId(i, temp + 1, k);
                if (ID == 0)
                {

                    // ensures ( more or less) that the block @i,temp,k is a
                    // surface block
                    return temp + 1;
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

    public static boolean isLevel_Round(World world, int i, int k,
            int inputHeight, int Radius)
    {
        // checking for levelness of the area;
        for (int x = -Radius; x <= Radius; x++)
        {
            for (int z = -Radius; z <= Radius; z++)
            {
                if ((x * x + z * z) > Radius * Radius)
                {
                    continue; // prevents execution if current position is out
                    // of bounds

                }
                else if (world.getBlockId(i + x, inputHeight - 1, k + z) == 0)
                {
                    return false; // ground is uneven.
                }
            }
        }
        return true;
    }

    public static void cleanUp(World world, int i, int j, int k, int[] drip_pan)
    {
        // TODO Clean up after Island Generations.
        // either, delete everything under the island, or ( preferable) move top
        // matter up.

        // triple nested for loop, until every block found is air. Also ignore
        // air blocks.
        // drip_pan[1] is the island Radius, drip_pan[2] is the heightBuffer

        // for y, input height until input height+heightBuffer.
        // for x: input x - radius to input x + radius
        // for z: input z - radius to input z + radius
        // if out of circle: continue
        // if ID = air : continue
        // else: move this block to y+heightBuffer, inc cntr.
        // if cntr = 0, then end loop;

        int cntr = 0; // Counts any non-air blocks. Used to terminate the loop.
        int ID;

        for (int y = j; y < j + drip_pan[2]; y++)
        {
            cntr = 0;
            for (int x = i - drip_pan[1]; x < (i + drip_pan[1]); x++)
            {
                for (int z = k - drip_pan[1]; z < (k + drip_pan[1]); z++)
                {
                    if ((x * x + z * z) > drip_pan[1] * drip_pan[1])
                    {
                        continue; // do nothing.
                    }
                    ID = world.getBlockId(x, y, z);
                    if (ID == 0)
                    {
                        continue; // do nothing.
                    }
                    else
                    {
                        cntr++;
                        world.setBlock(x, y + drip_pan[2], z, ID); // change
                                                                   // sky
                                                                   // block
                        world.setBlock(x, y, z, 0); // replace with air.
                    }
                }
            }

            if (cntr == 0)
            {
                break; // exit loop since there was nothing to move.
            }
        }

    }
}
