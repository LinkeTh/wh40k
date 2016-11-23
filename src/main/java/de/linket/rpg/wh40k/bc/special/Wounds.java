package de.linket.rpg.wh40k.bc.special;

import de.linket.rpg.wh40k.bc.common.RollableGameValue;
import de.linket.rpg.wh40k.bc.dice.DefaultBonusRollImpl;
import de.linket.rpg.wh40k.bc.types.SpecialType;

public class Wounds extends RollableGameValue<SpecialType, DefaultBonusRollImpl>
{
	@SuppressWarnings("unused")
	private Wounds() {
	}

	public Wounds(DefaultBonusRollImpl roll)
	{
		super(SpecialType.WOUNDS, roll);
	}

	@Override
	public String toString()
	{
		return String.valueOf(this.getValue());
	}
}
