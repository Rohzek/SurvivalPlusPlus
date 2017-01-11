package com.gmail.rohzek.util;

import org.lwjgl.input.Keyboard;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class KeyBindings 
{
    public static KeyBinding zoom;

    public static void mainRegistry()
    {
    	zoom = new KeyBinding("key.zoomSP", Keyboard.KEY_F, "key.categories.survivalplusplus");

        ClientRegistry.registerKeyBinding(zoom);
    }

}