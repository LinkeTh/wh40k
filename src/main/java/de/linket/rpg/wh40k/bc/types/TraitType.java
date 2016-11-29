package de.linket.rpg.wh40k.bc.types;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import de.linket.rpg.wh40k.bc.common.GameObject;
import de.linket.rpg.wh40k.bc.common.TextObject;
import de.linket.rpg.wh40k.bc.modifier.Modifier;
import de.linket.rpg.wh40k.bc.modifier.TextModifier;
import de.linket.rpg.wh40k.bc.player.characteristics.CharacteristicBonusModifier;
import de.linket.rpg.wh40k.bc.player.characteristics.CharacteristicModifier;
import de.linket.rpg.wh40k.bc.player.special.SpecialModifier;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TraitType implements GameObject
{
    RENEGADE_CLASS(new CharacteristicModifier(CharacteristicType.BALLISTIC_SKILL, 3), new CharacteristicModifier(CharacteristicType.WEAPON_SKILL, 3)),
    APOSTATE_CLASS(new CharacteristicModifier(CharacteristicType.FELLOWSHIP, 5)),
    PSYKER_CLASS(new CharacteristicModifier(CharacteristicType.WILLPOWER, 5)),
    HERETEK_CLASS(new CharacteristicModifier(CharacteristicType.INTELLIGENCE, 5)),
    AMPHIBIOUS(new TextModifier(new TextObject(""))),
    UNNATURAL_STRENGHT(new CharacteristicBonusModifier(CharacteristicType.STRENGTH, 4)),
    UNNATURAL_TOUGHNESS(new CharacteristicBonusModifier(CharacteristicType.TOUGHNESS, 4)),
    INSPIRING_PRESENCE(new TextModifier(new TextObject(""))),
    COLD_KILLER(new TextModifier(new TextObject(""))),
    RESOURCEFUL(new TextModifier(new TextObject(""))),
    PSYKER(new TextModifier(new TextObject(""))),
    TRAITOR_TO_MARS(new TextModifier(new TextObject(""))),
    ADROIT(new TextModifier(new TextObject(""))),
    SERPENTS_TONGUE(new TextModifier(new TextObject(""))),
    MECHANICUS_IMPLANTS(new TextModifier(new TextObject(""))),
    SORCERER(new SpecialModifier(SpecialType.CORRUPTION, 1), new TextModifier(new TextObject(SpecialType.PSYKER_BOUND.name()))),
    CHAOS_PSYKER(new SpecialModifier(SpecialType.CORRUPTION, 3 /* 1W5 */), new TextModifier(new TextObject(SpecialType.PSYKER_UNBOUND.name()))),
    THE_QUICK_AND_THE_DEAD(new SpecialModifier(SpecialType.INITIATIVE, 2));

    private List<Modifier<?>> modifiers;
    private boolean advancable;

    private TraitType(Modifier<?>... modifiers)
    {
        this(false, modifiers);
    }

    private TraitType(boolean advancable, Modifier<?>... modifiers)
    {
        this.advancable = advancable;
        this.modifiers = Arrays.asList(modifiers);
    }

    public String getName()
    {
        return this.name();
    }

    public boolean isAdvancable()
    {
        return this.advancable;
    }

    public List<Modifier<?>> getModifiers()
    {
        return this.modifiers;
    }

    @JsonCreator
    public static TraitType fromName(@JsonProperty("name") String name)
    {
        if (name == null)
        {
            return null;
        }

        for (TraitType type : TraitType.values())
        {
            if (type.getName().equalsIgnoreCase(name))
            {
                return type;
            }
        }
        return null;
    }
}
