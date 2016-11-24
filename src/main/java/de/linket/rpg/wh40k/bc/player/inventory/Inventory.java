package de.linket.rpg.wh40k.bc.player.inventory;

import java.util.ArrayList;
import java.util.List;

import de.linket.rpg.wh40k.bc.item.Item;
import de.linket.rpg.wh40k.bc.player.Character;

public class Inventory
{

    private List<Item<?>> items = new ArrayList<>();

    private Character character;

    public Inventory(Character character2)
    {
        this.character = character2;
    }

    public List<Item<?>> getItems()
    {
        return this.items;
    }

    public void setItems(List<Item<?>> items)
    {
        this.items = items;
    }

    public Character getCharacter()
    {
        return this.character;
    }

    public void setCharacter(Character character)
    {
        this.character = character;
    }
}
