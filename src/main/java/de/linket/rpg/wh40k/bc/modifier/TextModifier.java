package de.linket.rpg.wh40k.bc.modifier;

import de.linket.rpg.wh40k.bc.common.TextObject;

public class TextModifier extends AbstractModifier<TextObject>
{
    public TextModifier(TextObject type)
    {
        super();
        this.value = 0;
        this.type = type;
    }

    @Override
    public ModifierType getModifierType()
    {
        return ModifierType.TEXT;
    }
}
