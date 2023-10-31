package net.dkxly.parkour_thingies.fabridash_api;

import net.dkxly.parkour_thingies.ParkourThingies;
import net.dkxly.parkour_thingies.effect.ParkourThingiesStatusEffects;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

import java.util.Random;

public class Fabridash {
    
    private static Random random = new Random();

    /**
     * With this you can launch (or "dash") an entity forwards or backwards
     *
     * @param entity The entity that will perform the dash/will be launched
     * @param power The power of the dash aka how far it will go
     * @param reversed Weather to reverse the direction of the dash or no*/
    public static void dash(Entity entity, float power, boolean reversed){
        ParkourThingies.LOGGER.info("Dashing");

        float f = entity.getYaw();
        float g = 1F;
        float h = -MathHelper.sin(f * 0.017453292F) * MathHelper.cos(g * 0.017453292F);
        float k = -MathHelper.sin(g * 0.017453292F);
        float l = MathHelper.cos(f * 0.017453292F) * MathHelper.cos(g * 0.017453292F);
        float m = MathHelper.sqrt(h * h + k * k + l * l);
        float n = (1.0F + power) * 1.5F;
        h *= n / m;
        k *= n / m;
        l *= n / m;
        if(reversed){
            entity.addVelocity(-h, k, -l);
        }else{
            entity.addVelocity(h, k, l);
        }
        if(entity instanceof ServerPlayerEntity){
            sendVelocityPacket((ServerPlayerEntity) entity, entity.getVelocity());
        }
        for(int i = 0; i<200; i++){
            entity.getWorld().addParticle(ParticleTypes.SCULK_SOUL, entity.getX()+random.nextFloat(), entity.getY()+random.nextFloat(), entity.getZ()+random.nextFloat(), -0.5+random.nextFloat(), -0.5+random.nextFloat(), -0.5+random.nextFloat());
            entity.getWorld().addParticle(ParticleTypes.SCULK_CHARGE_POP, entity.getX()+random.nextFloat(), entity.getY()+random.nextFloat(), entity.getZ()+random.nextFloat(), -0.5+random.nextFloat(), -0.5+random.nextFloat(), -0.5+random.nextFloat());
        }
        if (entity instanceof ClientPlayerEntity playerEntity) {
            playerEntity.removeStatusEffect(ParkourThingiesStatusEffects.IRON_VELOCITIC_EFFECT);
            playerEntity.removeStatusEffect(ParkourThingiesStatusEffects.GOLD_VELOCITIC_EFFECT);
            playerEntity.removeStatusEffect(ParkourThingiesStatusEffects.DIAMOND_VELOCITIC_EFFECT);
            playerEntity.removeStatusEffect(ParkourThingiesStatusEffects.NETHERITE_VELOCITIC_EFFECT);
        }
    }

    /**This method will send a packet to the client, sending the velocity
     * calculated by the server to not cause desyncs. You normally don't need
     * to use it.*/
    public static void sendVelocityPacket(ServerPlayerEntity player, Vec3d vel){
        ParkourThingies.LOGGER.info("Sending the packet, with this vel: "+ vel);
        try{
            ServerPlayNetworking.send(player, VelocityPacketS2C.ID, new VelocityPacketS2C(vel));
        }catch(Exception e){
            ParkourThingies.LOGGER.error("FAILED to send data packets to the client!");
            e.printStackTrace();
        }
    }
}
