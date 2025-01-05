package com.jpan.tfc.diving.bell.client.models;

import com.jpan.tfc.diving.bell.DivingBellTFC;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.EntityModel;
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

public class DivingHelmetModel <T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(DivingBellTFC.MODID, "diving_helmet"), "main");
	public final ModelPart head;

	public DivingHelmetModel(ModelPart root) {
		this.head = root.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(33, 38).addBox(-5.0F, -9.0F, 3.0F, 8.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-6.0F, -10.0F, -6.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(0, 21).addBox(-7.0F, -9.0F, -5.0F, 12.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-5.0F, -11.0F, -5.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(41, 0).addBox(-5.0F, -9.0F, -7.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(41, 12).addBox(-5.0F, -8.0F, -7.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(41, 3).addBox(-5.0F, -2.0F, -7.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(41, 20).addBox(2.0F, -8.0F, -7.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(41, 28).addBox(-3.0F, -8.0F, -7.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(46, 12).addBox(0.0F, -8.0F, -7.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(41, 6).addBox(-4.0F, -4.0F, -7.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(41, 9).addBox(-4.0F, -7.0F, -7.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}