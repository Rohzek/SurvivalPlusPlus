package com.gmail.rohzek.blocks;

import java.util.HashSet;
import java.util.Set;

import com.gmail.rohzek.lib.Reference;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.common.registry.IForgeRegistry;

@ObjectHolder(Reference.MODID)
public class SPBlocks 
{	
	public static final Block MELON_SP = new SPMelon("melonSP");
	public static final Block PUMPKIN_SP = new SPPumpkin("pumpkinSP");
	public static final Block PUMPKIN_FACE_SP = new SPPumpkinFace("pumpkinFaceSP");
	public static final Block PUMPKIN_FACE_LIT_SP = new SPPumpkinFaceLit("pumpkinFaceLitSP");
	
	public static void registerRenders()
	{
		registerRender(Item.getItemFromBlock(MELON_SP));
		registerRender(Item.getItemFromBlock(PUMPKIN_SP));
		registerRender(Item.getItemFromBlock(PUMPKIN_FACE_SP));
		registerRender(Item.getItemFromBlock(PUMPKIN_FACE_LIT_SP));
	}
	
	public static void registerRender(Item item)
	{	
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
	
	@Mod.EventBusSubscriber
	public static class RegistrationHandler 
	{
		public static final Set<ItemBlock> ITEM_BLOCKS = new HashSet<ItemBlock>();

		@SubscribeEvent
		public static void registerBlocks(RegistryEvent.Register<Block> event) 
		{
			final IForgeRegistry<Block> registry = event.getRegistry();

			final Block[] blocks = 
			{
					MELON_SP,
					PUMPKIN_SP,
					PUMPKIN_FACE_SP,
					PUMPKIN_FACE_LIT_SP,
			};

			registry.registerAll(blocks);
		}
		
		@SubscribeEvent
		public static void registerItemBlocks(RegistryEvent.Register<Item> event) 
		{
			final ItemBlock[] items = 
			{
					new ItemBlock(MELON_SP),
					new ItemBlock(PUMPKIN_SP),
					new ItemBlock(PUMPKIN_FACE_SP),
					new ItemBlock(PUMPKIN_FACE_LIT_SP),
			};

			final IForgeRegistry<Item> registry = event.getRegistry();

			for (final ItemBlock item : items) 
			{
				registry.register(item.setRegistryName(item.getBlock().getRegistryName()));
				ITEM_BLOCKS.add(item);
			}
		}
	}

	public static void registerTileEntities(){}

	private static void registerTileEntity(Class<? extends TileEntity> tileEntityClass, String name) 
	{
		GameRegistry.registerTileEntity(tileEntityClass, Reference.RESOURCEID + name);
	}

	private static void registerTileEntity(Class<? extends TileEntity> tileEntityClass, String name, String legacyName) 
	{
		GameRegistry.registerTileEntityWithAlternatives(tileEntityClass, Reference.RESOURCEID + name, Reference.RESOURCEID + legacyName);
	}
}
