package net.dkxly.parkour_thingies.sounds;

import net.dkxly.parkour_thingies.ParkourThingies;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ParkourThingiesSounds {

    public static final SoundEvent VELOCITIC_WARP = registerSoundEvent("velocitic_warp");
    public static final SoundEvent LEAP = registerSoundEvent("leap");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(ParkourThingies.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        ParkourThingies.LOGGER.info("Registering soundies :)");
    }
}
