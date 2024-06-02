package net.frostytrix.tutorialmod.recipe;

import net.frostytrix.tutorialmod.TutorialModTest;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, TutorialModTest.MODID);

    public static final RegistryObject<RecipeSerializer<PadoukIncantationTableRecipe>> PADOUK_INCANTATION_SERIALIZER =
            SERIALIZERS.register("padouk_incantation", () -> PadoukIncantationTableRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
