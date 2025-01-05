package com.jpan.tfc.diving.bell.client.models;

import com.jpan.tfc.diving.bell.DivingBellTFC;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

// Made with Blockbench 4.11.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class SnorkelModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(DivingBellTFC.MODID, "scuba_gear"), "main");
	public final ModelPart head;

	public SnorkelModel(ModelPart root) {
		this.head = root.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 19).addBox(-3.0F, -5.25F, -5.0F, 6.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 23).addBox(-4.0F, -4.25F, -5.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(7, 23).addBox(3.0F, -4.25F, -5.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(4, -1).addBox(4.0F, -4.25F, -3.0F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(4, 7).addBox(-5.0F, -4.25F, -3.0F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(5, 16).addBox(-4.0F, -4.25F, 4.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(20, 11).addBox(-1.0F, -3.25F, -5.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(20, 7).addBox(1.0F, -2.25F, -5.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(17, 19).addBox(-1.0F, -2.25F, -6.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(20, 0).addBox(1.0F, -1.25F, -6.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 28).addBox(4.0F, -2.25F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(5.0F, -17.25F, -6.0F, 1.0F, 16.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(20, 3).addBox(-3.0F, -2.25F, -5.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(14, 26).addBox(1.0F, -4.25F, -4.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(21, 26).addBox(-1.0F, -4.25F, -4.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(24, 15).addBox(-3.0F, -4.25F, -4.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 24.0F, -8.0F));




				return LayerDefinition.create(meshdefinition, 32, 32);

	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
/*
@OnlyIn(Dist.CLIENT)
public class ScubaGear<T extends LivingEntity> extends HumanoidModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(DivingBellTFC.MODID, "scuba_gear"), "main");
	private final ModelPart group2;
	private final ModelPart group;

	public ScubaGear(ModelPart root) {
		super(root);
		this.group2 = root.getChild("group2");
		this.group = this.group2.getChild("group");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition group2 = partdefinition.addOrReplaceChild("group2", CubeListBuilder.create().texOffs(0, 19).addBox(-11.0F, -6.0F, 0.0F, 6.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 23).addBox(-12.0F, -5.0F, 0.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(7, 23).addBox(-5.0F, -5.0F, 0.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(5, 0).addBox(-5.0F, -5.0F, 2.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(5, 8).addBox(-12.0F, -5.0F, 2.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(5, 16).addBox(-12.0F, -5.0F, 8.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(20, 11).addBox(-9.0F, -4.0F, 0.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(20, 7).addBox(-7.0F, -3.0F, 0.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(17, 19).addBox(-9.0F, -3.0F, -1.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(20, 0).addBox(-7.0F, -2.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 28).addBox(-4.0F, -3.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-3.0F, -18.0F, -1.0F, 1.0F, 16.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(20, 3).addBox(-11.0F, -3.0F, 0.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 24.0F, -8.0F));

		PartDefinition group = group2.addOrReplaceChild("group", CubeListBuilder.create().texOffs(14, 26).addBox(-7.0F, -5.0F, 1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(21, 26).addBox(-9.0F, -5.0F, 1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(24, 15).addBox(-11.0F, -5.0F, 1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		group2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}*/