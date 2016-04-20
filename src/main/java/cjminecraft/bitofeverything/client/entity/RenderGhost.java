package cjminecraft.bitofeverything.client.entity;

import cjminecraft.bitofeverything.Reference;
import cjminecraft.bitofeverything.client.model.ModelGhost;
import cjminecraft.bitofeverything.entity.EntityGhost;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGhost extends RenderLiving<EntityGhost>{

	private static final ResourceLocation ghostTexture = new ResourceLocation(Reference.MODID + ":textures/entity/ghost.png"); // Initialized it and changed it to private static final
	
	public RenderGhost(RenderManager rendermanagerIn, ModelGhost model, float shadowSize) {
		super(rendermanagerIn, model, shadowSize);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityGhost entity) {
		return this.ghostTexture == null ? new ResourceLocation(Reference.MODID + ":textures/entity/ghost") : this.ghostTexture; //Added this
	}

}
