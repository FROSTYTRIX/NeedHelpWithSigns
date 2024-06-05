package net.frostytrix.tutorialmod.item.client;

import net.frostytrix.tutorialmod.TutorialModTest;
import net.frostytrix.tutorialmod.item.custom.WandItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class WandItemModel extends GeoModel<WandItem> {
    @Override
    public ResourceLocation getModelResource(WandItem wandItem) {
        return new ResourceLocation(TutorialModTest.MODID, "geo/wand_model.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WandItem wandItem) {
        return new ResourceLocation(TutorialModTest.MODID, "textures/item/wand.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WandItem wandItem) {
        return new ResourceLocation(TutorialModTest.MODID, "animations/wand.animation.json");
    }
}
