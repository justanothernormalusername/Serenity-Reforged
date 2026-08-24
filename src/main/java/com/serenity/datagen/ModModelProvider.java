package com.serenity.datagen;

import com.serenity.block.ModBlocks;
import com.serenity.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ALTAR_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRANITE_GEM_ORE);
        BlockStateModelGenerator.BlockTexturePool moonstonePool = blockStateModelGenerator .registerCubeAllModelTexturePool(ModBlocks.MOONSTONE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.POLISHED_MOONSTONE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SUNSTONE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.POLISHED_SUNSTONE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SWEDISH_MEATBALL_BLOCK);

        moonstonePool.stairs(ModBlocks.MOONSTONE_STAIRS);
        moonstonePool.slab(ModBlocks.MOONSTONE_SLAB);
        moonstonePool.fence(ModBlocks.MOONSTONE_FENCE);
        moonstonePool.fenceGate(ModBlocks.MOONSTONE_FENCE_GATE);
        moonstonePool.pressurePlate(ModBlocks.MOONSTONE_PRESSURE_PLATE);
        moonstonePool.button(ModBlocks.MOONSTONE_BUTTON);
        moonstonePool.wall(ModBlocks.MOONSTONE_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.MOONSTONE_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.MOONSTONE_TRAPDOOR);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        List<Item> unregisteredItems = new ArrayList<Item>(ModItems.ALL_MOD_ITEMS);

        itemModelGenerator.register(ModItems.MOONSTONE_SWORD, Models.HANDHELD);
        unregisteredItems.remove(ModItems.MOONSTONE_SWORD);
        itemModelGenerator.register(ModItems.MOONSTONE_AXE, Models.HANDHELD);
        unregisteredItems.remove(ModItems.MOONSTONE_AXE);
        itemModelGenerator.register(ModItems.MOONSTONE_PICKAXE, Models.HANDHELD);
        unregisteredItems.remove(ModItems.MOONSTONE_PICKAXE);
        itemModelGenerator.register(ModItems.MOONSTONE_SHOVEL, Models.HANDHELD);
        unregisteredItems.remove(ModItems.MOONSTONE_SHOVEL);
        itemModelGenerator.register(ModItems.MOONSTONE_HOE, Models.HANDHELD);
        unregisteredItems.remove(ModItems.MOONSTONE_HOE);

        itemModelGenerator.register(ModItems.SUNSTONE_SWORD, Models.HANDHELD);
        unregisteredItems.remove(ModItems.SUNSTONE_SWORD);
        itemModelGenerator.register(ModItems.SUNSTONE_AXE, Models.HANDHELD);
        unregisteredItems.remove(ModItems.SUNSTONE_AXE);
        itemModelGenerator.register(ModItems.SUNSTONE_PICKAXE, Models.HANDHELD);
        unregisteredItems.remove(ModItems.SUNSTONE_PICKAXE);
        itemModelGenerator.register(ModItems.SUNSTONE_SHOVEL, Models.HANDHELD);
        unregisteredItems.remove(ModItems.SUNSTONE_SHOVEL);
        itemModelGenerator.register(ModItems.SUNSTONE_HOE, Models.HANDHELD);
        unregisteredItems.remove(ModItems.SUNSTONE_HOE);

        itemModelGenerator.register(ModItems.GEMSTONE_HAMMER, Models.HANDHELD);
        unregisteredItems.remove(ModItems.GEMSTONE_HAMMER);


        itemModelGenerator.registerArmor((ArmorItem) ModItems.MOONSTONE_HELMET);
        unregisteredItems.remove(ModItems.MOONSTONE_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.MOONSTONE_CHESTPLATE);
        unregisteredItems.remove(ModItems.MOONSTONE_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.MOONSTONE_LEGGINGS);
        unregisteredItems.remove(ModItems.MOONSTONE_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.MOONSTONE_BOOTS);
        unregisteredItems.remove(ModItems.MOONSTONE_BOOTS);


        // Autogenerate rest as Models.GENERATED
        for (Item unregisteredItem : unregisteredItems) {
            itemModelGenerator.register(unregisteredItem, Models.GENERATED);
        }
    }
}
