package com.serenity.item;

import com.serenity.SerenityReforged;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item MOONSTONE = registerItem("moonstone", new Item(new Item.Settings()));
    public static final Item POLISHED_MOONSTONE = registerItem("polished_moonstone", new Item(new Item.Settings()));

    public static final Item SUNSTONE = registerItem("sunstone", new Item(new Item.Settings()));
    public static final Item POLISHED_SUNSTONE = registerItem("polished_sunstone", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(SerenityReforged.MOD_ID, name), item);
    }

    public static void registerModItems() {
        SerenityReforged.LOGGER.info("Registering Mod Items for " + SerenityReforged.MOD_ID);

    }
}
