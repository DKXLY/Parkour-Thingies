package net.dkxly.parkour_thingies.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

import static net.dkxly.parkour_thingies.ParkourThingies.itemList;

public class ParkourThingiesItemGroups {
    public static final ItemGroup PARKOUR_THINGIES = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ParkourThingiesItems.SCULK_STAR))
            .displayName(Text.literal("Parkour Thingies")).entries((displayContext, entries) -> {
                for(int i = 0; i < itemList.size(); i++) {
                    entries.add(itemList.get(i));
                }
            })
            .build();
}
