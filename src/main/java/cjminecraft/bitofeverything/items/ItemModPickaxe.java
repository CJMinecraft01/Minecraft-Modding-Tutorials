package cjminecraft.bitofeverything.items;

import cjminecraft.bitofeverything.BitOfEverything;
import cjminecraft.bitofeverything.init.ModItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class ItemModPickaxe extends ItemPickaxe {

	public ItemModPickaxe(ToolMaterial material, String unlocalizedName) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(BitOfEverything.items);
	}
	
	@Override
	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
		if(stack.getItem() == ModItems.copper_pick) {
			effectPlayer(entityLiving, Potion.digSpeed, 2);
		}
		return super.onEntitySwing(entityLiving, stack);
	}
	
	private void effectPlayer(EntityLivingBase entity, Potion potion, int amplifier) {
	    //Always effect for 8 seconds, then refresh
	    if (entity.getActivePotionEffect(potion) == null || entity.getActivePotionEffect(potion).getDuration() <= 1)
	        entity.addPotionEffect(new PotionEffect(potion.id, 159, amplifier, true, true));
	}

}
