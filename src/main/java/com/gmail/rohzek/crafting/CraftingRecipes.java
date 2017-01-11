package com.gmail.rohzek.crafting;

import com.gmail.rohzek.food.SPFoods;
import com.gmail.rohzek.items.SPItems;
import com.gmail.rohzek.tools.SPTools;
import com.gmail.rohzek.useables.SPCraftingTools;
import com.gmail.rohzek.util.RecipeRemover;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class CraftingRecipes 
{
	public static void register()
	{
		removeMinecraftRecipes();
		replaceMinecraftRecipes();
		registerCustomRecipes();
	}
	
	private static void removeMinecraftRecipes()
	{
		RecipeRemover.removeCraftingRecipe(Blocks.WOOL);
		
		RecipeRemover.removeCraftingRecipe(Items.DIAMOND_AXE);
		RecipeRemover.removeCraftingRecipe(Items.DIAMOND_HOE);
		RecipeRemover.removeCraftingRecipe(Items.DIAMOND_PICKAXE);
		RecipeRemover.removeCraftingRecipe(Items.DIAMOND_SHOVEL);
		RecipeRemover.removeCraftingRecipe(Items.DIAMOND_SWORD);
		RecipeRemover.removeCraftingRecipe(Items.GOLDEN_AXE);
		RecipeRemover.removeCraftingRecipe(Items.GOLDEN_HOE);
		RecipeRemover.removeCraftingRecipe(Items.GOLDEN_PICKAXE);
		RecipeRemover.removeCraftingRecipe(Items.GOLDEN_SHOVEL);
		RecipeRemover.removeCraftingRecipe(Items.GOLDEN_SWORD);
		RecipeRemover.removeCraftingRecipe(Items.IRON_AXE);
		RecipeRemover.removeCraftingRecipe(Items.IRON_HOE);
		RecipeRemover.removeCraftingRecipe(Items.IRON_PICKAXE);
		RecipeRemover.removeCraftingRecipe(Items.IRON_SHOVEL);
		RecipeRemover.removeCraftingRecipe(Items.IRON_SWORD);
		RecipeRemover.removeCraftingRecipe(Items.STONE_AXE);
		RecipeRemover.removeCraftingRecipe(Items.STONE_HOE);
		RecipeRemover.removeCraftingRecipe(Items.STONE_PICKAXE);
		RecipeRemover.removeCraftingRecipe(Items.STONE_SHOVEL);
		RecipeRemover.removeCraftingRecipe(Items.STONE_SWORD);
		RecipeRemover.removeCraftingRecipe(Items.WOODEN_AXE);
		RecipeRemover.removeCraftingRecipe(Items.WOODEN_HOE);
		RecipeRemover.removeCraftingRecipe(Items.WOODEN_PICKAXE);
		RecipeRemover.removeCraftingRecipe(Items.WOODEN_SHOVEL);
		RecipeRemover.removeCraftingRecipe(Items.WOODEN_SWORD);
	}
	
	private static void replaceMinecraftRecipes()
	{
		int dyeColors = 15;
		
		for(int i = 0; i <= 15; i++)
		{
			GameRegistry.addShapelessRecipe(new ItemStack(Blocks.WOOL, 1, i), new ItemStack(Blocks.WOOL, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.DYE, 1, dyeColors));
			dyeColors--;
		}
		
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.WOOL), "SSS", "SSS", "SSS", 'S', Items.STRING);
		
		GameRegistry.addShapedRecipe(new ItemStack(Items.DIAMOND_AXE), "D", "T", 'D', SPItems.DIAMOND_AXE_HEAD_SP, 'T', SPItems.TOOL_HANDLE_SP);
		GameRegistry.addShapedRecipe(new ItemStack(Items.DIAMOND_HOE), "D", "T", 'D', SPItems.DIAMOND_HOE_HEAD_SP, 'T', SPItems.TOOL_HANDLE_SP);
		GameRegistry.addShapedRecipe(new ItemStack(Items.DIAMOND_PICKAXE), "D", "T", 'D', SPItems.DIAMOND_PICKAXE_HEAD_SP, 'T', SPItems.TOOL_HANDLE_SP);
		GameRegistry.addShapedRecipe(new ItemStack(Items.DIAMOND_SHOVEL), "D", "T", 'D', SPItems.DIAMOND_SHOVEL_HEAD_SP, 'T', SPItems.TOOL_HANDLE_SP);
		GameRegistry.addShapedRecipe(new ItemStack(Items.DIAMOND_SWORD), "D", "T", 'D', SPItems.DIAMOND_SWORD_BLADE_SP, 'T', SPItems.TOOL_HANDLE_SP);
		GameRegistry.addShapedRecipe(new ItemStack(Items.GOLDEN_AXE), "G", "T", 'G', SPItems.GOLD_AXE_HEAD_SP, 'T', SPItems.TOOL_HANDLE_SP);
		GameRegistry.addShapedRecipe(new ItemStack(Items.GOLDEN_HOE), "G", "T", 'G', SPItems.GOLD_HOE_HEAD_SP, 'T', SPItems.TOOL_HANDLE_SP);
		GameRegistry.addShapedRecipe(new ItemStack(Items.GOLDEN_PICKAXE), "G", "T", 'G', SPItems.GOLD_PICKAXE_HEAD_SP, 'T', SPItems.TOOL_HANDLE_SP);
		GameRegistry.addShapedRecipe(new ItemStack(Items.GOLDEN_SHOVEL), "G", "T", 'G', SPItems.GOLD_SHOVEL_HEAD_SP, 'T', SPItems.TOOL_HANDLE_SP);
		GameRegistry.addShapedRecipe(new ItemStack(Items.GOLDEN_SWORD), "G", "T", 'G', SPItems.GOLD_SWORD_BLADE_SP, 'T', SPItems.TOOL_HANDLE_SP);
		GameRegistry.addShapedRecipe(new ItemStack(Items.IRON_AXE), "I", "T", 'I', SPItems.IRON_AXE_HEAD_SP, 'T', SPItems.TOOL_HANDLE_SP);
		GameRegistry.addShapedRecipe(new ItemStack(Items.IRON_HOE), "I", "T", 'I', SPItems.IRON_HOE_HEAD_SP, 'T', SPItems.TOOL_HANDLE_SP);
		GameRegistry.addShapedRecipe(new ItemStack(Items.IRON_PICKAXE), "I", "T", 'I', SPItems.IRON_PICKAXE_HEAD_SP, 'T', SPItems.TOOL_HANDLE_SP);
		GameRegistry.addShapedRecipe(new ItemStack(Items.IRON_SHOVEL), "I", "T", 'I', SPItems.IRON_SHOVEL_HEAD_SP, 'T', SPItems.TOOL_HANDLE_SP);
		GameRegistry.addShapedRecipe(new ItemStack(Items.IRON_SWORD), "I", "T", 'I', SPItems.IRON_SWORD_BLADE_SP, 'T', SPItems.TOOL_HANDLE_SP);
		GameRegistry.addShapedRecipe(new ItemStack(Items.STONE_AXE), "S", "T", 'S', SPItems.STONE_AXE_HEAD_SP, 'T', SPItems.TOOL_HANDLE_SP);
		GameRegistry.addShapedRecipe(new ItemStack(Items.STONE_HOE), "S", "T", 'S', SPItems.STONE_HOE_HEAD_SP, 'T', SPItems.TOOL_HANDLE_SP);
		GameRegistry.addShapedRecipe(new ItemStack(Items.STONE_PICKAXE), "S", "T", 'S', SPItems.STONE_PICKAXE_HEAD_SP, 'T', SPItems.TOOL_HANDLE_SP);
		GameRegistry.addShapedRecipe(new ItemStack(Items.STONE_SHOVEL), "S", "T", 'S', SPItems.STONE_SHOVEL_HEAD_SP, 'T', SPItems.TOOL_HANDLE_SP);
		GameRegistry.addShapedRecipe(new ItemStack(Items.STONE_SWORD), "S", "T", 'S', SPItems.STONE_SWORD_BLADE_SP, 'T', SPItems.TOOL_HANDLE_SP);
		GameRegistry.addShapedRecipe(new ItemStack(Items.WOODEN_AXE), "W", "T", 'W', SPItems.WOOD_AXE_HEAD_SP, 'T', SPItems.TOOL_HANDLE_SP);
		GameRegistry.addShapedRecipe(new ItemStack(Items.WOODEN_HOE), "W", "T", 'W', SPItems.WOOD_HOE_HEAD_SP, 'T', SPItems.TOOL_HANDLE_SP);
		GameRegistry.addShapedRecipe(new ItemStack(Items.WOODEN_PICKAXE), "W", "T", 'W', SPItems.WOOD_PICKAXE_HEAD_SP, 'T', SPItems.TOOL_HANDLE_SP);
		GameRegistry.addShapedRecipe(new ItemStack(Items.WOODEN_SHOVEL), "W", "T", 'W', SPItems.WOOD_SHOVEL_HEAD_SP, 'T', SPItems.TOOL_HANDLE_SP);
		GameRegistry.addShapedRecipe(new ItemStack(Items.WOODEN_SWORD), "W", "T", 'W', SPItems.WOOD_SWORD_BLADE_SP, 'T', SPItems.TOOL_HANDLE_SP);
	}
	
	private static void registerCustomRecipes()
	{
		toolParts();
		customTools();
		
	}
	
	private static void customTools()
	{
		GameRegistry.addShapedRecipe(new ItemStack(SPTools.FLINT_AXE_SP), "F", "T", 'F', SPItems.FLINT_AXE_HEAD_SP, 'T', SPItems.TOOL_HANDLE_SP);
		GameRegistry.addShapedRecipe(new ItemStack(SPTools.FLINT_HOE_SP), "F", "T", 'F', SPItems.FLINT_HOE_HEAD_SP, 'T', SPItems.TOOL_HANDLE_SP);
		GameRegistry.addShapedRecipe(new ItemStack(SPTools.FLINT_PICKAXE_SP), "F", "T", 'F', SPItems.FLINT_PICKAXE_HEAD_SP, 'T', SPItems.TOOL_HANDLE_SP);
		GameRegistry.addShapedRecipe(new ItemStack(SPTools.FLINT_SHOVEL_SP), "F", "T", 'F', SPItems.FLINT_SHOVEL_HEAD_SP, 'T', SPItems.TOOL_HANDLE_SP);
		GameRegistry.addShapedRecipe(new ItemStack(SPTools.FLINT_SWORD_SP), "F", "T", 'F', SPItems.FLINT_SWORD_BLADE_SP, 'T', SPItems.TOOL_HANDLE_SP);
		
		GameRegistry.addShapedRecipe(new ItemStack(SPTools.STEEL_AXE_SP), "S", "T", 'S', SPItems.STEEL_AXE_HEAD_SP, 'T', SPItems.TOOL_HANDLE_SP);
		GameRegistry.addShapedRecipe(new ItemStack(SPTools.STEEL_HOE_SP), "S", "T", 'S', SPItems.STEEL_HOE_HEAD_SP, 'T', SPItems.TOOL_HANDLE_SP);
		GameRegistry.addShapedRecipe(new ItemStack(SPTools.STEEL_PICKAXE_SP), "S", "T", 'S', SPItems.STEEL_PICKAXE_HEAD_SP, 'T', SPItems.TOOL_HANDLE_SP);
		GameRegistry.addShapedRecipe(new ItemStack(SPTools.STEEL_SHOVEL_SP), "S", "T", 'S', SPItems.STEEL_SHOVEL_HEAD_SP, 'T', SPItems.TOOL_HANDLE_SP);
		GameRegistry.addShapedRecipe(new ItemStack(SPTools.STEEL_SWORD_SP), "S", "T", 'S', SPItems.STEEL_SWORD_BLADE_SP, 'T', SPItems.TOOL_HANDLE_SP);
		
		GameRegistry.addShapedRecipe(new ItemStack(SPCraftingTools.TOOL_FILE_SP), "S", "S", "T", 'S', SPItems.STEEL_INGOT_SP, 'T', Items.STICK);
		GameRegistry.addShapedRecipe(new ItemStack(SPCraftingTools.TOOL_HAMMER_SP), "SSS", "SSS", " T ", 'S', SPItems.STEEL_INGOT_SP, 'T', SPItems.TOOL_HANDLE_SP);
		
		GameRegistry.addShapedRecipe(new ItemStack(SPCraftingTools.TOOL_FILE_SP), "I", "I", "T", 'I', Items.IRON_INGOT, 'T', Items.STICK);
		GameRegistry.addShapedRecipe(new ItemStack(SPCraftingTools.TOOL_HAMMER_SP), "III", "III", " T ", 'I', Items.IRON_INGOT, 'T', SPItems.TOOL_HANDLE_SP);
	}
	
	// These apparently have to be registered in the order that they appear, or it crashes
	public static void toolParts()
	{
		/*
		// Steel + Diamonds
		GameRegistry.addShapedRecipe(new ItemStack(SPItems.DIAMOND_AXE_HEAD_SP), "HF", "SD", 'S', SPItems.STEEL_AXE_HEAD_SP, 'D', Items.DIAMOND, 'H', new ItemStack(SPCraftingTools.TOOL_HAMMER_SP, 1, OreDictionary.WILDCARD_VALUE), 'F', new ItemStack(SPCraftingTools.TOOL_FILE_SP, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapedRecipe(new ItemStack(SPItems.DIAMOND_HOE_HEAD_SP), "HF", "SD", 'S', SPItems.STEEL_HOE_HEAD_SP, 'D', Items.DIAMOND, 'H', new ItemStack(SPCraftingTools.TOOL_HAMMER_SP, 1, OreDictionary.WILDCARD_VALUE), 'F', new ItemStack(SPCraftingTools.TOOL_FILE_SP, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapedRecipe(new ItemStack(SPItems.DIAMOND_PICKAXE_HEAD_SP), "HF", "SD", 'S', SPItems.STEEL_PICKAXE_HEAD_SP, 'D', Items.DIAMOND, 'H', new ItemStack(SPCraftingTools.TOOL_HAMMER_SP, 1, OreDictionary.WILDCARD_VALUE), 'F', new ItemStack(SPCraftingTools.TOOL_FILE_SP, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapedRecipe(new ItemStack(SPItems.DIAMOND_SHOVEL_HEAD_SP), "HF", "SD", 'S', SPItems.STEEL_SHOVEL_HEAD_SP, 'D', Items.DIAMOND, 'H', new ItemStack(SPCraftingTools.TOOL_HAMMER_SP, 1, OreDictionary.WILDCARD_VALUE), 'F', new ItemStack(SPCraftingTools.TOOL_FILE_SP, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapedRecipe(new ItemStack(SPItems.DIAMOND_SWORD_BLADE_SP), "HF", "SD", 'S', SPItems.STEEL_SWORD_BLADE_SP, 'D', Items.DIAMOND, 'H', new ItemStack(SPCraftingTools.TOOL_HAMMER_SP, 1, OreDictionary.WILDCARD_VALUE), 'F', new ItemStack(SPCraftingTools.TOOL_FILE_SP, 1, OreDictionary.WILDCARD_VALUE));
		
		GameRegistry.addShapedRecipe(new ItemStack(SPItems.FLINT_AXE_HEAD_SP), "FF", "FF", 'F', Items.FLINT);
		GameRegistry.addShapedRecipe(new ItemStack(SPItems.FLINT_HOE_HEAD_SP), "FF", 'F', Items.FLINT);
		GameRegistry.addShapedRecipe(new ItemStack(SPItems.FLINT_PICKAXE_HEAD_SP), "FFF", 'F', Items.FLINT);
		GameRegistry.addShapedRecipe(new ItemStack(SPItems.FLINT_SHOVEL_HEAD_SP), "F", 'F', Items.FLINT);
		GameRegistry.addShapedRecipe(new ItemStack(SPItems.FLINT_SWORD_BLADE_SP), "F", "F", 'F', Items.FLINT);
		
		GameRegistry.addShapedRecipe(new ItemStack(SPItems.GOLD_AXE_HEAD_SP), "HF", "GG", "GG", 'G', Items.GOLD_INGOT, 'H', new ItemStack(SPCraftingTools.TOOL_HAMMER_SP, 1, OreDictionary.WILDCARD_VALUE), 'F', new ItemStack(SPCraftingTools.TOOL_FILE_SP, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapedRecipe(new ItemStack(SPItems.GOLD_HOE_HEAD_SP), "HF", "GG", 'G', Items.GOLD_INGOT, 'H', new ItemStack(SPCraftingTools.TOOL_HAMMER_SP, 1, OreDictionary.WILDCARD_VALUE), 'F', new ItemStack(SPCraftingTools.TOOL_FILE_SP, 1, OreDictionary.WILDCARD_VALUE));
		//GameRegistry.addShapedRecipe(new ItemStack(SPItems.GOLD_PICKAXE_HEAD_SP), "HF", "GGG", 'G', Items.GOLD_INGOT, 'H', new ItemStack(SPCraftingTools.TOOL_HAMMER_SP, 1, OreDictionary.WILDCARD_VALUE), 'F', new ItemStack(SPCraftingTools.TOOL_FILE_SP, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapedRecipe(new ItemStack(SPItems.GOLD_SHOVEL_HEAD_SP), "HF", "G", 'G', Items.GOLD_INGOT, 'H', new ItemStack(SPCraftingTools.TOOL_HAMMER_SP, 1, OreDictionary.WILDCARD_VALUE), 'F', new ItemStack(SPCraftingTools.TOOL_FILE_SP, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapedRecipe(new ItemStack(SPItems.GOLD_SWORD_BLADE_SP), "HF", "G", "G", 'G', Items.GOLD_INGOT, 'H', new ItemStack(SPCraftingTools.TOOL_HAMMER_SP, 1, OreDictionary.WILDCARD_VALUE), 'F', new ItemStack(SPCraftingTools.TOOL_FILE_SP, 1, OreDictionary.WILDCARD_VALUE));
		
		GameRegistry.addShapedRecipe(new ItemStack(SPItems.IRON_AXE_HEAD_SP), "HF", "II", "II", 'G', Items.IRON_INGOT, 'H', new ItemStack(SPCraftingTools.TOOL_HAMMER_SP, 1, OreDictionary.WILDCARD_VALUE), 'F', new ItemStack(SPCraftingTools.TOOL_FILE_SP, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapedRecipe(new ItemStack(SPItems.IRON_HOE_HEAD_SP), "HF", "I", 'G', Items.IRON_INGOT, 'H', new ItemStack(SPCraftingTools.TOOL_HAMMER_SP, 1, OreDictionary.WILDCARD_VALUE), 'F', new ItemStack(SPCraftingTools.TOOL_FILE_SP, 1, OreDictionary.WILDCARD_VALUE));
		//GameRegistry.addShapedRecipe(new ItemStack(SPItems.IRON_PICKAXE_HEAD_SP), "HF", "III", 'G', Items.IRON_INGOT, 'H', new ItemStack(SPCraftingTools.TOOL_HAMMER_SP, 1, OreDictionary.WILDCARD_VALUE), 'F', new ItemStack(SPCraftingTools.TOOL_FILE_SP, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapedRecipe(new ItemStack(SPItems.IRON_SHOVEL_HEAD_SP), "HF", "I", 'G', Items.IRON_INGOT, 'H', new ItemStack(SPCraftingTools.TOOL_HAMMER_SP, 1, OreDictionary.WILDCARD_VALUE), 'F', new ItemStack(SPCraftingTools.TOOL_FILE_SP, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapedRecipe(new ItemStack(SPItems.IRON_SWORD_BLADE_SP), "HF", "I", "I", 'G', Items.IRON_INGOT, 'H', new ItemStack(SPCraftingTools.TOOL_HAMMER_SP, 1, OreDictionary.WILDCARD_VALUE), 'F', new ItemStack(SPCraftingTools.TOOL_FILE_SP, 1, OreDictionary.WILDCARD_VALUE));
		
		GameRegistry.addShapedRecipe(new ItemStack(SPItems.STEEL_AXE_HEAD_SP), "HF", "SS", "SS", 'G', SPItems.STEEL_INGOT_SP, 'H', new ItemStack(SPCraftingTools.TOOL_HAMMER_SP, 1, OreDictionary.WILDCARD_VALUE), 'F', new ItemStack(SPCraftingTools.TOOL_FILE_SP, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapedRecipe(new ItemStack(SPItems.STEEL_HOE_HEAD_SP), "HF", "SS", 'G', SPItems.STEEL_INGOT_SP, 'H', new ItemStack(SPCraftingTools.TOOL_HAMMER_SP, 1, OreDictionary.WILDCARD_VALUE), 'F', new ItemStack(SPCraftingTools.TOOL_FILE_SP, 1, OreDictionary.WILDCARD_VALUE));
		//GameRegistry.addShapedRecipe(new ItemStack(SPItems.STEEL_PICKAXE_HEAD_SP), "HF", "SSS", 'G', SPItems.STEEL_INGOT_SP, 'H', new ItemStack(SPCraftingTools.TOOL_HAMMER_SP, 1, OreDictionary.WILDCARD_VALUE), 'F', new ItemStack(SPCraftingTools.TOOL_FILE_SP, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapedRecipe(new ItemStack(SPItems.STEEL_SHOVEL_HEAD_SP), "HF", "S", 'G', SPItems.STEEL_INGOT_SP, 'H', new ItemStack(SPCraftingTools.TOOL_HAMMER_SP, 1, OreDictionary.WILDCARD_VALUE), 'F', new ItemStack(SPCraftingTools.TOOL_FILE_SP, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapedRecipe(new ItemStack(SPItems.STEEL_SWORD_BLADE_SP), "HF", "S", "S", 'G', SPItems.STEEL_INGOT_SP, 'H', new ItemStack(SPCraftingTools.TOOL_HAMMER_SP, 1, OreDictionary.WILDCARD_VALUE), 'F', new ItemStack(SPCraftingTools.TOOL_FILE_SP, 1, OreDictionary.WILDCARD_VALUE));
		
		//GameRegistry.addShapedRecipe(new ItemStack(SPItems.STONE_AXE_HEAD_SP), "F", "CC", "CC", 'C', Blocks.COBBLESTONE, 'F', new ItemStack(SPCraftingTools.TOOL_FILE_SP, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapedRecipe(new ItemStack(SPItems.STONE_HOE_HEAD_SP), "F", "CC", 'C', Blocks.COBBLESTONE, 'F', new ItemStack(SPCraftingTools.TOOL_FILE_SP, 1, OreDictionary.WILDCARD_VALUE));
		//GameRegistry.addShapedRecipe(new ItemStack(SPItems.STONE_PICKAXE_HEAD_SP), "F", "CCC", 'C', Blocks.COBBLESTONE, 'F', new ItemStack(SPCraftingTools.TOOL_FILE_SP, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapedRecipe(new ItemStack(SPItems.STONE_SHOVEL_HEAD_SP), "F", "C", 'C', Blocks.COBBLESTONE, 'F', new ItemStack(SPCraftingTools.TOOL_FILE_SP, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapedRecipe(new ItemStack(SPItems.STONE_SWORD_BLADE_SP), "F", "C", "C", 'C', Blocks.COBBLESTONE, 'F', new ItemStack(SPCraftingTools.TOOL_FILE_SP, 1, OreDictionary.WILDCARD_VALUE));
		
		GameRegistry.addShapedRecipe(new ItemStack(SPItems.WOOD_AXE_HEAD_SP), "F", "WW", "WW", 'W', new ItemStack(Blocks.PLANKS,1, OreDictionary.WILDCARD_VALUE), 'F', new ItemStack(SPCraftingTools.TOOL_FILE_SP, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapedRecipe(new ItemStack(SPItems.WOOD_HOE_HEAD_SP), "F", "WW", 'W', new ItemStack(Blocks.PLANKS,1,OreDictionary.WILDCARD_VALUE), 'F', new ItemStack(SPCraftingTools.TOOL_FILE_SP, 1, OreDictionary.WILDCARD_VALUE));
		//GameRegistry.addShapedRecipe(new ItemStack(SPItems.WOOD_PICKAXE_HEAD_SP), "F", "WWW", 'W', new ItemStack(Blocks.PLANKS,1,OreDictionary.WILDCARD_VALUE), 'F', new ItemStack(SPCraftingTools.TOOL_FILE_SP, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapedRecipe(new ItemStack(SPItems.WOOD_SHOVEL_HEAD_SP), "F", "W", 'W', new ItemStack(Blocks.PLANKS,1,OreDictionary.WILDCARD_VALUE), 'F', new ItemStack(SPCraftingTools.TOOL_FILE_SP, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapedRecipe(new ItemStack(SPItems.WOOD_SWORD_BLADE_SP), "F", "W", "W", 'W', new ItemStack(Blocks.PLANKS,1,OreDictionary.WILDCARD_VALUE), 'F', new ItemStack(SPCraftingTools.TOOL_FILE_SP, 1, OreDictionary.WILDCARD_VALUE));
		
		*/
		GameRegistry.addShapedRecipe(new ItemStack(SPItems.TOOL_HANDLE_SP), "S", "S", 'S', Items.STICK);
	}
	
	private static void exampleMetas()
	{
		//      Item, Amount, Meta
		GameRegistry.addShapedRecipe(new ItemStack(SPFoods.APPLE_SP, 1, 0), "A", " ", " ", 'A', Items.APPLE); // Crafts a Fresh Apple
		GameRegistry.addShapedRecipe(new ItemStack(SPFoods.APPLE_SP, 1, 1), " ", "A", " ", 'A', Items.APPLE); // Crafts a Stale Apple
		GameRegistry.addShapedRecipe(new ItemStack(SPFoods.APPLE_SP, 1, 2), " "," ","A", 'A', Items.APPLE); // Crafts a Moldy Apple
	}
}
