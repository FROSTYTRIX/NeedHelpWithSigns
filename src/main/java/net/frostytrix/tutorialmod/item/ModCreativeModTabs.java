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
                        output.accept(ModItems.CHARBON_MALICIEUX.get());
                    } )
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
