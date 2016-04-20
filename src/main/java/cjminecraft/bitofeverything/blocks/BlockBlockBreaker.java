package cjminecraft.bitofeverything.blocks;

import java.util.List;
import java.util.Random;

import cjminecraft.bitofeverything.BitOfEverything;
import cjminecraft.bitofeverything.handlers.EnumHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBlockBreaker extends Block implements IMetaBlockName {

	public static final PropertyEnum TYPE = PropertyEnum.create("type", EnumHandler.BlockBreakerTypes.class);
	public static final PropertyBool ACTIVE = PropertyBool.create("active");
	
	public BlockBlockBreaker(String unlocalizedName) {
		super(Material.rock);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(BitOfEverything.blocks);
		this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, EnumHandler.BlockBreakerTypes.WOOD).withProperty(ACTIVE, Boolean.valueOf(false)));
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List<ItemStack> list) {
		list.add(new ItemStack(item, 1, 0));
		list.add(new ItemStack(item, 1, 1));
		list.add(new ItemStack(item, 1, 2));
		list.add(new ItemStack(item, 1, 3));
		list.add(new ItemStack(item, 1, 4));
		list.add(new ItemStack(item, 1, 5));
	}
	
	@Override
	protected BlockState createBlockState() {
		return new BlockState(this, new IProperty[] { TYPE, ACTIVE });
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		if(meta == 0) {
			return getDefaultState().withProperty(TYPE, EnumHandler.BlockBreakerTypes.WOOD);
		}
		if(meta == 1) {
			return getDefaultState().withProperty(TYPE, EnumHandler.BlockBreakerTypes.STONE);
		}
		if(meta == 2) {
			return getDefaultState().withProperty(TYPE, EnumHandler.BlockBreakerTypes.IRON);
		}
		if(meta == 3) {
			return getDefaultState().withProperty(TYPE, EnumHandler.BlockBreakerTypes.GOLD);
		}
		if(meta == 4) {
			return getDefaultState().withProperty(TYPE, EnumHandler.BlockBreakerTypes.DIAMOND);
		}
		if(meta == 5) {
			return getDefaultState().withProperty(TYPE, EnumHandler.BlockBreakerTypes.COPPER);
		}
		return getDefaultState().withProperty(TYPE, EnumHandler.BlockBreakerTypes.WOOD);
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		EnumHandler.BlockBreakerTypes type = (EnumHandler.BlockBreakerTypes) state.getValue(TYPE);
		return type.getID();
	}
	
	@Override
	public int damageDropped(IBlockState state) {
		return this.getMetaFromState(state);
	}

	@Override
	public String getSpecialName(ItemStack stack) {
		if(stack.getItemDamage() == 0) {
			return "wood";
		}
		if(stack.getItemDamage() == 1) {
			return "stone";
		}
		if(stack.getItemDamage() == 2) {
			return "iron";
		}
		if(stack.getItemDamage() == 3) {
			return "gold";
		}
		if(stack.getItemDamage() == 4) {
			return "diamond";
		}
		if(stack.getItemDamage() == 5) {
			return "copper";
		}
		return "wood";
	}
	
	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, BlockPos pos, EntityPlayer player) {
		return new ItemStack(Item.getItemFromBlock(this), 1, this.getMetaFromState(world.getBlockState(pos)));
	}
	
	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos) {
		if(world.getBlockState(pos.up()).getBlock() != Blocks.air) {
			return state.withProperty(ACTIVE, Boolean.valueOf(true));
		}
		else {
			return state.withProperty(ACTIVE, Boolean.valueOf(false));
		}
	}

}
