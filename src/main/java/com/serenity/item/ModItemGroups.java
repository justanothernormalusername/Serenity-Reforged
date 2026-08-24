package com.serenity.item;

import com.serenity.SerenityReforged;
import com.serenity.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
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
                        for (Item modItem : ModItems.ALL_MOD_ITEMS) {
                            entries.add(modItem);
                        }
                        for (Block modBlock : ModBlocks.ALL_MOD_BLOCKS) {
                            entries.add(modBlock);
                        }
                    })
                    .build()
    );

    public static void registerItemGroups() {
        SerenityReforged.LOGGER.info("Registering Item Groups for " + SerenityReforged.MOD_ID);
    }
}
