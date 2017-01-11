package com.gmail.rohzek.food;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.IForgeRegistry;

public class SPFoods 
{
	public static int timeDay = 24000; // ticks for one whole day
	public static int fresh = 0, stale = 1, moldy = 2;
	public static String conFresh = "fresh", conStale = "stale", conMoldy = "moldy";
	
	// Minecraft Foods - Spoilable Type
	public static final Item APPLE_SP = new FoodSpoilable(4, 0.3f, false, (timeDay * 7), true, "appleSP"); // lasts 7 days;
	public static final Item BEEF_SP= new FoodSpoilable(3, 0.3f, true, timeDay, false, "beefSP");
	public static final Item BEEF_COOKED_SP = new FoodSpoilable(8, 0.8f, true, timeDay, true, "beefCookedSP"); // Steak
	public static final Item BREAD_SP = new FoodSpoilable(5, 0.6f, true, (timeDay * 7), true, "breadSP");
	public static final Item CHICKEN_SP = new FoodSpoilable(2, 0.3f, true, timeDay, false, "chickenSP");
	public static final Item CHICKEN_COOKED_SP = new FoodSpoilable(6, 0.6f, true, timeDay, true, "chickenCookedSP");
	//public static final Item CHORUS_FRUIT_SP;
	public static final Item CLOWN_FISH_SP = new FoodSpoilable(2, 0.3f, false, timeDay, false, "clownFishSP");
	public static final Item COOKIE_SP = new FoodSpoilable(2, 0.1f, false, (timeDay * 7), true, "cookieSP");
	public static final Item FISH_SP = new FoodSpoilable(2, 0.3f, false, timeDay, false, "fishSP");
	public static final Item FISH_COOKED_SP = new FoodSpoilable(5, 0.5f, false, timeDay, true, "fishCookedSP");
	public static final Item MELON_SLICE_SP = new FoodSpoilable(2, 0.3f, false, timeDay, true, "melonSliceSP");
	public static final Item MUTTON_SP = new FoodSpoilable(2, 0.3f, false, timeDay, false, "muttonSP");
	public static final Item MUTTON_COOKED_SP = new FoodSpoilable(8, 0.8f, false, timeDay, true, "muttonCookedSP");
	public static final Item PORK_SP = new FoodSpoilable(3, 0.3f, false, timeDay, true, "porkSP");
	public static final Item PORK_COOKED_SP = new FoodSpoilable(8, 0.8f, true, timeDay, true, "porkCookedSP");
	public static final Item POTATO_COOKED_SP = new FoodSpoilable(5, 0.6f, false, (timeDay * 2), true, "potatoCookedSP");
	public static final Item PUMPKIN_PIE_SP = new FoodSpoilable(8, 0.3f, false, (timeDay * 4), true, "pumpkinPieSP");
	public static final Item RABBIT_SP = new FoodSpoilable(2, 0.3f, true, timeDay, false, "rabbitSP");
	public static final Item RABBIT_COOKED_SP = new FoodSpoilable(5, 0.6f, true, timeDay, true, "rabbitCookedSP");
	public static final Item SALMON_SP = new FoodSpoilable(2, 0.3f, false, timeDay, false, "salmonSP");
	public static final Item SALMON_COOKED_SP = new FoodSpoilable(5, 0.5f, false, timeDay, true, "salmonCookedSP");
	
	// Added Foods - Spoilable Type
	public static final Item ANDR_MEAT_SP = new FoodSpoilable(2, 0.3f, false, timeDay, false, "andrMeatSP");
	public static final Item ANDR_MEAT_COOKED_SP = new FoodSpoilable(5, 0.6f, false, timeDay, true, "andrMeatCookedSP");
	public static final Item CALAMARI_SP = new FoodSpoilable(2, 0.3f, false, timeDay, false, "calamariSP");
	public static final Item CALAMARI_COOKED_SP = new FoodSpoilable(5, 0.6f, false, timeDay, true, "calamariCookedSP");
	public static final Item CARROT_COOKED_SP = new FoodSpoilable(4, 0.4f, false, timeDay, true, "carrotCookedSP");
	public static final Item EGG_COOKED_SP = new FoodSpoilable(2, 0.4f, false, timeDay, true, "eggCookedSP");
	public static final Item HORSE_BEEF_SP = new FoodSpoilable(2, 0.3f, false, timeDay, false, "horseBeefSP");
	public static final Item HORSE_BEEF_COOKED_SP = new FoodSpoilable(8, 0.8f, true, timeDay, true, "horseBeefCookedSP");
	public static final Item LONG_PORK_SP = new FoodSpoilable(2, 0.3f, true, timeDay, false, "longPorkSP");
	public static final Item LONG_PORK_COOKED_SP = new FoodSpoilable(4, 0.4f, true, timeDay, true, "longPorkCookedSP");
	public static final Item MUSHROOM_BROWN_GRILLED = new FoodSpoilable(6, 0.5f, false, (timeDay * 7), true, "mushroomBrownGrilledSP"); // Strength
	public static final Item MUSHROOM_RED_GRILLED = new FoodSpoilable(6, 0.5f, false, (timeDay * 7), true, "mushroomRedGrilledSP"); // Strength
	//public static final Item PUFFERFISH_PREPARED;
	public static final Item RICE_COOKED = new FoodSpoilable(8, 1.0f, false, timeDay, true, "riceCookedSP");
	public static final Item SUSHI = new FoodSpoilable(4, 0.3f, false, timeDay, true, "sushiSP");
	public static final Item SUSHI_CLOWNFISH = new FoodSpoilable(4, 0.3f, false, timeDay, true, "sushiClownfishSP");
	public static final Item SUSHI_PUFFERFISH = new FoodSpoilable(4, 0.3f, false, timeDay, true, "sushiPufferfishSP");
	public static final Item SUSHI_SALMON = new FoodSpoilable(4, 0.3f, false, timeDay, true, "sushiSalmonSP");
	
	// Plantables - Minecraft
	public static final Item BEETROOT_SP = new FoodSpoilablePlantable(1, 0.6f, (timeDay * 6), "beetrootSP", Blocks.BEETROOTS, Blocks.FARMLAND); // 6 days
	public static final Item CARROT_SP = new FoodSpoilablePlantable(3, 0.4f, (timeDay * 6), "carrotSP", Blocks.CARROTS, Blocks.FARMLAND); // 4 days
	public static final Item POTATO_SP = new FoodSpoilablePlantable(3, 0.4f, (timeDay * 6), "potatoSP", Blocks.POTATOES, Blocks.FARMLAND); // 2 weeks
	
	// Soups - Minecraft
	public static final Item BEET_ROOT_SOUP_SP = new FoodSpoilableSoup(6, 0.5f, (timeDay * 4), "beetRootSoupSP");
	public static final Item MUSHROOM_STEW_SP = new FoodSpoilableSoup(6, 0.5f, (timeDay * 4), "mushroomStewSP");
	public static final Item RABBIT_STEW_SP = new FoodSpoilableSoup(7, 0.9f, (timeDay * 4), "rabbitStewSP");
	
	// Soups - Added
	public static final Item BEEF_STEW_SP = new FoodSpoilableSoup(7, 0.8f, (timeDay * 4), "beefStewSP");
	public static final Item CHICKEN_DUMPLINGS_SP = new FoodSpoilableSoup(7, 0.5f, (timeDay * 4), "chickenDumplingsSP");
	
	// Salted
	public static final Item ANDR_MEAT_SALTED_SP = new FoodSafe(5, 0.6f, false, "andrMeatSaltedSP");
	public static final Item BEEF_SALTED_SP = new FoodSafe(8, 0.8f, true, "beefSaltedSP");
	public static final Item CHICKEN_SALTED_SP = new FoodSafe(6, 0.6f, false, "chickenSaltedSP");
	public static final Item HORSE_BEEF_SALTED_SP = new FoodSafe(8, 0.8f, false, "horseBeefSaltedSP");
	public static final Item LONG_PORK_SALTED_SP = new FoodSafe(4, 0.4f, false, "longPorkSaltedSP");
	public static final Item PORK_SALTED_SP = new FoodSafe(8, 0.8f, false, "porkSaltedSP");
	public static final Item MUTTON_SALTED_SP = new FoodSafe(6, 0.6f, false, "muttonSaltedSP");
	
	public static void registerRenders() 
	{
		// Minecraft Foods - Spoilable Type
		registerRender(APPLE_SP, fresh, conFresh);
		registerRender(APPLE_SP, stale, conStale);
		registerRender(APPLE_SP, moldy, conMoldy);
		registerRender(BEEF_SP, fresh, conFresh);
		registerRender(BEEF_SP, stale, conStale);
		registerRender(BEEF_SP, moldy, conMoldy);
		registerRender(BEEF_COOKED_SP, fresh, conFresh);
		registerRender(BEEF_COOKED_SP, stale, conStale);
		registerRender(BEEF_COOKED_SP, moldy, conMoldy);
		registerRender(BREAD_SP, fresh, conFresh);
		registerRender(BREAD_SP, stale, conStale);
		registerRender(BREAD_SP, moldy, conMoldy);
		registerRender(CHICKEN_SP, fresh, conFresh);
		registerRender(CHICKEN_SP, stale, conStale);
		registerRender(CHICKEN_SP, moldy, conMoldy);
		registerRender(CHICKEN_COOKED_SP, fresh, conFresh);
		registerRender(CHICKEN_COOKED_SP, stale, conStale);
		registerRender(CHICKEN_COOKED_SP, moldy, conMoldy);
		registerRender(CLOWN_FISH_SP, fresh, conFresh);
		registerRender(CLOWN_FISH_SP, stale, conStale);
		registerRender(CLOWN_FISH_SP, moldy, conMoldy);
		registerRender(COOKIE_SP, fresh, conFresh);
		registerRender(COOKIE_SP, stale, conStale);
		registerRender(COOKIE_SP, moldy, conMoldy);
		registerRender(FISH_SP, fresh, conFresh);
		registerRender(FISH_SP, stale, conStale);
		registerRender(FISH_SP, moldy, conMoldy);
		registerRender(FISH_COOKED_SP, fresh, conFresh);
		registerRender(FISH_COOKED_SP, stale, conStale);
		registerRender(FISH_COOKED_SP, moldy, conMoldy);
		registerRender(MELON_SLICE_SP, fresh, conFresh);
		registerRender(MELON_SLICE_SP, stale, conStale);
		registerRender(MELON_SLICE_SP, moldy, conMoldy);
		registerRender(MUTTON_SP, fresh, conFresh);
		registerRender(MUTTON_SP, stale, conStale);
		registerRender(MUTTON_SP, moldy, conMoldy);
		registerRender(MUTTON_COOKED_SP, fresh, conFresh);
		registerRender(MUTTON_COOKED_SP, stale, conStale);
		registerRender(MUTTON_COOKED_SP, moldy, conMoldy);
		registerRender(PORK_SP, fresh, conFresh);
		registerRender(PORK_SP, stale, conStale);
		registerRender(PORK_SP, moldy, conMoldy);
		registerRender(PORK_COOKED_SP, fresh, conFresh);
		registerRender(PORK_COOKED_SP, stale, conStale);
		registerRender(PORK_COOKED_SP, moldy, conMoldy);
		registerRender(POTATO_COOKED_SP, fresh, conFresh);
		registerRender(POTATO_COOKED_SP, stale, conStale);
		registerRender(POTATO_COOKED_SP, moldy, conMoldy);
		registerRender(PUMPKIN_PIE_SP, fresh, conFresh);
		registerRender(PUMPKIN_PIE_SP, stale, conStale);
		registerRender(PUMPKIN_PIE_SP, moldy, conMoldy);
		registerRender(RABBIT_SP, fresh, conFresh);
		registerRender(RABBIT_SP, stale, conStale);
		registerRender(RABBIT_SP, moldy, conMoldy);
		registerRender(RABBIT_COOKED_SP, fresh, conFresh);
		registerRender(RABBIT_COOKED_SP, stale, conStale);
		registerRender(RABBIT_COOKED_SP, moldy, conMoldy);
		registerRender(SALMON_SP, fresh, conFresh);
		registerRender(SALMON_SP, stale, conStale);
		registerRender(SALMON_SP, moldy, conMoldy);
		registerRender(SALMON_COOKED_SP, fresh, conFresh);
		registerRender(SALMON_COOKED_SP, stale, conStale);
		registerRender(SALMON_COOKED_SP, moldy, conMoldy);
		
		// Added Foods - Spoilable Type
		registerRender(ANDR_MEAT_SP, fresh, conFresh);
		registerRender(ANDR_MEAT_SP, stale, conStale);
		registerRender(ANDR_MEAT_SP, moldy, conMoldy);
		registerRender(ANDR_MEAT_COOKED_SP, fresh, conFresh);
		registerRender(ANDR_MEAT_COOKED_SP, stale, conStale);
		registerRender(ANDR_MEAT_COOKED_SP, moldy, conMoldy);
		registerRender(CALAMARI_SP, fresh, conFresh);
		registerRender(CALAMARI_SP, stale, conStale);
		registerRender(CALAMARI_SP, moldy, conMoldy);
		registerRender(CALAMARI_COOKED_SP, fresh, conFresh);
		registerRender(CALAMARI_COOKED_SP, stale, conStale);
		registerRender(CALAMARI_COOKED_SP, moldy, conMoldy);
		registerRender(CARROT_COOKED_SP, fresh, conFresh);
		registerRender(CARROT_COOKED_SP, stale, conStale);
		registerRender(CARROT_COOKED_SP, moldy, conMoldy);
		registerRender(EGG_COOKED_SP, fresh, conFresh);
		registerRender(EGG_COOKED_SP, stale, conStale);
		registerRender(EGG_COOKED_SP, moldy, conMoldy);
		registerRender(HORSE_BEEF_SP, fresh, conFresh);
		registerRender(HORSE_BEEF_SP, stale, conStale);
		registerRender(HORSE_BEEF_SP, moldy, conMoldy);
		registerRender(HORSE_BEEF_COOKED_SP, fresh, conFresh);
		registerRender(HORSE_BEEF_COOKED_SP, stale, conStale);
		registerRender(HORSE_BEEF_COOKED_SP, moldy, conMoldy);
		registerRender(LONG_PORK_SP, fresh, conFresh);
		registerRender(LONG_PORK_SP, stale, conStale);
		registerRender(LONG_PORK_SP, moldy, conMoldy);
		registerRender(LONG_PORK_COOKED_SP, fresh, conFresh);
		registerRender(LONG_PORK_COOKED_SP, stale, conStale);
		registerRender(LONG_PORK_COOKED_SP, moldy, conMoldy);
		registerRender(MUSHROOM_BROWN_GRILLED, fresh, conFresh);
		registerRender(MUSHROOM_BROWN_GRILLED, stale, conStale);
		registerRender(MUSHROOM_BROWN_GRILLED, moldy, conMoldy);
		registerRender(MUSHROOM_RED_GRILLED, fresh, conFresh);
		registerRender(MUSHROOM_RED_GRILLED, stale, conStale);
		registerRender(MUSHROOM_RED_GRILLED, moldy, conMoldy);
		registerRender(RICE_COOKED, fresh, conFresh);
		registerRender(RICE_COOKED, stale, conStale);
		registerRender(RICE_COOKED, moldy, conMoldy);
		registerRender(SUSHI, fresh, conFresh);
		registerRender(SUSHI, stale, conStale);
		registerRender(SUSHI, moldy, conMoldy);
		registerRender(SUSHI_CLOWNFISH, fresh, conFresh);
		registerRender(SUSHI_CLOWNFISH, stale, conStale);
		registerRender(SUSHI_CLOWNFISH, moldy, conMoldy);
		registerRender(SUSHI_PUFFERFISH, fresh, conFresh);
		registerRender(SUSHI_PUFFERFISH, stale, conStale);
		registerRender(SUSHI_PUFFERFISH, moldy, conMoldy);
		registerRender(SUSHI_SALMON, fresh, conFresh);
		registerRender(SUSHI_SALMON, stale, conStale);
		registerRender(SUSHI_SALMON, moldy, conMoldy);
		
		// Plantables
		registerRender(BEETROOT_SP, fresh, conFresh);
		registerRender(BEETROOT_SP, stale, conStale);
		registerRender(BEETROOT_SP, moldy, conMoldy);
		registerRender(CARROT_SP, fresh, conFresh);
		registerRender(CARROT_SP, stale, conStale);
		registerRender(CARROT_SP, moldy, conMoldy);
		registerRender(POTATO_SP, fresh, conFresh);
		registerRender(POTATO_SP, stale, conStale);
		registerRender(POTATO_SP, moldy, conMoldy);
		
		// Minecraft Soups
		registerRender(BEET_ROOT_SOUP_SP, fresh, conFresh);
		registerRender(BEET_ROOT_SOUP_SP, stale, conStale);
		registerRender(BEET_ROOT_SOUP_SP, moldy, conMoldy);
		registerRender(MUSHROOM_STEW_SP, fresh, conFresh);
		registerRender(MUSHROOM_STEW_SP, stale, conStale);
		registerRender(MUSHROOM_STEW_SP, moldy, conMoldy);
		registerRender(RABBIT_STEW_SP, fresh, conFresh);
		registerRender(RABBIT_STEW_SP, stale, conStale);
		registerRender(RABBIT_STEW_SP, moldy, conMoldy);
		
		// Added Soups
		registerRender(BEEF_STEW_SP, fresh, conFresh);
		registerRender(BEEF_STEW_SP, stale, conStale);
		registerRender(BEEF_STEW_SP, moldy, conMoldy);
		registerRender(CHICKEN_DUMPLINGS_SP, fresh, conFresh);
		registerRender(CHICKEN_DUMPLINGS_SP, stale, conStale);
		registerRender(CHICKEN_DUMPLINGS_SP, moldy, conMoldy);
		
		// Salted Foods
		registerRender(ANDR_MEAT_SALTED_SP);
		registerRender(BEEF_SALTED_SP);
		registerRender(CHICKEN_SALTED_SP);
		registerRender(HORSE_BEEF_SALTED_SP);
		registerRender(LONG_PORK_SALTED_SP);
		registerRender(PORK_SALTED_SP);
		registerRender(MUTTON_SALTED_SP);
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
			final Item[] foods =
				{
						APPLE_SP,
						BEEF_SP,
						BEEF_COOKED_SP,
						BREAD_SP,
						CHICKEN_SP,
						CHICKEN_COOKED_SP,
						CLOWN_FISH_SP,
						COOKIE_SP,
						FISH_SP,
						FISH_COOKED_SP,
						MELON_SLICE_SP,
						MUTTON_SP,
						MUTTON_COOKED_SP,
						PORK_SP,
						PORK_COOKED_SP,
						POTATO_COOKED_SP,
						PUMPKIN_PIE_SP,
						RABBIT_SP,
						RABBIT_COOKED_SP,
						SALMON_SP,
						SALMON_COOKED_SP,
						ANDR_MEAT_SP,
						ANDR_MEAT_COOKED_SP,
						CALAMARI_SP,
						CALAMARI_COOKED_SP,
						CARROT_COOKED_SP,
						EGG_COOKED_SP,
						HORSE_BEEF_SP,
						HORSE_BEEF_COOKED_SP,
						LONG_PORK_SP,
						LONG_PORK_COOKED_SP,
						MUSHROOM_BROWN_GRILLED,
						MUSHROOM_RED_GRILLED,
						RICE_COOKED,
						SUSHI,
						SUSHI_CLOWNFISH,
						SUSHI_PUFFERFISH,
						SUSHI_SALMON,
						BEETROOT_SP,
						CARROT_SP,
						POTATO_SP,
						BEET_ROOT_SOUP_SP,
						MUSHROOM_STEW_SP,
						RABBIT_STEW_SP,
						BEEF_STEW_SP,
						CHICKEN_DUMPLINGS_SP,
						ANDR_MEAT_SALTED_SP,
						BEEF_SALTED_SP,
						CHICKEN_SALTED_SP,
						HORSE_BEEF_SALTED_SP,
						LONG_PORK_SALTED_SP,
						PORK_SALTED_SP,
						MUTTON_SALTED_SP
				};
			
			final IForgeRegistry<Item> registry = event.getRegistry();

			for (final Item item : foods) 
			{
				registry.register(item);
				ITEMS.add(item);
			}
		}
	}
}
