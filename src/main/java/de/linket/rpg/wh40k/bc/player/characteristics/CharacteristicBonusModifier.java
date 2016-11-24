package de.linket.rpg.wh40k.bc.player.characteristics;

import de.linket.rpg.wh40k.bc.modifier.AbstractModifier;
import de.linket.rpg.wh40k.bc.modifier.ModifierType;
import de.linket.rpg.wh40k.bc.types.CharacteristicType;

public class CharacteristicBonusModifier extends AbstractModifier<CharacteristicType>
{

    public CharacteristicBonusModifier(CharacteristicType type, int value)
    {
        super();
        this.type = type;
        this.value = value;
    }

    @Override
    public ModifierType getModifierType()
    {
        return ModifierType.CHARACTERISTIC_BONUS;
    }
}
