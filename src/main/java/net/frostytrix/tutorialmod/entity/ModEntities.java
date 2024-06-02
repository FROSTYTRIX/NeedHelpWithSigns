package net.frostytrix.tutorialmod.entity;

import net.frostytrix.tutorialmod.TutorialModTest;
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



    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
