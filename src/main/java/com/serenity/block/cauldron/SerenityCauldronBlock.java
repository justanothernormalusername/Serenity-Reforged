package com.serenity.block.cauldron;

import com.mojang.serialization.MapCodec;
import com.serenity.SerenityReforged;
import net.minecraft.block.AbstractCauldronBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class SerenityCauldronBlock extends AbstractCauldronBlock {

    public final CauldronBehavior.CauldronBehaviorMap behaviorMap;

    public static final IntProperty LEVEL = IntProperty.of("level", 1, 3);
    
    /**
     * Constructs a cauldron block.
     *
     * <p>The behavior map must match {@link CauldronBehavior#createMap} by providing
     * a nonnull value for <em>all</em> items.
     *
     * @param settings
     * @param behaviorMap
     */

    public SerenityCauldronBlock(Settings settings, String name) {
        this(settings, CauldronBehavior.createMap(name));
        setDefaultState(this.stateManager.getDefaultState().with(LEVEL, 1));
    }

    @Override
    protected MapCodec<? extends AbstractCauldronBlock> getCodec() {
        return null;  // Apparently we don't need one??
    }

    private SerenityCauldronBlock(Settings settings, CauldronBehavior.CauldronBehaviorMap behaviorMap) {
        super(settings, behaviorMap);
        this.behaviorMap = behaviorMap;
    }

    public CauldronBehavior.CauldronBehaviorMap getInteractionMap() {
        return behaviorMap;
    }

    @Override
    protected double getFluidHeight(BlockState state) {
        return (6.0 + state.get(LEVEL) * 3.0) / 16.0;
    }

    @Override
    public boolean isFull(BlockState state) {
        return state.get(LEVEL) == 3;
    }

    public static void decrementFluidLevel(BlockState state, World world, BlockPos pos) {
        int i = state.get(LEVEL) - 1;
        BlockState blockState = i == 0 ? Blocks.CAULDRON.getDefaultState() : state.with(LEVEL, i);
        world.setBlockState(pos, blockState);
        world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(blockState));
    }

    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!world.isClient && entity instanceof ItemEntity itemEntity && this.isEntityTouchingFluid(state, pos, entity)) {
            SerenityReforged.LOGGER.info(itemEntity.getName().getString());
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LEVEL);
    }
}
