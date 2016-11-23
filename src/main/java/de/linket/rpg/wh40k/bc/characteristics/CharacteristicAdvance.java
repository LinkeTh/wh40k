package de.linket.rpg.wh40k.bc.characteristics;

import de.linket.rpg.wh40k.bc.advances.Advance;
import de.linket.rpg.wh40k.bc.exp.Experience;

public class CharacteristicAdvance implements Advance<CharacteristicModifier>
{
	private Experience cost;

	public CharacteristicAdvance() {
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
	public Experience getCosts() {
		return this.cost;
	}
}
