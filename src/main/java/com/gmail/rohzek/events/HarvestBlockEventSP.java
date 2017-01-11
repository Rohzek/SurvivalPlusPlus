package com.gmail.rohzek.events;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.gmail.rohzek.blocks.SPBlocks;
import com.gmail.rohzek.food.SPFoods;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class HarvestBlockEventSP 
{
	@SubscribeEvent
	public static void onBlockHarvest(HarvestDropsEvent event)
	{	
		Random rand = new Random();
		
		Block block = event.getState().getBlock();
		World world = event.getWorld();
		BlockPos pos = event.getPos();
		EntityPlayer harvester = event.getHarvester();
		int fortune = event.getFortuneLevel();
		IBlockState state = event.getState();
		
		List<ItemStack> items = new ArrayList<ItemStack>();
		
		// Replace vanilla melon drops with ours
		if(block == Blocks.MELON_BLOCK)
		{
			event.getDrops().clear();
			items.add(createItemStack(SPBlocks.MELON_SP));
			event.getDrops().addAll(items);
		}
		
		// Replace pumpkins -- Shouldn't be required, vanilla pumpkin spawn should be disabled.
		else if(block == Blocks.PUMPKIN)
		{
			event.getDrops().clear();
			items.add(createItemStack(SPBlocks.PUMPKIN_SP));
			event.getDrops().addAll(items);
		}
		
		// Replace leaves
		else if(block == Blocks.LEAVES || block == Blocks.LEAVES2)
		{
			event.getDrops().clear();
			int metadata = block.damageDropped(state);
			if(harvester != null && harvester.inventory.getCurrentItem().getItem() == Items.SHEARS)
			{
				if(block == Blocks.LEAVES)
				{
					items.add(createItemStack(Blocks.LEAVES, 1, metadata));
				}
				if(metadata == 0)
				{
					items.add(createItemStack(SPFoods.APPLE_SP, rand.nextInt(2)));
				}
			}
			else
			{	
				items.add(createItemStack(Blocks.SAPLING, rand.nextInt(3), metadata));
				items.add(createItemStack(Items.STICK, rand.nextInt(3)));
			}
			
			event.getDrops().addAll(items);
		}
	}
	
	private static ItemStack createItemStack(Item item)
	{
		return new ItemStack(item);
	}
	
	private static ItemStack createItemStack(Item item, int amount)
	{
		return new ItemStack(item, amount);
	}
	
	private static ItemStack createItemStack(Item item, int amount, int meta)
	{
		return new ItemStack(item, amount, meta);
	}
	
	private static ItemStack createItemStack(Block block)
	{
		return new ItemStack(Item.getItemFromBlock(block));
	}
	
	private static ItemStack createItemStack(Block block, int amount)
	{
		return new ItemStack(Item.getItemFromBlock(block), amount);
	}
	
	private static ItemStack createItemStack(Block block, int amount, int meta)
	{
		return new ItemStack(Item.getItemFromBlock(block), amount, meta);
	}
}
