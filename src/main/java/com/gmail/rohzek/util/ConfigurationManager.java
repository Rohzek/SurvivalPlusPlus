package com.gmail.rohzek.util;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ConfigurationManager
{
	public static boolean isDebug;
	public static boolean foodSpoils;
	public static boolean fovChangeAllowed;
	public static boolean correctTools;
	
	public ConfigurationManager(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		config.load();
		
		isDebug = config.getBoolean("debug", "dev", false, "Enables more printouts to the chat. WARNING: Will spam the log file. Good for bug reports. Not recommended for regular play.");
		foodSpoils = config.getBoolean("spoilage", "gameChangers", true, "If enabled, food will spoil. WARNING: Turning this off will not unspoil food, or re-enable stack sizing. Disabling this will only freeze the spoiling process.");
		correctTools = config.getBoolean("correctTools", "gameChangers", true, "If enabled, most blocks will require the proper tools to break at all.");
		fovChangeAllowed = config.getBoolean("fovChangeAllowed", "qualityOfLife", false, "If enabled, will allow sprinting to change FOV.");
		
		config.save();
	}
}
