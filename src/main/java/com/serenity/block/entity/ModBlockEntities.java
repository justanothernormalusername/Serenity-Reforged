package com.serenity.block.entity;

import com.serenity.SerenityReforged;
import com.serenity.block.ModBlocks;
import com.serenity.block.entity.custom.GrindstoneBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {

    public static final BlockEntityType<GrindstoneBlockEntity> GRINDSTONE_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(SerenityReforged.MOD_ID, "grindstone_be"),
                    BlockEntityType.Builder.create(GrindstoneBlockEntity::new, ModBlocks.GRINDSTONE).build(null));

    public static void registerBlockEntities() {
        SerenityReforged.LOGGER.info("Registering Block Entities for " + SerenityReforged.MOD_ID);
    }
}
