package net.dkxly.parkour_thingies.effect;

import net.dkxly.parkour_thingies.ParkourThingies;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ParkourThingiesStatusEffects {
    public static IronVelociticEffect IRON_VELOCITIC_EFFECT = Registry.register(Registries.STATUS_EFFECT, new Identifier(ParkourThingies.MOD_ID, "iron_velocitic_effect"), new IronVelociticEffect(StatusEffectCategory.NEUTRAL, 000000));
    public static GoldVelociticEffect GOLD_VELOCITIC_EFFECT = Registry.register(Registries.STATUS_EFFECT, new Identifier(ParkourThingies.MOD_ID, "gold_velocitic_effect"), new GoldVelociticEffect(StatusEffectCategory.NEUTRAL, 000000));
    public static DiamondVelociticEffect DIAMOND_VELOCITIC_EFFECT = Registry.register(Registries.STATUS_EFFECT, new Identifier(ParkourThingies.MOD_ID, "diamond_velocitic_effect"), new DiamondVelociticEffect(StatusEffectCategory.NEUTRAL, 000000));
    public static NetheriteVelociticEffect NETHERITE_VELOCITIC_EFFECT = Registry.register(Registries.STATUS_EFFECT, new Identifier(ParkourThingies.MOD_ID, "netherite_velocitic_effect"), new NetheriteVelociticEffect(StatusEffectCategory.NEUTRAL, 000000));
    public static IronLeapEffect IRON_LEAP_EFFECT = Registry.register(Registries.STATUS_EFFECT, new Identifier(ParkourThingies.MOD_ID, "iron_leap_effect"), new IronLeapEffect(StatusEffectCategory.NEUTRAL, 000000));
    public static GoldLeapEffect GOLD_LEAP_EFFECT = Registry.register(Registries.STATUS_EFFECT, new Identifier(ParkourThingies.MOD_ID, "gold_leap_effect"), new GoldLeapEffect(StatusEffectCategory.NEUTRAL, 000000));
    public static DiamondLeapEffect DIAMOND_LEAP_EFFECT = Registry.register(Registries.STATUS_EFFECT, new Identifier(ParkourThingies.MOD_ID, "diamond_leap_effect"), new DiamondLeapEffect(StatusEffectCategory.NEUTRAL, 000000));
    public static NetheriteLeapEffect NETHERITE_LEAP_EFFECT = Registry.register(Registries.STATUS_EFFECT, new Identifier(ParkourThingies.MOD_ID, "netherite_leap_effect"), new NetheriteLeapEffect(StatusEffectCategory.NEUTRAL, 000000));

    public static StatusEffect registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(ParkourThingies.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        ParkourThingies.LOGGER.info("Registering status effects for the velocitic block :)");
    }
}
