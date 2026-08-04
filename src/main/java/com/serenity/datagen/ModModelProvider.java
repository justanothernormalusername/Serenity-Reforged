package com.serenity.datagen;

import com.serenity.block.ModBlocks;
import com.serenity.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

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
        itemModelGenerator.register(ModItems.MOONSTONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.POLISHED_MOONSTONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SUNSTONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.POLISHED_SUNSTONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ICED_TEA, Models.GENERATED);
        itemModelGenerator.register(ModItems.SANDPAPER, Models.GENERATED);
        itemModelGenerator.register(ModItems.SWEDISH_MEATBALLS, Models.GENERATED);
    }
}
