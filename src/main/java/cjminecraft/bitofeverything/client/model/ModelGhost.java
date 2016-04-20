package cjminecraft.bitofeverything.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGhost extends ModelBase {

	private ModelRenderer body;
	
	public ModelGhost() {
		body = new ModelRenderer(this, 0, 0);
		this.body.addBox(-0.6F, 0F, -0.6F, 6, 16, 6);
		this.body.setTextureSize(256, 256);
	}
	
	public void render(Entity entityIn, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_,
			float p_78088_6_, float scale) {
		this.setRotationAngles(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, scale, entityIn); // Change the 0's to the args
		this.body.render(scale);
	}
	
}
