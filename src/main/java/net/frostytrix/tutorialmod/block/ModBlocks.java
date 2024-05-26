package net.frostytrix.tutorialmod.block;

import net.frostytrix.tutorialmod.TutorialModTest;
import net.frostytrix.tutorialmod.block.custom.FarfadetMalicieuxBlock;
import net.frostytrix.tutorialmod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialModTest.MODID);

    public static final RegistryObject<Block> ARTHUSSITTE_BLOCK = registerBlock("arthussitte_block",
            () -> new   Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.SLIME_BLOCK)));
    public static final RegistryObject<Block> RAW_ARTHUSSITTE_BLOCK = registerBlock("raw_arthussitte_block",
        () -> new   Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.SLIME_BLOCK)));
    public static final RegistryObject<Block> ARTHUSSITTE_ORE = registerBlock("arthussitte_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2f).requiresCorrectToolForDrops(), UniformInt.of(4,8)));
    public static final RegistryObject<Block> DEEPSLATE_ARTHUSSITTE_ORE = registerBlock("deepslate_arthussitte_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(2.5f).requiresCorrectToolForDrops(), UniformInt.of(5,9)));
    public static final RegistryObject<Block> FARFADET_MALICIEUX_BLOCK = registerBlock("farfadet_malicieux_block",
            () -> new FarfadetMalicieuxBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).strength(1f)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register((eventBus));
    }
}
