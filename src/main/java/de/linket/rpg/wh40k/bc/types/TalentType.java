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

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TalentType implements GameObject
{
    AMBIDEXTROUS(new TextModifier(new TextObject(""))),
    BULGING_BICEPS(new TextModifier(new TextObject(""))),
    LEGION_WEAPON_TRAINING(new TextModifier(new TextObject(""))),
    HEIGHTENED_SENSES(true),
    HEIGHTENED_SENSES_HEARING(HEIGHTENED_SENSES, new TextModifier(new TextObject(""))),
    HEIGHTENED_SENSES_SIGHT(HEIGHTENED_SENSES, new TextModifier(new TextObject(""))),
    NERVES_OF_STEEL(new TextModifier(new TextObject(""))),
    QUICK_DRAW(new TextModifier(new TextObject(""))),
    RESISTANCE(true),
    RESISTANCE_POISON(RESISTANCE, new TextModifier(new TextObject("INCREASED POISON RESISTANCE"))),
    RESISTANCE_HEAT(RESISTANCE, new TextModifier(new TextObject("INCREASED FIRE RESISTANCE"))),
    RESISTANCE_COLD(RESISTANCE, new TextModifier(new TextObject("INCREASED FIRE RESISTANCE"))),
    UNARMED_WARRIOR(new TextModifier(new TextObject(""))),
    IRON_DISCIPLE(new TextModifier(new TextObject(""))),
    AIR_OF_AUTHORITY(new TextModifier(new TextObject(""))),
    DISTURBING_VOICE(new TextModifier(new TextObject(""))),
    LESSER_MINON_OF_CHAOS(new TextModifier(new TextObject(""))),
    LIGHTNING_REFLEXES(new TextModifier(new TextObject(""))),
    RAPID_RELOAD(new TextModifier(new TextObject(""))),
    DISARM(new TextModifier(new TextObject(""))),
    DOUBLE_TEAM(new TextModifier(new TextObject(""))),
    MEDITATION(new TextModifier(new TextObject(""))),
    WARP_SENSE(new TextModifier(new TextObject(""))),
    CHILD_OF_THE_WARP(new TextModifier(new TextObject(""))),
    MIMIC(new TextModifier(new TextObject(""))),
    TECHNICAL_KNOCK(new TextModifier(new TextObject(""))),
    DIE_HARD(new TextModifier(new TextObject(""))),
    DEADEYE_SHOT(new TextModifier(new TextObject(""))),
    ARMOUR_MONGER(new TextModifier(new TextObject(""))),
    WEAPON_TECH(new TextModifier(new TextObject(""))),
    CATFALL(new TextModifier(new TextObject(""))),
    COMBAT_SENSE(new TextModifier(new TextObject(""))),
    MARKSMAN(new TextModifier(new TextObject(""))),
    TAKEDOWN(new TextModifier(new TextObject(""))),
    HIP_SHOOTING(new TextModifier(new TextObject(""))),
    MECHADENDRITE_TRAINING(true),
    MECHADENDRITE_TRAINING_WEAPON(MECHADENDRITE_TRAINING, new TextModifier(new TextObject(""))),
    MECHADENDRITE_TRAINING_UTILITY(MECHADENDRITE_TRAINING, new TextModifier(new TextObject(""))),
    ENEMY(true),
    ENEMY_ADEPTUS_MECHANICUS(ENEMY, new TextModifier(new TextObject(""))),
    PEER(true),
    PEER_TODO(PEER, new TextModifier(new TextObject(""))),
    HATRED(true),
    HATRED_ORCS(HATRED, new TextModifier(new TextObject(""))),
    HATRED_ELDAR(HATRED, new TextModifier(new TextObject(""))),
    HATRED_HUMANS(HATRED, new TextModifier(new TextObject(""))),
    HATRED_TODO(HATRED, new TextModifier(new TextObject(""))),
    JADED(new TextModifier(new TextObject(""))),
    LIGHT_SLEEPER(new TextModifier(new TextObject(""))),
    BLIND_FIGHTING(new TextModifier(new TextObject(""))),
    COLD_HEARTED(new TextModifier(new TextObject(""))),
    SOUND_CONSTITUTION(new TextModifier(new TextObject(""))),
    TOTAL_RECAL(new TextModifier(new TextObject(""))),
    UNSHAKEABLE_WILL(new TextModifier(new TextObject(""))),
    WEAPON_TRAINING(true),
    WEAPON_TRAINING_LASER(WEAPON_TRAINING, new TextModifier(new TextObject(""))),
    WEAPON_TRAINING_PRIMARY(WEAPON_TRAINING, new TextModifier(new TextObject(""))),
    WEAPON_TRAINING_SHOCK(WEAPON_TRAINING, new TextModifier(new TextObject(""))),
    WEAPON_TRAINING_BOLT(WEAPON_TRAINING, new TextModifier(new TextObject(""))),
    WEAPON_TRAINING_PLASMA(WEAPON_TRAINING, new TextModifier(new TextObject(""))),
    WEAPON_TRAINING_POWER(WEAPON_TRAINING, new TextModifier(new TextObject(""))),
    WEAPON_TRAINING_CHAIN(WEAPON_TRAINING, new TextModifier(new TextObject(""))),
    WEAPON_TRAINING_SOLID_PROJECTILE(WEAPON_TRAINING, new TextModifier(new TextObject(""))),
    WEAPON_TRAINING_HEAVY(WEAPON_TRAINING, new TextModifier(new TextObject(""))),
    RADIANT_PRESENCE(new TextModifier(new TextObject(""))),
    POLYGLOT(new TextModifier(new TextObject(""))),
    INSPIRE_WRATH(new TextModifier(new TextObject(""))),
    SURE_STRIKE(new TextModifier(new TextObject("")));

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
