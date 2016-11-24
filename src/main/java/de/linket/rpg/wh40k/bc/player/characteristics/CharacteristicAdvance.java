package de.linket.rpg.wh40k.bc.player.characteristics;

import de.linket.rpg.wh40k.bc.exp.Experience;
import de.linket.rpg.wh40k.bc.player.advances.Advance;

public class CharacteristicAdvance implements Advance<CharacteristicModifier>
{
    private Experience cost;

    public CharacteristicAdvance()
    {
    }

    public CharacteristicAdvance(Experience cost)
    {
        this.cost = cost;
    }

    @Override
    public CharacteristicModifier getModifier()
    {
        return new CharacteristicModifier(null, 5);
    }

    @Override
    public Experience getCosts()
    {
        return this.cost;
    }
}
