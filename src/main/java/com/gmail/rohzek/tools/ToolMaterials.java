package com.gmail.rohzek.tools;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

public class ToolMaterials 
{	                    // String name, int harvestLevel, int maxUses, float efficiency, float damage, int enchantability
	public static final Item.ToolMaterial TOOL_MATERIAL_FLINT = EnumHelper.addToolMaterial("flint", 1, 115, 4.0f, 1.0f, 5);
	public static final Item.ToolMaterial TOOL_MATERIAL_STEEL = EnumHelper.addToolMaterial("steel", 3, 999, 7.0f, 2.8f, 9);
}