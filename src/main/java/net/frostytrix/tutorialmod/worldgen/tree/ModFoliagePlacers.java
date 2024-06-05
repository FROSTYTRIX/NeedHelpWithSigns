package net.frostytrix.tutorialmod.worldgen.tree;

import net.frostytrix.tutorialmod.TutorialModTest;
import net.frostytrix.tutorialmod.worldgen.tree.custom.PadoukFoliagePlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModFoliagePlacers {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS =
            DeferredRegister.create(Registries.FOLIAGE_PLACER_TYPE, TutorialModTest.MODID);

    public static final RegistryObject<FoliagePlacerType<PadoukFoliagePlacer>> PADOUK_FOLIAGE_PLACER =
            FOLIAGE_PLACERS.register("padouk_foliage_placer", () -> new FoliagePlacerType<>(PadoukFoliagePlacer.CODEC));

    public static void register(IEventBus eventBus){
        FOLIAGE_PLACERS.register(eventBus);
    }
}
