package de.linket.rpg.wh40k.bc.skills;

import de.linket.rpg.wh40k.bc.advances.Advance;
import de.linket.rpg.wh40k.bc.exp.Experience;

public class SkillAdvance implements Advance<SkillModifier>
{
	private Experience cost;

	public SkillAdvance(Experience cost) {
		this.cost = cost;
	}

	@Override
	public SkillModifier getModifier()
	{
		return new SkillModifier(null, 10);
	}

	@Override
	public Experience getCosts() {
		return this.cost;
	}
}
