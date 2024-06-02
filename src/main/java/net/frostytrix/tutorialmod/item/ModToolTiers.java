package net.frostytrix.tutorialmod.item;

import net.frostytrix.tutorialmod.util.ModTags;
import net.frostytrix.tutorialmod.TutorialModTest;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier ARTHUSSITTE = TierSortingRegistry.registerTier(
            new ForgeTier(5, 2500, 11f, 5f, 20,
                    ModTags.Blocks.NEEDS_ARTHUSSITTE_TOOL, () -> Ingredient.of(ModItems.ARTHUSSITTE.get())),
            new ResourceLocation(TutorialModTest.MODID, "arthussite"), List.of(Tiers.NETHERITE), List.of());
}
