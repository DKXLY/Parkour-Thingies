package net.dkxly.parkour_thingies;

import net.dkxly.parkour_thingies.fabridash_api.VelocityPacketS2C;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

import java.util.NoSuchElementException;

public class ParkourThingiesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        registerVelocityPacket();
    }

    private void registerVelocityPacket(){
        ParkourThingies.LOGGER.info("Registering dash packet receiver on the client... Courtesy of Fabridash!");
        ClientPlayNetworking.registerGlobalReceiver(VelocityPacketS2C.ID, ((client, handler, buf, responseSender) -> {
            var results = VelocityPacketS2C.read(buf);

            client.execute(() -> {
                try{
                    client.player.setVelocity(results);
                }catch (NoSuchElementException e){
                    ParkourThingies.LOGGER.warn("No value in the packet, probably not a big problem");
                }catch (Exception e){
                    ParkourThingies.LOGGER.error("There was an error while getting the packet!");
                    e.printStackTrace();
                }
            });
        }));
    }
}
