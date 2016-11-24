package de.linket.rpg.wh40k.bc.player.special;

import de.linket.rpg.wh40k.bc.common.ModifiableGameValue;
import de.linket.rpg.wh40k.bc.types.SpecialType;

public class Initiative extends ModifiableGameValue<SpecialType>
{
    public Initiative(int value)
    {
        super(SpecialType.INITIATIVE, value);
    }

    @Override
    public String toString()
    {
        return String.valueOf(this.getValue());
    }
}
