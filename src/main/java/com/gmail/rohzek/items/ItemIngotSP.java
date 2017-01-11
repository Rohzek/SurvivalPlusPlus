package com.gmail.rohzek.items;

import com.gmail.rohzek.main.Main;

import net.minecraft.item.Item;

public class ItemIngotSP extends Item
{
	public ItemIngotSP(String names)
	{
		setNames(names);
		setCreativeTab(Main.SP_INGOTS_TAB);
	}
	
	private void setNames(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
	}
}
