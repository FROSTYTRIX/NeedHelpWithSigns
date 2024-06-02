package net.frostytrix.tutorialmod;

import com.mojang.logging.LogUtils;
import net.frostytrix.tutorialmod.block.ModBlocks;
import net.frostytrix.tutorialmod.block.entity.ModBlockEntities;
import net.frostytrix.tutorialmod.entity.ModEntities;
import net.frostytrix.tutorialmod.entity.client.TimmyRenderer;
import net.frostytrix.tutorialmod.entity.custom.TimmyEntity;
import net.frostytrix.tutorialmod.item.ModCreativeModTabs;
import net.frostytrix.tutorialmod.item.ModItems;
import net.frostytrix.tutorialmod.loot.ModLootModifiers;
import net.frostytrix.tutorialmod.recipe.ModRecipes;
import net.frostytrix.tutorialmod.screen.ModMenuTypes;
import net.frostytrix.tutorialmod.screen.PadoukIncantationTableScreen;
import net.frostytrix.tutorialmod.sound.ModSounds;
import net.frostytrix.tutorialmod.util.ModWoodTypes;
import net.frostytrix.tutorialmod.villager.ModVillagers;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TutorialModTest.MODID)
public class TutorialModTest {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "frostytrixmod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public TutorialModTest() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModLootModifiers.register(modEventBus);
        ModSounds.register(modEventBus);
        ModVillagers.register(modEventBus);
        ModEntities.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModRecipes.register(modEventBus);


        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

       }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.ARTHUSSITTE);
            event.accept(ModItems.RAW_ARTHUSSITTE);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            Sheets.addWoodType(ModWoodTypes.PADOUK);

            EntityRenderers.register(ModEntities.TIMMY.get(), TimmyRenderer::new);

            MenuScreens.register(ModMenuTypes.PADOUK_INCANTATION_TABLE_MENU.get(), PadoukIncantationTableScreen::new);
        }
    }
}
