package de.linket.rpg.wh40k.bc.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import de.linket.rpg.wh40k.bc.common.GameObject;
import de.linket.rpg.wh40k.bc.common.selection.SelectionWrapper;
import de.linket.rpg.wh40k.bc.definition.races.skills.HumanSkillWrapper;
import de.linket.rpg.wh40k.bc.definition.races.skills.SpaceMarineSkillWrapper;
import de.linket.rpg.wh40k.bc.definition.races.talents.HumanTalentWrapper;
import de.linket.rpg.wh40k.bc.definition.races.talents.SpaceMarineTalentWrapper;
import de.linket.rpg.wh40k.bc.definition.races.traits.HumanTraitWrapper;
import de.linket.rpg.wh40k.bc.definition.races.traits.SpaceMarineTraitWrapper;
import de.linket.rpg.wh40k.bc.exp.Experience;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum RaceType implements GameObject
{
    CHAOS_SPACE_MARINE(30, new Experience(500), new SpaceMarineSkillWrapper(), new SpaceMarineTalentWrapper(), new SpaceMarineTraitWrapper()),
    HUMAN(25, new Experience(1000), new HumanSkillWrapper(), new HumanTalentWrapper(), new HumanTraitWrapper());

    private int characteristicBonus;
    private Experience startExperience;
    private SelectionWrapper<SkillType> skillWrapper;
    private SelectionWrapper<TalentType> talentWrapper;
    private SelectionWrapper<TraitType> traitWrapper;

    private RaceType(int characteristicBonus, Experience startExperience, SelectionWrapper<SkillType> skillWrapper,
                    SelectionWrapper<TalentType> talentWrapper, SelectionWrapper<TraitType> traitWrapper)
    {
        this.characteristicBonus = characteristicBonus;
        this.startExperience = startExperience;
        this.skillWrapper = skillWrapper;
        this.talentWrapper = talentWrapper;
        this.traitWrapper = traitWrapper;
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

    @JsonIgnore
    public SelectionWrapper<TraitType> getTraitWrapper()
    {
        return this.traitWrapper;
    };

    @JsonIgnore
    public SelectionWrapper<TalentType> getTalentWrapper()
    {
        return this.talentWrapper;
    }

    @JsonCreator
    public static RaceType fromName(@JsonProperty("name") String name)
    {
        if (name == null)
        {
            return null;
        }

        for (RaceType type : RaceType.values())
        {
            if (type.getName().equalsIgnoreCase(name))
            {
                return type;
            }
        }
        return null;
    }
}
