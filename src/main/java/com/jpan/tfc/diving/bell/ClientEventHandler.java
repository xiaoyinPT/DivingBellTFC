package com.jpan.tfc.diving.bell;

import java.util.Collections;
import java.util.Map;
import java.util.function.Consumer;

import org.jetbrains.annotations.NotNull;

import com.jpan.tfc.diving.bell.client.models.DivingHelmetModel;
import com.jpan.tfc.diving.bell.client.models.SnorkelModel;
import com.jpan.tfc.diving.bell.items.AirTankItem;
import com.jpan.tfc.diving.bell.items.DivingHelmItem;
import com.jpan.tfc.diving.bell.items.SnorkelItem;

import net.dries007.tfc.common.TFCCreativeTabs;
import net.dries007.tfc.util.Metal;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.RegistryObject;

@EventBusSubscriber(
		   modid = DivingBellTFC.MODID,
		   bus = Bus.MOD
		)
public class ClientEventHandler {
	
	public static final RegistryObject<Item> BRASS_SCUBA_GEAR_GOGGLES = DivingBellTFC.ITEMS.register("parts/goggles/brass",
			  ()-> new Item(new Item.Properties()));
	  public static final RegistryObject<Item> BRASS_SCUBA_GEAR_MINUS_GLASS = DivingBellTFC.ITEMS.register("parts/snorkel/brass",
			  ()-> new Item(new Item.Properties()));
	  
	  public static final RegistryObject<Item> BRASS_SCUBA_GEAR = DivingBellTFC.ITEMS.register("snorkels/brass", 
    		  () -> new SnorkelItem("tfcdivingbell:textures/head/scuba_head_texture.png", Metal.Default.COPPER.armorTier(), ArmorItem.Type.HELMET,
    				  new Item.Properties().rarity(Metal.Default.BRASS.getRarity()).durability(Metal.Default.COPPER.armorTier().getDurabilityForType(ArmorItem.Type.HELMET))));
	  
	  public static final RegistryObject<Item> RG_SCUBA_GEAR_GOGGLES = DivingBellTFC.ITEMS.register("parts/goggles/rose_gold",
			  ()-> new Item(new Item.Properties()));
	  public static final RegistryObject<Item> RG_SCUBA_GEAR_MINUS_GLASS = DivingBellTFC.ITEMS.register("parts/snorkel/rose_gold",
			  ()-> new Item(new Item.Properties()));
	  
	  public static final RegistryObject<Item> RG_SCUBA_GEAR = DivingBellTFC.ITEMS.register("snorkels/rose_gold", 
    		  () -> new SnorkelItem("tfcdivingbell:textures/head/scuba_head_texture_rg.png", Metal.Default.COPPER.armorTier(), ArmorItem.Type.HELMET,
    				  new Item.Properties().rarity(Metal.Default.ROSE_GOLD.getRarity()).durability(Metal.Default.COPPER.armorTier().getDurabilityForType(ArmorItem.Type.HELMET))));
	  
	  public static final RegistryObject<Item> SS_SCUBA_GEAR_GOGGLES = DivingBellTFC.ITEMS.register("parts/goggles/sterling_silver",
			  ()-> new Item(new Item.Properties()));
	  public static final RegistryObject<Item> SS_SCUBA_GEAR_MINUS_GLASS = DivingBellTFC.ITEMS.register("parts/snorkel/sterling_silver",
			  ()-> new Item(new Item.Properties()));
	  
	  public static final RegistryObject<Item> SS_SCUBA_GEAR = DivingBellTFC.ITEMS.register("snorkels/sterling_silver", 
    		  () -> new SnorkelItem("tfcdivingbell:textures/head/scuba_head_texture_ss.png", Metal.Default.COPPER.armorTier(), ArmorItem.Type.HELMET,
    				  new Item.Properties().rarity(Metal.Default.STERLING_SILVER.getRarity()).durability(Metal.Default.COPPER.armorTier().getDurabilityForType(ArmorItem.Type.HELMET))));
	
	  
	  public static final RegistryObject<Item> BRASS_DIVING_HELMET_HALF = DivingBellTFC.ITEMS.register("parts/diving_helmet_half/brass",
			  ()-> new Item(new Item.Properties()));
	  public static final RegistryObject<Item> BRASS_DIVING_HELMET_MINUS_GLASS = DivingBellTFC.ITEMS.register("parts/diving_helmet/brass",
			  ()-> new Item(new Item.Properties()));
	  
	  public static final RegistryObject<Item> BRASS_DIVING_HELMET = DivingBellTFC.ITEMS.register("diving_helmets/brass", 
    		  () -> new DivingHelmItem("tfcdivingbell:textures/head/diving_helmet_head.png", Metal.Default.BRONZE.armorTier(), ArmorItem.Type.HELMET,
    				  new Item.Properties().rarity(Metal.Default.BRASS.getRarity()).durability(Metal.Default.BRONZE.armorTier().getDurabilityForType(ArmorItem.Type.HELMET))));
	  
	  public static final RegistryObject<Item> LEATHER_HOSE = DivingBellTFC.ITEMS.register("leather_hose",
			  () -> new Item(new Item.Properties()));
	  
	  public static final RegistryObject<Item> BRASS_CYLINDER = DivingBellTFC.ITEMS.register("parts/cylinder/brass",
			  ()-> new Item(new Item.Properties()));
	  public static final RegistryObject<Item> BRASS_TANK = DivingBellTFC.ITEMS.register("parts/tank/brass",
			  ()-> new Item(new Item.Properties()));
	  public static final RegistryObject<Item> BRASS_AIR_TANK = DivingBellTFC.ITEMS.register("airtanks/brass",
			  () -> new AirTankItem(1200,  new Item.Properties().rarity(Metal.Default.BRASS.getRarity())));
	  
	  public static final RegistryObject<Item> STEEL_CYLINDER = DivingBellTFC.ITEMS.register("parts/cylinder/steel",
			  ()-> new Item(new Item.Properties()));
	  public static final RegistryObject<Item> STEEL_TANK = DivingBellTFC.ITEMS.register("parts/tank/steel",
			  ()-> new Item(new Item.Properties()));
	  public static final RegistryObject<Item> STEEL_AIR_TANK = DivingBellTFC.ITEMS.register("airtanks/steel",
			  () -> new AirTankItem(2400,  new Item.Properties().rarity(Metal.Default.STEEL.getRarity())));
	  
	  public static final RegistryObject<Item> BLACK_STEEL_CYLINDER = DivingBellTFC.ITEMS.register("parts/cylinder/black_steel",
			  ()-> new Item(new Item.Properties()));
	  public static final RegistryObject<Item> BLACK_STEEL_TANK = DivingBellTFC.ITEMS.register("parts/tank/black_steel",
			  ()-> new Item(new Item.Properties()));
	  public static final RegistryObject<Item> BLACK_STEEL_AIR_TANK = DivingBellTFC.ITEMS.register("airtanks/black_steel",
			  () -> new AirTankItem(6000,  new Item.Properties().rarity(Metal.Default.STEEL.getRarity())));
	
	  public static final RegistryObject<Item> RED_STEEL_CYLINDER = DivingBellTFC.ITEMS.register("parts/cylinder/red_steel",
			  ()-> new Item(new Item.Properties()));
	  public static final RegistryObject<Item> RED_STEEL_TANK = DivingBellTFC.ITEMS.register("parts/tank/red_steel",
			  ()-> new Item(new Item.Properties()));
	  
	  public static final RegistryObject<Item> RED_STEEL_AIR_TANK = DivingBellTFC.ITEMS.register("airtanks/red_steel",
			  () -> new AirTankItem(12000,  new Item.Properties().rarity(Metal.Default.STEEL.getRarity())));
	  
	  public static final RegistryObject<Item> BLUE_STEEL_CYLINDER = DivingBellTFC.ITEMS.register("parts/cylinder/blue_steel",
			  ()-> new Item(new Item.Properties()));
	  public static final RegistryObject<Item> BLUE_STEEL_TANK = DivingBellTFC.ITEMS.register("parts/tank/blue_steel",
			  ()-> new Item(new Item.Properties()));
		  
	  public static final RegistryObject<Item> BLUE_STEEL_AIR_TANK = DivingBellTFC.ITEMS.register("airtanks/blue_steel",
			  () -> new AirTankItem(12000,  new Item.Properties().rarity(Metal.Default.STEEL.getRarity())));
	 @SubscribeEvent
	   public static void buildTab(BuildCreativeModeTabContentsEvent event) {
	      if (event.getTab().equals(TFCCreativeTabs.METAL.tab().get())) {
	    	  
	       event.accept(BRASS_SCUBA_GEAR_GOGGLES);  
	       event.accept(BRASS_SCUBA_GEAR_MINUS_GLASS);
	       event.accept(BRASS_SCUBA_GEAR);
	       
	       event.accept(SS_SCUBA_GEAR_GOGGLES);  
	       event.accept(SS_SCUBA_GEAR_MINUS_GLASS);
	       event.accept(SS_SCUBA_GEAR);
	       
	       event.accept(RG_SCUBA_GEAR_GOGGLES);  
	       event.accept(RG_SCUBA_GEAR_MINUS_GLASS);
	       event.accept(RG_SCUBA_GEAR);
	       
	       event.accept(BRASS_DIVING_HELMET_HALF);
	       event.accept(BRASS_DIVING_HELMET_MINUS_GLASS);
	       event.accept(BRASS_DIVING_HELMET);
	       event.accept(LEATHER_HOSE);
	       
	       event.accept(BRASS_CYLINDER);
	       event.accept(STEEL_CYLINDER);
	       event.accept(BLACK_STEEL_CYLINDER);
	       event.accept(RED_STEEL_CYLINDER);
	       event.accept(BLUE_STEEL_CYLINDER);
	       event.accept(BRASS_TANK);
	       event.accept(STEEL_TANK);
	       event.accept(BLACK_STEEL_TANK);
	       event.accept(RED_STEEL_TANK);
	       event.accept(BLUE_STEEL_TANK);
	       event.accept(BRASS_AIR_TANK);
	       event.accept(STEEL_AIR_TANK);
	       event.accept(BLACK_STEEL_AIR_TANK);
	       event.accept(RED_STEEL_AIR_TANK);
	       event.accept(BLUE_STEEL_AIR_TANK);
	      }
	   }
	 
	   @SubscribeEvent
       public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event)
       {
		   event.registerLayerDefinition(SnorkelModel.LAYER_LOCATION, SnorkelModel::createBodyLayer);
		   event.registerLayerDefinition(DivingHelmetModel.LAYER_LOCATION, DivingHelmetModel::createBodyLayer);
       }
}
