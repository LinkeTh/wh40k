package de.linket.rpg.wh40k.bc.item;

import de.linket.rpg.wh40k.bc.types.ItemCategoryType;
import de.linket.rpg.wh40k.bc.types.MiscItemType;

public class MiscItem implements Item<MiscItemType>{

	private MiscItemType type;

	public MiscItem(MiscItemType type) {
		super();
		this.type = type;
	}
	@Override
	public MiscItemType getType() {
		return this.type;
	}

	@Override
	public ItemCategoryType getCategory() {
		return ItemCategoryType.MISC;
	}
}
