package bakenokawa.FL_IS.configuration;

public class ConfigurationSettings
{
    // Enable/Disable All Island Generation.
    public static boolean ENABLE_ISLAND_SPAWN;
    public static String  ENABLE_ISLAND_SPAWN_CONFIGNAME = "";
    public static boolean ENABLE_ISLAND_SPAWN_DEFAU = true;

    // Island Gen Settings.
    public static int ISLAND_SPAWN_RATE;
    public static String ISLAND_SPAWN_RATE_CONFIGNAME = "Island Spawn Rate";
    public static int ISLAND_SPAWN_RATE_DEFAU = 24;
    
    public static int MIN_ISLAND_SIZE;
    public static String MIN_ISLAND_SIZE_CONFIGNAME = "Minimum Island Size";
    public static int MIN_ISLAND_SIZE_DEFAU = 5;
    
    public static int MIN_ISLAND_HEIGHT;
    public static String MIN_ISLAND_HEIGHT_CONFIGNAME = "Minimum Island Levitation";
    public static int MIN_ISLAND_HEIGHT_DEFAU = 20;
    
    public static int ISLAND_HEIGHT_VAR;
    public static String ISLAND_HEIGHT_VAR_CONFIGNAME = "Island Levitation Variance";
    public static int ISLAND_HEIGHT_VAR_DEFAU = 7;
    
    public static int ISLAND_SIZE_VAR;
    public static String ISLAND_SIZE_VAR_CONFIGNAME = "Island Size Variance";
    public static int ISLAND_SIZE_VAR_DEFAU = 5;
    
    public static int REPLACE_BLOCK_ID;
    public static String REPLACE_BLOCK_ID_CONFIGNAME = "Replacement Block Id";
    public static int REPLACE_BLOCK_ID_DEFAU = 9;


}
