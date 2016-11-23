package de.linket.rpg.wh40k.bc.types;

import com.fasterxml.jackson.annotation.*;

import de.linket.rpg.wh40k.bc.common.GameObject;
import de.linket.rpg.wh40k.bc.common.selection.SelectionWrapper;
import de.linket.rpg.wh40k.bc.exp.Experience;
import de.linket.rpg.wh40k.bc.races.skills.HumanSkillWrapper;
import de.linket.rpg.wh40k.bc.races.skills.SpaceMarineSkillWrapper;
import de.linket.rpg.wh40k.bc.races.talents.HumanTalentWrapper;
import de.linket.rpg.wh40k.bc.races.talents.SpaceMarineTalentWrapper;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum RaceType implements GameObject
{
	CHAOS_SPACE_MARINE(30, new Experience(500), new SpaceMarineSkillWrapper(), new SpaceMarineTalentWrapper()),
	HUMAN(25, new Experience(1000), new HumanSkillWrapper(), new HumanTalentWrapper());

	private int characteristicBonus;
	private Experience startExperience;
	private SelectionWrapper<SkillType> skillWrapper;
	private SelectionWrapper<TalentType> talentWrapper;

	private RaceType(int characteristicBonus, Experience startExperience, SelectionWrapper<SkillType> skillWrapper,
			SelectionWrapper<TalentType> talentWrapper)
	{
		this.characteristicBonus = characteristicBonus;
		this.startExperience = startExperience;
		this.skillWrapper = skillWrapper;
		this.talentWrapper = talentWrapper;
	}

	@JsonIgnore
	public SelectionWrapper<TalentType> getTalentWrapper()
	{
		return this.talentWrapper;
	}

	public String getName()
	{
		return this.name();
	}

	public Experience getStartExperience()
	{
		return this.startExperience;
	}

	public int getCharacteristicBonus()
	{
		return this.characteristicBonus;
	}

	@JsonIgnore
	public SelectionWrapper<SkillType> getSkillWrapper()
	{
		return this.skillWrapper;
	}

	@JsonCreator
	public static RaceType fromName(@JsonProperty("name") String name)
	{
		if(name == null)
		{
			return null;
		}

		for(RaceType type : RaceType.values())
		{
			if(type.getName().equalsIgnoreCase(name))
			{
				return type;
			}
		}
		return null;
	}
}
