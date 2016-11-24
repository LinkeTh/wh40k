package de.linket.rpg.wh40k.bc.types;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import de.linket.rpg.wh40k.bc.common.GameObject;
import de.linket.rpg.wh40k.bc.common.TextObject;
import de.linket.rpg.wh40k.bc.modifier.Modifier;
import de.linket.rpg.wh40k.bc.modifier.TextModifier;
import de.linket.rpg.wh40k.bc.player.characteristics.CharacteristicBonusModifier;
import de.linket.rpg.wh40k.bc.player.characteristics.CharacteristicModifier;
import de.linket.rpg.wh40k.bc.player.skills.SkillModifier;
import de.linket.rpg.wh40k.bc.player.special.SpecialModifier;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TalentType implements GameObject
{
    BLA(new SpecialModifier(SpecialType.WOUNDS, 3)),
    FAST(new CharacteristicModifier(CharacteristicType.AGILITY, 2)),
    YOUNG(new CharacteristicBonusModifier(CharacteristicType.INTELLIGENCE, 3)),
    FAT(new SkillModifier(SkillType.MEDICAE, 10)),
    RESISTANCE(true),
    RESISTANCE_POISON(RESISTANCE, new TextModifier(new TextObject("INCREASED POISON RESISTANCE"))),
    RESISTANCE_FIRE(RESISTANCE, new TextModifier(new TextObject("INCREASED FIRE RESISTANCE"))),
    TODO(new SkillModifier(SkillType.DODGE, 10));

    private List<Modifier<?>> modifiers;
    private boolean advancable;
    private TalentType parent;
    private boolean specialisable;

    private TalentType(boolean specialisable, TalentType parent, boolean advancable, Modifier<?>... modifiers)
    {
        this.specialisable = specialisable;
        this.advancable = advancable;
        this.parent = parent;
        if (modifiers != null)
        {
            this.modifiers = Arrays.asList(modifiers);
        }
    }

    private TalentType(boolean specialisable, TalentType parent, boolean advancable)
    {
        this.specialisable = specialisable;
        this.advancable = advancable;
        this.parent = parent;
        this.modifiers = null;
    }

    private TalentType(TalentType parent, Modifier<?>... modifiers)
    {
        this(false, parent, false, modifiers);
    }

    private TalentType(boolean specialisable)
    {
        this(specialisable, null, false);
    }

    private TalentType(boolean advancable, Modifier<?>... modifiers)
    {
        this(false, null, advancable, modifiers);
    }

    private TalentType(Modifier<?>... modifiers)
    {
        this(false, null, false, modifiers);
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

    @JsonIgnore
    public TalentType getParent()
    {
        return this.parent;
    }

    public boolean isSpecialisable()
    {
        return this.specialisable;
    }

    @JsonIgnore
    public List<TalentType> getAvailableSubTypes()
    {
        return Arrays.asList(TalentType.values()).stream().filter(st -> this.equals(st.parent)).collect(Collectors.toList());
    }

    @JsonCreator
    public static TalentType fromName(@JsonProperty("name") String name)
    {
        if (name == null)
        {
            return null;
        }

        for (TalentType type : TalentType.values())
        {
            if (type.getName().equalsIgnoreCase(name))
            {
                return type;
            }
        }
        return null;
    }
}
