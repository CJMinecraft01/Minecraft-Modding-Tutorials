package cjminecraft.bitofeverything.items;

import cjminecraft.bitofeverything.BitOfEverything;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.Item.ToolMaterial;

public class ItemModHoe extends ItemHoe {
	
	public ItemModHoe(ToolMaterial material, String unlocalizedName) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(BitOfEverything.items);
	}

}
