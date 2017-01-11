package com.gmail.rohzek.main;

import com.gmail.rohzek.blocks.SPBlocks;
import com.gmail.rohzek.crafting.CraftingRecipes;
import com.gmail.rohzek.creativetabs.SPTab;
import com.gmail.rohzek.events.DecorateBiomeEventSP;
import com.gmail.rohzek.food.SPFoods;
import com.gmail.rohzek.items.SPItems;
import com.gmail.rohzek.lib.Reference;
import com.gmail.rohzek.proxys.CommonProxy;
import com.gmail.rohzek.smelting.SmeltingRecipes;
import com.gmail.rohzek.tools.SPTools;
import com.gmail.rohzek.util.ConfigurationManager;
import com.gmail.rohzek.util.KeyBindings;
import com.gmail.rohzek.util.LoadModData;
import com.gmail.rohzek.util.LogHelper;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class Main 
{
	@Instance(Reference.MODID)
	public static Main survivalplus;
	
	@SidedProxy(clientSide = Reference.CLIENTSIDEPROXY, serverSide = Reference.SERVERSIDEPROXY)
	public static CommonProxy proxy;
	
	public static final SPTab SP_BLOCKS_TAB = new SPTab("blocksTab", SPBlocks.PUMPKIN_SP);
	public static final SPTab SP_FOODS_TAB = new SPTab("foodsTab", SPFoods.APPLE_SP);
	public static final SPTab SP_INGOTS_TAB = new SPTab("ingotsTab", SPItems.STEEL_INGOT_SP);
	public static final SPTab SP_INGREDIENTS_TAB = new SPTab("ingredientsTab", SPBlocks.MELON_SP);
	public static final SPTab SP_TOOL_PARTS_TAB = new SPTab("toolPartsTab", SPItems.STEEL_PICKAXE_HEAD_SP);
	public static final SPTab SP_TOOLS_TAB = new SPTab("toolsTab", SPTools.STEEL_PICKAXE_SP);
	
	@Mod.EventHandler
	public static void PreLoad(FMLPreInitializationEvent PreEvent)
	{
		ConfigurationManager manager = new ConfigurationManager(PreEvent);
		
		LogHelper.debug("Loading MCMOD replacement info");
		
		// This has to load early. This is a replacement for our MCMOD.Info
		LoadModData.load(PreEvent);
		
		SPBlocks.registerTileEntities();
		KeyBindings.mainRegistry();
		MinecraftForge.TERRAIN_GEN_BUS.register(DecorateBiomeEventSP.class);
		CraftingRecipes.register();
		SmeltingRecipes.mainRegistry();
	}
	
	@Mod.EventHandler
	public static void load(FMLInitializationEvent event)
	{
		proxy.registerRenders();
	}
	
	@Mod.EventHandler
	public static void PostLoad(FMLPostInitializationEvent PostEvent){}
}
