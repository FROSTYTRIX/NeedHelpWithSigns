package net.frostytrix.tutorialmod.event;

import net.frostytrix.tutorialmod.TutorialModTest;
import net.frostytrix.tutorialmod.entity.ModEntities;
import net.frostytrix.tutorialmod.entity.client.ModModelLayers;
import net.frostytrix.tutorialmod.entity.client.TimmyModel;
import net.frostytrix.tutorialmod.entity.custom.TimmyEntity;
import net.frostytrix.tutorialmod.util.ModWoodTypes;
import net.minecraft.client.renderer.Sheets;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = TutorialModTest.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.TIMMY.get(), TimmyEntity.createAttribute().build());
    }
}
