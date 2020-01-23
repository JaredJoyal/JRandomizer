package jaredjoyal.jrandomizer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/*
 * This instanced class provides the base interface of the mod with Forge.
 */
@Mod(JRandomizer.modID)
public class JRandomizer
{
	// semi-unique string id for the mod
	public static final String modID = "jrandomizer";
	// logger for printing info/warnings/errors to the console
	public static Logger logger = LogManager.getLogger(modID);
	// instance of the mod ensuring constructor gets called
	public static JRandomizer instance;
	
	/*
	 * This constructor initializes the instance of the class and hooks up basic event functions.
	 */
	public JRandomizer()
	{
		instance = this;
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::Setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::ClientRegistries);
	}
	
	/*
	 * This dummy function allows for mod setup capabilities.
	 * 
	 * event - the intercepted event
	 */
	private void Setup(final FMLCommonSetupEvent event)
	{
		logger.info("Setup completed.");
	}
	
	/*
	 * This dummy function allows for mod client setup capabilities.
	 * 
	 * event - the intercepted event
	 */
	private void ClientRegistries(FMLClientSetupEvent event)
	{
		logger.info("Client Registries completed.");
	}
}
