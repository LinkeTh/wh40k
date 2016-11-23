package de.linket.rpg.wh40k.bc.types;

import java.util.Arrays;
import java.util.List;

import de.linket.rpg.wh40k.bc.common.GameObject;
import de.linket.rpg.wh40k.bc.common.Modifier;

public enum ItemCategoryType implements GameObject
{
    MISC,
    ARMOR,
    WEAPON;

    private List<Modifier<?>> modifiers;

    private ItemCategoryType(Modifier<?>... modifiers)
    {
        this.modifiers = Arrays.asList(modifiers);
    }

    public List<Modifier<?>> getModifiers()
    {
        return this.modifiers;
    }
}
