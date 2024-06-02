package net.frostytrix.tutorialmod.datagen.loot;

import net.frostytrix.tutorialmod.block.ModBlocks;
import net.frostytrix.tutorialmod.block.custom.GuinnessCropBlock;
import net.frostytrix.tutorialmod.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
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

        this.dropSelf(ModBlocks.PADOUK_LOG.get());
        this.dropSelf(ModBlocks.PADOUK_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_PADOUK_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_PADOUK_WOOD.get());
        this.dropSelf(ModBlocks.PADOUK_PLANKS.get());
        this.dropSelf(ModBlocks.PADOUK_STAIRS.get());
        this.dropSelf(ModBlocks.PADOUK_BUTTON.get());
        this.dropSelf(ModBlocks.PADOUK_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.PADOUK_FENCE_GATE.get());
        this.dropSelf(ModBlocks.PADOUK_FENCE.get());
        this.dropSelf(ModBlocks.PADOUK_TRAPDOOR.get());
        this.dropSelf(ModBlocks.PADOUK_INCANTATION_TABLE.get());

        this.add(ModBlocks.PADOUK_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.ARTHUSSITTE_BLOCK.get(), NORMAL_LEAVES_SAPLING_CHANCES)); // ADD SAPPLING

        this.add(ModBlocks.PADOUK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PADOUK_SLAB.get()));
        this.add(ModBlocks.PADOUK_DOOR.get(),
                block -> createDoorTable(ModBlocks.PADOUK_DOOR.get()));

        this.add(ModBlocks.ARTHUSSITTE_ORE.get(),
                block -> createOreDrop(ModBlocks.ARTHUSSITTE_ORE.get(), ModItems.ARTHUSSITTE.get()));
        this.add(ModBlocks.DEEPSLATE_ARTHUSSITTE_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_ARTHUSSITTE_ORE.get(), ModItems.ARTHUSSITTE.get()));

        this.add(ModBlocks.PADOUK_SIGN.get(), block ->
                createSingleItemTable(ModItems.PADOUK_SIGN.get()));
        this.add(ModBlocks.PADOUK_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.PADOUK_SIGN.get()));
        this.add(ModBlocks.PADOUK_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.PADOUK_HANGING_SIGN.get()));
        this.add(ModBlocks.PADOUK_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.PADOUK_HANGING_SIGN.get()));

        // Crops
        // GUINNESS ?!

        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.GUINNESS_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GuinnessCropBlock.AGE, 5));

        this.add(ModBlocks.GUINNESS_CROP.get(), createCropDrops(ModBlocks.GUINNESS_CROP.get(), ModItems.GUINNESS.get(),
                ModItems.BLESSED_GUINNESS_SEEDS.get(), lootitemcondition$builder));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }

}
