package com.gmail.rohzek.food;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.IForgeRegistry;

public class SPIngredients 
{
	public static int timeDay = 24000; // ticks for one whole day
	public static int fresh = 0, stale = 1, moldy = 2;
	public static String conFresh = "fresh", conStale = "stale", conMoldy = "moldy";
	
	// Ingredients - Minecraft
	//public static final Item EGG_SP
	//public static final Item MILK_SP
	//public static final Item WHEAT_SP;
	
	// Ingredients - Added
	//public static final Item BUTTER_SP
	//public static final Item DOUGH_SP
	//public static final Item FLOUR_SP
	public static final Item PUMPKIN_BOWL_SP = new NonFoodSpoilable(timeDay, "pumpkinBowlSP");
	//public static final Item RICE_SP
	//public static final Item RICE_CUP_SP
	//public static final Item SALT_SP
	//public static final Item YEAST_MATURE_SP
	//public static final Item YEAST_MIX_SP
	//public static final Item YEAST_POWDER_SP
	
	public static void registerRenders() 
	{
		// Minecraft Ingredients - Spoilable Type
		
		// Added Ingredients - Spoilable Type
		registerRender(PUMPKIN_BOWL_SP, fresh, conFresh);
		registerRender(PUMPKIN_BOWL_SP, stale, conStale);
		registerRender(PUMPKIN_BOWL_SP, moldy, conMoldy);
	}
	
	public static void registerRender(Item item)
	{	
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
	
	public static void registerRender(Item item, int meta, String addon)
	{	
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName() + addon, "inventory"));
	}
	
	@Mod.EventBusSubscriber
	public static class RegistrationHandler 
	{
		public static final Set<Item> ITEMS = new HashSet<Item>();
		
		@SubscribeEvent
		public static void registerItems(RegistryEvent.Register<Item> event) 
		{
			final Item[] ingredients =
				{
					PUMPKIN_BOWL_SP,
				};
			
			final IForgeRegistry<Item> registry = event.getRegistry();

			for (final Item item : ingredients) 
			{
				registry.register(item);
				ITEMS.add(item);
			}
		}
	}
}
