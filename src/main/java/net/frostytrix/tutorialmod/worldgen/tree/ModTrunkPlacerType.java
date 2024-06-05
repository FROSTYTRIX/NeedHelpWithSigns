package net.frostytrix.tutorialmod.worldgen.tree;

import net.frostytrix.tutorialmod.TutorialModTest;
import net.frostytrix.tutorialmod.worldgen.tree.custom.PadoukTrunkPlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModTrunkPlacerType {
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER =
            DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, TutorialModTest.MODID);

    public static final RegistryObject<TrunkPlacerType<PadoukTrunkPlacer>> PADOUK_TRUNK_PLACER =
            TRUNK_PLACER.register("padouk_trunk_placer", () -> new TrunkPlacerType<>(PadoukTrunkPlacer.CODEC));

    public static void register(IEventBus eventBus) {
        TRUNK_PLACER.register(eventBus);
    }
}
