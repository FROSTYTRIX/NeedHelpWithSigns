package net.frostytrix.tutorialmod.datagen;

import net.frostytrix.tutorialmod.TutorialModTest;
import net.frostytrix.tutorialmod.block.ModBlocks;
import net.frostytrix.tutorialmod.block.custom.GuinnessCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

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

        // PADOUK

        blockWithItem(ModBlocks.PADOUK_PLANKS);

        stairsBlock(((StairBlock) ModBlocks.PADOUK_STAIRS.get()), blockTexture(ModBlocks.PADOUK_PLANKS.get()));
        slabBlock(((SlabBlock) ModBlocks.PADOUK_SLAB.get()),
                blockTexture(ModBlocks.PADOUK_PLANKS.get()), blockTexture(ModBlocks.PADOUK_PLANKS.get()));

        buttonBlock(((ButtonBlock) ModBlocks.PADOUK_BUTTON.get()), blockTexture(ModBlocks.PADOUK_PLANKS.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.PADOUK_PRESSURE_PLATE.get()), blockTexture(ModBlocks.PADOUK_PLANKS.get()));

        fenceBlock(((FenceBlock) ModBlocks.PADOUK_FENCE.get()), blockTexture(ModBlocks.PADOUK_PLANKS.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.PADOUK_FENCE_GATE.get()), blockTexture(ModBlocks.PADOUK_PLANKS.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.PADOUK_DOOR.get()), modLoc("block/padouk_bottom_door"), modLoc("block/padouk_top_door"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.PADOUK_TRAPDOOR.get()), modLoc("block/padouk_trapdoor"), true, "cutout");

        logBlock(((RotatedPillarBlock) ModBlocks.PADOUK_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.PADOUK_WOOD.get()), blockTexture(ModBlocks.PADOUK_LOG.get()),
                blockTexture(ModBlocks.PADOUK_LOG.get()));

        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_PADOUK_LOG.get()), blockTexture(ModBlocks.STRIPPED_PADOUK_LOG.get()),
                new ResourceLocation(TutorialModTest.MODID, "block/stripped_padouk_log_top"));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_PADOUK_WOOD.get()), blockTexture(ModBlocks.STRIPPED_PADOUK_LOG.get()),
                blockTexture(ModBlocks.STRIPPED_PADOUK_LOG.get()));

        blockItem(ModBlocks.PADOUK_LOG);
        blockItem(ModBlocks.STRIPPED_PADOUK_LOG);
        blockItem(ModBlocks.STRIPPED_PADOUK_WOOD);
        blockItem(ModBlocks.PADOUK_WOOD);

        leavesBlock(ModBlocks.PADOUK_LEAVES);

        signBlock(((StandingSignBlock) ModBlocks.PADOUK_SIGN.get()), ((WallSignBlock) ModBlocks.PADOUK_WALL_SIGN.get()),
                blockTexture(ModBlocks.PADOUK_PLANKS.get()));

        hangingSignBlock(ModBlocks.PADOUK_HANGING_SIGN.get(), (ModBlocks.PADOUK_WALL_HANGING_SIGN.get()),
                blockTexture(ModBlocks.PADOUK_PLANKS.get()));

        //Crop Guinness
        makeGuinnessCrop((CropBlock) ModBlocks.GUINNESS_CROP.get(), "guinness_stage", "guinness_stage");
    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), new ResourceLocation("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    //Wood
    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(TutorialModTest.MODID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }
    // Crops
    //Guinness
    public void makeGuinnessCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> guinnessStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] guinnessStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((GuinnessCropBlock) block).getAgeProperty()),
                new ResourceLocation(TutorialModTest.MODID, "block/" + textureName + state.getValue(((GuinnessCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ResourceLocation texture) {
        ModelFile sign = models().sign(name(signBlock), texture);
        hangingSignBlock(signBlock, wallSignBlock, sign);
    }

    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ModelFile sign) {
        simpleBlock(signBlock, sign);
        simpleBlock(wallSignBlock, sign);
    }

    private String name(Block block) {
        return key(block).getPath();
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }
}
