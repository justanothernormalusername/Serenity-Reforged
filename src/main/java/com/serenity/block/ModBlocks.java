package com.serenity.block;

import com.serenity.SerenityReforged;
import com.serenity.block.cauldron.SerenityCauldronBlock;
import com.serenity.block.custom.AltarBlock;
import com.serenity.block.custom.GrindstoneBlock;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
    public static final List<Block> ALL_MOD_BLOCKS = new ArrayList<>();

    public static final Block MOONSTONE_BLOCK = registerBlock(
            "moonstone_block",
            new Block(AbstractBlock.Settings.create().strength(3f).requiresTool().sounds(BlockSoundGroup.BASALT))
    );
    public static final Block POLISHED_MOONSTONE_BLOCK = registerBlock(
            "polished_moonstone_block",
            new Block(AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.MEDIUM_AMETHYST_BUD))
    );
    public static final Block SUNSTONE_BLOCK = registerBlock(
            "sunstone_block",
            new Block(AbstractBlock.Settings.create().strength(3f).requiresTool().sounds(BlockSoundGroup.BASALT))
    );
    public static final Block POLISHED_SUNSTONE_BLOCK = registerBlock(
            "polished_sunstone_block",
            new Block(AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.MEDIUM_AMETHYST_BUD))
    );
    public static final Block GRANITE_GEM_ORE = registerBlock(
            "granite_gem_ore",
            new ExperienceDroppingBlock(
                    UniformIntProvider.create(3, 7),
                    AbstractBlock.Settings.create().strength(3f, 3f).requiresTool().sounds(BlockSoundGroup.GLASS)
            )
    );
    public static final Block ALTAR_BLOCK = registerBlock(
            "altar_block",
            new AltarBlock(AbstractBlock.Settings.create().strength(1f).requiresTool().sounds(BlockSoundGroup.ANCIENT_DEBRIS))
    );
    public static final Block SWEDISH_MEATBALL_BLOCK = registerBlock(
            "swedish_meatball_block",
            new ExperienceDroppingBlock(ConstantIntProvider.create(1), AbstractBlock.Settings.create().strength(0.5f).sounds(BlockSoundGroup.HONEY))
            {
                @Override
                public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
                    tooltip.add(Text.translatable("tooltip.serenity.swedish_meatball_block"));
                    super.appendTooltip(stack, context, tooltip, options);
                }
            });
    public static final Block MOONSTONE_STAIRS = registerBlock(
            "moonstone_stairs",
            new StairsBlock(ModBlocks.MOONSTONE_BLOCK.getDefaultState(),
                    AbstractBlock.Settings.create().strength(3f).requiresTool())
    );
    public static final Block MOONSTONE_SLAB = registerBlock(
            "moonstone_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(3f).requiresTool())
    );

    public static final Block MOONSTONE_BUTTON = registerBlock(
            "moonstone_button",
            new ButtonBlock(BlockSetType.IRON, 100, AbstractBlock.Settings.create().strength(3f).requiresTool().noCollision())
    );
    public static final Block MOONSTONE_PRESSURE_PLATE = registerBlock(
            "moonstone_pressure_plate",
            new PressurePlateBlock(BlockSetType.IRON, AbstractBlock.Settings.create().strength(3f).requiresTool())
    );

    public static final Block MOONSTONE_FENCE = registerBlock(
            "moonstone_fence",
            new FenceBlock(AbstractBlock.Settings.create().strength(3f).requiresTool())
    );
    public static final Block MOONSTONE_FENCE_GATE = registerBlock(
            "moonstone_fence_gate",
            new FenceGateBlock(WoodType.ACACIA, AbstractBlock.Settings.create().strength(3f).requiresTool())
    );
    public static final Block MOONSTONE_WALL = registerBlock(
            "moonstone_wall",
            new WallBlock(AbstractBlock.Settings.create().strength(3f).requiresTool())
    );

    public static final Block MOONSTONE_DOOR = registerBlock(
            "moonstone_door",
            new DoorBlock(BlockSetType.CHERRY, AbstractBlock.Settings.create().strength(3f).requiresTool().nonOpaque())
    );
    public static final Block MOONSTONE_TRAPDOOR = registerBlock(
            "moonstone_trapdoor",
            new TrapdoorBlock(BlockSetType.CHERRY, AbstractBlock.Settings.create().strength(3f).requiresTool().nonOpaque())
    );

    public static final Block GRINDSTONE = registerBlock("grindstone",
            new GrindstoneBlock(AbstractBlock.Settings.create().nonOpaque()));

    public static final SerenityCauldronBlock BRINE_CAULDRON = Registry.register(
            Registries.BLOCK,
            Identifier.of(SerenityReforged.MOD_ID, "brine_cauldron"),
            new SerenityCauldronBlock(AbstractBlock.Settings.create().strength(3f), SerenityReforged.MOD_ID + ":brine")
    );

    public static final SerenityCauldronBlock CLAY_SLURRY_CAULDRON = Registry.register(
            Registries.BLOCK,
            Identifier.of(SerenityReforged.MOD_ID, "clay_slurry_cauldron"),
            new SerenityCauldronBlock(AbstractBlock.Settings.create().strength(3f), SerenityReforged.MOD_ID + ":clay_slurry")
    );


    private static Block registerBlock(String name, Block block) {
        Block registeredBlock = Registry.register(Registries.BLOCK, Identifier.of(SerenityReforged.MOD_ID, name), block);
        ALL_MOD_BLOCKS.add(registeredBlock);
        registerBlockItem(name, block);
        return registeredBlock;
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(
                Registries.ITEM,
                Identifier.of(SerenityReforged.MOD_ID, name),
                new BlockItem(block, new Item.Settings())
        );
    }

    public static void registerModBlocks() {
        SerenityReforged.LOGGER.info("Registering Mod Blocks for " + SerenityReforged.MOD_ID);

    }
}
