package net.frostytrix.tutorialmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties GUINNESS = new FoodProperties.Builder().nutrition(2).alwaysEat()
            .saturationMod(1f).effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 200), 0.5f).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 1), .5f).build();
}
