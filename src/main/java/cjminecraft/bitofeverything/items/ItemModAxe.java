package cjminecraft.bitofeverything.items;

import cjminecraft.bitofeverything.BitOfEverything;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.Item.ToolMaterial;

public class ItemModAxe extends ItemAxe {
	
	public ItemModAxe(ToolMaterial material, String unlocalizedName) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(BitOfEverything.items);
	}

}
