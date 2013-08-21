package bakenokawa.FL_IS;

import java.io.File;

import bakenokawa.FL_IS.WorldGen.FloatingIslandGenerator;
import bakenokawa.FL_IS.configuration.ConfigurationHandler;
import bakenokawa.FL_IS.lib.Reference;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Bakenokawa's Floating Islands
 * 
 * @author Bakenokawa
 * @license Lesser GNU Public Lisence v3 (http://www.gnu.org/licenses/lgpl.html
 */

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION )
public class Bakeno_FloatingIslands
{
   // World_Gen;
    public static FloatingIslandGenerator FL_IS_GEN = new FloatingIslandGenerator();
    
    @Instance(Reference.MOD_ID)
    public static Bakeno_FloatingIslands instance;
    
    // pre-init:: Load any files needed for mod, init blocks and items.
    @EventHandler
    public void preInit(FMLPreInitializationEvent Event)
    {
     // Initialize the configuration
        ConfigurationHandler.init(new File(Event.getModConfigurationDirectory()
                .getAbsolutePath()
                + File.separator
                + Reference.CHANNEL_NAME
                + File.separator + Reference.MOD_ID + ".cfg"));
        
        // Initialize mod items
        // ModItems.init();
        
    }

    // init :: regeister events for in-game code runs, and crafting recipes.
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        //Register Floating Island Generator to World Generator.
        GameRegistry.registerWorldGenerator(FL_IS_GEN);
    }

    //post-init:: after all mods loaded, run code which runs offf other mods, such as API stuff.
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    }

}






