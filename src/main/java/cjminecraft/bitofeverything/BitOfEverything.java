package cjminecraft.bitofeverything;

import cjminecraft.bitofeverything.creativetabs.TabBOEBlocks;
import cjminecraft.bitofeverything.creativetabs.TabBOEItems;
import cjminecraft.bitofeverything.handlers.RecipeHandler;
import cjminecraft.bitofeverything.init.ModBlocks;
import cjminecraft.bitofeverything.init.ModEntities;
import cjminecraft.bitofeverything.init.ModItems;
import cjminecraft.bitofeverything.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class BitOfEverything {
	
	@SidedProxy(serverSide = Reference.SERVER_PROXY_CLASS, clientSide = Reference.CLIENT_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@Mod.Instance("boe")
	public static BitOfEverything instance;
	
	public static CreativeTabs items = new TabBOEItems("tabBOEItems");
	public static CreativeTabs blocks = new TabBOEBlocks("tabBOEBlocks");
	
	@EventHandler()
	public static void preInit(FMLPreInitializationEvent event) {
		proxy.registerTileEntities();
		ModItems.init();
		ModItems.register();
		ModBlocks.init();
		ModBlocks.register();
		
		ModEntities.registerEntities();
	}
	
	@EventHandler()
	public static void init(FMLInitializationEvent event) {
		proxy.registerGuiHandler();
		proxy.registerRenders();
		proxy.registerModelBakeryStuff();
		proxy.registerWorldGenerators();
		RecipeHandler.registerCraftingRecipes();
		RecipeHandler.registerFurnaceRecipes();
		proxy.registerEntityRenders();//Moved to init
		ModEntities.setEntityToSpawn();
		ModEntities.generateSpawnEgg();
	}
	
	@EventHandler()
	public static void postInit(FMLPostInitializationEvent event) {
	}

}
