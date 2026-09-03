package com.serenity;

import com.serenity.block.ModBlocks;
import com.serenity.screen.ModScreenHandlers;
import com.serenity.screen.custom.GrindstoneScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;

public class SerenityReforgedClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MOONSTONE_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MOONSTONE_TRAPDOOR, RenderLayer.getCutout());

        HandledScreens.register(ModScreenHandlers.GRINDSTONE_SCREEN_HANDLER, GrindstoneScreen::new);

        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> 0xff000000, ModBlocks.BRINE_CAULDRON);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> 0xff000000, ModBlocks.CLAY_SLURRY_CAULDRON);
    }
}
