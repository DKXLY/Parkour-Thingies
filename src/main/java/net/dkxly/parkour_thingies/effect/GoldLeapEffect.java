package net.dkxly.parkour_thingies.effect;

import net.dkxly.parkour_thingies.ParkourThingies;
import net.dkxly.parkour_thingies.block.custom.DiamondLeapBlock;
import net.dkxly.parkour_thingies.block.custom.GoldLeapBlock;
import net.dkxly.parkour_thingies.block.custom.IronLeapBlock;
import net.dkxly.parkour_thingies.block.custom.NetheriteLeapBlock;
import net.dkxly.parkour_thingies.sounds.ParkourThingiesSounds;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

import static net.dkxly.parkour_thingies.ParkourThingies.soundVolume;

public class GoldLeapEffect extends StatusEffect {
    protected GoldLeapEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity playerEntity) {
            if ((GoldLeapBlock.blockPos.getY() + 2f) < playerEntity.getY()) {
                playerEntity.playSound(ParkourThingiesSounds.LEAP, soundVolume, 1);
            }
        }
        super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
