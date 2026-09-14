package com.serenity.mixin;

import com.serenity.block.ModBlocks;
import com.serenity.block.cauldron.SerenityCauldronBlock;
import net.minecraft.block.AbstractCauldronBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeveledCauldronBlock;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.minecraft.block.LeveledCauldronBlock.LEVEL;

@Mixin(LeveledCauldronBlock.class)
public abstract class LeveledCauldronBlockMixin extends AbstractCauldronBlock{

    // Dummy constructor to satisfy the compiler
    public LeveledCauldronBlockMixin(Settings settings, CauldronBehavior.CauldronBehaviorMap behaviorMap) {
        super(settings, behaviorMap);
    }

    @Inject(method = "onEntityCollision", at = @At("HEAD"))
    private void serenity$onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity, CallbackInfo ci) {
        AbstractCauldronBlock superObject = (AbstractCauldronBlock) (Object) this;
        if (entity instanceof ItemEntity itemEntity && !world.isClient && state.get(LEVEL) == 3 && this.isEntityTouchingFluid(state, pos, entity)) {
            if (itemEntity.getStack().isOf(Items.CLAY_BALL)) {
                world.setBlockState(pos, ModBlocks.CLAY_SLURRY_CAULDRON.getDefaultState().with(SerenityCauldronBlock.LEVEL, 3));
                itemEntity.getStack().decrement(1);
                world.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_BREWING_STAND_BREW, SoundCategory.BLOCKS, 1.0F, 1.0F);
                world.playSound((PlayerEntity)null, pos, SoundEvents.ENTITY_PLAYER_SPLASH_HIGH_SPEED, SoundCategory.BLOCKS, 0.5F, 1.0F);
            }
            else if (itemEntity.getStack().isOf(Items.DRIED_KELP_BLOCK)) {
                world.setBlockState(pos, ModBlocks.BRINE_CAULDRON.getDefaultState().with(SerenityCauldronBlock.LEVEL, 3));
                itemEntity.getStack().decrement(1);
                world.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_BREWING_STAND_BREW, SoundCategory.BLOCKS, 1.0F, 1.0F);
                world.playSound((PlayerEntity)null, pos, SoundEvents.ENTITY_PLAYER_SPLASH_HIGH_SPEED, SoundCategory.BLOCKS, 0.5F, 1.0F);
            }
        }
    }
}
