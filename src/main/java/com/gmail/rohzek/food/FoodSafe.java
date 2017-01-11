package com.gmail.rohzek.food;

import com.gmail.rohzek.main.Main;

import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;

public class FoodSafe extends ItemFood
{	
	public FoodSafe(int hunger, float saturation, boolean isWolfFood, String name) 
	{
		super(hunger, saturation, isWolfFood);
		setNames(name);
		setCreativeTab(Main.SP_FOODS_TAB);
	}
	
	public FoodSafe(int hunger, float saturation, boolean isWolfFood, String name, PotionEffect... effects) 
	{
		super(hunger, saturation, isWolfFood);
		setNames(name);
		
		for(int i = 0; i < effects.length; i++)
		{
			setPotionEffect(effects[i], 1.0f);
		}
		
		setCreativeTab(Main.SP_FOODS_TAB);
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack item)
    {
        return 20;
    }
	
	private void setNames(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
	}
}
