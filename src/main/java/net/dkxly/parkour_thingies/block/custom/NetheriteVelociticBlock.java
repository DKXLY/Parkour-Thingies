package net.dkxly.parkour_thingies.block.custom;

import net.dkxly.parkour_thingies.effect.ParkourThingiesStatusEffects;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class NetheriteVelociticBlock extends Block {

    public static BlockPos blockPos = new BlockPos(1, 10000, 1);

    public NetheriteVelociticBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        blockPos = pos;
        StatusEffectInstance statusEffectInstance = new StatusEffectInstance(ParkourThingiesStatusEffects.NETHERITE_VELOCITIC_EFFECT, 5, 0, true, false, false);

        if (entity instanceof PlayerEntity playerEntity) {
            playerEntity.addStatusEffect(statusEffectInstance);
        }

        super.onSteppedOn(world, pos, state, entity);
    }

    @Override
    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        entity.handleFallDamage(fallDistance, 0f, world.getDamageSources().fall());
    }
}
