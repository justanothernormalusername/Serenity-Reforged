package com.serenity.block.custom;

import com.serenity.item.ModItems;
import com.serenity.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class AltarBlock extends Block {
    public AltarBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {

        world.playSound(player, pos, SoundEvents.ITEM_GOAT_HORN_PLAY, SoundCategory.BLOCKS, 1.0F, 1.0F);
        if (!world.isClient) {
            world.setBlockState(pos, Blocks.GOLD_BLOCK.getDefaultState(), 3);
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof ItemEntity itemEntity && !world.isClient()) {
            if (itemEntity.getStack().getItem() == ModItems.MOONSTONE && world.isDay()) {
                itemEntity.setStack(new ItemStack(ModItems.SUNSTONE, itemEntity.getStack().getCount()));
            }
            else if (itemEntity.getStack().getItem() == ModItems.SUNSTONE && !world.isDay()) {
                itemEntity.setStack(new ItemStack(ModItems.MOONSTONE, itemEntity.getStack().getCount()));
            }
            else if (isValidItem(itemEntity.getStack())) {
                itemEntity.setStack(new ItemStack(Items.AMETHYST_SHARD, itemEntity.getStack().getCount()));
            }
        }

        super.onSteppedOn(world, pos, state, entity);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        tooltip.add(Text.translatable("tooltop.serenity.altar_block.tooltip"));
        super.appendTooltip(stack, context, tooltip, options);
    }

    private boolean isValidItem(ItemStack stack) {
        return stack.isIn(ModTags.Items.TRANSFORMABLE_ITEMS);
    }
}
