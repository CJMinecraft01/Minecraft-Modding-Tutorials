package cjminecraft.bitofeverything.handlers;

import cjminecraft.bitofeverything.init.ModBlocks;
import cjminecraft.bitofeverything.init.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipeHandler {
	
	public static void registerCraftingRecipes() {
		GameRegistry.addRecipe(new ItemStack(ModBlocks.copper_block), new Object[] { "III","III","III",'I',ModItems.copper_ingot});
		registerArmourRecipe(ModItems.copper_helmet, ModItems.copper_chestplate, ModItems.copper_leggings, ModItems.copper_boots, ModItems.copper_ingot);
		registerToolRecipe(ModItems.copper_pick, ModItems.copper_axe, ModItems.copper_hoe, ModItems.copper_shovel, ModItems.copper_sword, ModItems.copper_ingot);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.copper_ingot,9,0), new Object[] {Item.getItemFromBlock(ModBlocks.copper_block)});
		
		GameRegistry.addRecipe(new ItemStack(ModBlocks.block_breaker, 1, 0), new Object[] { "WWW","WPW","WGW", 'W', Blocks.planks, 'P', Items.wooden_pickaxe, 'G', new ItemStack(ModItems.gear, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.block_breaker, 1, 1), new Object[] { "WWW","WPW","WGW", 'W', Blocks.cobblestone, 'P', Items.stone_pickaxe, 'G', new ItemStack(ModItems.gear, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.block_breaker, 1, 2), new Object[] { "WWW","WPW","WGW", 'W', Items.iron_ingot, 'P', Items.iron_pickaxe, 'G', new ItemStack(ModItems.gear, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.block_breaker, 1, 3), new Object[] { "WWW","WPW","WGW", 'W', Items.gold_ingot, 'P', Items.golden_pickaxe, 'G', new ItemStack(ModItems.gear, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.block_breaker, 1, 4), new Object[] { "WWW","WPW","WGW", 'W', Items.diamond, 'P', Items.diamond_pickaxe, 'G', new ItemStack(ModItems.gear, 1, 4) });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.block_breaker, 1, 5), new Object[] { "WWW","WPW","WGW", 'W', ModItems.copper_ingot, 'P', ModItems.copper_pick, 'G', new ItemStack(ModItems.gear, 1, 5) });
		
		System.out.println("Registered Crafting Recipes!");
	}
	
	public static void registerFurnaceRecipes() {
		GameRegistry.addSmelting(ModBlocks.copper_ore, new ItemStack(ModItems.copper_ingot), 0.7f);
		
		System.out.println("Registered Furnace Recipes!");
	}
	
	public static void registerArmourRecipe(Item helmet, Item chestplate, Item leggings, Item boots, Item ingot) {
		GameRegistry.addRecipe(new ItemStack(helmet), new Object[] { "III","I I","   ",'I',ingot});
		GameRegistry.addRecipe(new ItemStack(helmet), new Object[] { "   ","III","I I",'I',ingot});
		GameRegistry.addRecipe(new ItemStack(chestplate), new Object[] { "I I","III","III",'I',ingot});
		GameRegistry.addRecipe(new ItemStack(leggings), new Object[] { "III","I I","I I",'I',ingot});
		GameRegistry.addRecipe(new ItemStack(boots), new Object[] { "   ","I I","I I",'I',ingot});
		GameRegistry.addRecipe(new ItemStack(boots), new Object[] { "I I","I I","   ",'I',ingot});
	}
	
	public static void registerToolRecipe(Item pickaxe, Item axe, Item hoe, Item shovel, Item sword, Item ingot) {
		GameRegistry.addRecipe(new ItemStack(pickaxe), new Object[] { "III"," S "," S ",'I',ingot,'S',Items.stick});
		GameRegistry.addRecipe(new ItemStack(axe), new Object[] { " II"," SI"," S ",'I',ingot,'S',Items.stick});
		GameRegistry.addRecipe(new ItemStack(axe), new Object[] { "II ","IS "," S ",'I',ingot,'S',Items.stick});
		GameRegistry.addRecipe(new ItemStack(hoe), new Object[] { " II"," S "," S ",'I',ingot,'S',Items.stick});
		GameRegistry.addRecipe(new ItemStack(hoe), new Object[] { "II "," S "," S ",'I',ingot,'S',Items.stick});
		GameRegistry.addRecipe(new ItemStack(shovel), new Object[] { " I "," S "," S ",'I',ingot,'S',Items.stick});
		GameRegistry.addRecipe(new ItemStack(shovel), new Object[] { "I  ","S  ","S  ",'I',ingot,'S',Items.stick});
		GameRegistry.addRecipe(new ItemStack(shovel), new Object[] { "  I","  S","  S",'I',ingot,'S',Items.stick});
		GameRegistry.addRecipe(new ItemStack(sword), new Object[] { " I "," I "," S ",'I',ingot,'S',Items.stick});
		GameRegistry.addRecipe(new ItemStack(sword), new Object[] { "I  ","I  ","S  ",'I',ingot,'S',Items.stick});
		GameRegistry.addRecipe(new ItemStack(sword), new Object[] { "  I","  I","  S",'I',ingot,'S',Items.stick});
	}

}
