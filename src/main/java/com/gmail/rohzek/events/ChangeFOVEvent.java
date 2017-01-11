package com.gmail.rohzek.events;

import com.gmail.rohzek.util.ConfigurationManager;
import com.gmail.rohzek.util.KeyBindings;
import com.gmail.rohzek.util.LogHelper;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber
public class ChangeFOVEvent 
{
	@SubscribeEvent
	public static void changeFOVEvent(FOVUpdateEvent event)
	{
		final float sensitivity = Minecraft.getMinecraft().gameSettings.mouseSensitivity;
		
		float tempSensativity = sensitivity - sensitivity + 0.001f;
		
		float oldFOV = 1.0f;
		
		float newFOV;
		
		EntityPlayer player = event.getEntity();
		
		if(ConfigurationManager.fovChangeAllowed){}
		else
		{
			if(player.isSprinting())
			{	
				event.setNewfov(oldFOV);
			}
			
			if(player.getActivePotionEffect(MobEffects.SPEED) != null)
			{
				event.setNewfov(oldFOV);
			}
			if(player.getActivePotionEffect(MobEffects.SLOWNESS) != null)
			{
				event.setNewfov(oldFOV);
			}
		}
		
		
		if(KeyBindings.zoom.isKeyDown())
		{
			event.setNewfov(oldFOV - oldFOV + 0.2f);
			
			//Minecraft.getMinecraft().gameSettings.mouseSensitivity = tempSensativity;
		}
		
		else if(!KeyBindings.zoom.isKeyDown())
		{
			event.setNewfov(oldFOV);
			
			//Minecraft.getMinecraft().gameSettings.mouseSensitivity = sensitivity;
		}
		
	}
}
