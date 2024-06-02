package net.frostytrix.tutorialmod.item;

import net.frostytrix.tutorialmod.TutorialModTest;
import net.frostytrix.tutorialmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialModTest.MODID);

    public static final RegistryObject<CreativeModeTab> ARTHUSETTE_TAB = CREATIVE_MODE_TABS.register("arthussette_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ARTHUSSITTE.get()))
                    .title(Component.translatable("creativetab.arthussette_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.RAW_ARTHUSSITTE.get());
                        output.accept(ModItems.ARTHUSSITTE.get());
                        output.accept(ModBlocks.ARTHUSSITTE_BLOCK.get());
                        output.accept(ModBlocks.RAW_ARTHUSSITTE_BLOCK.get());
                        output.accept(ModBlocks.ARTHUSSITTE_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_ARTHUSSITTE_ORE.get());
                        output.accept(ModItems.ARTHUSSETTE_ORE_DETECTOR.get());
                        output.accept(ModBlocks.FARFADET_MALICIEUX_BLOCK.get());
                        output.accept(ModItems.GUINNESS.get());
                        output.accept(ModItems.GUINNESS_SEEDS.get());
                        output.accept(ModItems.BLESSED_GUINNESS_SEEDS.get());
                        output.accept(ModItems.CHARBON_MALICIEUX.get());
                        output.accept(ModItems.FOUR_LEAVES_CLOVER.get());

                        // PADOUK
                        output.accept(ModBlocks.PADOUK_LOG.get());
                        output.accept(ModBlocks.STRIPPED_PADOUK_LOG.get());
                        output.accept(ModBlocks.PADOUK_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_PADOUK_WOOD.get());
                        output.accept(ModBlocks.PADOUK_LEAVES.get());
                        output.accept(ModBlocks.PADOUK_PLANKS.get());
                        output.accept(ModBlocks.PADOUK_TRAPDOOR.get());
                        output.accept(ModBlocks.PADOUK_DOOR.get());
                        output.accept(ModBlocks.PADOUK_BUTTON.get());
                        output.accept(ModBlocks.PADOUK_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.PADOUK_FENCE_GATE.get());
                        output.accept(ModBlocks.PADOUK_FENCE.get());
                        output.accept(ModBlocks.PADOUK_SLAB.get());
                        output.accept(ModBlocks.PADOUK_STAIRS.get());
                        output.accept(ModBlocks.PADOUK_INCANTATION_TABLE.get());
                        output.accept(ModBlocks.PADOUK_WALL_HANGING_SIGN.get());
                        output.accept(ModBlocks.PADOUK_SIGN.get());

                        //arthussite stuff
                        //tools
                        output.accept(ModItems.ARTHUSSITTE_SWORD.get());
                        output.accept(ModItems.ARTHUSSITTE_PICKAXE.get());
                        output.accept(ModItems.ARTHUSSITTE_AXE.get());
                        output.accept(ModItems.ARTHUSSITTE_SHOVEL.get());
                        output.accept(ModItems.ARTHUSSITTE_HOE.get());
                        //armor
                        output.accept(ModItems.ARTHUSSITTE_HELMET.get());
                        output.accept(ModItems.ARTHUSSITTE_CHESTPLATE.get());
                        output.accept(ModItems.ARTHUSSITTE_LEGGINGS.get());
                        output.accept(ModItems.ARTHUSSITTE_BOOTS.get());
                        // Mobs
                        output.accept(ModItems.TIMMY_SPAWN_EGG.get());
                    } )
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
