package com.gmail.rohzek.lib;

/**
 * Holds global variables to be called elsewhere
 * @author Rohzek
 *
 */
public class Reference 
{
	// Mod ID
	public static final String MODID = "survivalplusplus";
	
	// Just like MODID but with : attached to save time while assigning resource locations
	public static final String RESOURCEID = "survivalplusplus:";
	
	// The name that gets seen in brackets when we log to the console.
	public static final String LOG = "SURVIVALPLUSPLUS";
	
	// Human readable title
	public static final String NAME = "Survival++";
	
	// We only have to change it here... MCMOD.info is gone and the ModData is hardcoded to check here
	public static final String VERSION = "1.0";
	
	public static final String CLIENTSIDEPROXY = "com.gmail.rohzek.proxys.ClientProxy";
	
	public static final String SERVERSIDEPROXY = "com.gmail.rohzek.proxys.CommonProxy";
}
