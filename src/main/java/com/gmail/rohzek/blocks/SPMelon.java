package com.gmail.rohzek.blocks;

import com.gmail.rohzek.main.Main;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class SPMelon extends Block
{
	public SPMelon(String name) 
	{
		super(Material.GOURD, MapColor.LIME);
		
		setCreativeTab(Main.SP_INGREDIENTS_TAB);
		
		setHardness(1.0f);
		
		setNames(name);
	}
	
	public void setNames(String name)
	{
		setRegistryName(name);
		setUnlocalizedName(name);
	}
	
}
