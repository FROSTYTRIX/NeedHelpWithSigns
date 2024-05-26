package net.frostytrix.tutorialmod.datagen;

import net.frostytrix.tutorialmod.ModTags;
import net.frostytrix.tutorialmod.TutorialModTest;
import net.frostytrix.tutorialmod.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeBlockTagsProvider;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {

    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TutorialModTest.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ModTags.Blocks.ARTHUSSETTE_ORE_DETECTOR_ORES)
                .add(ModBlocks.ARTHUSSITTE_ORE.get()).addTags(Tags.Blocks.ORES);

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(ModBlocks.ARTHUSSITTE_ORE.get(),
                        ModBlocks.RAW_ARTHUSSITTE_BLOCK.get(),
                        ModBlocks.DEEPSLATE_ARTHUSSITTE_ORE.get(),
                        ModBlocks.ARTHUSSITTE_BLOCK.get()
                );

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.FARFADET_MALICIEUX_BLOCK.get());

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.FARFADET_MALICIEUX_BLOCK.get());
    }
}
