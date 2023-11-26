package net.dkxly.parkour_thingies.block;

import net.dkxly.parkour_thingies.ParkourThingies;
import net.dkxly.parkour_thingies.block.custom.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.Instrument;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import static net.dkxly.parkour_thingies.ParkourThingies.itemList;

public class ParkourThingiesBlocks {
    public static final Block IRON_LEAP_BLOCK = registerBlock("iron_leap_block", new IronLeapBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block GOLD_LEAP_BLOCK = registerBlock("gold_leap_block", new GoldLeapBlock(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK)));
    public static final Block DIAMOND_LEAP_BLOCK = registerBlock("diamond_leap_block", new DiamondLeapBlock(FabricBlockSettings.copyOf(Blocks.DIAMOND_BLOCK)));
    public static final Block NETHERITE_LEAP_BLOCK = registerBlock("netherite_leap_block", new NetheriteLeapBlock(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK)));
    public static final Block GOLD_PLATED_EMERALD_BLOCK = registerBlock("gold_plated_emerald_block", new Block(FabricBlockSettings.copyOf(Blocks.EMERALD_BLOCK)));
    public static final Block IRON_VELOCITIC_BLOCK = registerBlock("iron_velocitic_block", new IronVelociticBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block GOLD_VELOCITIC_BLOCK = registerBlock("gold_velocitic_block", new GoldVelociticBlock(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK)));
    public static final Block DIAMOND_VELOCITIC_BLOCK = registerBlock("diamond_velocitic_block", new DiamondVelociticBlock(FabricBlockSettings.copyOf(Blocks.DIAMOND_BLOCK)));
    public static final Block NETHERITE_VELOCITIC_BLOCK = registerBlock("netherite_velocitic_block", new NetheriteVelociticBlock(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK)));

    public static Block registerBlock(String id, Block block) {
        registerBlockItem(id, block);
        return Registry.register(
                Registries.BLOCK,
                new Identifier(ParkourThingies.MOD_ID, id),
                block
        );
    }

    public static void registerBlockItem(String id, Block block) {
        BlockItem item = Registry.register(
                Registries.ITEM,
                new Identifier(ParkourThingies.MOD_ID, id),
                new BlockItem(block, new FabricItemSettings())
        );
        itemList.add(item);
    }

    public static void registerModBlocks() {
        ParkourThingies.LOGGER.info("Initializing custom parkour blockies :)");
    }
}
