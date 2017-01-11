package com.gmail.rohzek.events;

import com.gmail.rohzek.util.ConfigurationManager;
import com.gmail.rohzek.util.LogHelper;

import net.minecraft.block.Block;
import net.minecraft.block.BlockAnvil;
import net.minecraft.block.BlockBeacon;
import net.minecraft.block.BlockBone;
import net.minecraft.block.BlockBrewingStand;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockDispenser;
import net.minecraft.block.BlockDropper;
import net.minecraft.block.BlockEnderChest;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.BlockHopper;
import net.minecraft.block.BlockIce;
import net.minecraft.block.BlockNetherBrick;
import net.minecraft.block.BlockObserver;
import net.minecraft.block.BlockPrismarine;
import net.minecraft.block.BlockQuartz;
import net.minecraft.block.BlockSandStone;
import net.minecraft.block.BlockShulkerBox;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.block.BlockStoneSlab;
import net.minecraft.block.BlockStoneSlabNew;
import net.minecraft.block.BlockWall;
import net.minecraft.block.BlockWoodSlab;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class BreakBlockEventSP 
{
	@SubscribeEvent
	public static void breakSpeed(PlayerEvent.BreakSpeed event) 
	{
		IBlockState state = event.getState();
		Block block = state.getBlock();
		EntityPlayer player = event.getEntityPlayer();
		
		if(ConfigurationManager.correctTools)
		{
			if(!canToolMine(state, block, player))
			{
				event.setCanceled(true);
				LogHelper.debug("Ah, ah, ah. No breaky. Find the correct tool.");
			}
		}
	}
	
	@SubscribeEvent
	public static void breakBlock(BlockEvent.BreakEvent event) 
	{
		IBlockState state = event.getState();
		Block block = state.getBlock();
		EntityPlayer player = event.getPlayer();
		
		if(ConfigurationManager.correctTools)
		{
			if(!canToolMine(state, block, player))
			{
				event.setCanceled(true);
				LogHelper.debug("Ah, ah, ah. No breaky. Find the correct tool.");
			}
		}
	}
	
	// If block needs a tool
	public static boolean doesBlockNeedTool(IBlockState state, Block block)
	{	
		return block.getHarvestTool(state) != null ? true : false;
	}
	
	// What tool are we holding
	public static Item currentHeldItem(EntityPlayer player)
	{
		return player.inventory.getCurrentItem().getItem();
	}
	
	// Is this tool right for this block?
	public static boolean canToolMine(IBlockState state, Block block, EntityPlayer player)
	{		
		ItemStack stack = player.inventory.getCurrentItem();
		Item item = stack.getItem();
		
		int blockHarvestLevel =  block.getHarvestLevel(state);
		int itemHarvestLevel = item.getHarvestLevel(stack, block.getHarvestTool(state), player, state);
		
		if(!player.capabilities.isCreativeMode)
		{
			if(block.getHarvestTool(state) != null)
			{
				if(block.getHarvestTool(state).equals("shovel") || block instanceof BlockChest || block instanceof BlockIce ||  
				   block == Blocks.LADDER || block instanceof BlockShulkerBox || block == Blocks.MELON_BLOCK)
				{
					// We can dig without a tool, and pickup chests and break thin ice without a tool.
					return true;
				}
			}
			
			else if(block.getHarvestTool(state) == null)
			{
				if(block == Blocks.REDSTONE_BLOCK || block == Blocks.COAL_BLOCK || block == Blocks.STONE_STAIRS ||
				   block instanceof BlockWall)
				{
					// These blocks require a pickaxe but don't get picked up, block them anyway
					return item instanceof ItemPickaxe ? true : false;
				}
				
				if(block instanceof BlockDropper || block instanceof BlockHopper || block instanceof BlockFurnace ||
				   block instanceof BlockBrewingStand || block instanceof BlockAnvil || block instanceof BlockEnderChest ||
				   block instanceof BlockDispenser || block == Blocks.END_STONE || block == Blocks.IRON_TRAPDOOR ||
				   block == Blocks.IRON_BARS || block instanceof BlockObserver || block instanceof BlockBeacon)
				{
					// These blocks require a pickaxe but don't get picked up, block them anyway
					return item instanceof ItemPickaxe ? true : false;
				}
				
				if(block instanceof BlockBone || block instanceof BlockPrismarine || 
				   block == Blocks.HARDENED_CLAY || block == Blocks.STAINED_HARDENED_CLAY)
				{
					// These blocks require a pickaxe but don't get picked up, block them anyway
					return item instanceof ItemPickaxe ? true : false;
				}
				
				if(block instanceof BlockNetherBrick || block == Blocks.NETHER_BRICK_STAIRS)
				{
					// Netherbrick stuff seems to be iffy.
					return item instanceof ItemPickaxe ? true : false;
				}
				
				if(block instanceof BlockStoneBrick || block == Blocks.STONE_BRICK_STAIRS ||
				   block == Blocks.BRICK_BLOCK || block == Blocks.BRICK_STAIRS)
				{
					// Brick stuffs fail the checks below, but we still require a pickaxe.
					return item instanceof ItemPickaxe ? true : false;
				}
				
				if(block instanceof BlockQuartz || block == Blocks.QUARTZ_STAIRS)
				{
					// Stone bricks fail the checks below, but we still require a pickaxe.
					return item instanceof ItemPickaxe ? true : false;
				}
				
				if(block == Blocks.ACACIA_STAIRS || block == Blocks.BIRCH_STAIRS || block == Blocks.DARK_OAK_STAIRS ||
				   block == Blocks.JUNGLE_STAIRS || block == Blocks.OAK_STAIRS)
				{
					// Wooden stairs don't count as wood blocks, but blocks them too.
					return item instanceof ItemAxe ? true : false;
				}
				
				if(block instanceof BlockSandStone || block == Blocks.SANDSTONE_STAIRS || block == Blocks.RED_SANDSTONE_STAIRS)
				{
					// Sandstone stuff seems to be iffy
					return item instanceof ItemPickaxe ? true : false;
				}
				
				if(block == Blocks.PURPUR_BLOCK || block == Blocks.PURPUR_PILLAR || block == Blocks.PURPUR_STAIRS ||
				   block == Blocks.PURPUR_DOUBLE_SLAB ||block == Blocks.PURPUR_SLAB)
				{
					// Purpur stuff is probably iffy, atleast the slabs and stuffs.
					return item instanceof ItemPickaxe ? true : false;
				}
				
				if(block instanceof BlockStoneSlab || block instanceof BlockStoneSlabNew)
				{
					// Slabs seem to not be blocked
					return item instanceof ItemPickaxe ? true : false;
				}
				
				if(block instanceof BlockWoodSlab)
				{
					// Slabs seem to not be blocked
					return item instanceof ItemAxe ? true : false;
				}
				
				// We don't need a tool to mine this anyway
				return true;
			}
			
			else{}
			// If all else fails, then we need the correct tool.
			
		    // Gold returns 0 and gold would be useless as a tool, so we're going to ignore it.
			return blockHarvestLevel <= (itemHarvestLevel > 0 ? itemHarvestLevel : -1);
		}
		return true;
	}
}
