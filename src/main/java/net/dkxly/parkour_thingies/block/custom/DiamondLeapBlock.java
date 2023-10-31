package net.dkxly.parkour_thingies.block.custom;

import net.dkxly.parkour_thingies.effect.ParkourThingiesStatusEffects;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DiamondLeapBlock extends Block {

    public static BlockPos blockPos = new BlockPos(1, 1, 1);

    public DiamondLeapBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if(entity instanceof ServerPlayerEntity serverPlayerEntity) {
            StatusEffectInstance statusEffectInstance = new StatusEffectInstance(
                    StatusEffects.JUMP_BOOST,
                    7,
                    6,
                    false,
                    false,
                    false
            );


            StatusEffectInstance leap = new StatusEffectInstance(
                    ParkourThingiesStatusEffects.DIAMOND_LEAP_EFFECT,
                    5,
                    0,
                    true,
                    false
            );

            blockPos = pos;

            serverPlayerEntity.addStatusEffect(statusEffectInstance);
            serverPlayerEntity.addStatusEffect(leap);
        }
    }

    @Override
    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        entity.handleFallDamage(fallDistance, 0f, world.getDamageSources().fall());
    }
}
