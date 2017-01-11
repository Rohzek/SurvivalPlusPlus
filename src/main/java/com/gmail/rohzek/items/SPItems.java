package com.gmail.rohzek.items;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.IForgeRegistry;

public class SPItems 
{
	// Pieces
	public static final ItemToolPart DIAMOND_AXE_HEAD_SP = new ItemToolPart("diamondAxeHeadSP");
	public static final ItemToolPart DIAMOND_HOE_HEAD_SP = new ItemToolPart("diamondHoeHeadSP");
	public static final ItemToolPart DIAMOND_PICKAXE_HEAD_SP = new ItemToolPart("diamondPickaxeHeadSP");
	public static final ItemToolPart DIAMOND_SHOVEL_HEAD_SP = new ItemToolPart("diamondShovelHeadSP");
	public static final ItemToolPart DIAMOND_SWORD_BLADE_SP = new ItemToolPart("diamondSwordBladeSP");
	public static final ItemToolPart FLINT_AXE_HEAD_SP = new ItemToolPart("flintAxeHeadSP");
	public static final ItemToolPart FLINT_HOE_HEAD_SP = new ItemToolPart("flintHoeHeadSP");
	public static final ItemToolPart FLINT_PICKAXE_HEAD_SP = new ItemToolPart("flintPickaxeHeadSP");
	public static final ItemToolPart FLINT_SHOVEL_HEAD_SP = new ItemToolPart("flintShovelHeadSP");
	public static final ItemToolPart FLINT_SWORD_BLADE_SP = new ItemToolPart("flintSwordBladeSP");
	public static final ItemToolPart GOLD_AXE_HEAD_SP = new ItemToolPart("goldAxeHeadSP");
	public static final ItemToolPart GOLD_HOE_HEAD_SP = new ItemToolPart("goldHoeHeadSP");
	public static final ItemToolPart GOLD_PICKAXE_HEAD_SP = new ItemToolPart("goldPickaxeHeadSP");
	public static final ItemToolPart GOLD_SHOVEL_HEAD_SP = new ItemToolPart("goldShovelHeadSP");
	public static final ItemToolPart GOLD_SWORD_BLADE_SP = new ItemToolPart("goldSwordBladeSP");
	public static final ItemToolPart IRON_AXE_HEAD_SP = new ItemToolPart("ironAxeHeadSP");
	public static final ItemToolPart IRON_HOE_HEAD_SP = new ItemToolPart("ironHoeHeadSP");
	public static final ItemToolPart IRON_PICKAXE_HEAD_SP = new ItemToolPart("ironPickaxeHeadSP");
	public static final ItemToolPart IRON_SHOVEL_HEAD_SP = new ItemToolPart("ironShovelHeadSP");
	public static final ItemToolPart IRON_SWORD_BLADE_SP = new ItemToolPart("ironSwordBladeSP");
	public static final ItemToolPart STEEL_AXE_HEAD_SP = new ItemToolPart("steelAxeHeadSP");
	public static final ItemToolPart STEEL_HOE_HEAD_SP = new ItemToolPart("steelHoeHeadSP");
	public static final ItemToolPart STEEL_PICKAXE_HEAD_SP = new ItemToolPart("steelPickaxeHeadSP");
	public static final ItemToolPart STEEL_SHOVEL_HEAD_SP = new ItemToolPart("steelShovelHeadSP");
	public static final ItemToolPart STEEL_SWORD_BLADE_SP = new ItemToolPart("steelSwordBladeSP");
	public static final ItemToolPart STONE_AXE_HEAD_SP = new ItemToolPart("stoneAxeHeadSP");
	public static final ItemToolPart STONE_HOE_HEAD_SP = new ItemToolPart("stoneHoeHeadSP");
	public static final ItemToolPart STONE_PICKAXE_HEAD_SP = new ItemToolPart("stonePickaxeHeadSP");
	public static final ItemToolPart STONE_SHOVEL_HEAD_SP = new ItemToolPart("stoneShovelHeadSP");
	public static final ItemToolPart STONE_SWORD_BLADE_SP = new ItemToolPart("stoneSwordBladeSP");
	public static final ItemToolPart WOOD_AXE_HEAD_SP = new ItemToolPart("woodAxeHeadSP");
	public static final ItemToolPart WOOD_HOE_HEAD_SP = new ItemToolPart("woodHoeHeadSP");
	public static final ItemToolPart WOOD_PICKAXE_HEAD_SP = new ItemToolPart("woodPickaxeHeadSP");
	public static final ItemToolPart WOOD_SHOVEL_HEAD_SP = new ItemToolPart("woodShovelHeadSP");
	public static final ItemToolPart WOOD_SWORD_BLADE_SP = new ItemToolPart("woodSwordBladeSP");
	
	// Tool Handle
	public static final ItemToolPart TOOL_HANDLE_SP = new ItemToolPart("toolHandleSP");
	
	// Ingots
	public static final ItemIngotSP STEEL_INGOT_SP = new ItemIngotSP("steelIngotSP");
	
	public static void registerRenders() 
	{
		// Tool Pieces
		registerRender(DIAMOND_AXE_HEAD_SP);
		registerRender(DIAMOND_HOE_HEAD_SP);
		registerRender(DIAMOND_PICKAXE_HEAD_SP);
		registerRender(DIAMOND_SHOVEL_HEAD_SP);
		registerRender(DIAMOND_SWORD_BLADE_SP);
		registerRender(FLINT_AXE_HEAD_SP);
		registerRender(FLINT_HOE_HEAD_SP);
		registerRender(FLINT_PICKAXE_HEAD_SP);
		registerRender(FLINT_SHOVEL_HEAD_SP);
		registerRender(FLINT_SWORD_BLADE_SP);
		registerRender(GOLD_AXE_HEAD_SP);
		registerRender(GOLD_HOE_HEAD_SP);
		registerRender(GOLD_PICKAXE_HEAD_SP);
		registerRender(GOLD_SHOVEL_HEAD_SP);
		registerRender(GOLD_SWORD_BLADE_SP);
		registerRender(IRON_AXE_HEAD_SP);
		registerRender(IRON_HOE_HEAD_SP);
		registerRender(IRON_PICKAXE_HEAD_SP);
		registerRender(IRON_SHOVEL_HEAD_SP);
		registerRender(IRON_SWORD_BLADE_SP);
		registerRender(STEEL_AXE_HEAD_SP);
		registerRender(STEEL_HOE_HEAD_SP);
		registerRender(STEEL_PICKAXE_HEAD_SP);
		registerRender(STEEL_SHOVEL_HEAD_SP);
		registerRender(STEEL_SWORD_BLADE_SP);
		registerRender(STONE_AXE_HEAD_SP);
		registerRender(STONE_HOE_HEAD_SP);
		registerRender(STONE_PICKAXE_HEAD_SP);
		registerRender(STONE_SHOVEL_HEAD_SP);
		registerRender(STONE_SWORD_BLADE_SP);
		registerRender(WOOD_AXE_HEAD_SP);
		registerRender(WOOD_HOE_HEAD_SP);
		registerRender(WOOD_PICKAXE_HEAD_SP);
		registerRender(WOOD_SHOVEL_HEAD_SP);
		registerRender(WOOD_SWORD_BLADE_SP);
		
		// Tool Handle
		registerRender(TOOL_HANDLE_SP);
		
		// Ingots
		registerRender(STEEL_INGOT_SP);
	}
	
	public static void registerRender(Item item)
	{	
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
	
	public static void registerRender(Item item, int meta, String addon)
	{	
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName() + addon, "inventory"));
	}
	
	@Mod.EventBusSubscriber
	public static class RegistrationHandler 
	{
		public static final Set<Item> ITEMS = new HashSet<Item>();
		
		@SubscribeEvent
		public static void registerItems(RegistryEvent.Register<Item> event) 
		{
			final Item[] ingredients =
				{
					DIAMOND_AXE_HEAD_SP,
					DIAMOND_HOE_HEAD_SP,
					DIAMOND_PICKAXE_HEAD_SP,
					DIAMOND_SHOVEL_HEAD_SP,
					DIAMOND_SWORD_BLADE_SP,
					FLINT_AXE_HEAD_SP,
					FLINT_HOE_HEAD_SP,
					FLINT_PICKAXE_HEAD_SP,
					FLINT_SHOVEL_HEAD_SP,
					FLINT_SWORD_BLADE_SP,
					GOLD_AXE_HEAD_SP,
					GOLD_HOE_HEAD_SP,
					GOLD_PICKAXE_HEAD_SP,
					GOLD_SHOVEL_HEAD_SP,
					GOLD_SWORD_BLADE_SP,
					IRON_AXE_HEAD_SP,
					IRON_HOE_HEAD_SP,
					IRON_PICKAXE_HEAD_SP,
					IRON_SHOVEL_HEAD_SP,
					IRON_SWORD_BLADE_SP,
					STEEL_AXE_HEAD_SP,
					STEEL_HOE_HEAD_SP,
					STEEL_PICKAXE_HEAD_SP,
					STEEL_SHOVEL_HEAD_SP,
					STEEL_SWORD_BLADE_SP,
					STONE_AXE_HEAD_SP,
					STONE_HOE_HEAD_SP,
					STONE_PICKAXE_HEAD_SP,
					STONE_SHOVEL_HEAD_SP,
					STONE_SWORD_BLADE_SP,
					WOOD_AXE_HEAD_SP,
					WOOD_HOE_HEAD_SP,
					WOOD_PICKAXE_HEAD_SP,
					WOOD_SHOVEL_HEAD_SP,
					WOOD_SWORD_BLADE_SP,
					TOOL_HANDLE_SP,
					STEEL_INGOT_SP,
				};
			
			final IForgeRegistry<Item> registry = event.getRegistry();

			for (final Item item : ingredients) 
			{
				registry.register(item);
				ITEMS.add(item);
			}
		}
	}
}
