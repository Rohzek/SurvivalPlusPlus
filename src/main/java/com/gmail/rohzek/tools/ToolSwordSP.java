package com.gmail.rohzek.tools;

import com.gmail.rohzek.main.Main;

import net.minecraft.item.ItemSword;

public class ToolSwordSP extends ItemSword
{
	public ToolSwordSP(ToolMaterial material, String names) 
	{
		super(material);
		setNames(names);
		setCreativeTab(Main.SP_TOOLS_TAB);
	}
	
	private void setNames(String names)
	{
		setRegistryName(names);
		setUnlocalizedName(names);
	}
}
