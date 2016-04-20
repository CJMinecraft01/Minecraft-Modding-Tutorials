package cjminecraft.bitofeverything.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemBlockMiniChest extends ItemBlock {

	public ItemBlockMiniChest(Block block) {
		super(block);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}

}
