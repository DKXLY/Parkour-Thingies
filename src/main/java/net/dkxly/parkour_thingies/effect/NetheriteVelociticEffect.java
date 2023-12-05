package net.dkxly.parkour_thingies.effect;

import net.dkxly.parkour_thingies.block.custom.NetheriteVelociticBlock;
import net.dkxly.parkour_thingies.fabridash_api.Fabridash;
import net.dkxly.parkour_thingies.sounds.ParkourThingiesSounds;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;

import static net.dkxly.parkour_thingies.ParkourThingies.soundVolume;

public class NetheriteVelociticEffect extends StatusEffect {
    protected NetheriteVelociticEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity playerEntity) {
            if ((NetheriteVelociticBlock.blockPos.getY() + 1.5f) < playerEntity.getY()) {
                playerEntity.playSound(ParkourThingiesSounds.VELOCITIC_WARP, SoundCategory.BLOCKS, soundVolume, 1);
                Fabridash.dash(playerEntity, 3f, false);

                StatusEffectInstance speed = new StatusEffectInstance(StatusEffects.SPEED, 4, 4, true, false, false);
                playerEntity.addStatusEffect(speed);
            }
        }
        super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
