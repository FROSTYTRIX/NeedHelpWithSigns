package net.frostytrix.tutorialmod.datagen.loot;

import net.frostytrix.tutorialmod.block.ModBlocks;
import net.frostytrix.tutorialmod.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.ARTHUSSITTE_BLOCK.get());
        this.dropSelf(ModBlocks.FARFADET_MALICIEUX_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_ARTHUSSITTE_BLOCK.get());

        this.add(ModBlocks.ARTHUSSITTE_ORE.get(),
                block -> createOreDrop(ModBlocks.ARTHUSSITTE_ORE.get(), ModItems.ARTHUSSITTE.get()));
     this.add(ModBlocks.DEEPSLATE_ARTHUSSITTE_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_ARTHUSSITTE_ORE.get(), ModItems.ARTHUSSITTE.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
