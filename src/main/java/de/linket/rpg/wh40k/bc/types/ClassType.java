package de.linket.rpg.wh40k.bc.types;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import de.linket.rpg.wh40k.bc.classes.skills.ApostateSkillWrapper;
import de.linket.rpg.wh40k.bc.classes.skills.ChampionSkillWrapper;
import de.linket.rpg.wh40k.bc.classes.skills.ChosenSkillWrapper;
import de.linket.rpg.wh40k.bc.classes.skills.ForsakenSkillWrapper;
import de.linket.rpg.wh40k.bc.classes.skills.HeretekSkillWrapper;
import de.linket.rpg.wh40k.bc.classes.skills.PsykerSkillWrapper;
import de.linket.rpg.wh40k.bc.classes.skills.RenegadeSkillWrapper;
import de.linket.rpg.wh40k.bc.classes.skills.SorcererSkillWrapper;
import de.linket.rpg.wh40k.bc.classes.talents.ApostateTalentWrapper;
import de.linket.rpg.wh40k.bc.classes.talents.ChampionTalentWrapper;
import de.linket.rpg.wh40k.bc.classes.talents.ChosenTalentWrapper;
import de.linket.rpg.wh40k.bc.classes.talents.ForsakenTalentWrapper;
import de.linket.rpg.wh40k.bc.classes.talents.HeretekTalentWrapper;
import de.linket.rpg.wh40k.bc.classes.talents.PsykerTalentWrapper;
import de.linket.rpg.wh40k.bc.classes.talents.RenegadeTalentWrapper;
import de.linket.rpg.wh40k.bc.classes.talents.SorcererTalentWrapper;
import de.linket.rpg.wh40k.bc.common.GameObject;
import de.linket.rpg.wh40k.bc.common.selection.SelectionWrapper;
import de.linket.rpg.wh40k.bc.dice.DefaultBonusRollImpl;
import de.linket.rpg.wh40k.bc.special.PsyRating;
import de.linket.rpg.wh40k.bc.special.Wounds;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ClassType implements GameObject
{
	APOSTATE(RaceType.HUMAN, new PsyRating(0), new ApostateSkillWrapper(), new ApostateTalentWrapper(), new Wounds(
			new DefaultBonusRollImpl(DiceType.W5, 1, 9))),
	CHAMPION(RaceType.CHAOS_SPACE_MARINE, new PsyRating(0), new ChampionSkillWrapper(), new ChampionTalentWrapper(), new Wounds(
			new DefaultBonusRollImpl(DiceType.W5, 1, 15))),
	CHOSEN(RaceType.CHAOS_SPACE_MARINE, new PsyRating(0), new ChosenSkillWrapper(), new ChosenTalentWrapper(), new Wounds(
			new DefaultBonusRollImpl(DiceType.W5, 1, 16))),
	FORSAKEN(RaceType.CHAOS_SPACE_MARINE, new PsyRating(0), new ForsakenSkillWrapper(), new ForsakenTalentWrapper(), new Wounds(
			new DefaultBonusRollImpl(DiceType.W5, 1, 15))),
	HERETEK(RaceType.HUMAN, new PsyRating(0), new HeretekSkillWrapper(), new HeretekTalentWrapper(), new Wounds(
			new DefaultBonusRollImpl(DiceType.W5, 1, 12))),
	PSYKER(RaceType.HUMAN, new PsyRating(3), new PsykerSkillWrapper(), new PsykerTalentWrapper(), new Wounds(
			new DefaultBonusRollImpl(DiceType.W5, 1, 8))),
	RENEGADE(RaceType.HUMAN, new PsyRating(0), new RenegadeSkillWrapper(), new RenegadeTalentWrapper(), new Wounds(
			new DefaultBonusRollImpl(DiceType.W5, 1, 10))),
	SORCERER(RaceType.CHAOS_SPACE_MARINE, new PsyRating(2), new SorcererSkillWrapper(), new SorcererTalentWrapper(), new Wounds(
			new DefaultBonusRollImpl(DiceType.W5, 1, 15)));

	public static List<ClassType> getAvailableClasses(RaceType restriction)
	{
		if (restriction == null)
		{
			return null;
		}

		return Arrays.asList(ClassType.values()).stream().filter(ct -> ct.restriction.equals(restriction)).collect(Collectors.toList());
	}

	private PsyRating psyRating;
	private RaceType restriction;
	private SelectionWrapper<SkillType> skillWrapper;
	private SelectionWrapper<TalentType> talentWrapper;

	private Wounds wound;

	private ClassType(RaceType restriction, PsyRating psyRating, SelectionWrapper<SkillType> skillWrapper, SelectionWrapper<TalentType> talentWrapper,
			Wounds wound)
	{
		this.restriction = restriction;
		this.skillWrapper = skillWrapper;
		this.talentWrapper = talentWrapper;
		this.wound = wound;
		this.psyRating = psyRating;
	}

	public String getName()
	{
		return this.name();
	}

	public PsyRating getPsyRating()
	{
		return this.psyRating;
	}

	public RaceType getRestriction()
	{
		return this.restriction;
	};

	@JsonIgnore
	public SelectionWrapper<SkillType> getSkillWrapper()
	{
		return this.skillWrapper;
	}

	@JsonIgnore
	public SelectionWrapper<TalentType> getTalentWrapper()
	{
		return this.talentWrapper;
	}

	public Wounds getWound()
	{
		return this.wound;
	}


	@JsonCreator
	public static ClassType fromName(@JsonProperty("name") String name)
	{
		if(name == null)
		{
			return null;
		}

		for(ClassType type : ClassType.values())
		{
			if(type.getName().equalsIgnoreCase(name))
			{
				return type;
			}
		}
		return null;
	}
}
