package com.gmail.rohzek.useables;

import com.gmail.rohzek.main.Main;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;

public class ToolKnifeSP extends Item
{
	public ToolKnifeSP(String names) 
	{
		super();
		setNames(names);
		setMaxDamage(50);
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
	
	private void setNames(String names)
	{
		setRegistryName(names);
		setUnlocalizedName(names);
	}
}
