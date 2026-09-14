package com.serenity.model;

import com.serenity.SerenityReforged;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class GrindstoneModel extends Model {
	public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(SerenityReforged.id("main"), "grindstone");
	public static final Identifier TEXTURE_LOCATION = SerenityReforged.id("textures/entity/grindstone.png");

	private final ModelPart main;
	private final ModelPart stone;

	public GrindstoneModel(ModelPart root) {
		super(RenderLayer::getEntitySolid);

		this.main = root.getChild("main");
		this.stone = this.main.getChild("stone");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData main = modelPartData.addChild("main", ModelPartBuilder.create().uv(40, 27).cuboid(-8.0F, 4.0F, -8.0F, 16.0F, 3.0F, 1.0F, new Dilation(0.0F))
		.uv(52, 55).cuboid(-8.0F, 4.0F, -7.0F, 1.0F, 3.0F, 3.0F, new Dilation(0.0F))
		.uv(32, 51).cuboid(-8.0F, 4.0F, -4.0F, 1.0F, 5.0F, 4.0F, new Dilation(0.0F))
		.uv(42, 51).cuboid(7.0F, 4.0F, -4.0F, 1.0F, 5.0F, 4.0F, new Dilation(0.0F))
		.uv(0, 56).cuboid(7.0F, 4.0F, -7.0F, 1.0F, 3.0F, 3.0F, new Dilation(0.0F))
		.uv(40, 18).cuboid(-7.0F, 4.0F, 7.0F, 14.0F, 8.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 33).cuboid(-7.0F, 11.0F, 0.0F, 14.0F, 1.0F, 7.0F, new Dilation(0.0F))
		.uv(36, 41).cuboid(-5.0F, 12.0F, 6.0F, 10.0F, 3.0F, 1.0F, new Dilation(0.0F))
		.uv(8, 56).cuboid(-5.0F, 12.0F, 3.0F, 1.0F, 3.0F, 3.0F, new Dilation(0.0F))
		.uv(16, 56).cuboid(4.0F, 12.0F, 3.0F, 1.0F, 3.0F, 3.0F, new Dilation(0.0F))
		.uv(42, 31).cuboid(-5.0F, 12.0F, 2.0F, 10.0F, 3.0F, 1.0F, new Dilation(0.0F))
		.uv(16, 50).cuboid(2.0F, 0.0F, 3.0F, 4.0F, 2.0F, 4.0F, new Dilation(0.0F))
		.uv(0, 50).cuboid(-6.0F, 0.0F, 3.0F, 4.0F, 2.0F, 4.0F, new Dilation(0.0F))
		.uv(36, 45).cuboid(-6.0F, 0.0F, -5.0F, 4.0F, 2.0F, 4.0F, new Dilation(0.0F))
		.uv(42, 35).cuboid(2.0F, 0.0F, -5.0F, 4.0F, 2.0F, 4.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-8.0F, 2.0F, -8.0F, 16.0F, 2.0F, 16.0F, new Dilation(0.0F))
		.uv(24, 56).cuboid(-1.0F, 11.0F, -1.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(52, 45).cuboid(-1.0F, 3.0F, -1.0F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r1 = main.addChild("cube_r1", ModelPartBuilder.create()
				.uv(0, 41)
				.cuboid(-6.0F, 0.0F, 0.0F, 8.0F, 8.0F, 1.0F,
						new Dilation(0.0F)),
				ModelTransform.of(7.0F, 4.0F, 2.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData cube_r2 = main.addChild("cube_r2", ModelPartBuilder.create()
				.uv(18, 41)
				.cuboid(-6.0F, 0.0F, 0.0F, 8.0F, 8.0F, 1.0F,
						new Dilation(0.0F)),
				ModelTransform.of(-8.0F, 4.0F, 2.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData stone = main.addChild("stone", ModelPartBuilder.create()
				.uv(0, 18).cuboid(-5.0F, 4.0F, -5.0F, 10.0F, 5.0F, 10.0F,
						new Dilation(0.0F)),
				ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		return TexturedModelData.of(modelData, 128, 128);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
		main.render(matrices, vertexConsumer, light, overlay, color);
	}

	public ModelPart getStone() {
		return this.stone;
	}
}