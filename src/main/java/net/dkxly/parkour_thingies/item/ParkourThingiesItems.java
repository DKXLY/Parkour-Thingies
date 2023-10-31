package net.dkxly.parkour_thingies.item;

import net.dkxly.parkour_thingies.ParkourThingies;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.dkxly.parkour_thingies.ParkourThingies.itemList;

public class ParkourThingiesItems {
    public static final Item SCULK_ESSENCE = registerItem("sculk_essence", new Item(new FabricItemSettings()));
    public static final Item SCULK_STAR = registerItem("sculk_star", new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        Item registeredItem = Registry.register(Registries.ITEM, new Identifier(ParkourThingies.MOD_ID, name), item);
        itemList.add(registeredItem);
        return registeredItem;
    }

    public static void registerModItems() {
        ParkourThingies.LOGGER.info("Initializing cool items for Parkour Thingies.");
    }
}
