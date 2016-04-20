package cjminecraft.bitofeverything.items;

import cjminecraft.bitofeverything.BitOfEverything;
import cjminecraft.bitofeverything.init.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemModArmour extends ItemArmor {

	public ItemModArmour(ArmorMaterial material, int renderIndex, int armorType, String unlocalizedName) {
		super(material, renderIndex, armorType);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(BitOfEverything.items);
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
		if (stack.getItem() == ModItems.copper_helmet) {
			effectPlayer(player, Potion.nightVision, 0);
		}
		if (stack.getItem() == ModItems.copper_chestplate) {
			effectPlayer(player, Potion.invisibility, 0);
		}
		if (stack.getItem() == ModItems.copper_leggings) {
			effectPlayer(player, Potion.moveSpeed, 2);
		}
		if (stack.getItem() == ModItems.copper_boots) {
			effectPlayer(player, Potion.jump, 2);
		}
		if (player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(2) != null
				&& player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(0) != null
				&& player.inventory.armorItemInSlot(3).getItem() == ModItems.copper_helmet
				&& player.inventory.armorItemInSlot(2).getItem() == ModItems.copper_chestplate
				&& player.inventory.armorItemInSlot(1).getItem() == ModItems.copper_leggings
				&& player.inventory.armorItemInSlot(0).getItem() == ModItems.copper_boots) {
			effectPlayer(player, Potion.absorption, 0);
			effectPlayer(player, Potion.heal, 0);
			effectPlayer(player, Potion.healthBoost, 2);
		}
		super.onArmorTick(world, player, stack);
	}

	private void effectPlayer(EntityPlayer entity, Potion potion, int amplifier) {
		// Always effect for 8 seconds, then refresh
		if (entity.getActivePotionEffect(potion) == null || entity.getActivePotionEffect(potion).getDuration() <= 1)
			entity.addPotionEffect(new PotionEffect(potion.id, 159, amplifier, true, true));
	}

}
