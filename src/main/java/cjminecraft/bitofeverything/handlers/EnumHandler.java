package cjminecraft.bitofeverything.handlers;

import net.minecraft.util.IStringSerializable;

public class EnumHandler {
	
	public enum BlockBreakerTypes implements IStringSerializable {
		
		WOOD(0, "wood"),
		STONE(1, "stone"),
		IRON(2, "iron"),
		GOLD(3, "gold"),
		DIAMOND(4, "diamond"),
		COPPER(5, "copper");
		
		private int ID;
		private String name;
		
		private BlockBreakerTypes(int ID, String name) {
			this.ID = ID;
			this.name = name;
		}
		
		public String getName() {
			return name;
		}
		
		public int getID() {
			return ID;
		}
		
		@Override
		public String toString() {
			return getName();
		}
	}

}
