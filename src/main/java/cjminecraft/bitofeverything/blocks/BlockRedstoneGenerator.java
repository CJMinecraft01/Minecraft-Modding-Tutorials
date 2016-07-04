package cjminecraft.bitofeverything.blocks;

import cjminecraft.bitofeverything.BitOfEverything;
import cjminecraft.bitofeverything.handlers.GuiHandler;
import cjminecraft.bitofeverything.tileentities.TileEntityMiniChest;
import cjminecraft.bitofeverything.tileentities.TileEntityRedstoneGenerator;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockRedstoneGenerator extends BlockContainer {

	public BlockRedstoneGenerator(String unlocalizedName) {
		super(Material.rock);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(BitOfEverything.blocks);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityRedstoneGenerator();
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumFacing side, float hitX, float hitY, float hitZ) {
		if(!worldIn.isRemote) {
			playerIn.openGui(BitOfEverything.instance, GuiHandler.REDSTONE_GENERATOR, worldIn, pos.getX(), pos.getY(), pos.getZ());
		}
		return true;
	}
	
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState blockstate) {
		TileEntityRedstoneGenerator te = (TileEntityRedstoneGenerator) world.getTileEntity(pos);
	    InventoryHelper.dropInventoryItems(world, pos, te);
	    super.breakBlock(world, pos, blockstate);
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
	    if (stack.hasDisplayName()) {
	        ((TileEntityRedstoneGenerator) worldIn.getTileEntity(pos)).setCustomName(stack.getDisplayName());
	    }
	}
	
	@Override
	public int getRenderType() {
		return 3;
	}

}
