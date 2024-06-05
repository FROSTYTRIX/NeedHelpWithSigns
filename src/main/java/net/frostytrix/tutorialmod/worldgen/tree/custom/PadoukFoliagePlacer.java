package net.frostytrix.tutorialmod.worldgen.tree.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.frostytrix.tutorialmod.worldgen.tree.ModFoliagePlacers;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class PadoukFoliagePlacer extends FoliagePlacer {
    public static final Codec<PadoukFoliagePlacer> CODEC = RecordCodecBuilder.create(padoukFoliagePlacerInstance
            -> foliagePlacerParts(padoukFoliagePlacerInstance).and(Codec.intRange(0,16).fieldOf("height")
            .forGetter(fp -> fp.height)).apply(padoukFoliagePlacerInstance, PadoukFoliagePlacer::new));

    private final int height;

    public PadoukFoliagePlacer(IntProvider pRadius, IntProvider pOffset, int height) {
        super(pRadius, pOffset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return ModFoliagePlacers.PADOUK_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader pLevel, FoliageSetter pBlockSetter, RandomSource pRandom, TreeConfiguration pConfig,
                                 int pMaxFreeTreeHeight, FoliageAttachment pAttach, int foliageHeight, int foliageRadius, int Offset) {
        int $$9 = 0;

        for(int $$10 = Offset; $$10 >= Offset - foliageHeight*Offset; --$$10) {
            this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttach.pos(), $$9, $$10-3, pAttach.doubleTrunk());
            if ($$9 >= 1 && $$10 == Offset - foliageHeight + 1) {
                --$$9;
            } else if ($$9 < foliageRadius + pAttach.radiusOffset()) {
                ++$$9;
            }
        }
    }

    @Override
    public int foliageHeight(RandomSource randomSource, int i, TreeConfiguration treeConfiguration) {
        return this.height;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource randomSource, int pLocalX, int pLocalY, int pLocalZ, int pRange, boolean b) {
        return false;
    }
}
