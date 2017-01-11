package com.gmail.rohzek.smelting;

import com.gmail.rohzek.blocks.SPBlocks;
import com.gmail.rohzek.util.ConfigurationManager;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SmeltingRecipes 
{
	public static void mainRegistry()
	{
		addSmeltingRecipes();
	}
	
	private static void addSmeltingRecipes()
	{
		//GameRegistry.addSmelting(SGOres.netherCoalOre, new ItemStack(Items.COAL), 0.1f);
	}
}
