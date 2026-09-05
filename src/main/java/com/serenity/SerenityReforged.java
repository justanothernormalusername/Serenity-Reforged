package com.serenity;

import com.serenity.block.ModBlocks;
import com.serenity.block.cauldron.SerenityCauldronBlock;
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
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Identifier;

import net.minecraft.util.ItemActionResult;
import net.minecraft.world.event.GameEvent;
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


		// Empty cauldron behavior map
		CauldronBehavior.EMPTY_CAULDRON_BEHAVIOR.map().put(ModItems.BRINE_BOTTLE, (state, world, pos, player, hand, stack) -> {
			if (!world.isClient) {
				Item item = stack.getItem();
				player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(Items.GLASS_BOTTLE)));
				player.incrementStat(Stats.USE_CAULDRON);
				player.incrementStat(Stats.USED.getOrCreateStat(item));
				world.setBlockState(pos, ModBlocks.BRINE_CAULDRON.getDefaultState());
				world.playSound((PlayerEntity)null, pos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
				world.emitGameEvent(null, GameEvent.FLUID_PLACE, pos);
			}

			return ItemActionResult.success(world.isClient);
		});
		CauldronBehavior.EMPTY_CAULDRON_BEHAVIOR.map().put(ModItems.CLAY_SLURRY_BOTTLE, (state, world, pos, player, hand, stack) -> {
			if (!world.isClient) {
				Item item = stack.getItem();
				player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(Items.GLASS_BOTTLE)));
				player.incrementStat(Stats.USE_CAULDRON);
				player.incrementStat(Stats.USED.getOrCreateStat(item));
				world.setBlockState(pos, ModBlocks.CLAY_SLURRY_CAULDRON.getDefaultState());
				world.playSound((PlayerEntity)null, pos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
				world.emitGameEvent(null, GameEvent.FLUID_PLACE, pos);
			}

			return ItemActionResult.success(world.isClient);
		});


		// Brine cauldron behavior map
		ModBlocks.BRINE_CAULDRON.getInteractionMap().map().put(Items.GLASS_BOTTLE, (state, world, pos, player, hand, stack) -> {
			if (!world.isClient) {
				Item item = stack.getItem();
				player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(ModItems.BRINE_BOTTLE)));
				player.incrementStat(Stats.USE_CAULDRON);
				player.incrementStat(Stats.USED.getOrCreateStat(item));
				SerenityCauldronBlock.decrementFluidLevel(state, world, pos);
				world.playSound((PlayerEntity)null, pos, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
				world.emitGameEvent(null, GameEvent.FLUID_PICKUP, pos);
			}

			return ItemActionResult.success(world.isClient);
		});
		ModBlocks.BRINE_CAULDRON.getInteractionMap().map().put(ModItems.BRINE_BOTTLE, (state, world, pos, player, hand, stack) -> {
			if (state.get(SerenityCauldronBlock.LEVEL) == 3) {
				return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
			}
			if (!world.isClient) {
				player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(Items.GLASS_BOTTLE)));
				player.incrementStat(Stats.USE_CAULDRON);
				player.incrementStat(Stats.USED.getOrCreateStat(stack.getItem()));
				world.setBlockState(pos, state.cycle(SerenityCauldronBlock.LEVEL));
				world.playSound((PlayerEntity)null, pos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
				world.emitGameEvent(null, GameEvent.FLUID_PLACE, pos);
			}

			return ItemActionResult.success(world.isClient);
		});


		// Clay slurry cauldron behavior map
		ModBlocks.CLAY_SLURRY_CAULDRON.getInteractionMap().map().put(Items.GLASS_BOTTLE, (state, world, pos, player, hand, stack) -> {
			if (!world.isClient) {
				Item item = stack.getItem();
				player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(ModItems.CLAY_SLURRY_BOTTLE)));
				player.incrementStat(Stats.USE_CAULDRON);
				player.incrementStat(Stats.USED.getOrCreateStat(item));
				SerenityCauldronBlock.decrementFluidLevel(state, world, pos);
				world.playSound((PlayerEntity)null, pos, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
				world.emitGameEvent(null, GameEvent.FLUID_PICKUP, pos);
			}

			return ItemActionResult.success(world.isClient);
		});
		ModBlocks.CLAY_SLURRY_CAULDRON.getInteractionMap().map().put(ModItems.CLAY_SLURRY_BOTTLE, (state, world, pos, player, hand, stack) -> {
			if (state.get(SerenityCauldronBlock.LEVEL) == 3) {
				return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
			}
			if (!world.isClient) {
				player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(Items.GLASS_BOTTLE)));
				player.incrementStat(Stats.USE_CAULDRON);
				player.incrementStat(Stats.USED.getOrCreateStat(stack.getItem()));
				world.setBlockState(pos, state.cycle(SerenityCauldronBlock.LEVEL));
				world.playSound((PlayerEntity)null, pos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
				world.emitGameEvent(null, GameEvent.FLUID_PLACE, pos);
			}

			return ItemActionResult.success(world.isClient);
		});
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}
