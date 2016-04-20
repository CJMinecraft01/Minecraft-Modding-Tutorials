package cjminecraft.bitofeverything.proxy;

import cjminecraft.bitofeverything.BitOfEverything;
import cjminecraft.bitofeverything.handlers.GuiHandler;
import cjminecraft.bitofeverything.tileentities.TileEntityMiniChest;
import cjminecraft.bitofeverything.worldgen.OreGen;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
	
	public void registerRenders() {
		
	}
	
	public void registerWorldGenerators() {
		GameRegistry.registerWorldGenerator(new OreGen(), 0);
	}
	
	public void registerModelBakeryStuff() {
		
	}
	
	public void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityMiniChest.class, "mini_chest");
	}
	
	public void registerGuiHandler() {
		NetworkRegistry.INSTANCE.registerGuiHandler(BitOfEverything.instance, new GuiHandler());
	}
	
	public void registerEntityRenders() {
		
	}

}
