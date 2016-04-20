package cjminecraft.bitofeverything.creativetabs;

import cjminecraft.bitofeverything.init.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabBOEBlocks extends CreativeTabs {
	
	public TabBOEBlocks(String label) {
		super(label);
		this.setBackgroundImageName("boe.png");
	}

	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(ModBlocks.copper_ore);
	}

}
