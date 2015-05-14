package fr.theshark34.craftsender;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = CraftSender.MODID, version = CraftSender.VERSION)
public class CraftSender {
    public static final String MODID = "CraftSender";
    public static final String VERSION = "1.0-SNAPSHOT";

    private Logger logger = LogManager.getLogger();
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
        logger.info("[CraftSender] Initializing CraftSender");
    }
}
