package net.dkxly.parkour_thingies;

import net.dkxly.parkour_thingies.block.ParkourThingiesBlocks;
import net.dkxly.parkour_thingies.effect.ParkourThingiesStatusEffects;
import net.dkxly.parkour_thingies.item.ParkourThingiesItemGroups;
import net.dkxly.parkour_thingies.item.ParkourThingiesItems;
import net.dkxly.parkour_thingies.sounds.ParkourThingiesSounds;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

public class ParkourThingies implements ModInitializer {
	public static List<Item> itemList = new ArrayList<>();
	public static final String MOD_ID = "parkour_thingies";
    public static final Logger LOGGER = LoggerFactory.getLogger("parkour_thingies");

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing parkour blockies :)");
		ParkourThingiesStatusEffects.registerEffects();
		ParkourThingiesSounds.registerSounds();
		ParkourThingiesBlocks.registerModBlocks();
		ParkourThingiesItems.registerModItems();

		Registry.register(Registries.ITEM_GROUP, new Identifier(MOD_ID, MOD_ID), ParkourThingiesItemGroups.PARKOUR_THINGIES);
	}
}