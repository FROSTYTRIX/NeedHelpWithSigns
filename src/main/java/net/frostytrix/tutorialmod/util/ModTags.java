package net.frostytrix.tutorialmod.util;

import net.frostytrix.tutorialmod.TutorialModTest;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks{
        public static final TagKey<Block> ARTHUSSETTE_ORE_DETECTOR_ORES = tag("ore_detector_ores");
        public static final TagKey<Block> NEEDS_ARTHUSSITTE_TOOL = tag("needs_arthussitte_tool");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(TutorialModTest.MODID, name));
        }

    }

    public static class Items{
        public static final TagKey<Item> PADOUK_LOG = tag("padouk_log");
        public static final TagKey<Item> PADOUK_WOOD = tag("padouk_wood");
        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(TutorialModTest.MODID, name));
        }
    }
}
