package com.gmail.rohzek.food;

import java.util.List;

import org.lwjgl.input.Keyboard;

import com.gmail.rohzek.main.Main;
import com.gmail.rohzek.util.ConfigurationManager;
import com.gmail.rohzek.util.LogHelper;
import com.mojang.realmsclient.gui.ChatFormatting;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class NonFoodSpoilable extends Item
{
	int timeBeforeMold = 0;
	
	public NonFoodSpoilable(int time, String name)
	{
		super();
		
		setCreativeTab(Main.SP_INGREDIENTS_TAB);
		
		setNames(name);
		
		setMaxStackSize(1);
		
		setHasSubtypes(true);
		
		timeBeforeMold = time;
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
				tooltip.add(ChatFormatting.GREEN + "Fresh ingredients are safe to cook with.");
			}
			
			else if(currentState == 1)
			{
				tooltip.add(ChatFormatting.YELLOW + "Stale ingredients are risky to cook with.");
			}
			
			else if(currentState == 2)
			{
				tooltip.add(ChatFormatting.RED + "Moldy ingredients are too dangerous to cook with.");
			}
		}
	}
	
	@Override
	public Item setContainerItem(Item containerItem)
	{
		return super.setContainerItem(containerItem);
	}
	
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
				
				LogHelper.debug("Decaying ingredient on ground:" + decay);
				
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
					
					LogHelper.debug("Decaying ingredient in pocket:" + decay);
					
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
					
					LogHelper.debug("Decaying ingredient in pocket:" + decay);
					
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
