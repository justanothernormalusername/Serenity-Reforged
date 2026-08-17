package com.serenity.datagen;

import com.serenity.item.ModItems;
import com.serenity.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        getOrCreateTagBuilder(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(Items.GOLD_INGOT)
                .add(Items.IRON_INGOT)
                .add(Items.DIAMOND);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.MOONSTONE_SWORD)
                .add(ModItems.SUNSTONE_SWORD);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.MOONSTONE_PICKAXE)
                .add(ModItems.SUNSTONE_PICKAXE);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.MOONSTONE_AXE)
                .add(ModItems.SUNSTONE_AXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.MOONSTONE_SHOVEL)
                .add(ModItems.SUNSTONE_SHOVEL);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.MOONSTONE_HOE)
                .add(ModItems.SUNSTONE_HOE);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.MOONSTONE_HELMET)
                .add(ModItems.MOONSTONE_CHESTPLATE)
                .add(ModItems.MOONSTONE_LEGGINGS)
                .add(ModItems.MOONSTONE_BOOTS);
    }
}
