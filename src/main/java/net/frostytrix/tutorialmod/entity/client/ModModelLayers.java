package net.frostytrix.tutorialmod.entity.client;

import net.frostytrix.tutorialmod.TutorialModTest;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {
    public static final ModelLayerLocation TIMMY_LAYER = new ModelLayerLocation(
            new ResourceLocation(TutorialModTest.MODID, "timmy_layer"), "main");
    public static final ModelLayerLocation PADOUK_BOAT_LAYER = new ModelLayerLocation(
            new ResourceLocation(TutorialModTest.MODID, "boat/padouk"), "main");
    public static final ModelLayerLocation PADOUK_CHEST_BOAT_LAYER = new ModelLayerLocation(
            new ResourceLocation(TutorialModTest.MODID, "chest_boat/padouk"), "main");
}
