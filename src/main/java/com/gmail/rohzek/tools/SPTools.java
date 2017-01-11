package com.gmail.rohzek.tools;

import java.util.HashSet;
import java.util.Set;

import com.gmail.rohzek.items.SPItems;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.IForgeRegistry;

public class SPTools 
{
	public final static ToolAxeSP FLINT_AXE_SP = new ToolAxeSP(ToolMaterials.TOOL_MATERIAL_FLINT, 3.5f, 0.2f, "flintAxeSP"); // Adjust damage + speed
	public final static ToolHoeSP FLINT_HOE_SP = new ToolHoeSP(ToolMaterials.TOOL_MATERIAL_FLINT, "flintHoeSP");
	public final static ToolPickaxeSP FLINT_PICKAXE_SP = new ToolPickaxeSP(ToolMaterials.TOOL_MATERIAL_FLINT, "flintPickaxeSP");
	public final static ToolShovelSP FLINT_SHOVEL_SP = new ToolShovelSP(ToolMaterials.TOOL_MATERIAL_FLINT, "flintShovelSP");
	public final static ToolSwordSP FLINT_SWORD_SP = new ToolSwordSP(ToolMaterials.TOOL_MATERIAL_FLINT, "flintSwordSP");
	public final static ToolAxeSP STEEL_AXE_SP = new ToolAxeSP(ToolMaterials.TOOL_MATERIAL_STEEL, 5.0f, 0.2f, "steelAxeSP"); // Adjust damage + speed
	public final static ToolHoeSP STEEL_HOE_SP = new ToolHoeSP(ToolMaterials.TOOL_MATERIAL_STEEL, "steelHoeSP");
	public final static ToolPickaxeSP STEEL_PICKAXE_SP = new ToolPickaxeSP(ToolMaterials.TOOL_MATERIAL_STEEL, "steelPickaxeSP");
	public final static ToolShovelSP STEEL_SHOVEL_SP = new ToolShovelSP(ToolMaterials.TOOL_MATERIAL_STEEL, "steelShovelSP");
	public final static ToolSwordSP STEEL_SWORD_SP = new ToolSwordSP(ToolMaterials.TOOL_MATERIAL_STEEL, "steelSwordSP");
	
	public static void registerRenders() 
	{
		ToolMaterials.TOOL_MATERIAL_FLINT.setRepairItem(new ItemStack(Items.FLINT));
		ToolMaterials.TOOL_MATERIAL_STEEL.setRepairItem(new ItemStack(SPItems.STEEL_INGOT_SP));
		
		registerRender(FLINT_AXE_SP);
		registerRender(FLINT_HOE_SP);
		registerRender(FLINT_PICKAXE_SP);
		registerRender(FLINT_SHOVEL_SP);
		registerRender(FLINT_SWORD_SP);
		registerRender(STEEL_AXE_SP);
		registerRender(STEEL_HOE_SP);
		registerRender(STEEL_PICKAXE_SP);
		registerRender(STEEL_SHOVEL_SP);
		registerRender(STEEL_SWORD_SP);
	}
	
	public static void registerRender(Item item)
	{	
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
	
	@Mod.EventBusSubscriber
	public static class RegistrationHandler 
	{
		public static final Set<Item> ITEMS = new HashSet<Item>();

		@SubscribeEvent
		public static void registerItems(RegistryEvent.Register<Item> event) 
		{
			final Item[] items = 
			{
				FLINT_AXE_SP,
				FLINT_HOE_SP,
				FLINT_PICKAXE_SP,
				FLINT_SHOVEL_SP,
				FLINT_SWORD_SP,
				STEEL_AXE_SP,
				STEEL_HOE_SP,
				STEEL_PICKAXE_SP,
				STEEL_SHOVEL_SP,
				STEEL_SWORD_SP,
			};

			final IForgeRegistry<Item> registry = event.getRegistry();

			for (final Item item : items) 
			{
				registry.register(item);
				ITEMS.add(item);
			}
		}
	}
}
