package com.gmail.rohzek.useables;

import com.gmail.rohzek.main.Main;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemFileSP extends Item
{
	public ItemFileSP(String names) 
	{
		super();
		setNames(names);
		setMaxDamage(25);
		setCreativeTab(Main.SP_TOOLS_TAB);
	}

	@Override
	public boolean hasContainerItem(ItemStack stack) 
	{
		return true;
	}

	@Override
	public ItemStack getContainerItem(ItemStack stack) 
	{
		stack = stack.copy();
		stack.attemptDamageItem(1, itemRand);
		return stack;
	}
	
	private void setNames(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
	}
}
