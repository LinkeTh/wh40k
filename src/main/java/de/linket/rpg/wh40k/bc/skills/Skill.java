package de.linket.rpg.wh40k.bc.skills;

import de.linket.rpg.wh40k.bc.advances.AdvanceList;
import de.linket.rpg.wh40k.bc.common.Advanceable;
import de.linket.rpg.wh40k.bc.common.ModifiableGameValue;
import de.linket.rpg.wh40k.bc.exp.Experience;
import de.linket.rpg.wh40k.bc.types.SkillStateType;
import de.linket.rpg.wh40k.bc.types.SkillType;
import de.linket.rpg.wh40k.bc.util.StringUtil;

public class Skill extends ModifiableGameValue<SkillType> implements Advanceable
{
	private static final int ADVANCE_LIMIT = 4;

	private AdvanceList<SkillAdvance> advances = new AdvanceList<>(ADVANCE_LIMIT);

	public Skill(SkillType type)
	{
		this(type, SkillStateType.KNOWN);
	}

	public Skill(SkillType type, SkillStateType state)
	{
		super(type,state.getValue());
	}

	@Override
	public void advance(Experience cost)
	{

		if (this.advances.hasAdvanceLeft())
		{
			SkillAdvance advance = new SkillAdvance(cost);
			this.addAdvance(advance);
		}
	}

	private void addAdvance(SkillAdvance advance)
	{
		this.advances.addAdvance(advance);
		this.addModifier(advance.getModifier());
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();

		builder.append(StringUtil.padRight(this.getType().name(), 40));
		builder.append(" = ");
		builder.append(SkillStateType.getByValue(this.getValue()));
		builder.append(" (");
		builder.append(this.getValue());
		builder.append(") ");
		return builder.toString();
	}
}
