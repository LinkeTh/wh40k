package de.linket.rpg.wh40k.bc.player.special;

import de.linket.rpg.wh40k.bc.common.RollableGameValue;
import de.linket.rpg.wh40k.bc.dice.DefaultBonusRollImpl;
import de.linket.rpg.wh40k.bc.types.DiceType;
import de.linket.rpg.wh40k.bc.types.SpecialType;

public class Wounds extends RollableGameValue<SpecialType, DefaultBonusRollImpl>
{
    @SuppressWarnings("unused")
    private Wounds()
    {
    }

    public Wounds(DefaultBonusRollImpl roll)
    {
        super(SpecialType.WOUNDS, roll);
    }

    public Wounds(DiceType dice, int numberOfDice, int baseValue)
    {
        super(SpecialType.WOUNDS, new DefaultBonusRollImpl(dice, numberOfDice, baseValue));
    }

    @Override
    public String toString()
    {
        return String.valueOf(this.getValue());
    }
}
