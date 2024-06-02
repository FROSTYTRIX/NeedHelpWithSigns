package net.frostytrix.tutorialmod.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.frostytrix.tutorialmod.TutorialModTest;
import net.frostytrix.tutorialmod.recipe.PadoukIncantationTableRecipe;
import net.frostytrix.tutorialmod.screen.PadoukIncantationTableScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

@JeiPlugin
public class JEITutorialModTestPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(TutorialModTest.MODID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new PadoukIncantationCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();
        List<PadoukIncantationTableRecipe> padoukIncantationTableRecipes = recipeManager.getAllRecipesFor(PadoukIncantationTableRecipe.Type.INSTANCE);
        registration.addRecipes(PadoukIncantationCategory.PADOUK_INCANTATION_TYPE, padoukIncantationTableRecipes);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(PadoukIncantationTableScreen.class, 86, 31, 7, 26,
                PadoukIncantationCategory.PADOUK_INCANTATION_TYPE);
    }
}
