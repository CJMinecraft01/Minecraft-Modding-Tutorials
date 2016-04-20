package cjminecraft.bitofeverything.blocks;

import cjminecraft.bitofeverything.BitOfEverything;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockItemCase extends Block {
	
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

	public BlockItemCase(String unlocalizedName) {
		super(Material.wood);
		this.setStepSound(soundTypeWood);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(BitOfEverything.blocks);
		this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH);
		
		this.setResistance(15);
		this.setHardness(2);
		this.setHarvestLevel("axe", 0);
	}
	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, BlockPos pos) {
		if(world.getBlockState(pos).getValue(FACING) == EnumFacing.NORTH) {
			this.setBlockBounds(0.375f, 0, 0.125f, 0.625f, 0.75f, 0.375f);
		}
		if(world.getBlockState(pos).getValue(FACING) == EnumFacing.SOUTH) {
			this.setBlockBounds(0.375f, 0, 0.625f, 0.625f, 0.75f, 0.875f);
		}
		if(world.getBlockState(pos).getValue(FACING) == EnumFacing.EAST) {
			this.setBlockBounds(0.625f, 0, 0.375f, 0.875f, 0.75f, 0.625f);
		}
		if(world.getBlockState(pos).getValue(FACING) == EnumFacing.WEST) {
			this.setBlockBounds(0.125f, 0, 0.375f, 0.375f, 0.75f, 0.625f);
		}
	}
	
	@Override
	protected BlockState createBlockState() {
		return new BlockState(this, new IProperty[] { FACING });
	}
	
	@Override
	public boolean isFullCube() {
		return false;
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public boolean shouldSideBeRendered(IBlockAccess worldIn, BlockPos pos, EnumFacing side) {
		return true;
	}
	
	public IBlockState getStateFromMeta(int meta) {
		
		EnumFacing facing = EnumFacing.getFront(meta);
		
		if(facing.getAxis() == EnumFacing.Axis.Y) {
			facing = EnumFacing.NORTH;
		}
		
		return this.getDefaultState().withProperty(FACING, facing);
		
	}
	
	public int getMetaFromState(IBlockState state) {
		return ((EnumFacing)state.getValue(FACING)).getIndex();
	}
	
	@Override
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ,
			int meta, EntityLivingBase placer) {
		EnumFacing enumfacing = placer.getHorizontalFacing().getOpposite();
		return this.getDefaultState().withProperty(FACING, enumfacing);
	}
	
	@Override
	public EnumWorldBlockLayer getBlockLayer() {
		return EnumWorldBlockLayer.CUTOUT;
	}

}
