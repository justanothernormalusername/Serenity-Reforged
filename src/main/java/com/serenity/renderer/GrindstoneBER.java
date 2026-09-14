package com.serenity.renderer;

import com.serenity.block.custom.GrindstoneBlock;
import com.serenity.block.entity.custom.GrindstoneBlockEntity;
import com.serenity.model.GrindstoneModel;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.RotationAxis;

public class GrindstoneBER implements BlockEntityRenderer<GrindstoneBlockEntity> {
    private final GrindstoneModel model;


    public GrindstoneBER(BlockEntityRendererFactory.Context context) {

        this.model = new GrindstoneModel(context.getLayerModelPart(GrindstoneModel.LAYER_LOCATION));
    }

    @Override
    public void render(GrindstoneBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();
        matrices.translate(0.5f, 0.0f, 0.5f);

        switch (entity.getCachedState().get(GrindstoneBlock.FACING)) {
            case EAST -> matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(270));
            case SOUTH -> matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180));
            case WEST -> matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(90));
        }

        this.model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntitySolid(GrindstoneModel.TEXTURE_LOCATION)), light, overlay);
        matrices.pop();
    }
}
