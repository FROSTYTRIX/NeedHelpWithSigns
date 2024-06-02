package net.frostytrix.tutorialmod.datagen;

import net.frostytrix.tutorialmod.util.ModTags;
import net.frostytrix.tutorialmod.TutorialModTest;
import net.frostytrix.tutorialmod.block.ModBlocks;
import net.frostytrix.tutorialmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, TutorialModTest.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.ARTHUSSITTE_HELMET.get(),
                        ModItems.ARTHUSSITTE_CHESTPLATE.get(),
                        ModItems.ARTHUSSITTE_LEGGINGS.get(),
                        ModItems.ARTHUSSITTE_BOOTS.get());

        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.PADOUK_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_PADOUK_LOG.get().asItem())
                .add(ModBlocks.PADOUK_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_PADOUK_LOG.get().asItem());

        this.tag(ModTags.Items.PADOUK_LOG)
                .add(ModBlocks.PADOUK_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_PADOUK_LOG.get().asItem())
                .add(ModBlocks.PADOUK_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_PADOUK_LOG.get().asItem());

        this.tag(ModTags.Items.PADOUK_WOOD)
                .add(ModBlocks.PADOUK_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_PADOUK_WOOD.get().asItem());

        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.PADOUK_PLANKS.get().asItem());
    }
}
