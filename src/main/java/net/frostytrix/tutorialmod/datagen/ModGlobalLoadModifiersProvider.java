package net.frostytrix.tutorialmod.datagen;

import net.frostytrix.tutorialmod.TutorialModTest;
import net.frostytrix.tutorialmod.item.ModItems;
import net.frostytrix.tutorialmod.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLoadModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLoadModifiersProvider(PackOutput output) {
        super(output, TutorialModTest.MODID);
    }

    @Override
    protected void start() {

        // CLOVER
        add("four_leaves_clover_from_sheep_white", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/sheep/white")).build(),
                LootItemRandomChanceCondition.randomChance(.01f).build()}, ModItems.FOUR_LEAVES_CLOVER.get()));
        add("four_leaves_clover_from_sheep_black", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/sheep/black")).build(),
                LootItemRandomChanceCondition.randomChance(.01f).build()}, ModItems.FOUR_LEAVES_CLOVER.get()));
        add("four_leaves_clover_from_sheep_blue", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/sheep/blue")).build(),
                LootItemRandomChanceCondition.randomChance(.01f).build()}, ModItems.FOUR_LEAVES_CLOVER.get()));
        add("four_leaves_clover_from_sheep_brown", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/sheep/brown")).build(),
                LootItemRandomChanceCondition.randomChance(.01f).build()}, ModItems.FOUR_LEAVES_CLOVER.get()));
        add("four_leaves_clover_from_sheep_cyan", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/sheep/cyan")).build(),
                LootItemRandomChanceCondition.randomChance(.01f).build()}, ModItems.FOUR_LEAVES_CLOVER.get()));
        add("four_leaves_clover_from_sheep_gray", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/sheep/gray")).build(),
                LootItemRandomChanceCondition.randomChance(.01f).build()}, ModItems.FOUR_LEAVES_CLOVER.get()));
        add("four_leaves_clover_from_sheep_green", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/sheep/green")).build(),
                LootItemRandomChanceCondition.randomChance(.25f).build()}, ModItems.FOUR_LEAVES_CLOVER.get()));
        add("four_leaves_clover_from_sheep_light_blue", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/sheep/light_blue")).build(),
                LootItemRandomChanceCondition.randomChance(.01f).build()}, ModItems.FOUR_LEAVES_CLOVER.get()));
        add("four_leaves_clover_from_sheep_light_gray", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/sheep/light_gray")).build(),
                LootItemRandomChanceCondition.randomChance(.01f).build()}, ModItems.FOUR_LEAVES_CLOVER.get()));
        add("four_leaves_clover_from_sheep_lime", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/sheep/lime")).build(),
                LootItemRandomChanceCondition.randomChance(.01f).build()}, ModItems.FOUR_LEAVES_CLOVER.get()));
        add("four_leaves_clover_from_sheep_magenta", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/sheep/magenta")).build(),
                LootItemRandomChanceCondition.randomChance(.01f).build()}, ModItems.FOUR_LEAVES_CLOVER.get()));
        add("four_leaves_clover_from_sheep_orange", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/sheep/orange")).build(),
                LootItemRandomChanceCondition.randomChance(.01f).build()}, ModItems.FOUR_LEAVES_CLOVER.get()));
        add("four_leaves_clover_from_sheep_pink", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/sheep/pink")).build(),
                LootItemRandomChanceCondition.randomChance(.01f).build()}, ModItems.FOUR_LEAVES_CLOVER.get()));
        add("four_leaves_clover_from_sheep_purple", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/sheep/purple")).build(),
                LootItemRandomChanceCondition.randomChance(.01f).build()}, ModItems.FOUR_LEAVES_CLOVER.get()));
        add("four_leaves_clover_from_sheep_red", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/sheep/red")).build(),
                LootItemRandomChanceCondition.randomChance(.01f).build()}, ModItems.FOUR_LEAVES_CLOVER.get()));
        add("four_leaves_clover_from_sheep_yellow", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/sheep/yellow")).build(),
                LootItemRandomChanceCondition.randomChance(.01f).build()}, ModItems.FOUR_LEAVES_CLOVER.get()));

        //


    }
}
