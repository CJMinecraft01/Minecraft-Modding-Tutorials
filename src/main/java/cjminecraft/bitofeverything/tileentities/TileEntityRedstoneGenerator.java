package cjminecraft.bitofeverything.tileentities;

import java.util.ArrayList;

import cjminecraft.bitofeverything.container.slot.SlotRedstoneGenerator;
import cofh.api.energy.IEnergyProvider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.network.play.server.S49PacketUpdateEntityNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.ITickable;

public class TileEntityRedstoneGenerator extends TileEntity implements IInventory, IEnergyProvider, ITickable {
	
	private int increasePerTick = 20;
	
	private int maxRF = 100000;
	private int currentRF;
	private int cooldown;
	
	private ItemStack[] inventory;
	private String customName;
	
	public TileEntityRedstoneGenerator() {
		this.inventory = new ItemStack[this.getSizeInventory()];
	}
	
	public String getCustomName() {
		return customName;
	}
	
	public void setCustomName(String customName) {
		this.customName = customName;
	}
	
	@Override
	public String getName() {
		return this.hasCustomName() ? this.customName : "container.redstone_generator";
	}
	
	@Override
	public boolean hasCustomName() {
		return this.customName != null && !this.customName.equals("");
	}
	
	@Override
	public IChatComponent getDisplayName() {
		return this.hasCustomName() ? new ChatComponentText(this.getName()) : new ChatComponentTranslation(this.getName());
	}
	
	@Override
	public int getSizeInventory() {
		return 1;
	}
	
	@Override
	public ItemStack getStackInSlot(int index) {
	    if (index < 0 || index >= this.getSizeInventory())
	        return null;
	    return this.inventory[index];
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
	    if (this.getStackInSlot(index) != null) {
	        ItemStack itemstack;

	        if (this.getStackInSlot(index).stackSize <= count) {
	            itemstack = this.getStackInSlot(index);
	            this.setInventorySlotContents(index, null);
	            this.markDirty();
	            return itemstack;
	        } else {
	            itemstack = this.getStackInSlot(index).splitStack(count);

	            if (this.getStackInSlot(index).stackSize <= 0) {
	                this.setInventorySlotContents(index, null);
	            } else {
	                //Just to show that changes happened
	                this.setInventorySlotContents(index, this.getStackInSlot(index));
	            }

	            this.markDirty();
	            return itemstack;
	        }
	    } else {
	        return null;
	    }
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
	    if (index < 0 || index >= this.getSizeInventory())
	        return;

	    if (stack != null && stack.stackSize > this.getInventoryStackLimit())
	        stack.stackSize = this.getInventoryStackLimit();
	        
	    if (stack != null && stack.stackSize == 0)
	        stack = null;

	    this.inventory[index] = stack;
	    this.markDirty();
	}
	
	@Override
	public int getInventoryStackLimit() {
		return 64;
	}
	
	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return this.worldObj.getTileEntity(this.getPos()) == this && player.getDistanceSq(this.pos.add(0.5, 0.5, 0.5)) <= 64;
	}
	
	@Override
	public void openInventory(EntityPlayer player) {
	}
	
	@Override
	public void closeInventory(EntityPlayer player) {
	}
	
	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		return stack.getItem() == Items.redstone || stack.getItem() == Item.getItemFromBlock(Blocks.redstone_block) || this.currentRF < this.maxRF;
	}
	
	@Override
	public int getField(int id) {
		switch(id) {
		case 0:
			return this.currentRF;
		case 1:
			return this.maxRF;
		case 2:
			return this.cooldown;
		case 3:
			return this.increasePerTick;
		}
		return 0;
	}
	
	@Override
	public void setField(int id, int value) {
		switch(id) {
		case 0:
			this.currentRF = value;
		case 1:
			this.maxRF = value;
		case 2:
			this.cooldown = value;
		case 3:
			this.increasePerTick = value;
		}
	}
	
	@Override
	public int getFieldCount() {
		return 4;
	}
	
	@Override
	public void clear() {
		for(int i = 0; i < this.getSizeInventory(); i++)
			this.setInventorySlotContents(i, null);
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt) {

	    NBTTagList list = new NBTTagList();
	    for (int i = 0; i < this.getSizeInventory(); ++i) {
	        if (this.getStackInSlot(i) != null) {
	            NBTTagCompound stackTag = new NBTTagCompound();
	            stackTag.setByte("Slot", (byte) i);
	            this.getStackInSlot(i).writeToNBT(stackTag);
	            list.appendTag(stackTag);
	        }
	    }
	    nbt.setTag("Items", list);
	    nbt.setInteger("currentRF", this.currentRF);
	    nbt.setInteger("cooldown", this.cooldown);
	    nbt.setInteger("ipt", this.increasePerTick);

	    if (this.hasCustomName()) {
	        nbt.setString("CustomName", this.getCustomName());
	    }
	    super.writeToNBT(nbt);
	}


	@Override
	public void readFromNBT(NBTTagCompound nbt) {

	    NBTTagList list = nbt.getTagList("Items", 10);
	    for (int i = 0; i < list.tagCount(); ++i) {
	        NBTTagCompound stackTag = list.getCompoundTagAt(i);
	        int slot = stackTag.getByte("Slot") & 255;
	        this.setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(stackTag));
	    }
	    this.currentRF = nbt.getInteger("currentRF");
	    this.cooldown = nbt.getInteger("cooldown");
	    this.increasePerTick = nbt.getInteger("ipt");

	    if (nbt.hasKey("CustomName", 8)) {
	        this.setCustomName(nbt.getString("CustomName"));
	    }
	    super.readFromNBT(nbt);
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
	    ItemStack stack = this.getStackInSlot(index);
	    this.setInventorySlotContents(index, null);
	    return stack;
	}

	@Override
	public int getEnergyStored(EnumFacing from) {
		return this.currentRF;
	}

	@Override
	public int getMaxEnergyStored(EnumFacing from) {
		return maxRF;
	}

	@Override
	public boolean canConnectEnergy(EnumFacing from) {
		return true;
	}

	@Override
	public int extractEnergy(EnumFacing from, int maxExtract, boolean simulate) {
		currentRF -= maxExtract;
		return maxExtract;
	}

	@Override
	public void update() {
		if(this.worldObj != null) { //changed this
			if(canUse()) {
				if(this.cooldown <= 0) {
					if(this.inventory[0].getItem() == Item.getItemFromBlock(Blocks.redstone_block)) {
						this.cooldown = 600;
						this.increasePerTick = 50;
					} else {
						this.cooldown = 70;
						this.increasePerTick = 20;
					}
					//this.decrStackSize(0, 1); removed this
					this.inventory[0].stackSize -= 1; //added this
					if(this.inventory[0].stackSize == 0) { //added this
						this.inventory[0] = null;
					}
				}
			}
			if(this.cooldown > 0) {
				this.cooldown--;
				if(this.currentRF < this.maxRF) {
					this.currentRF += this.increasePerTick;
				}
			}
			this.markDirty();
		}
	}
	
	private boolean canUse() {
		if(this.inventory[0] == null) {
			return false;
		}
		else {
			if(this.inventory[0].getItem() == Items.redstone || this.inventory[0].getItem() == Item.getItemFromBlock(Blocks.redstone_block)) {
				if(this.currentRF < this.maxRF) {
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound nbtTagCompound = new NBTTagCompound();
		writeToNBT(nbtTagCompound);
		int metadata = getBlockMetadata();
		return new S35PacketUpdateTileEntity(this.pos, metadata, nbtTagCompound);
	}
	
	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		readFromNBT(pkt.getNbtCompound());
	} //added these
	
}
