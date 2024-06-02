package net.frostytrix.tutorialmod.datagen;

import net.frostytrix.tutorialmod.util.ModTags;
import net.frostytrix.tutorialmod.TutorialModTest;
import net.frostytrix.tutorialmod.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {

    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TutorialModTest.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
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

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.ARTHUSSITTE_ORE.get())
                .add(ModBlocks.ARTHUSSITTE_BLOCK.get())
                .add(ModBlocks.DEEPSLATE_ARTHUSSITTE_ORE.get())
                .add(ModBlocks.RAW_ARTHUSSITTE_BLOCK.get());

        this.tag(BlockTags.FENCES)
                .add(ModBlocks.PADOUK_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.PADOUK_FENCE_GATE.get());

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.PADOUK_LOG.get())
                .add(ModBlocks.STRIPPED_PADOUK_LOG.get())
                .add(ModBlocks.PADOUK_WOOD.get())
                .add(ModBlocks.STRIPPED_PADOUK_LOG.get());

        this.tag(BlockTags.PLANKS)
                .add(ModBlocks.PADOUK_PLANKS.get());
    }
}
