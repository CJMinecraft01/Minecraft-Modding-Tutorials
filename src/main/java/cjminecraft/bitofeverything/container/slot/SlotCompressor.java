package cjminecraft.bitofeverything.container.slot;

import cjminecraft.bitofeverything.compressor.CompressorRegistry;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotCompressor extends Slot {

	public SlotCompressor(IInventory inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack) {
		return isValid(stack);
	}
	
	public static boolean isValid(ItemStack stack) {
		if(CompressorRegistry.recipes.containsKey(stack)) {
			return true;
		}else {
			return true;
		}
	}

}
