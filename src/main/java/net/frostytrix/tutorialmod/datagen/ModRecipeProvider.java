package net.frostytrix.tutorialmod.datagen;

import net.frostytrix.tutorialmod.TutorialModTest;
import net.frostytrix.tutorialmod.block.ModBlocks;
import net.frostytrix.tutorialmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> ARTHUSSITE_SMELTABLES = List.of(ModItems.RAW_ARTHUSSITTE.get(),
            ModBlocks.ARTHUSSITTE_ORE.get(),
            ModBlocks.DEEPSLATE_ARTHUSSITTE_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    // Liste des crafts

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreBlasting(pWriter, ARTHUSSITE_SMELTABLES, RecipeCategory.MISC, ModItems.ARTHUSSITTE.get(), 0.25f, 100, "arthussite");
        oreSmelting(pWriter, ARTHUSSITE_SMELTABLES, RecipeCategory.MISC, ModItems.ARTHUSSITTE.get(), 0.25f, 200, "arthussite");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ARTHUSSITTE_BLOCK.get(), 1)
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.ARTHUSSITTE.get())
                .unlockedBy(getHasName(ModItems.ARTHUSSITTE.get()), has(ModItems.ARTHUSSITTE.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ARTHUSSITTE.get(), 9)
                .requires(ModBlocks.ARTHUSSITTE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.ARTHUSSITTE_BLOCK.get()), has(ModBlocks.ARTHUSSITTE_BLOCK.get()))
                .save(pWriter);
    }




    //Copie Colle pour modifier quoi que ce soit

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        Iterator var9 = pIngredients.iterator();

        while(var9.hasNext()) {
            ItemLike itemlike = (ItemLike)var9.next();
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult,
                    pExperience, pCookingTime, pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, TutorialModTest.MODID + ":" + (pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }

}
