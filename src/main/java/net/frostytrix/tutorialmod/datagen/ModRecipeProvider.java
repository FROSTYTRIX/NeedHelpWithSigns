package net.frostytrix.tutorialmod.datagen;

import net.frostytrix.tutorialmod.util.ModTags;
import net.frostytrix.tutorialmod.TutorialModTest;
import net.frostytrix.tutorialmod.block.ModBlocks;
import net.frostytrix.tutorialmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
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

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_ARTHUSSITTE_BLOCK.get(), 1)
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.RAW_ARTHUSSITTE.get())
                .unlockedBy(getHasName(ModItems.RAW_ARTHUSSITTE.get()), has(ModItems.RAW_ARTHUSSITTE.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_ARTHUSSITTE.get(), 9)
                .requires(ModBlocks.RAW_ARTHUSSITTE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RAW_ARTHUSSITTE_BLOCK.get()), has(ModBlocks.RAW_ARTHUSSITTE_BLOCK.get()))
                .save(pWriter);


        // PADOUK

        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE, ModBlocks.PADOUK_BUTTON.get(), 1)
                .requires(ModBlocks.ARTHUSSITTE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.PADOUK_PLANKS.get()), has(ModBlocks.PADOUK_PLANKS.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.PADOUK_DOOR.get(), 3)
                .pattern("SS ")
                .pattern("SS ")
                .pattern("SS ")
                .define('S', ModBlocks.PADOUK_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.PADOUK_PLANKS.get()), has(ModBlocks.PADOUK_PLANKS.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.PADOUK_TRAPDOOR.get(), 2)
                .pattern("   ")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModBlocks.PADOUK_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.PADOUK_PLANKS.get()), has(ModBlocks.PADOUK_PLANKS.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PADOUK_STAIRS.get(), 3)
                .pattern("S  ")
                .pattern("SS ")
                .pattern("SSS")
                .define('S', ModBlocks.PADOUK_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.PADOUK_PLANKS.get()), has(ModBlocks.PADOUK_PLANKS.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PADOUK_SLAB.get(), 3)
                .pattern("   ")
                .pattern("   ")
                .pattern("SSS")
                .define('S', ModBlocks.PADOUK_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.PADOUK_PLANKS.get()), has(ModBlocks.PADOUK_PLANKS.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PADOUK_FENCE.get(), 3)
                .pattern("   ")
                .pattern("BSB")
                .pattern("BSB")
                .define('B', ModBlocks.PADOUK_PLANKS.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModBlocks.PADOUK_PLANKS.get()), has(ModBlocks.PADOUK_PLANKS.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PADOUK_FENCE_GATE.get(), 3)
                .pattern("   ")
                .pattern("BSB")
                .pattern("BSB")
                .define('S', ModBlocks.PADOUK_PLANKS.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModBlocks.PADOUK_PLANKS.get()), has(ModBlocks.PADOUK_PLANKS.get()))
                .save(pWriter);

        // Armor n Tools
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.ARTHUSSITTE_HELMET.get(), 1)
                .pattern("   ")
                .pattern("XXX")
                .pattern("X X")
                .define('X', ModItems.ARTHUSSITTE.get())
                .unlockedBy(getHasName(ModItems.ARTHUSSITTE.get()), has(ModItems.ARTHUSSITTE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.ARTHUSSITTE_CHESTPLATE.get(), 1)
                .pattern("X X")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', ModItems.ARTHUSSITTE.get())
                .unlockedBy(getHasName(ModItems.ARTHUSSITTE.get()), has(ModItems.ARTHUSSITTE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.ARTHUSSITTE_LEGGINGS.get(), 1)
                .pattern("XXX")
                .pattern("X X")
                .pattern("X X")
                .define('X', ModItems.ARTHUSSITTE.get())
                .unlockedBy(getHasName(ModItems.ARTHUSSITTE.get()), has(ModItems.ARTHUSSITTE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.ARTHUSSITTE_BOOTS.get(), 1)
                .pattern("   ")
                .pattern("X X")
                .pattern("X X")
                .define('X', ModItems.ARTHUSSITTE.get())
                .unlockedBy(getHasName(ModItems.ARTHUSSITTE.get()), has(ModItems.ARTHUSSITTE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.ARTHUSSITTE_SWORD.get(), 1)
                .pattern(" X ")
                .pattern(" X ")
                .pattern(" x ")
                .define('X', ModItems.ARTHUSSITTE.get())
                .define( 'x', Items.STICK)
                .unlockedBy(getHasName(ModItems.ARTHUSSITTE.get()), has(ModItems.ARTHUSSITTE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ARTHUSSITTE_PICKAXE.get(), 1)
                .pattern("XXX")
                .pattern(" x ")
                .pattern(" x ")
                .define('X', ModItems.ARTHUSSITTE.get())
                .define( 'x', Items.STICK)
                .unlockedBy(getHasName(ModItems.ARTHUSSITTE.get()), has(ModItems.ARTHUSSITTE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ARTHUSSITTE_AXE.get(), 1)
                .pattern("XX ")
                .pattern("Xx ")
                .pattern(" x ")
                .define('X', ModItems.ARTHUSSITTE.get())
                .define( 'x', Items.STICK)
                .unlockedBy(getHasName(ModItems.ARTHUSSITTE.get()), has(ModItems.ARTHUSSITTE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ARTHUSSITTE_SHOVEL.get(), 1)
                .pattern(" X ")
                .pattern(" x ")
                .pattern(" x ")
                .define('X', ModItems.ARTHUSSITTE.get())
                .define( 'x', Items.STICK)
                .unlockedBy(getHasName(ModItems.ARTHUSSITTE.get()), has(ModItems.ARTHUSSITTE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ARTHUSSITTE_HOE.get(), 1)
                .pattern(" XX")
                .pattern(" x ")
                .pattern(" x ")
                .define('X', ModItems.ARTHUSSITTE.get())
                .define( 'x', Items.STICK)
                .unlockedBy(getHasName(ModItems.ARTHUSSITTE.get()), has(ModItems.ARTHUSSITTE.get()))
                .save(pWriter);
        // PLANKS
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PADOUK_PLANKS.get(),4)
                .requires(ModTags.Items.PADOUK_LOG)
                .unlockedBy(getHasName(ModBlocks.PADOUK_LOG.get()), has(ModBlocks.PADOUK_LOG.get()))
                .save(pWriter);
        // WOOD
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PADOUK_WOOD.get(), 3)
                .pattern("   ")
                .pattern(" XX")
                .pattern(" XX")
                .define('X', ModBlocks.PADOUK_LOG.get())
                .unlockedBy(getHasName(ModBlocks.PADOUK_LOG.get()), has(ModBlocks.PADOUK_LOG.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_PADOUK_WOOD.get(), 3)
                .pattern("   ")
                .pattern(" XX")
                .pattern(" XX")
                .define('X', ModBlocks.STRIPPED_PADOUK_LOG.get())
                .unlockedBy(getHasName(ModBlocks.PADOUK_LOG.get()), has(ModBlocks.PADOUK_LOG.get()))
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
