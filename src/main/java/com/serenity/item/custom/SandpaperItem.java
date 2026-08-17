package com.serenity.item.custom;

import com.serenity.SerenityReforged;
import com.serenity.block.ModBlocks;
import com.serenity.component.ModDataComponentTypes;
import net.minecraft.block.Block;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.List;
import java.util.Map;

public class SandpaperItem extends Item {
    private static final Map<Block, Block> POLISH_MAP =
            Map.of(
                    ModBlocks.MOONSTONE_BLOCK, ModBlocks.POLISHED_MOONSTONE_BLOCK,
                    ModBlocks.SUNSTONE_BLOCK, ModBlocks.POLISHED_SUNSTONE_BLOCK
            );

	public SandpaperItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        SerenityReforged.LOGGER.info("Sandpaper item using onBlock");
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if (POLISH_MAP.containsKey(clickedBlock)) {
            if (!world.isClient()) {
                world.setBlockState(context.getBlockPos(), POLISH_MAP.get(clickedBlock).getDefaultState());

                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS);

                context.getStack().set(ModDataComponentTypes.COORDINATES, context.getBlockPos());
            }
        }

        return super.useOnBlock(context);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.serenity.sandpaper.shift_down"));
        } else {
            tooltip.add(Text.translatable("tooltip.serenity.sandpaper"));
        }

        if (stack.get(ModDataComponentTypes.COORDINATES) != null) {
            tooltip.add(Text.literal("Last polished block at: " + stack.get(ModDataComponentTypes.COORDINATES)));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}
