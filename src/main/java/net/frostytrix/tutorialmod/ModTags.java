package net.frostytrix.tutorialmod;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks{
        public static final TagKey<Block> ARTHUSSETTE_ORE_DETECTOR_ORES = tag("ore_detector_ores");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(TutorialModTest.MODID, name));
        }

    }

    public static class Items{

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(TutorialModTest.MODID, name));
        }
    }
}
