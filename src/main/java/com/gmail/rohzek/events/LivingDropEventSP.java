package com.gmail.rohzek.events;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.gmail.rohzek.food.SPFoods;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityDonkey;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.entity.passive.EntityMule;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class LivingDropEventSP 
{
	@SubscribeEvent
	public static void onLivingDrop(LivingDropsEvent event)
	{
		Entity entity = event.getEntity();
		World world = entity.getEntityWorld();
		BlockPos pos = entity.getPosition();
		
		// Chicken Drops
		if(entity instanceof EntityChicken)
		{
			event.getDrops().clear();
			
			List<EntityItem> items = new ArrayList<EntityItem>();
			
			if(entity.isBurning())
			{
				EntityItem item = createEntityItem(world, pos, SPFoods.CHICKEN_COOKED_SP);
				items.add(item);
			}
			else
			{
				EntityItem item = createEntityItem(world, pos, SPFoods.CHICKEN_SP);
				items.add(item);
			}
			
			EntityItem item = createEntityItem(world, pos, Items.FEATHER, 3);
			items.add(item);
			
			event.getDrops().addAll(items);
		}
		
		// Cow Drops
		if(entity instanceof EntityCow)
		{
			event.getDrops().clear();
			
			List<EntityItem> items = new ArrayList<EntityItem>();
			
			if(entity.isBurning())
			{
				EntityItem item = createEntityItem(world, pos, SPFoods.BEEF_COOKED_SP, 1, 4);
				items.add(item);
			}
			else
			{
				EntityItem item = createEntityItem(world, pos, SPFoods.BEEF_SP, 1, 4);
				items.add(item);
			}
			
			EntityItem item = createEntityItem(world, pos, Items.LEATHER, 3);
			items.add(item);
			
			event.getDrops().addAll(items);
		}
		
		// We're counting a Donkey as a Horse
		if(entity instanceof EntityDonkey)
		{
			event.getDrops().clear();
			
			List<EntityItem> items = new ArrayList<EntityItem>();
			
			if(entity.isBurning())
			{
				EntityItem item = createEntityItem(world, pos, SPFoods.HORSE_BEEF_COOKED_SP, 1, 4);
				items.add(item);
			}
			else
			{
				EntityItem item = createEntityItem(world, pos, SPFoods.HORSE_BEEF_SP, 1, 4);
				items.add(item);
			}
			
			EntityItem item = createEntityItem(world, pos, Items.LEATHER, 3);
			items.add(item);
			
			event.getDrops().addAll(items);
		}
		
		// Enderman
		if(entity instanceof EntityEnderman)
		{
			event.getDrops().clear();
			
			List<EntityItem> items = new ArrayList<EntityItem>();
			
			if(entity.isBurning())
			{
				EntityItem item = createEntityItem(world, pos, SPFoods.ANDR_MEAT_COOKED_SP, 1, 3);
				items.add(item);
			}
			else
			{
				EntityItem item = createEntityItem(world, pos, SPFoods.ANDR_MEAT_SP, 1, 3);
				items.add(item);
			}
			
			EntityItem item = createEntityItem(world, pos, Items.ENDER_PEARL, 2);
			items.add(item);
			
			event.getDrops().addAll(items);
		}
		
		// Horse
		if(entity instanceof EntityHorse)
		{
			event.getDrops().clear();
			
			List<EntityItem> items = new ArrayList<EntityItem>();
			
			if(entity.isBurning())
			{
				EntityItem item = createEntityItem(world, pos, SPFoods.HORSE_BEEF_COOKED_SP, 1, 4);
				items.add(item);
			}
			else
			{
				EntityItem item = createEntityItem(world, pos, SPFoods.HORSE_BEEF_SP, 1, 4);
				items.add(item);
			}
			
			EntityItem item = createEntityItem(world, pos, Items.LEATHER, 3);
			items.add(item);
			
			event.getDrops().addAll(items);
		}
		
		// Counting a Mule as a Horse
		if(entity instanceof EntityMule)
		{
			event.getDrops().clear();
			
			List<EntityItem> items = new ArrayList<EntityItem>();
			
			if(entity.isBurning())
			{
				EntityItem item = createEntityItem(world, pos, SPFoods.HORSE_BEEF_COOKED_SP, 1, 4);
				items.add(item);
			}
			else
			{
				EntityItem item = createEntityItem(world, pos, SPFoods.HORSE_BEEF_SP, 1, 4);
				items.add(item);
			}
			
			EntityItem item = createEntityItem(world, pos, Items.LEATHER, 3);
			items.add(item);
			
			event.getDrops().addAll(items);
		}
		
		// Mooshroom
		if(entity instanceof EntityMooshroom)
		{
			event.getDrops().clear();
			
			List<EntityItem> items = new ArrayList<EntityItem>();
			
			if(entity.isBurning())
			{
				EntityItem item = createEntityItem(world, pos, SPFoods.BEEF_COOKED_SP, 1, 4);
				items.add(item);
				
				EntityItem item2 = createEntityItem(world, pos, SPFoods.MUSHROOM_RED_GRILLED, 4);
				items.add(item2);
			}
			else
			{
				EntityItem item = createEntityItem(world, pos, SPFoods.BEEF_SP, 1, 4);
				items.add(item);
				
				EntityItem item2 = createEntityItem(world, pos, Item.getItemFromBlock(Blocks.RED_MUSHROOM), 4); // My red mushroom
				items.add(item2);
			}
			
			event.getDrops().addAll(items);
		}
		
		// Pig
		if(entity instanceof EntityPig)
		{
			event.getDrops().clear();
			
			List<EntityItem> items = new ArrayList<EntityItem>();
			
			if(entity.isBurning())
			{
				EntityItem item = createEntityItem(world, pos, SPFoods.PORK_COOKED_SP, 1, 4);
				items.add(item);
			}
			else
			{
				EntityItem item = createEntityItem(world, pos, SPFoods.PORK_SP, 1, 4);
				items.add(item);
			}
			
			event.getDrops().addAll(items);
		}
		
		// Usagi
		if(entity instanceof EntityRabbit)
		{
			event.getDrops().clear();
			
			List<EntityItem> items = new ArrayList<EntityItem>();
			
			if(entity.isBurning())
			{
				EntityItem item = createEntityItem(world, pos, SPFoods.RABBIT_COOKED_SP);
				//items.add(item);
			}
			else
			{
				EntityItem item = createEntityItem(world, pos, SPFoods.RABBIT_SP);
				//items.add(item);
			}
			
			EntityItem item = createEntityItem(world, pos, Items.RABBIT_HIDE, 2);
			items.add(item);
			
			event.getDrops().addAll(items);
		}
		
		// Sheep
		if(entity instanceof EntitySheep)
		{
			event.getDrops().clear();
			
			List<EntityItem> items = new ArrayList<EntityItem>();
			
			if(entity.isBurning())
			{
				EntityItem item = createEntityItem(world, pos, SPFoods.MUTTON_COOKED_SP, 1, 4);
				items.add(item);
			}
			else
			{
				EntityItem item = createEntityItem(world, pos, SPFoods.MUTTON_SP, 1, 4);
				items.add(item);
			}
			
			EntitySheep ent = (EntitySheep) entity;
			
			EnumDyeColor color = ent.getFleeceColor();
			
			int woolColor = color.getMetadata();
			
			if(!ent.getSheared())
			{
				EntityItem item = createEntityItem(world, pos, woolColor, Item.getItemFromBlock(Blocks.WOOL), 1, 3);
				items.add(item);
			}
			
			event.getDrops().addAll(items);
		}
		
		// Squid
		if(entity instanceof EntitySquid)
		{
			event.getDrops().clear();
			
			List<EntityItem> items = new ArrayList<EntityItem>();
			
			if(entity.isBurning())
			{
				EntityItem item = createEntityItem(world, pos, SPFoods.CALAMARI_COOKED_SP, 1, 6);
				items.add(item);
			}
			else
			{
				EntityItem item = createEntityItem(world, pos, SPFoods.CALAMARI_SP, 1, 6);
				items.add(item);
			}
			
			EntityItem item = createEntityItem(world, pos, Items.DYE);
			items.add(item);
			
			event.getDrops().addAll(items);
		}
		
		// Villager
		if(entity instanceof EntityVillager)
		{
			event.getDrops().clear();
			
			List<EntityItem> items = new ArrayList<EntityItem>();
			
			if(entity.isBurning())
			{
				EntityItem item = createEntityItem(world, pos, SPFoods.LONG_PORK_COOKED_SP, 1, 6);
				items.add(item);
			}
			else
			{
				EntityItem item = createEntityItem(world, pos, SPFoods.LONG_PORK_SP, 1, 6);
				items.add(item);
			}
			
			EntityItem item = createEntityItem(world, pos, Items.EMERALD, 2);
			items.add(item);
			
			event.getDrops().addAll(items);
		}
	}
	
	private static EntityItem createEntityItem(World world, BlockPos pos, Item item)
	{
		return new EntityItem(world, pos.getX(), pos.getY() + 1, pos.getZ(), new ItemStack(item));
	}
	
	private static EntityItem createEntityItem(World world, BlockPos pos, int meta, Item item)
	{
		return new EntityItem(world, pos.getX(), pos.getY() + 1, pos.getZ(), new ItemStack(item, 1, meta));
	}
	
	private static EntityItem createEntityItem(World world, BlockPos pos, int meta, Item item, int amount)
	{
		Random rand = new Random();
		
		return new EntityItem(world, pos.getX(), pos.getY() + 1, pos.getZ(), new ItemStack(item, rand.nextInt(amount), meta));
	}
	
	private static EntityItem createEntityItem(World world, BlockPos pos, int meta, Item item, int min, int max)
	{
		Random rand = new Random();
		
		return new EntityItem(world, pos.getX(), pos.getY() + 1, pos.getZ(), new ItemStack(item, min + rand.nextInt(max), meta));
	}
	
	private static EntityItem createEntityItem(World world, BlockPos pos, Item item, int amount)
	{
		Random rand = new Random();
		
		return new EntityItem(world, pos.getX(), pos.getY() + 1, pos.getZ(), new ItemStack(item, rand.nextInt(amount)));
	}
	
	private static EntityItem createEntityItem(World world, BlockPos pos, Item item, int amtMin, int amtMax)
	{
		Random rand = new Random();
		
		return new EntityItem(world, pos.getX(), pos.getY() + 1, pos.getZ(), new ItemStack(item, amtMin + rand.nextInt(amtMax)));
	}
	
	private static EntityItem createEntityItem(World world, BlockPos pos, ItemStack stack)
	{
		Random rand = new Random();
		
		return new EntityItem(world, pos.getX(), pos.getY() + 1, pos.getZ(), stack);
	}
}
