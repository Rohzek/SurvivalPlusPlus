package com.gmail.rohzek.tools;

import com.gmail.rohzek.main.Main;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;

public class ToolAxeSP extends ItemAxe
{
	public ToolAxeSP(ToolMaterial material, float damage, float speed, String names) 
	{
		super(material, damage, speed);
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
