package net.frostytrix.tutorialmod.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBinding {
    public static final String KEY_CATEGORY_ARTHUSSETTE = "key.category.frostytrixmod.tutorial";
    public static final String KEY_SEND_PACKET = "key.tutorialmod.send_packet";

    public static final KeyMapping PACKET_KEY = new KeyMapping(KEY_SEND_PACKET, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_O, KEY_CATEGORY_ARTHUSSETTE);

}
