package com.gmail.rohzek.proxys;

import com.gmail.rohzek.blocks.SPBlocks;
import com.gmail.rohzek.events.LoadModelEventSP;
import com.gmail.rohzek.food.SPFoods;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * For things that must render ONLY on client, such as the graphics for the blocks we're rendering here.
 * @author Rohzek
 *
 */
public class ClientProxy extends CommonProxy
{		
	@Override
	public void registerRenders(){}
}
