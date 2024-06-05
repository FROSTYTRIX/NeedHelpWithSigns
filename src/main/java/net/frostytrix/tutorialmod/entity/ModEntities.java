package net.frostytrix.tutorialmod.entity;

import net.frostytrix.tutorialmod.TutorialModTest;
import net.frostytrix.tutorialmod.entity.custom.CoinProjectileEntity;
import net.frostytrix.tutorialmod.entity.custom.ModBoatEntity;
import net.frostytrix.tutorialmod.entity.custom.ModChestBoatEntity;
import net.frostytrix.tutorialmod.entity.custom.TimmyEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TutorialModTest.MODID);

    public static final RegistryObject<EntityType<TimmyEntity>> TIMMY =
            ENTITY_TYPES.register("timmy", () -> EntityType.Builder.of(TimmyEntity::new, MobCategory.CREATURE)
                    .sized(.9f, 2f).build("timmy"));

    public static final RegistryObject<EntityType<ModBoatEntity>> MOD_BOAT =
            ENTITY_TYPES.register("mod_boat", () -> EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new, MobCategory.MISC)
                    .sized(1.375f, 0.5625f).build("mod_boat"));
    public static final RegistryObject<EntityType<ModChestBoatEntity>> MOD_CHEST_BOAT =
            ENTITY_TYPES.register("mod_chest_boat", () -> EntityType.Builder.<ModChestBoatEntity>of(ModChestBoatEntity::new, MobCategory.MISC)
                    .sized(1.375f, 0.5625f).build("mod_chest_boat"));

    public static final RegistryObject<EntityType<CoinProjectileEntity>> COIN_PROJECTILE =
            ENTITY_TYPES.register("coin_projectile", () -> EntityType.Builder.<CoinProjectileEntity>of(CoinProjectileEntity::new, MobCategory.MISC)
                    .sized(.5f, 0.5f).build("coin_projectile"));




    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
