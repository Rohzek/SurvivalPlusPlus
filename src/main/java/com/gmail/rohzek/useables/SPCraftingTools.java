package com.gmail.rohzek.useables;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.IForgeRegistry;

public class SPCraftingTools 
{
	public static final ItemHammerSP TOOL_HAMMER_SP = new ItemHammerSP("toolHammerSP");
	public static final ItemFileSP TOOL_FILE_SP = new ItemFileSP("toolFileSP");
		
	public static void registerRenders() 
	{
		registerRender(TOOL_HAMMER_SP);
		registerRender(TOOL_FILE_SP);
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
					TOOL_HAMMER_SP,
					TOOL_FILE_SP,
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
