package net.frostytrix.tutorialmod.block;

import net.frostytrix.tutorialmod.TutorialModTest;
import net.frostytrix.tutorialmod.block.custom.*;
import net.frostytrix.tutorialmod.item.ModItems;
import net.frostytrix.tutorialmod.util.ModWoodTypes;
import net.minecraft.client.gui.Gui;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
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

    // Padouk

    public static final RegistryObject<Block> PADOUK_PLANKS = registerBlock("padouk_planks",
            () -> new PlankBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));


    public static final RegistryObject<Block> PADOUK_STAIRS = registerBlock("padouk_stairs",
            () -> new StairBlock(() -> ModBlocks.PADOUK_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));
    public static final RegistryObject<Block> PADOUK_SLAB = registerBlock("padouk_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));


    public static final RegistryObject<Block> PADOUK_DOOR = registerBlock("padouk_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).noOcclusion(), BlockSetType.OAK));
    public static final RegistryObject<Block> PADOUK_TRAPDOOR = registerBlock("padouk_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).noOcclusion(), BlockSetType.OAK));

    public static final RegistryObject<Block> PADOUK_BUTTON = registerBlock("padouk_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), BlockSetType.OAK, 10, true));
    public static final RegistryObject<Block> PADOUK_PRESSURE_PLATE = registerBlock("padouk_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE),
                    BlockSetType.OAK));

    public static final RegistryObject<Block> PADOUK_FENCE = registerBlock("padouk_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));
    public static final RegistryObject<Block> PADOUK_FENCE_GATE = registerBlock("padouk_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));

    // Arbre ?

    public static final RegistryObject<Block> PADOUK_LOG = registerBlock("padouk_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(3f)));
    public static final RegistryObject<Block> PADOUK_WOOD = registerBlock("padouk_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(3f)));
    public static final RegistryObject<Block> STRIPPED_PADOUK_LOG = registerBlock("stripped_padouk_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).strength(3f)));
    public static final RegistryObject<Block> STRIPPED_PADOUK_WOOD = registerBlock("stripped_padouk_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).strength(3f)));

    public static final RegistryObject<Block> PADOUK_LEAVES = registerBlock("padouk_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });

    // Signs

    public static final RegistryObject<Block> PADOUK_SIGN = BLOCKS.register("padouk_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.PADOUK));
    public static final RegistryObject<Block> PADOUK_WALL_SIGN = BLOCKS.register("padouk_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.PADOUK));

    public static final RegistryObject<Block> PADOUK_HANGING_SIGN = BLOCKS.register("padouk_hanging_sign",
            () -> new ModHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.PADOUK));
    public static final RegistryObject<Block> PADOUK_WALL_HANGING_SIGN = BLOCKS.register("padouk_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.PADOUK));

    // Crops

    public static final RegistryObject<Block> GUINNESS_CROP = BLOCKS.register("guinness_crop",
            () -> new GuinnessCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));

    // Incantation

    public static final RegistryObject<Block> PADOUK_INCANTATION_TABLE = registerBlock("padouk_incantation_table",
            () -> new PadoukIncantationTable(BlockBehaviour.Properties.copy(Blocks.LECTERN).noOcclusion()));


    // Fin

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
