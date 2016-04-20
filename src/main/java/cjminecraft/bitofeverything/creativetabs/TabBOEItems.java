package cjminecraft.bitofeverything.creativetabs;

import cjminecraft.bitofeverything.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabBOEItems extends CreativeTabs {

	public TabBOEItems(String label) {
		super(label);
		this.setBackgroundImageName("boe.png");
	}

	@Override
	public Item getTabIconItem() {
		return ModItems.copper_ingot;
	}

}
