package cjminecraft.bitofeverything.items;

import java.util.List;

import cjminecraft.bitofeverything.BitOfEverything;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemGear extends Item {
	
	public ItemGear(String unloaclizedName) {
		this.setUnlocalizedName(unloaclizedName);
		this.setCreativeTab(BitOfEverything.items);
		this.setHasSubtypes(true);
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List<ItemStack> items) {
		items.add(new ItemStack(item, 1, 0));
		items.add(new ItemStack(item, 1, 1));
		items.add(new ItemStack(item, 1, 2));
		items.add(new ItemStack(item, 1, 3));
		items.add(new ItemStack(item, 1, 4));
		items.add(new ItemStack(item, 1, 5));
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		if(stack.getItemDamage() == 0) {
			return this.getUnlocalizedName() + ".wood";
		}
		if(stack.getItemDamage() == 1) {
			return this.getUnlocalizedName() + ".stone";
		}
		if(stack.getItemDamage() == 2) {
			return this.getUnlocalizedName() + ".iron";
		}
		if(stack.getItemDamage() == 3) {
			return this.getUnlocalizedName() + ".gold";
		}
		if(stack.getItemDamage() == 4) {
			return this.getUnlocalizedName() + ".diamond";
		}
		if(stack.getItemDamage() == 5) {
			return this.getUnlocalizedName() + ".copper";
		}
		return "wood";
	}

}
