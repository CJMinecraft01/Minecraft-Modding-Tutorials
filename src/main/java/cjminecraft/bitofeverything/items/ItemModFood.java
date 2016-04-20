package cjminecraft.bitofeverything.items;

import cjminecraft.bitofeverything.BitOfEverything;
import cjminecraft.bitofeverything.init.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemModFood extends ItemFood {
	
	private PotionEffect[] effects;

	public ItemModFood(String unlocalizedName, int amount, float saturation, boolean isWolfFood, PotionEffect... effects) {
		super(amount, saturation, isWolfFood);
		this.setUnlocalizedName(unlocalizedName);
		this.effects = effects;
		this.setCreativeTab(BitOfEverything.items);
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
		super.onFoodEaten(stack, world, player);
		if(!world.isRemote) {
			for(int i = 0; i < effects.length; i++) {
				player.addPotionEffect(effects[i]);
			}
		}
	}

}
