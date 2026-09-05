package com.serenity.datagen;

import com.serenity.block.ModBlocks;
import com.serenity.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.GRANITE_GEM_ORE)
                .add(ModBlocks.MOONSTONE_BLOCK)
                .add(ModBlocks.POLISHED_MOONSTONE_BLOCK)
                .add(ModBlocks.SUNSTONE_BLOCK)
                .add(ModBlocks.POLISHED_SUNSTONE_BLOCK)
                .add(ModBlocks.ALTAR_BLOCK)
                .add(ModBlocks.BRINE_CAULDRON)
                .add(ModBlocks.CLAY_SLURRY_CAULDRON);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.GRANITE_GEM_ORE);

        getOrCreateTagBuilder(BlockTags.FENCES).add(ModBlocks.MOONSTONE_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(ModBlocks.MOONSTONE_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WALLS).add(ModBlocks.MOONSTONE_WALL);

        // Uses optional tag to prevent datagen referencing vanilla tag before loading
        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_GEM_TOOL).addOptionalTag(BlockTags.NEEDS_DIAMOND_TOOL.id());
    }
}
