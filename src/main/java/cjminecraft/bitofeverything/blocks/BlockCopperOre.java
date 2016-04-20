package cjminecraft.bitofeverything.blocks;

import cjminecraft.bitofeverything.BitOfEverything;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockCopperOre extends Block {

	public BlockCopperOre(String unlocalizedName) {
		super(Material.rock);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(BitOfEverything.blocks);
	}

}
