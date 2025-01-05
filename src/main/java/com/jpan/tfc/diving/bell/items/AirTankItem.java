package com.jpan.tfc.diving.bell.items;

import org.joml.Math;

import net.dries007.tfc.common.blockentities.BellowsBlockEntity;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;

public class AirTankItem extends Item {

	
	public AirTankItem(int maxDamage, Properties p_41383_) {
		super(p_41383_.durability(maxDamage));
	}
	
	
	@Override
	public InteractionResult onItemUseFirst(ItemStack stack, UseOnContext context) {
		if(context.getLevel().getExistingBlockEntity(context.getClickedPos()) != null &&
				context.getLevel().getExistingBlockEntity(context.getClickedPos()) instanceof BellowsBlockEntity bellows) {
			if(bellows.getTicksSincePushed() < 1 || bellows.getTicksSincePushed() > 20) {
				this.setDamage(stack, Math.min(this.getDamage(stack) - 10, 0));
			}
		}
		return super.onItemUseFirst(stack, context);
	}

}
