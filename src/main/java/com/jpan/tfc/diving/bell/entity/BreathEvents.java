package com.jpan.tfc.diving.bell.entity;



import java.awt.event.ItemEvent;

import com.jpan.tfc.diving.bell.DivingBellTFC;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = "tfcdivingbell")
public class BreathEvents{
	
	public static final TagKey<Item> breathingReedTag = ItemTags.create(new ResourceLocation(DivingBellTFC.MODID, "breathing_reeds"));
	 public static final TagKey<Item> snorkelTag = ItemTags.create(new ResourceLocation(DivingBellTFC.MODID, "snorkels"));
	 public static final TagKey<Item> divingBellTag = ItemTags.create(new ResourceLocation(DivingBellTFC.MODID, "diving_bells"));
	 public static final TagKey<Item> airhoseTag = ItemTags.create(new ResourceLocation(DivingBellTFC.MODID, "air_hose"));
	 public static final TagKey<Item> divingHelmetTag = ItemTags.create(new ResourceLocation(DivingBellTFC.MODID, "diving_helmets"));
	 public static final TagKey<Item> oxygenTankTag = ItemTags.create(new ResourceLocation(DivingBellTFC.MODID, "oxygen_tanks"));
	
	  @SubscribeEvent
	  public static void onPlayerTick(LivingEvent.LivingTickEvent evt) {
		  boolean snorkel = false;
		  if(evt.getEntity().isInWater()) {
			  for(ItemStack itm : evt.getEntity().getArmorSlots()) {
				  if(itm.is(snorkelTag)) {
					  snorkel= true;
					  if(closestAirAbove(evt.getEntity(), 3, true)) {
						  evt.getEntity().setAirSupply(Math.min(evt.getEntity().getAirSupply() + 5, evt.getEntity().getMaxAirSupply()));
					  }
				  }
				  if(itm.is(divingBellTag)) {
					  if(evt.getEntity().getOffhandItem().is(airhoseTag)) {
						  if(closestAirAbove(evt.getEntity(), evt.getEntity().getOffhandItem().getCount(), false)) {
							  evt.getEntity().setAirSupply(Math.min(evt.getEntity().getAirSupply() + 5, evt.getEntity().getMaxAirSupply()));
						  }
					  }
				  }
				  if(itm.is(divingHelmetTag)) {
					  if(evt.getEntity().getOffhandItem().is(oxygenTankTag)) {
						  while(evt.getEntity().getAirSupply() < LivingEntity.TOTAL_AIR_SUPPLY &&
								  evt.getEntity().getOffhandItem().getDamageValue() < evt.getEntity().getOffhandItem().getMaxDamage() - 2) {
							  evt.getEntity().setAirSupply(Math.min(evt.getEntity().getAirSupply() + 5, evt.getEntity().getMaxAirSupply()));
							  evt.getEntity().getOffhandItem().setDamageValue(evt.getEntity().getOffhandItem().getDamageValue() + 1);
						  }
					  }
				  }
			  }
			  if(evt.getEntity().getOffhandItem().is(breathingReedTag) && !snorkel) {
				  if(closestAirAbove(evt.getEntity(), 2, false)) {
					  evt.getEntity().setAirSupply(Math.min(evt.getEntity().getAirSupply() + 5, evt.getEntity().getMaxAirSupply()));
				  }
			  }
		  }
	  }
	  
	  public static boolean closestAirAbove(LivingEntity ent,int maxHeightInBlocks, boolean direct) {
		  int xOffset = 0;
		  int zOffset = 0;
		  int yOffset = 0;
		  for(int i = 0; i < maxHeightInBlocks; i++) {
			  BlockPos up = new BlockPos(ent.getBlockX()+ xOffset, (int)Math.round(ent.getEyeY() + yOffset), ent.getBlockZ()+zOffset); 
			  if(ent.level().getBlockState(up).isAir())
				  return true;
			  if(ent.level().getBlockState(up).isCollisionShapeFullBlock(ent.level(), up)) {
				  if(direct)
					  return false;
				  boolean foundPath = false;
				  int td = 1;
				  while(!foundPath && i + td < maxHeightInBlocks) {
					  for(int x = -td; x <= td; x++) {
						  for(int y = -td; y <= td; y++) {
							  BlockPos upXZ = new BlockPos(ent.getBlockX()+ xOffset + x, (int)Math.round(ent.getEyeY() + yOffset), ent.getBlockZ()+zOffset + y);
							  if(ent.level().getBlockState(upXZ).isAir())
								  return true;
							  if(ent.level().getFluidState(upXZ).is(FluidTags.WATER)) {
								  i += Math.abs(x) + Math.abs(y);
								  xOffset += x;
								  zOffset += y;
								  yOffset++;
								  foundPath = true;
							  }
						  }  
					  }
					  if(!foundPath)
						  td++;
				  }
				  i += td;
			  }else {
				  yOffset++;
			  }
		  }
		 return false;
	  }
	
}