package com.serenity.item;

import com.serenity.SerenityReforged;
import com.serenity.datagen.ModDamageTypes;
import com.serenity.item.custom.HammerItem;
import com.serenity.item.custom.IcedTeaItem;
import com.serenity.item.custom.ModArmorItem;
import com.serenity.item.custom.SandpaperItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class ModItems {
    public static final List<Item> ALL_MOD_ITEMS = new ArrayList<>();

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

    public static final Item HONEY_DOP_STICK = registerItem("honey_dop_stick", new Item(new Item.Settings()));
    public static final Item SLIME_DOP_STICK = registerItem("slime_dop_stick", new Item(new Item.Settings()));
    public static final Item INFERNAL_DOP_STICK = registerItem("infernal_dop_stick", new Item(new Item.Settings()));

    public static final Item LOUPE = registerItem("loupe", new Item(new Item.Settings().maxCount(1)));

    public static final Item STONE_GEODE = registerItem("stone_geode", new Item(new Item.Settings()));
    public static final Item DEEPSLATE_GEODE = registerItem("deepslate_geode", new Item(new Item.Settings()));
    public static final Item ANDESITE_GEODE = registerItem("andesite_geode", new Item(new Item.Settings()));
    public static final Item DIORITE_GEODE = registerItem("diorite_geode", new Item(new Item.Settings()));
    public static final Item GRANITE_GEODE = registerItem("granite_geode", new Item(new Item.Settings()));
    public static final Item BLACKSTONE_GEODE = registerItem("blackstone_geode", new Item(new Item.Settings()));

    public static final Item BRINE_BOTTLE = registerItem("brine_bottle",
            new Item(new Item.Settings().food(ModFoodComponents.BRINE_BOTTLE).maxCount(16)) {
                @Override
                public UseAction getUseAction(ItemStack stack) {
                    return UseAction.DRINK;
                }

                @Override
                public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
                    if (!world.isClient() && user instanceof PlayerEntity player) {
                        player.addExhaustion(16f);
                    }

                    return super.finishUsing(stack, world, user);
                }
            }
    );

    public static final Item CLAY_SLURRY_BOTTLE = registerItem("clay_slurry_bottle",
            new Item(new Item.Settings().food(ModFoodComponents.CLAY_SLURRY_BOTTLE).maxCount(16)) {
                @Override
                public UseAction getUseAction(ItemStack stack) {
                    return UseAction.DRINK;
                }

                @Override
                public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
                    if (!world.isClient() && user instanceof PlayerEntity player) {
                        player.damage(ModDamageTypes.create(world, ModDamageTypes.SLURRY), 4f);
                    }

                    return super.finishUsing(stack, world, user);
                }
            }
    );

    private static Item registerItem(String name, Item item) {
        Item registeredItem = Registry.register(Registries.ITEM, Identifier.of(SerenityReforged.MOD_ID, name), item);
        ALL_MOD_ITEMS.add(registeredItem);
        return registeredItem;
    }

    public static void registerModItems() {
        SerenityReforged.LOGGER.info("Registering Mod Items for " + SerenityReforged.MOD_ID);

    }
}
