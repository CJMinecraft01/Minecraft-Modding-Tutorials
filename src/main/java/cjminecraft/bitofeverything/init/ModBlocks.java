package cjminecraft.bitofeverything.init;

import cjminecraft.bitofeverything.Reference;
import cjminecraft.bitofeverything.blocks.BlockBlockBreaker;
import cjminecraft.bitofeverything.blocks.BlockCopperBlock;
import cjminecraft.bitofeverything.blocks.BlockCopperFurnace;
import cjminecraft.bitofeverything.blocks.BlockCopperOre;
import cjminecraft.bitofeverything.blocks.BlockItemCase;
import cjminecraft.bitofeverything.blocks.BlockMiniChest;
import cjminecraft.bitofeverything.blocks.ItemBlockItemCase;
import cjminecraft.bitofeverything.blocks.ItemBlockMeta;
import cjminecraft.bitofeverything.blocks.ItemBlockMiniChest;
import cjminecraft.bitofeverything.handlers.EnumHandler;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	public static Block copper_ore;
	public static Block copper_block;
	
	public static Block block_breaker;
	
	public static Block mini_chest;
	
	public static Block copper_furnace;
	public static Block lit_copper_furnace;
	
	public static Block item_case;

	public static void init() {
		copper_ore = new BlockCopperOre("copper_ore");
		copper_block = new BlockCopperBlock("copper_block");
		
		block_breaker = new BlockBlockBreaker("block_breaker");
		
		mini_chest = new BlockMiniChest("mini_chest");
		
		copper_furnace = new BlockCopperFurnace("copper_furnace", false);
		lit_copper_furnace = new BlockCopperFurnace("lit_copper_furnace", true);
		
		item_case = new BlockItemCase("item_case");
	}

	public static void register() {
		registerBlock(copper_ore);
		registerBlock(copper_block);
		
		GameRegistry.registerBlock(block_breaker, ItemBlockMeta.class, "block_breaker");
		
		GameRegistry.registerBlock(mini_chest, ItemBlockMiniChest.class, "mini_chest");
		
		registerBlock(copper_furnace);
		registerBlock(lit_copper_furnace);
		
		GameRegistry.registerBlock(item_case, ItemBlockItemCase.class, "item_case");
	}

	public static void registerRenders() {
		registerRender(copper_ore);
		registerRender(copper_block);
		
		for(int i = 0; i < EnumHandler.BlockBreakerTypes.values().length; i++) {
			registerRender(block_breaker, i, EnumHandler.BlockBreakerTypes.values()[i].getName() + "_block_breaker");
		}
		
		registerRender(mini_chest, 0, "mini_chest");
		
		registerRender(copper_furnace);
		registerRender(lit_copper_furnace);
		
		registerRender(item_case, 0, "item_case");
	}

	public static void registerBlock(Block block) {
		GameRegistry.registerBlock(block, block.getUnlocalizedName().substring(5));
		System.out.println("Registered Block: " + block.getUnlocalizedName().substring(5));
	}

	public static void registerRender(Block block) {
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0,
				new ModelResourceLocation(Reference.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	
	public static void registerRender(Block block, int meta, String fileName) {
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta,
				new ModelResourceLocation(Reference.MODID + ":" + fileName, "inventory"));
	}

}
