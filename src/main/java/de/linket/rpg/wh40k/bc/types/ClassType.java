package de.linket.rpg.wh40k.bc.types;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import de.linket.rpg.wh40k.bc.common.GameObject;
import de.linket.rpg.wh40k.bc.common.selection.SelectionWrapper;
import de.linket.rpg.wh40k.bc.definition.classes.skills.ApostateSkillWrapper;
import de.linket.rpg.wh40k.bc.definition.classes.skills.ChampionSkillWrapper;
import de.linket.rpg.wh40k.bc.definition.classes.skills.ChosenSkillWrapper;
import de.linket.rpg.wh40k.bc.definition.classes.skills.ForsakenSkillWrapper;
import de.linket.rpg.wh40k.bc.definition.classes.skills.HeretekSkillWrapper;
import de.linket.rpg.wh40k.bc.definition.classes.skills.PsykerSkillWrapper;
import de.linket.rpg.wh40k.bc.definition.classes.skills.RenegadeSkillWrapper;
import de.linket.rpg.wh40k.bc.definition.classes.skills.SorcererSkillWrapper;
import de.linket.rpg.wh40k.bc.definition.classes.talents.ApostateTalentWrapper;
import de.linket.rpg.wh40k.bc.definition.classes.talents.ChampionTalentWrapper;
import de.linket.rpg.wh40k.bc.definition.classes.talents.ChosenTalentWrapper;
import de.linket.rpg.wh40k.bc.definition.classes.talents.ForsakenTalentWrapper;
import de.linket.rpg.wh40k.bc.definition.classes.talents.HeretekTalentWrapper;
import de.linket.rpg.wh40k.bc.definition.classes.talents.PsykerTalentWrapper;
import de.linket.rpg.wh40k.bc.definition.classes.talents.RenegadeTalentWrapper;
import de.linket.rpg.wh40k.bc.definition.classes.talents.SorcererTalentWrapper;
import de.linket.rpg.wh40k.bc.definition.classes.traits.ApostateTraitWrapper;
import de.linket.rpg.wh40k.bc.definition.classes.traits.ChampionTraitWrapper;
import de.linket.rpg.wh40k.bc.definition.classes.traits.ChosenTraitWrapper;
import de.linket.rpg.wh40k.bc.definition.classes.traits.HeretekTraitWrapper;
import de.linket.rpg.wh40k.bc.definition.classes.traits.PsykerTraitWrapper;
import de.linket.rpg.wh40k.bc.definition.classes.traits.RenegadeTraitWrapper;
import de.linket.rpg.wh40k.bc.definition.classes.traits.SorcererTraitWrapper;
import de.linket.rpg.wh40k.bc.player.skills.Skill;
import de.linket.rpg.wh40k.bc.player.special.PsyRating;
import de.linket.rpg.wh40k.bc.player.special.Wounds;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ClassType implements GameObject
{
    APOSTATE(RaceType.HUMAN, new PsyRating(0), new ApostateSkillWrapper(), new ApostateTalentWrapper(), new ApostateTraitWrapper(), new Wounds(
                    DiceType.W5, 1, 9)),
    CHAMPION(RaceType.CHAOS_SPACE_MARINE, new PsyRating(
                    0), new ChampionSkillWrapper(), new ChampionTalentWrapper(), new ChampionTraitWrapper(), new Wounds(DiceType.W5, 1, 15)),
    CHOSEN(RaceType.CHAOS_SPACE_MARINE, new PsyRating(0), new ChosenSkillWrapper(), new ChosenTalentWrapper(), new ChosenTraitWrapper(), new Wounds(
                    DiceType.W5, 1, 16)),
    FORSAKEN(RaceType.CHAOS_SPACE_MARINE, new PsyRating(0), new ForsakenSkillWrapper(), new ForsakenTalentWrapper(), null, new Wounds(DiceType.W5, 1,
                    15)),
    HERETEK(RaceType.HUMAN, new PsyRating(0), new HeretekSkillWrapper(), new HeretekTalentWrapper(), new HeretekTraitWrapper(), new Wounds(
                    DiceType.W5, 1, 12)),
    PSYKER(RaceType.HUMAN, new PsyRating(3), new PsykerSkillWrapper(), new PsykerTalentWrapper(), new PsykerTraitWrapper(), new Wounds(DiceType.W5, 1,
                    8)),
    RENEGADE(RaceType.HUMAN, new PsyRating(0), new RenegadeSkillWrapper(), new RenegadeTalentWrapper(), new RenegadeTraitWrapper(), new Wounds(
                    DiceType.W5, 1, 10)),
    SORCERER(RaceType.CHAOS_SPACE_MARINE, new PsyRating(
                    2), new SorcererSkillWrapper(), new SorcererTalentWrapper(), new SorcererTraitWrapper(), new Wounds(DiceType.W5, 1, 15));

    private PsyRating psyRating;
    private RaceType restriction;
    private SelectionWrapper<Skill> skillWrapper;
    private SelectionWrapper<TalentType> talentWrapper;
    private SelectionWrapper<TraitType> traitWrapper;

    private Wounds wound;

    private ClassType(RaceType restriction, PsyRating psyRating, SelectionWrapper<Skill> skillWrapper, SelectionWrapper<TalentType> talentWrapper,
                    SelectionWrapper<TraitType> traitWrapper, Wounds wound)
    {
        this.restriction = restriction;
        this.skillWrapper = skillWrapper;
        this.talentWrapper = talentWrapper;
        this.traitWrapper = traitWrapper;
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
    public SelectionWrapper<TraitType> getTraitWrapper()
    {
        return this.traitWrapper;
    }

    @JsonIgnore
    public SelectionWrapper<Skill> getSkillWrapper()
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

    public static List<ClassType> getAvailableClasses(RaceType restriction)
    {
        if (restriction == null)
        {
            return null;
        }

        return Arrays.asList(ClassType.values()).stream().filter(ct -> ct.restriction.equals(restriction)).collect(Collectors.toList());
    }

    @JsonCreator
    public static ClassType fromName(@JsonProperty("name") String name)
    {
        if (name == null)
        {
            return null;
        }

        for (ClassType type : ClassType.values())
        {
            if (type.getName().equalsIgnoreCase(name))
            {
                return type;
            }
        }
        return null;
    }
}
