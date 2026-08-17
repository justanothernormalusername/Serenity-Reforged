package com.serenity.item;

import com.serenity.SerenityReforged;
import com.serenity.item.custom.HammerItem;
import com.serenity.item.custom.IcedTeaItem;
import com.serenity.item.custom.ModArmorItem;
import com.serenity.item.custom.SandpaperItem;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item MOONSTONE = registerItem("moonstone", new Item(new Item.Settings()));
    public static final Item POLISHED_MOONSTONE = registerItem("polished_moonstone", new Item(new Item.Settings()));

    public static final Item SUNSTONE = registerItem("sunstone", new Item(new Item.Settings()));
    public static final Item POLISHED_SUNSTONE = registerItem("polished_sunstone", new Item(new Item.Settings()));

    public static final Item SANDPAPER = registerItem("sandpaper", new SandpaperItem(new Item.Settings().maxDamage(16)));

    public static final Item SWEDISH_MEATBALLS = registerItem("swedish_meatballs", new Item(new Item.Settings().food(ModFoodComponents.SWEDISH_MEATBALLS)));
    public static final Item ICED_TEA = registerItem("iced_tea", new IcedTeaItem(new Item.Settings().food(ModFoodComponents.ICED_TEA)));

    public static final Item MOONSTONE_SWORD = registerItem("moonstone_sword", new SwordItem(ModToolMaterials.MOONSTONE, new Item.Settings()
            .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.MOONSTONE, 3, -2.4f))));
    public static final Item MOONSTONE_PICKAXE = registerItem("moonstone_pickaxe", new PickaxeItem(ModToolMaterials.MOONSTONE, new Item.Settings()
            .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.MOONSTONE, 1, -2.8f))));
    public static final Item MOONSTONE_AXE = registerItem("moonstone_axe", new AxeItem(ModToolMaterials.MOONSTONE, new Item.Settings()
            .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.MOONSTONE, 6, -3.2f))));
    public static final Item MOONSTONE_SHOVEL = registerItem("moonstone_shovel", new ShovelItem(ModToolMaterials.MOONSTONE, new Item.Settings()
            .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.MOONSTONE, 1.5f, -3.0f))));
    public static final Item MOONSTONE_HOE = registerItem("moonstone_hoe", new HoeItem(ModToolMaterials.MOONSTONE, new Item.Settings()
            .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.MOONSTONE, -3, 0.0f))));

    public static final Item SUNSTONE_SWORD = registerItem("sunstone_sword", new SwordItem(ModToolMaterials.SUNSTONE, new Item.Settings()
            .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.SUNSTONE, 3, -2.4f))));
    public static final Item SUNSTONE_PICKAXE = registerItem("sunstone_pickaxe", new PickaxeItem(ModToolMaterials.SUNSTONE, new Item.Settings()
            .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.SUNSTONE, 1, -2.8f))));
    public static final Item SUNSTONE_AXE = registerItem("sunstone_axe", new AxeItem(ModToolMaterials.SUNSTONE, new Item.Settings()
            .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.SUNSTONE, 6, -3.2f))));
    public static final Item SUNSTONE_SHOVEL = registerItem("sunstone_shovel", new ShovelItem(ModToolMaterials.SUNSTONE, new Item.Settings()
            .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.SUNSTONE, 1.5f, -3.0f))));
    public static final Item SUNSTONE_HOE = registerItem("sunstone_hoe", new HoeItem(ModToolMaterials.SUNSTONE, new Item.Settings()
            .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.SUNSTONE, -3, 0.0f))));

    public static final Item GEMSTONE_HAMMER = registerItem("gemstone_hammer", new HammerItem(ModToolMaterials.GEMSTONE, new Item.Settings()
            .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.GEMSTONE, 7, -3.4f))));

    public static final Item MOONSTONE_HELMET = registerItem("moonstone_helmet",
            new ModArmorItem(ModArmorMaterials.MOONSTONE_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));
    public static final Item MOONSTONE_CHESTPLATE = registerItem("moonstone_chestplate",
            new ArmorItem(ModArmorMaterials.MOONSTONE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))));
    public static final Item MOONSTONE_LEGGINGS = registerItem("moonstone_leggings",
            new ArmorItem(ModArmorMaterials.MOONSTONE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));
    public static final Item MOONSTONE_BOOTS = registerItem("moonstone_boots",
            new ArmorItem(ModArmorMaterials.MOONSTONE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(SerenityReforged.MOD_ID, name), item);
    }

    public static void registerModItems() {
        SerenityReforged.LOGGER.info("Registering Mod Items for " + SerenityReforged.MOD_ID);

    }
}
