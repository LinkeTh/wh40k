package de.linket.rpg.wh40k.bc.item;

import de.linket.rpg.wh40k.bc.types.ArmorType;
import de.linket.rpg.wh40k.bc.types.ItemCategoryType;

public class Armor implements Item<ArmorType>{

	private ArmorType type;

	public Armor(ArmorType type) {
		super();
		this.type = type;
	}
	@Override
	public ArmorType getType() {
		return this.type;
	}

	@Override
	public ItemCategoryType getCategory() {
		return ItemCategoryType.ARMOR;
	}
}
