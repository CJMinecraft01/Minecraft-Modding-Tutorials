package cjminecraft.bitofeverything.proxy;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import cjminecraft.bitofeverything.client.entity.RenderGhost;
import cjminecraft.bitofeverything.client.model.ModelGhost;
import cjminecraft.bitofeverything.entity.EntityGhost;
import cjminecraft.bitofeverything.init.ModBlocks;
import cjminecraft.bitofeverything.init.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderGhast;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void registerRenders() {
		ModItems.registerRenders();
		ModBlocks.registerRenders();
	}
	
	@Override
	public void registerModelBakeryStuff() {
		ModelBakery.registerItemVariants(ModItems.gear, new ResourceLocation("boe:wood_gear"), new ResourceLocation("boe:stone_gear"), new ResourceLocation("boe:iron_gear"), new ResourceLocation("boe:gold_gear"), new ResourceLocation("boe:diamond_gear"), new ResourceLocation("boe:copper_gear"));
		ModelBakery.registerItemVariants(Item.getItemFromBlock(ModBlocks.block_breaker), new ResourceLocation("boe:wood_block_breaker"), new ResourceLocation("boe:stone_block_breaker"), new ResourceLocation("boe:iron_block_breaker"), new ResourceLocation("boe:gold_block_breaker"), new ResourceLocation("boe:diamond_block_breaker"), new ResourceLocation("boe:copper_block_breaker"));
	}
	
	@Override
	public void registerEntityRenders() {
		RenderingRegistry.registerEntityRenderingHandler(EntityGhost.class, new RenderGhost(Minecraft.getMinecraft().getRenderManager(), new ModelGhost(), 0.4f)); //use depricated method
	}

}
