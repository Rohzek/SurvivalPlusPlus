package com.gmail.rohzek.blocks;

import com.gmail.rohzek.main.Main;

import net.minecraft.block.BlockPumpkin;

public class SPPumpkin extends BlockPumpkin
{
	public SPPumpkin(String name)
	{
		super();
		
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
