package de.linket.rpg.wh40k.bc.player.inventory;

import java.util.ArrayList;
import java.util.List;
import de.linket.rpg.wh40k.bc.player.Character;
import de.linket.rpg.wh40k.bc.item.Item;

public class Inventory  {

	private List<Item<?>> items = new ArrayList<>();

	private Character character;

	public Inventory(Character character2)
	{
		this.character = character2;
	}

}
