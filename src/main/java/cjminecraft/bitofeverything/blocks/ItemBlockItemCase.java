package cjminecraft.bitofeverything.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemBlockItemCase extends ItemBlock {

	public ItemBlockItemCase(Block block) {
		super(block);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}

}
