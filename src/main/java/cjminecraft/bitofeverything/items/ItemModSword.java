package cjminecraft.bitofeverything.items;

import cjminecraft.bitofeverything.BitOfEverything;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;

public class ItemModSword extends ItemSword {
	
	public ItemModSword(ToolMaterial material, String unlocalizedName) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(BitOfEverything.items);
	}

}
