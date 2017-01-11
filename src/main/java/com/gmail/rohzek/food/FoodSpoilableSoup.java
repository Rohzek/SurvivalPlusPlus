package com.gmail.rohzek.food;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class FoodSpoilableSoup extends FoodSpoilable
{	
	public FoodSpoilableSoup(int hunger, float saturation, int time, String name) 
	{
		super(hunger, saturation, false, time, true, name);
	}
	
	public FoodSpoilableSoup(int hunger, float saturation, int time, String name, PotionEffect... effects)
	{
		super(hunger, saturation, false, time, true, name, effects);
	}
	
	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) 
	{
		super.onItemUseFinish(stack, worldIn, entityLiving);
		
		return new ItemStack(Items.BOWL);
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack itemStack)
    {
		return EnumAction.DRINK;
    }
}
