package cjminecraft.bitofeverything.container.slot;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ISmartItemModel;

public class SlotRedstoneGenerator extends Slot {

	public SlotRedstoneGenerator(IInventory inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack) {
		return stack.getItem() == Items.redstone || stack.getItem() == Item.getItemFromBlock(Blocks.redstone_block);
	}

}
