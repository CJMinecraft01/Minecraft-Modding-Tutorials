package cjminecraft.bitofeverything.init;

import cjminecraft.bitofeverything.Reference;
import cjminecraft.bitofeverything.items.ItemGear;
import cjminecraft.bitofeverything.items.ItemModArmour;
import cjminecraft.bitofeverything.items.ItemModAxe;
import cjminecraft.bitofeverything.items.ItemModFood;
import cjminecraft.bitofeverything.items.ItemModHoe;
import cjminecraft.bitofeverything.items.ItemModPickaxe;
import cjminecraft.bitofeverything.items.ItemModShovel;
import cjminecraft.bitofeverything.items.ItemModSword;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
	
	public static Item copper_ingot;
	
	public static Item gear;
	
	//Armour Materials
	public static ArmorMaterial copperArmourMaterial = EnumHelper.addArmorMaterial("copper", "boe:copper_armour", 15, new int[]{2,6,5,2}, 9);
	
	//Tool Materials
	public static ToolMaterial copperMaterial = EnumHelper.addToolMaterial("copper", 2, 300, 5.0F, 2.0F, 12);
	
	//Armour
	public static ItemArmor copper_helmet;
	public static ItemArmor copper_chestplate;
	public static ItemArmor copper_leggings;
	public static ItemArmor copper_boots;
	
	//Tools
	public static ItemPickaxe copper_pick;
	public static ItemHoe copper_hoe;
	public static ItemAxe copper_axe;
	public static ItemSpade copper_shovel;
	public static ItemSword copper_sword;
	
	//Food
	public static Item copper_apple;
	
	public static void init() {
		copper_ingot = new Item().setUnlocalizedName("copper_ingot");
		
		gear = new ItemGear("gear");
		
		//Armour
		copper_helmet = new ItemModArmour(copperArmourMaterial, 0, 0, "copper_helmet");
		copper_chestplate = new ItemModArmour(copperArmourMaterial, 0, 1, "copper_chestplate");
		copper_leggings = new ItemModArmour(copperArmourMaterial, 1, 2, "copper_leggings");
		copper_boots = new ItemModArmour(copperArmourMaterial, 0, 3, "copper_boots");
		
		//Tools
		copper_pick = new ItemModPickaxe(copperMaterial, "copper_pickaxe");
		copper_hoe = new ItemModHoe(copperMaterial, "copper_hoe");
		copper_axe = new ItemModAxe(copperMaterial, "copper_axe");
		copper_shovel = new ItemModShovel(copperMaterial, "copper_shovel");
		copper_sword= new ItemModSword(copperMaterial, "copper_sword");
		
		//Food
		copper_apple = new ItemModFood("copper_apple", 4, 1.2f, false, new PotionEffect(Potion.moveSpeed.id, 2400, 2), new PotionEffect(Potion.healthBoost.id, 100, 0)).setAlwaysEdible();
	}
	
	public static void register() {
		registerItem(copper_ingot);
		
		registerItem(gear);
		
		//Armour
		registerItem(copper_helmet);
		registerItem(copper_chestplate);
		registerItem(copper_leggings);
		registerItem(copper_boots);
		
		//Tools
		registerItem(copper_pick);
		registerItem(copper_axe);
		registerItem(copper_hoe);
		registerItem(copper_shovel);
		registerItem(copper_sword);
		
		//Food
		registerItem(copper_apple);
	}
	
	public static void registerRenders() {
		registerRender(copper_ingot);
		
		registerRender(gear, 0, "wood_gear");
		registerRender(gear, 1, "stone_gear");
		registerRender(gear, 2, "iron_gear");
		registerRender(gear, 3, "gold_gear");
		registerRender(gear, 4, "diamond_gear");
		registerRender(gear, 5, "copper_gear");
		
		//Armour
		registerRender(copper_helmet);
		registerRender(copper_chestplate);
		registerRender(copper_leggings);
		registerRender(copper_boots);
		
		//Tools
		registerRender(copper_pick);
		registerRender(copper_hoe);
		registerRender(copper_axe);
		registerRender(copper_shovel);
		registerRender(copper_sword);
		
		//Food
		registerRender(copper_apple);
	}
	
	public static void registerItem(Item item) {
		GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
		System.out.println("Registered Item: " + item.getUnlocalizedName().substring(5));
	}
	
	public static void registerRender(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	
	public static void registerRender(Item item, int meta, String fileName) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation(Reference.MODID + ":" + fileName, "inventory"));
	}

}
