package bakenokawa.FL_IS.configuration;

import java.io.File;
import java.util.logging.Level;

import bakenokawa.FL_IS.lib.Reference;

import cpw.mods.fml.common.FMLLog;

import net.minecraftforge.common.Configuration;

public class ConfigurationHandler
{
    public static Configuration configuration;

    public static final String CATEGORY_CONTROL = "controls";
    public static final String CATEGORY_SETTINGS = "settings";

    public static void init(File configFile) {
        configuration = new Configuration(configFile);

        try
        {
            configuration.load();

            /* General configs */
            ConfigurationSettings.ENABLE_ISLAND_SPAWN = configuration.get(CATEGORY_CONTROL, ConfigurationSettings.ENABLE_ISLAND_SPAWN_CONFIGNAME, ConfigurationSettings.ENABLE_ISLAND_SPAWN_DEFAU).getBoolean(ConfigurationSettings.ENABLE_ISLAND_SPAWN_DEFAU);

            /* Setting configs */
            ConfigurationSettings.ISLAND_SPAWN_RATE = configuration.get(CATEGORY_SETTINGS, ConfigurationSettings.ISLAND_SPAWN_RATE_CONFIGNAME, ConfigurationSettings.ISLAND_SPAWN_RATE_DEFAU).getInt(ConfigurationSettings.ISLAND_SPAWN_RATE_DEFAU);
            ConfigurationSettings.MIN_ISLAND_SIZE = configuration.get(CATEGORY_SETTINGS, ConfigurationSettings.MIN_ISLAND_SIZE_CONFIGNAME, ConfigurationSettings.MIN_ISLAND_SIZE_DEFAU).getInt(ConfigurationSettings.MIN_ISLAND_SIZE_DEFAU);
            ConfigurationSettings.MIN_ISLAND_HEIGHT = configuration.get(CATEGORY_SETTINGS, ConfigurationSettings.MIN_ISLAND_HEIGHT_CONFIGNAME, ConfigurationSettings.MIN_ISLAND_HEIGHT_DEFAU).getInt(ConfigurationSettings.MIN_ISLAND_HEIGHT_DEFAU);
            ConfigurationSettings.ISLAND_HEIGHT_VAR = configuration.get(CATEGORY_SETTINGS, ConfigurationSettings.ISLAND_HEIGHT_VAR_CONFIGNAME, ConfigurationSettings.ISLAND_HEIGHT_VAR_DEFAU).getInt(ConfigurationSettings.ISLAND_HEIGHT_VAR_DEFAU);
            ConfigurationSettings.ISLAND_SIZE_VAR = configuration.get(CATEGORY_SETTINGS, ConfigurationSettings.ISLAND_SIZE_VAR_CONFIGNAME, ConfigurationSettings.ISLAND_SIZE_VAR_DEFAU).getInt(ConfigurationSettings.ISLAND_SIZE_VAR_DEFAU);
            ConfigurationSettings.MIN_ISLAND_HEIGHT = configuration.get(CATEGORY_SETTINGS, ConfigurationSettings.MIN_ISLAND_HEIGHT_CONFIGNAME, ConfigurationSettings.MIN_ISLAND_HEIGHT_DEFAU).getInt(ConfigurationSettings.MIN_ISLAND_HEIGHT_DEFAU);
            ConfigurationSettings.REPLACE_BLOCK_ID = configuration.get(CATEGORY_SETTINGS, ConfigurationSettings.REPLACE_BLOCK_ID_CONFIGNAME, ConfigurationSettings.REPLACE_BLOCK_ID_DEFAU).getInt(ConfigurationSettings.REPLACE_BLOCK_ID_DEFAU);
        }
        catch (Exception e) {
            FMLLog.log(Level.SEVERE, e, Reference.MOD_NAME + " has had a problem loading its configuration");
        }
        finally {
            configuration.save();
        }
    }
}
