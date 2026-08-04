package com.serenity.item;

import com.serenity.SerenityReforged;
import com.serenity.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup SERENITY_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(SerenityReforged.MOD_ID, "serenity_items"),
            FabricItemGroup.builder().icon(() ->
                    new ItemStack(ModItems.MOONSTONE))
                    .displayName(Text.translatable("itemgroup.serenity.serenity_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.MOONSTONE);
                        entries.add(ModItems.POLISHED_MOONSTONE);
                        entries.add(ModBlocks.MOONSTONE_BLOCK);
                        entries.add(ModBlocks.POLISHED_MOONSTONE_BLOCK);
                        entries.add(ModItems.SUNSTONE);
                        entries.add(ModItems.POLISHED_SUNSTONE);
                        entries.add(ModBlocks.SUNSTONE_BLOCK);
                        entries.add(ModBlocks.POLISHED_SUNSTONE_BLOCK);
                        entries.add(ModBlocks.SWEDISH_MEATBALL_BLOCK);

                        entries.add(ModBlocks.GRANITE_GEM_ORE);
                        entries.add(ModBlocks.ALTAR_BLOCK);

                        entries.add(ModItems.SANDPAPER);

                        entries.add(ModItems.SWEDISH_MEATBALLS);
                        entries.add(ModItems.ICED_TEA);

                        entries.add(ModBlocks.MOONSTONE_BUTTON);
                        entries.add(ModBlocks.MOONSTONE_DOOR);
                        entries.add(ModBlocks.MOONSTONE_TRAPDOOR);
                        entries.add(ModBlocks.MOONSTONE_FENCE);
                        entries.add(ModBlocks.MOONSTONE_FENCE_GATE);
                        entries.add(ModBlocks.MOONSTONE_PRESSURE_PLATE);
                        entries.add(ModBlocks.MOONSTONE_STAIRS);
                        entries.add(ModBlocks.MOONSTONE_SLAB);
                        entries.add(ModBlocks.MOONSTONE_WALL);
                    })
                    .build()
    );

    public static void registerItemGroups() {
        SerenityReforged.LOGGER.info("Registering Item Groups for " + SerenityReforged.MOD_ID);
    }
}
