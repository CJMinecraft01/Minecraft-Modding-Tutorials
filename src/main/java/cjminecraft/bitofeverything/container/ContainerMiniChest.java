package cjminecraft.bitofeverything.container;

import cjminecraft.bitofeverything.tileentities.TileEntityMiniChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerMiniChest extends Container {
	
	private TileEntityMiniChest te;

	public ContainerMiniChest(IInventory playerInv, TileEntityMiniChest te) {
		this.te = te;
		
		this.addSlotToContainer(new Slot(te, 0, 80, 16));
		
		//Player Inventory
		for (int y = 0; y < 3; ++y) {
			for (int x = 0; x < 9; ++x) {
				this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, 8 + x * 18, 41 + y * 18));
			}
		}
		//Player Hotbar	
		for (int x = 0; x < 9; ++x) {
			this.addSlotToContainer(new Slot(playerInv, x, 8 + x * 18, 99));
		}
		
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return this.te.isUseableByPlayer(playerIn);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int fromSlot) {
		ItemStack previous = null;
		Slot slot = (Slot) this.inventorySlots.get(fromSlot);

		if (slot != null && slot.getHasStack()) {
			ItemStack current = slot.getStack();
		        previous = current.copy();

		        if (fromSlot < 1) {
				// From TE Inventory to Player Inventory
		        	if (!this.mergeItemStack(current, 1, this.inventorySlots.size(), true)){
	                    		return null;
	                	}
		        } else {
		            // From Player Inventory to TE Inventory
		            if (!this.mergeItemStack(current, 0, 1, false))
		                return null;
		        }

		        if (current.stackSize == 0)
		            slot.putStack((ItemStack) null);
		        else
		            slot.onSlotChanged();
		    }
		    return previous;
	}

}
