package com.gmail.rohzek.util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;

//Can remove custom crafting recipes and smelting recipes from the game...
public class RecipeRemover 
{
	// Checks for recipes that turn into items
	public static void removeCraftingRecipe(Item item)
	{
		int recipesRemoved = 0;
		
	     List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
	     Iterator<IRecipe> remover = recipes.iterator();
	     
	     while(remover.hasNext())
	     {
	    	// If the output matches the specified item
	    	 ItemStack itemstack = remover.next().getRecipeOutput();
				
				if(itemstack != null && itemstack.getItem() == item)
				{
					// Remove the recipe
					remover.remove();
					recipesRemoved++;
				}
	     }
	     
	     LogHelper.debug("Removed " + recipesRemoved + " crafting recipes for " + item.getRegistryName());
	}
	
	// Checks for reciepes that turn into items
		public static void removeCraftingRecipe(ItemStack itemStack)
		{
			int recipesRemoved = 0;
			
		     List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
		     Iterator<IRecipe> remover = recipes.iterator();
		     
		     while(remover.hasNext())
		     {
		    	// If the output matches the specified block
		    	 ItemStack itemstack = remover.next().getRecipeOutput();
					
					if(itemstack != null && itemstack == itemStack)
					{
						// Remove the recipe
						remover.remove();
						recipesRemoved++;
					}
		     }
		     
		     LogHelper.debug("Removed " + recipesRemoved + " crafting recipes for " + itemStack.getDisplayName());
		}
	
	// Checks for recipes that turn into blocks
	public static void removeCraftingRecipe(Block block)
	{
		int recipesRemoved = 0;
		
	     List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
	     Iterator<IRecipe> remover = recipes.iterator();
	     
	     while(remover.hasNext())
	     {
	    	 ItemStack itemstack = remover.next().getRecipeOutput();
				
	    	 	// If the output matches the specified block
				if(itemstack != null && itemstack.getItem() == Item.getItemFromBlock(block))
				{
					// Remove the recipe
					remover.remove();
					recipesRemoved++;
				}
	     }
	     
	     LogHelper.debug("Removed " + recipesRemoved + " crafting recipes for " + block.getLocalizedName());
	}
	
	public static void removeRecipeClass(Class<? extends IRecipe> recipeClass) 
	{
		int recipesRemoved = 0;

		List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
		Iterator<IRecipe> remover = recipes.iterator();

		while (remover.hasNext()) 
		{
			// If the recipe is an instance of the specified class,
			if (recipeClass.isInstance(remover.next())) 
			{
				// Remove the recipe
				remover.remove();
				recipesRemoved++;
			}
		}
		 LogHelper.debug("Removed " + recipesRemoved + " crafting recipes for " + recipeClass.getName());
	}
	
	// You have to pass in a new ItemStack().. But this will work for Items or Blocks without extra work.
	public static void removeSmeltingRecipe (ItemStack itemstack)
	{
		int recipesRemoved = 0;
		
		Map<ItemStack, ItemStack> recipes = FurnaceRecipes.instance().getSmeltingList();
		
		for (Iterator<Map.Entry<ItemStack, ItemStack>> remover = recipes.entrySet().iterator(); remover.hasNext(); ) 
		{
			Map.Entry<ItemStack, ItemStack> entry = remover.next();
			
			ItemStack result = entry.getValue();
			
			if (ItemStack.areItemStacksEqual(result, itemstack)) 
			{
				remover.remove();
				recipesRemoved++;
			}
		}
		
		LogHelper.debug("Removed smelting recipes for " + itemstack.getDisplayName());
	}
	
	
}

