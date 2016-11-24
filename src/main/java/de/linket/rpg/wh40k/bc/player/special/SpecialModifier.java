package de.linket.rpg.wh40k.bc.player.special;

import de.linket.rpg.wh40k.bc.modifier.AbstractModifier;
import de.linket.rpg.wh40k.bc.modifier.ModifierType;
import de.linket.rpg.wh40k.bc.types.SpecialType;

public class SpecialModifier extends AbstractModifier<SpecialType>
{

    public SpecialModifier(SpecialType type, int value)
    {
        super();
        this.type = type;
        this.value = value;
    }

    @Override
    public ModifierType getModifierType()
    {
        return ModifierType.SPECIAL;
    }
}
