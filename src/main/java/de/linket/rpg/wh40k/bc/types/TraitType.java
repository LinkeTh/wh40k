package de.linket.rpg.wh40k.bc.types;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import de.linket.rpg.wh40k.bc.characteristics.CharacteristicModifier;
import de.linket.rpg.wh40k.bc.common.GameObject;
import de.linket.rpg.wh40k.bc.common.TextObject;
import de.linket.rpg.wh40k.bc.modifier.Modifier;
import de.linket.rpg.wh40k.bc.modifier.TextModifier;
import de.linket.rpg.wh40k.bc.skills.SkillModifier;
import de.linket.rpg.wh40k.bc.special.SpecialModifier;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TraitType implements GameObject
{
    BIG(new SpecialModifier(SpecialType.WOUNDS, 3)),
    AMPHIB(new CharacteristicModifier(CharacteristicType.AGILITY, 2)),
    FAT(new TextModifier(new TextObject("BLA BLA BLA BLABLABLAA"))),
    TODO(new SkillModifier(SkillType.DODGE, 10));

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
