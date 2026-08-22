package com.serenity.screen;

import com.serenity.SerenityReforged;
import com.serenity.screen.custom.GrindstoneScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class ModScreenHandlers {
    public static final ScreenHandlerType<GrindstoneScreenHandler> GRINDSTONE_SCREEN_HANDLER =
            Registry.register(
                    Registries.SCREEN_HANDLER,
                    Identifier.of(SerenityReforged.MOD_ID, "grindstone_screen_handler"),
                    new ExtendedScreenHandlerType<>(GrindstoneScreenHandler::new, BlockPos.PACKET_CODEC)
            );

    public static void registerScreenHandlers() {
        SerenityReforged.LOGGER.info("Registering Screen Handlers for " + SerenityReforged.MOD_ID);
    }
}
