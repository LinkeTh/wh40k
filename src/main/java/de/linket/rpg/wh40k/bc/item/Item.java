package de.linket.rpg.wh40k.bc.item;

import de.linket.rpg.wh40k.bc.common.GameItem;
import de.linket.rpg.wh40k.bc.common.GameObject;
import de.linket.rpg.wh40k.bc.types.ItemCategoryType;

public interface Item<T extends GameObject> extends GameItem<T>{

	public ItemCategoryType getCategory();
}
