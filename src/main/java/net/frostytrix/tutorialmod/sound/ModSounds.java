package net.frostytrix.tutorialmod.sound;

import net.frostytrix.tutorialmod.TutorialModTest;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENT =
        DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, TutorialModTest.MODID);

    public static final RegistryObject<SoundEvent> FARFADET_MALICIEUX_RIGHT_CLICK = registerSoundEvents("farfadet_malicieux_right_click");


    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENT.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(TutorialModTest.MODID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENT.register(eventBus);
    }
}
