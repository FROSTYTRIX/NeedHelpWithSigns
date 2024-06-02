package net.frostytrix.tutorialmod.util;

import net.frostytrix.tutorialmod.TutorialModTest;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWoodTypes {
    public static final WoodType PADOUK = WoodType.register(new WoodType(TutorialModTest.MODID + ":padouk", BlockSetType.OAK));
}
