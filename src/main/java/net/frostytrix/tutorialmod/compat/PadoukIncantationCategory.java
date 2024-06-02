package net.frostytrix.tutorialmod.compat;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.frostytrix.tutorialmod.TutorialModTest;
import net.frostytrix.tutorialmod.block.ModBlocks;
import net.frostytrix.tutorialmod.recipe.PadoukIncantationTableRecipe;
import net.minecraft.data.advancements.packs.VanillaAdvancementProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class PadoukIncantationCategory implements IRecipeCategory<PadoukIncantationTableRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(TutorialModTest.MODID, "padouk_incantation");
    public static final ResourceLocation TEXTURE = new ResourceLocation(TutorialModTest.MODID,
            "textures/gui/padouk_incantation_table_gui.png");

    public static final RecipeType<PadoukIncantationTableRecipe> PADOUK_INCANTATION_TYPE =
            new RecipeType<>(UID, PadoukIncantationTableRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public PadoukIncantationCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 80);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.PADOUK_INCANTATION_TABLE.get()));
    }


    @Override
    public RecipeType<PadoukIncantationTableRecipe> getRecipeType() {
        return PADOUK_INCANTATION_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.frostytrixmod.padouk_incantation_table");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, PadoukIncantationTableRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 80, 11).addIngredients(recipe.getIngredients().get(0));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 80, 59).addItemStack(recipe.getResultItem(null));
    }
}
