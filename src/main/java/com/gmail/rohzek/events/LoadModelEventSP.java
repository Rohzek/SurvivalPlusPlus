package com.gmail.rohzek.events;

import com.gmail.rohzek.blocks.SPBlocks;
import com.gmail.rohzek.food.SPFoods;
import com.gmail.rohzek.food.SPIngredients;
import com.gmail.rohzek.items.SPItems;
import com.gmail.rohzek.tools.SPTools;
import com.gmail.rohzek.useables.SPCraftingTools;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class LoadModelEventSP 
{
	@SubscribeEvent
    public static void onModelRegistry(ModelRegistryEvent event)
	{
		SPFoods.registerRenders();
		SPIngredients.registerRenders();
		SPBlocks.registerRenders();
		SPItems.registerRenders();
		SPTools.registerRenders();
		SPCraftingTools.registerRenders();
    }
}
