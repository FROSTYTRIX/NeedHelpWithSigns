package net.frostytrix.tutorialmod.block.entity;

import net.frostytrix.tutorialmod.TutorialModTest;
import net.frostytrix.tutorialmod.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, TutorialModTest.MODID);

    public static final RegistryObject<BlockEntityType<PadoukIncantationTableEntity>> PADOUK_INCANTATION_TABLE_BE =
            BLOCK_ENTITIES.register("padouk_incantation_table_be", () ->
                    BlockEntityType.Builder.of(PadoukIncantationTableEntity::new,
                            ModBlocks.PADOUK_INCANTATION_TABLE.get()).build(null));

    public static final RegistryObject<BlockEntityType<ModSignBlockEntity>> MOD_SIGN =
            BLOCK_ENTITIES.register("mod_sign", () ->
                    BlockEntityType.Builder.of(ModSignBlockEntity::new,
                            ModBlocks.PADOUK_SIGN.get(), ModBlocks.PADOUK_WALL_SIGN.get()).build(null));

    public static final RegistryObject<BlockEntityType<ModHangingSignEntityBlock>> MOD_HANGING_SIGN =
            BLOCK_ENTITIES.register("mod_hanging_sign", () ->
                    BlockEntityType.Builder.of(ModHangingSignEntityBlock::new,
                            ModBlocks.PADOUK_HANGING_SIGN.get(), ModBlocks.PADOUK_WALL_HANGING_SIGN.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }

}
