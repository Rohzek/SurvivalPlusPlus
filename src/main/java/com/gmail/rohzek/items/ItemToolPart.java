package com.gmail.rohzek.items;

import com.gmail.rohzek.main.Main;

import net.minecraft.item.Item;

public class ItemToolPart extends Item
{
	public ItemToolPart(String names)
	{
		setNames(names);
		setCreativeTab(Main.SP_TOOL_PARTS_TAB);
	}
	
	private void setNames(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
	}
}
