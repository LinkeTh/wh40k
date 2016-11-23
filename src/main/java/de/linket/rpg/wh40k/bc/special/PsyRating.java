package de.linket.rpg.wh40k.bc.special;

import de.linket.rpg.wh40k.bc.common.ModifiableGameValue;
import de.linket.rpg.wh40k.bc.types.SpecialType;

public class PsyRating extends ModifiableGameValue<SpecialType>
{
	public PsyRating(int value)
	{
		super(SpecialType.PSYRATING, value);
	}

	@Override
	public String toString()
	{
		return String.valueOf(this.getValue());
	}
}
