package com.gmail.rohzek.food;

import java.util.List;

import org.lwjgl.input.Keyboard;

import com.gmail.rohzek.main.Main;
import com.gmail.rohzek.util.ConfigurationManager;
import com.gmail.rohzek.util.LogHelper;
import com.mojang.realmsclient.gui.ChatFormatting;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemSeedFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FoodSpoilablePlantable extends ItemSeedFood
{
	PotionEffect[] effects = null;
	
	int timeBeforeMold = 0;
	boolean isCooked = false;
	
	public FoodSpoilablePlantable(int hunger, float saturation, int time, String name, Block toPlant, Block toPlantOn) 
	{
		super(hunger, saturation, toPlant, toPlantOn);
		
		setCreativeTab(Main.SP_FOODS_TAB);
		
		setNames(name);
		
		setMaxStackSize(1);
		
		setHasSubtypes(true);
		
		timeBeforeMold = time;
		isCooked = true;
	}
	
	public FoodSpoilablePlantable(int hunger, float saturation, int time, String name, Block toPlant, Block toPlantOn, PotionEffect... effects) 
	{
		super(hunger, saturation, toPlant, toPlantOn);
		
		setCreativeTab(Main.SP_FOODS_TAB);
		
		setNames(name);
		
		setMaxStackSize(1);
		
		setHasSubtypes(true);
		
		this.effects = new PotionEffect[effects.length];
		
		for(int i = 0; i < effects.length; i++)
		{
			this.effects[i] = effects[i];
		}
		
		timeBeforeMold = time;
		isCooked = true;
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) 
	{
		//int condition = loadCurrentCondition(stack);
		int condition = 0;
		
		if(!worldIn.isRemote)
		{
			// Add effects supplied by constructor
			if(this.effects != null)
			{
				for(int i = 0; i < this.effects.length; i++)
        		{
        			player.addPotionEffect(this.effects[i]);
        		}
			}
			
			if(condition == 0)
			{
				//Potion potionIn, int durationIn, int amplifierIn, boolean ambientIn, boolean showParticlesIn
				player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 300, 10, true, true)); // 300 == 0:15
				player.addPotionEffect(new PotionEffect(MobEffects.SATURATION, 300, 10, true, true));
			}
			
			else if(condition == 1) // Stale
			{
				player.addPotionEffect(new PotionEffect(MobEffects.HUNGER, 30, 10, true, true));
				player.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 900, 10, true, true));
			}
			
			else if(condition == 2) // Moldy
			{
				player.addPotionEffect(new PotionEffect(MobEffects.HUNGER, 600, 10, true, true));
				player.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 900, 10, true, true));
				player.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 300, 10, true, true));
				player.addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, 650, 10, true, true));
				player.addPotionEffect(new PotionEffect(MobEffects.WITHER, 150, 10, true, true));
				player.addPotionEffect(new PotionEffect(MobEffects.INSTANT_DAMAGE));
			}
		}
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack item)
    {
        return 20;
    }
	
	// We can get the time the item was crafted for decay
	@Override
	public void onCreated(ItemStack itemStack, World world, EntityPlayer player) 
	{
		int meta = getDamage(itemStack);
		
		if(meta == 0)
		{
			itemStack.setTagCompound(new NBTTagCompound());
			
			saveCreationTime(itemStack, world.getTotalWorldTime());
			saveLastingFactor(itemStack, timeBeforeMold);
			setDamage(itemStack, meta);
			getItemStackDisplayName(itemStack);
		}
		else if(meta == 1)
		{
			itemStack.setTagCompound(new NBTTagCompound());
			
			saveCreationTime(itemStack, world.getTotalWorldTime());
			saveDecayFactor(itemStack, (timeBeforeMold / 2));
			saveLastingFactor(itemStack, timeBeforeMold);
			setDamage(itemStack, meta);
			getItemStackDisplayName(itemStack);
		}
		else if(meta >= 2)
		{
			itemStack.setTagCompound(new NBTTagCompound());
			
			saveCreationTime(itemStack, world.getTotalWorldTime());
			saveDecayFactor(itemStack, (timeBeforeMold));
			saveLastingFactor(itemStack, timeBeforeMold);
			setDamage(itemStack, meta);
			getItemStackDisplayName(itemStack);
		}
	}
		
	// This fires while you're holding the item
	@Override
	public void onUpdate(ItemStack itemStack, World world, Entity player, int par4, boolean par5) 
	{
		if(!world.isRemote)
		{
			updateCondition(itemStack, world.getTotalWorldTime());
		}
	}
	
	// This fires while the item is on the ground
	@Override
	public boolean onEntityItemUpdate(EntityItem entityItem)
	{
		ItemStack itemStack = entityItem.getEntityItem();
		
		updateConditionEntityItem(itemStack);
			
		return false;
	}
	
	// changes display name?
	@Override
	public String getItemStackDisplayName(ItemStack stack) 
	{
		String name = super.getItemStackDisplayName(stack);
		String prefix = getDamage(stack) == 0 ? "Fresh " : getDamage(stack) == 1 ? "Stale " : "Moldy ";
		
		return prefix + name;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) 
	{
		int currentState = loadCurrentCondition(stack);
		if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
		{	
			if(currentState == 0)
			{
				tooltip.add(ChatFormatting.GREEN + "Fresh food is safe to eat.");
			}
			
			else if(currentState == 1)
			{
				tooltip.add(ChatFormatting.YELLOW + "Stale food is risky to eat.");
			}
			
			else if(currentState == 2)
			{
				tooltip.add(ChatFormatting.RED + "Moldy food is dangerous to eat.");
			}
		}
	}
	
	/*
	 //Adds all sub items to the creative tab as well
	@Override
	public void getSubItems(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> subItems) 
	{
		for (int i = 0; i < 3; ++i) 
		{
			subItems.add(new ItemStack(this, 1, i));
		}
	}
	*/
	
	private void setNames(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
	}
	
	// Save functions for all of the data, split up so you can access them seperatly.:
	 public void saveCreationTime(ItemStack itemStack, long creationTime)
	 {
		 NBTTagCompound saveData;
		 
		 saveData = itemStack.getTagCompound();
		 
		 if(saveData != null)
		 {
			 saveData.setLong("creationTime", creationTime);
		 }	
		 else	
		 {
			 itemStack.setTagCompound(new NBTTagCompound());
		 }
	 }
		 
	 public void saveDecayFactor(ItemStack itemStack, int decayFactor)
	 {
		 NBTTagCompound saveData;
		 
		 saveData = itemStack.getTagCompound();
		 
		 if(saveData != null)
		 {
			 saveData.setInteger("decayFactor", decayFactor);
		 }
		 else
		 {
			 itemStack.setTagCompound(new NBTTagCompound());
				
		 }
	 }
		 
	 public void saveLastingFactor(ItemStack itemStack, int timeLast)
	 {
		 NBTTagCompound saveData;
		 
		 saveData = itemStack.getTagCompound();
		 
		 if(saveData != null)
		 {
			 saveData.setInteger("timeLast", timeLast);
		 }
		 else
		 {
			 itemStack.setTagCompound(new NBTTagCompound());
		 }
	 }
		 
		 
	 public void saveStoreTimeStamp(ItemStack itemStack, long storeTimestamp)
	 {
		 NBTTagCompound saveData;
		 
		 saveData = itemStack.getTagCompound();
		 
		 if(saveData != null)
		 {
			 saveData.setLong("storeTimestamp", storeTimestamp);
		 }
		 else
		 {
			 itemStack.setTagCompound(new NBTTagCompound());
		 }
	 }
		 
	 public void saveCurrentCondition(ItemStack itemStack, int currentCondition)
	 {
		 NBTTagCompound saveData;
		 
		 saveData = itemStack.getTagCompound();
		 
		 if(saveData != null)
		 {
			 saveData.setInteger("currentCondition", currentCondition);
		 }
		 else
		 {
			 itemStack.setTagCompound(new NBTTagCompound());
		 }
	 }
	 
	 public void saveCookedStatus(ItemStack itemStack, boolean status)
	 {
		 NBTTagCompound saveData;
		 
		 saveData = itemStack.getTagCompound();
		 
		 if(saveData != null)
		 {
			 saveData.setBoolean("cookedStatus", status);
		 }
		 else
		 {
			 itemStack.setTagCompound(new NBTTagCompound());
		 }
	 }
	 
	 public long loadCreationTime(ItemStack itemStack)
	 {
		 NBTTagCompound retrieveData;
		 
		 retrieveData = itemStack.getTagCompound();
		 
		 if(retrieveData != null && retrieveData.hasKey("creationTime"))
		 {
			 return retrieveData.getLong("creationTime");
		 }
				
		 else
		 {
			 return 0;
		 }
	 }
		 
	 public int loadDecayFactor(ItemStack itemStack)
	 {
		 NBTTagCompound retrieveData;
		 
		 retrieveData = itemStack.getTagCompound();
		 
		 if(retrieveData != null && retrieveData.hasKey("decayFactor"))
		 {
			 return retrieveData.getInteger("decayFactor");
		 }
				
		 else
		 {
			 return 0;
		 }
	 }
	 
	 public int loadLastingFactor(ItemStack itemStack)
	 {
		 NBTTagCompound retrieveData;
		 
		 retrieveData = itemStack.getTagCompound();
		 
		 if(retrieveData != null && retrieveData.hasKey("timeLast"))
		 {
			 return retrieveData.getInteger("timeLast");
		 }
				
		 else
		 {
			 return timeBeforeMold;
		 }
	 }
		 
	 public long loadStoreTimeStamp(ItemStack itemStack)
	 {
		 NBTTagCompound retrieveData;
		 
		 retrieveData = itemStack.getTagCompound();
		 
		 if(retrieveData != null && retrieveData.hasKey("storeTimestamp"))
		 {
			 return retrieveData.getLong("storeTimestamp");
		 }
			
		 else
		 {
			 return 0;
		 }
	 }
		 
	 public int loadCurrentCondition(ItemStack itemStack)
	 {
		 NBTTagCompound retrieveData;
		 
		 retrieveData = itemStack.getTagCompound();
			 
		 if(retrieveData != null && retrieveData.hasKey("currentCondition"))
		 {
			 return retrieveData.getInteger("currentCondition");
		 }
			
		 else
		 {
			 return 0;
		 }
	 }
	 
	 public boolean loadCookedStatus(ItemStack itemStack)
	 {
		 NBTTagCompound retrieveData;
		 
		 retrieveData = itemStack.getTagCompound();
			 
		 if(retrieveData != null && retrieveData.hasKey("cookedStatus"))
		 {
			 return retrieveData.getBoolean("cookedStatus");
		 }
			
		 else
		 {
			 return false;
		 }
	 }
		 
	 // Changes condition based on delay...
	 // Constantly reading/writing these values probably isn't a good way to do this...
	 // not sure what else to do though?
	 public void updateConditionEntityItem(ItemStack itemStack)
	 {
		 if(ConfigurationManager.foodSpoils)
		 {
			 if(loadCurrentCondition(itemStack) != 2)
			 {
				 long currentTime = loadStoreTimeStamp(itemStack);
				 long timeToWait = currentTime + 150;
				 int decay = loadDecayFactor(itemStack);
				 int ruin = loadLastingFactor(itemStack);
				 
				 decay++;
				 
				 LogHelper.debug("Decaying food on ground:" + decay);
				 
				 saveDecayFactor(itemStack, decay);
				 
				 // Half makes the item stale
				 if(decay >= ruin / 2)
				 {
					 saveCurrentCondition(itemStack, 1);
					 getItemStackDisplayName(itemStack);
					 setDamage(itemStack, 1);
				 }
				 
				 // Full makes the item moldy/ruined
				 if(decay >= ruin)
				 {
					 saveCurrentCondition(itemStack, 2);
					 getItemStackDisplayName(itemStack);
					 setDamage(itemStack, 2);
				 }
			 }
		 }
	 }
	 
	 public void updateCondition(ItemStack itemStack, long currentTime)
	 {
		 if(ConfigurationManager.foodSpoils)
		 {
			 if(loadCurrentCondition(itemStack) != 2)
			 {
				 long lastRan = loadStoreTimeStamp(itemStack);
				 
				 if(lastRan == 0)
				 {
					 int decay = loadDecayFactor(itemStack);
					 int ruin = loadLastingFactor(itemStack);
					 
					 decay++;
					 
					 LogHelper.debug("Decaying food in pocket:" + decay);
					 
					 saveDecayFactor(itemStack, decay);
					 
					 saveStoreTimeStamp(itemStack, currentTime);
					 
					 // Half makes the item stale
					 if(decay >= ruin / 2)
					 {
						 saveCurrentCondition(itemStack, 1);
						 getItemStackDisplayName(itemStack);
						 setDamage(itemStack, 1);
					 }
					 
					 // Full makes the item moldy/ruined
					 if(decay >= ruin)
					 {
						 saveCurrentCondition(itemStack, 2);
						 getItemStackDisplayName(itemStack);
						 setDamage(itemStack, 2);
					 }
				 }
				 
				 else if(lastRan != 0 && (currentTime - lastRan) >= 150)
				 {
					 int decay = loadDecayFactor(itemStack);
					 int ruin = loadLastingFactor(itemStack);
					 
					 decay += (currentTime - lastRan);
					 
					 LogHelper.debug("Decaying food in pocket:" + decay);
					 
					 LogHelper.debug("Will last for: " + (((ruin - decay) / 20) / 60) + " more minutes");
					 
					 saveDecayFactor(itemStack, decay);
					 
					 saveStoreTimeStamp(itemStack, currentTime);
					 
					 
					 // Full makes the item moldy/ruined
					 if(decay >= ruin)
					 {
						 LogHelper.debug("Food is moldy");
						 saveCurrentCondition(itemStack, 2);
						 getItemStackDisplayName(itemStack);
						 setDamage(itemStack, 2);
					 }
					 
					 // Half makes the item stale
					 else if(decay >= (ruin / 2))
					 {
						 LogHelper.debug("Food is stale");
						 saveCurrentCondition(itemStack, 1);
						 getItemStackDisplayName(itemStack);
						 setDamage(itemStack, 1);
					 }
					 
					 else
					 {
						 LogHelper.debug("Food is still fresh");
					 }
				 }
			 }
		 }
	 }
}
