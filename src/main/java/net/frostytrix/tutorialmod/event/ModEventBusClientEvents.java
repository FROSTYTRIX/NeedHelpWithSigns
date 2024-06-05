package net.frostytrix.tutorialmod.event;

import net.frostytrix.tutorialmod.TutorialModTest;
import net.frostytrix.tutorialmod.block.entity.ModBlockEntities;
import net.frostytrix.tutorialmod.block.entity.renderer.PadoukIncantationBlockEntityRenderer;
import net.frostytrix.tutorialmod.entity.client.ModModelLayers;
import net.frostytrix.tutorialmod.entity.client.TimmyModel;
import net.frostytrix.tutorialmod.networking.ModPackets;
import net.frostytrix.tutorialmod.networking.packet.ExampleC2SPacket;
import net.frostytrix.tutorialmod.util.KeyBinding;
import net.frostytrix.tutorialmod.util.ModWoodTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TutorialModTest.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.TIMMY_LAYER, TimmyModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.PADOUK_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
        event.registerLayerDefinition(ModModelLayers.PADOUK_BOAT_LAYER, BoatModel::createBodyModel);
    }

    @SubscribeEvent
    public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.PADOUK_INCANTATION_TABLE_BE.get(), PadoukIncantationBlockEntityRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.MOD_SIGN.get(), SignRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.MOD_HANGING_SIGN.get(), HangingSignRenderer::new);
    }

    @SubscribeEvent
    public static void onKeyRegister(RegisterKeyMappingsEvent event){
        event.register(KeyBinding.PACKET_KEY);
    }

    public static void onKeyInput(InputEvent.Key event) {
        if (KeyBinding.PACKET_KEY.consumeClick()) {
                Minecraft.getInstance().player.sendSystemMessage(Component.literal("Test"));
        }
    }
}
