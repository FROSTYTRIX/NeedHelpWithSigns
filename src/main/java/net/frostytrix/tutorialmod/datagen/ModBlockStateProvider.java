package net.frostytrix.tutorialmod.datagen;

import net.frostytrix.tutorialmod.TutorialModTest;
import net.frostytrix.tutorialmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TutorialModTest.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.ARTHUSSITTE_BLOCK);
        blockWithItem(ModBlocks.RAW_ARTHUSSITTE_BLOCK);
        blockWithItem(ModBlocks.ARTHUSSITTE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_ARTHUSSITTE_ORE);
        blockWithItem(ModBlocks.FARFADET_MALICIEUX_BLOCK);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
