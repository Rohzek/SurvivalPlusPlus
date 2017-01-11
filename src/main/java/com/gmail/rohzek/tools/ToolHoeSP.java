package com.gmail.rohzek.tools;

import com.gmail.rohzek.main.Main;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;

public class ToolHoeSP extends ItemHoe
{
	public ToolHoeSP(ToolMaterial material, String names) 
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
	
	@Override
	public int getHarvestLevel(ItemStack stack, String toolClass, EntityPlayer player, IBlockState blockState) 
	{
		return 1;
	}
}
