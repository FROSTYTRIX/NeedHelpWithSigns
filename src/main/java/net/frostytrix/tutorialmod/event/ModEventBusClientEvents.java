package net.frostytrix.tutorialmod.event;

import net.frostytrix.tutorialmod.TutorialModTest;
import net.frostytrix.tutorialmod.block.entity.ModBlockEntities;
import net.frostytrix.tutorialmod.block.entity.renderer.PadoukIncantationBlockEntityRenderer;
import net.frostytrix.tutorialmod.entity.client.ModModelLayers;
import net.frostytrix.tutorialmod.entity.client.TimmyModel;
import net.frostytrix.tutorialmod.util.ModWoodTypes;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TutorialModTest.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.TIMMY_LAYER, TimmyModel::createBodyLayer);
    }

    public static void modWoodTypesRegister() {
        WoodType.register(ModWoodTypes.PADOUK);
    }

    public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.PADOUK_INCANTATION_TABLE_BE.get(), PadoukIncantationBlockEntityRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.MOD_SIGN.get(), SignRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.MOD_HANGING_SIGN.get(), HangingSignRenderer::new);
    }
}
