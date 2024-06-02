package net.frostytrix.tutorialmod.item;

import net.frostytrix.tutorialmod.TutorialModTest;
import net.frostytrix.tutorialmod.block.ModBlocks;
import net.frostytrix.tutorialmod.block.custom.GuinnessCropBlock;
import net.frostytrix.tutorialmod.entity.ModEntities;
import net.frostytrix.tutorialmod.item.custom.ArthussetteOreDetectorItem;
import net.frostytrix.tutorialmod.item.custom.FuelItem;
import net.frostytrix.tutorialmod.item.custom.ModArmorItem;
import net.frostytrix.tutorialmod.sound.ModSounds;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public  static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialModTest.MODID);

    public static final RegistryObject<Item> ARTHUSSITTE = ITEMS.register("arthussite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_ARTHUSSITTE = ITEMS.register("raw_arthussite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ARTHUSSETTE_ORE_DETECTOR = ITEMS.register("arthussette_ore_detector",
            () -> new ArthussetteOreDetectorItem(new Item.Properties().durability(100)));

    public static final RegistryObject<Item> GUINNESS = ITEMS.register("guinness",
            () -> new Item(new Item.Properties().food(ModFoods.GUINNESS)));

    public static final RegistryObject<Item> CHARBON_MALICIEUX = ITEMS.register("charbon_malicieux",
            () -> new FuelItem(new Item.Properties(), 1600));

    public static final RegistryObject<Item> FOUR_LEAVES_CLOVER = ITEMS.register("four_leaves_clover",
            () -> new Item(new Item.Properties()));

    // Arthussitte Stuff
    // Tools
    public static final RegistryObject<Item> ARTHUSSITTE_SWORD = ITEMS.register("arthussitte_sword",
            () -> new SwordItem(ModToolTiers.ARTHUSSITTE, 3, -2.4f, new Item.Properties()));
    public static final RegistryObject<Item> ARTHUSSITTE_PICKAXE = ITEMS.register("arthussitte_pickaxe",
            () -> new PickaxeItem(ModToolTiers.ARTHUSSITTE, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> ARTHUSSITTE_AXE = ITEMS.register("arthussitte_axe",
            () -> new AxeItem(ModToolTiers.ARTHUSSITTE, 5, -3f, new Item.Properties()));
    public static final RegistryObject<Item> ARTHUSSITTE_SHOVEL = ITEMS.register("arthussitte_shovel",
            () -> new ShovelItem(ModToolTiers.ARTHUSSITTE, 1, -3f, new Item.Properties()));
    public static final RegistryObject<Item> ARTHUSSITTE_HOE = ITEMS.register("arthussitte_hoe",
            () -> new HoeItem(ModToolTiers.ARTHUSSITTE, -4, 0f, new Item.Properties()));
    // Armor
    public static final RegistryObject<Item> ARTHUSSITTE_HELMET = ITEMS.register("arthussitte_helmet",
            () -> new ModArmorItem(ModArmorMaterials.ARTHUSSITTE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> ARTHUSSITTE_CHESTPLATE = ITEMS.register("arthussitte_chestplate",
            () -> new ModArmorItem(ModArmorMaterials.ARTHUSSITTE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> ARTHUSSITTE_LEGGINGS = ITEMS.register("arthussitte_leggings",
            () -> new ModArmorItem(ModArmorMaterials.ARTHUSSITTE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> ARTHUSSITTE_BOOTS = ITEMS.register("arthussitte_boots",
            () -> new ModArmorItem(ModArmorMaterials.ARTHUSSITTE, ArmorItem.Type.BOOTS, new Item.Properties()));

    // Crops

    public static final RegistryObject<Item> GUINNESS_SEEDS = ITEMS.register("guinness_seeds",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BLESSED_GUINNESS_SEEDS = ITEMS.register("blessed_guinness_seeds",
            () -> new ItemNameBlockItem(ModBlocks.GUINNESS_CROP.get(), new Item.Properties().rarity(Rarity.EPIC)));
    // MUSIC

    // Mobs
    public static final RegistryObject<Item> TIMMY_SPAWN_EGG = ITEMS.register("timmy_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.TIMMY, 0x97f283, 0xffd700,
                    new Item.Properties()));

    // Wood
    public static final RegistryObject<Item> PADOUK_SIGN = ITEMS.register("padouk_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.PADOUK_SIGN.get(), ModBlocks.PADOUK_WALL_SIGN.get()));
    public static final RegistryObject<Item> PADOUK_HANGING_SIGN = ITEMS.register("padouk_hanging_sign",
            () -> new HangingSignItem(ModBlocks.PADOUK_HANGING_SIGN.get(), ModBlocks.PADOUK_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));





    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
