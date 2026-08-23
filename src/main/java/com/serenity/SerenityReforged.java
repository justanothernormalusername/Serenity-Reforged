package com.serenity;

import com.serenity.block.ModBlocks;
import com.serenity.block.entity.ModBlockEntities;
import com.serenity.component.ModDataComponentTypes;
import com.serenity.item.ModItemGroups;
import com.serenity.item.ModItems;
import com.serenity.recipe.ModRecipes;
import com.serenity.screen.ModScreenHandlers;
import com.serenity.util.HammerUsageEvent;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SerenityReforged implements ModInitializer {
	public static final String MOD_ID = "serenity";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModDataComponentTypes.registerDataComponentTypes();

		ModBlockEntities.registerBlockEntities();

		ModScreenHandlers.registerScreenHandlers();

		ModRecipes.registerRecipes();

		FuelRegistry.INSTANCE.add(ModBlocks.SWEDISH_MEATBALL_BLOCK, 400);

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}
