package com.jpan.tfc.diving.bell.items;

import java.util.Collections;
import java.util.Map;
import java.util.function.Consumer;

import org.jetbrains.annotations.NotNull;

import com.jpan.tfc.diving.bell.client.models.SnorkelModel;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

public class SnorkelItem extends ArmorItem{

	public String texturePath;
	
	public SnorkelItem(String texturePath, ArmorMaterial p_40386_, Type p_266831_, Properties p_40388_) {
		super(p_40386_, p_266831_, p_40388_);
		this.texturePath = texturePath;
	}

	  @Override
	  @OnlyIn(Dist.CLIENT)
	  public void initializeClient(final @NotNull Consumer<IClientItemExtensions> consumer) {
		  consumer.accept(new IClientItemExtensions() {
            public HumanoidModel getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
                HumanoidModel armorModel = new HumanoidModel<LivingEntity>(
                		new ModelPart(
                				Collections.emptyList(),
                				Map.of("hat",
                						new SnorkelModel(Minecraft.getInstance().getEntityModels().bakeLayer(SnorkelModel.LAYER_LOCATION)).head,
                						"head", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "body",
                						new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_arm",
                						new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_arm",
                						new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_leg",
                						new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_leg",
                						new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
                armorModel.crouching = living.isShiftKeyDown();
                armorModel.riding = defaultModel.riding;
                armorModel.young = living.isBaby();
                return armorModel;
	  }
});
}
	  
	  @OnlyIn(Dist.CLIENT)
	    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
	        return texturePath;
	    }

}