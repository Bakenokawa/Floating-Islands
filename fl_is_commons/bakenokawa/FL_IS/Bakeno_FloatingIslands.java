package bakenokawa.FL_IS;

import bakenokawa.FL_IS.lib.Reference;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * Bakenokawa's Floating Islands
 * 
 * @author Bakenokawa
 * @license Lesser GNU Public Lisence v3 (http://www.gnu.org/licenses/lgpl.html
 */

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION )
public class Bakeno_FloatingIslands
{
    // pre-init:: Load any files needed for mod, init blocks and items.
    @PreInit
    public void preInit(FMLPreInitializationEvent Event)
    {
    }

    // init :: regeister events for in-game code runs, and crafting recipes.
    @Init
    public void init(FMLInitializationEvent event)
    {
    }

    //post-init:: after all mods loaded, run code which runs offf other mods, such as API stuff.
    @PostInit
    public void postInit(FMLPostInitializationEvent event)
    {
    }

}






