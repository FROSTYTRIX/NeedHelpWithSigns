package net.frostytrix.tutorialmod.item.client;

import net.frostytrix.tutorialmod.item.custom.WandItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class WandItemRenderer extends GeoItemRenderer<WandItem> {
    public WandItemRenderer() {
        super(new WandItemModel());
    }
}
