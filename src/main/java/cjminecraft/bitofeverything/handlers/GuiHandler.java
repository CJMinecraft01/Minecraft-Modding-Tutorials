package cjminecraft.bitofeverything.handlers;

import cjminecraft.bitofeverything.client.gui.GuiMiniChest;
import cjminecraft.bitofeverything.container.ContainerMiniChest;
import cjminecraft.bitofeverything.tileentities.TileEntityCopperFurnace;
import cjminecraft.bitofeverything.tileentities.TileEntityMiniChest;
import net.minecraft.client.gui.inventory.GuiFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ContainerFurnace;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
	
	public static final int MINI_CHEST = 0;
	public static final int COPPER_FURNACE = 1;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == MINI_CHEST) {
			return new ContainerMiniChest(player.inventory, (TileEntityMiniChest) world.getTileEntity(new BlockPos(x, y, z)));
		}
		if(ID == COPPER_FURNACE) {
			return new ContainerFurnace(player.inventory, (TileEntityCopperFurnace) world.getTileEntity(new BlockPos(x, y, z)));
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == MINI_CHEST) {
			return new GuiMiniChest(player.inventory, (TileEntityMiniChest) world.getTileEntity(new BlockPos(x, y, z)));
		}
		if(ID == COPPER_FURNACE) {
			return new GuiFurnace(player.inventory, (TileEntityCopperFurnace) world.getTileEntity(new BlockPos(x, y, z)));
		}
		return null;
	}

}
