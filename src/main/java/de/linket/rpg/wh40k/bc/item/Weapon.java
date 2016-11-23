package de.linket.rpg.wh40k.bc.item;

import de.linket.rpg.wh40k.bc.types.ItemCategoryType;
import de.linket.rpg.wh40k.bc.types.WeaponType;

public class Weapon implements Item<WeaponType>{

	private WeaponType type;

	public Weapon(WeaponType type) {
		super();
		this.type = type;
	}
	@Override
	public WeaponType getType() {
		return this.type;
	}

	@Override
	public ItemCategoryType getCategory() {
		return ItemCategoryType.WEAPON;
	}
}
