package net.frostytrix.tutorialmod.item;

import net.frostytrix.tutorialmod.TutorialModTest;
import net.frostytrix.tutorialmod.item.custom.ArthussetteOreDetectorItem;
import net.frostytrix.tutorialmod.item.custom.FuelItem;
import net.minecraft.world.item.Item;
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


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
