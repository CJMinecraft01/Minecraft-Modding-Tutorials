package cjminecraft.bitofeverything.items;

import cjminecraft.bitofeverything.BitOfEverything;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.Item.ToolMaterial;

public class ItemModShovel extends ItemSpade {
	
	public ItemModShovel(ToolMaterial material, String unlocalizedName) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(BitOfEverything.items);
	}

}
