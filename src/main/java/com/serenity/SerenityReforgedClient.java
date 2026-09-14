package com.serenity;

import com.serenity.block.ModBlocks;
import com.serenity.block.entity.ModBlockEntities;
import com.serenity.model.GrindstoneModel;
import com.serenity.renderer.GrindstoneBER;
import com.serenity.screen.ModScreenHandlers;
import com.serenity.screen.custom.GrindstoneScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class SerenityReforgedClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MOONSTONE_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MOONSTONE_TRAPDOOR, RenderLayer.getCutout());

        HandledScreens.register(ModScreenHandlers.GRINDSTONE_SCREEN_HANDLER, GrindstoneScreen::new);

        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> 0xff057183, ModBlocks.BRINE_CAULDRON);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> 0xff8b836e, ModBlocks.CLAY_SLURRY_CAULDRON);

        // Model Layers
        EntityModelLayerRegistry.registerModelLayer(GrindstoneModel.LAYER_LOCATION, GrindstoneModel::getTexturedModelData);

        // Block Entity Renderers
        BlockEntityRendererFactories.register(ModBlockEntities.GRINDSTONE_BE, GrindstoneBER::new);
    }
}
