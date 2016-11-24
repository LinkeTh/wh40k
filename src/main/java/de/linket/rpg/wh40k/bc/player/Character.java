package de.linket.rpg.wh40k.bc.player;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import de.linket.rpg.wh40k.bc.alignment.Alignment;
import de.linket.rpg.wh40k.bc.alignment.AlignmentTracker;
import de.linket.rpg.wh40k.bc.characteristics.Characteristic;
import de.linket.rpg.wh40k.bc.common.GameObject;
import de.linket.rpg.wh40k.bc.exp.Experience;
import de.linket.rpg.wh40k.bc.modifier.Modifier;
import de.linket.rpg.wh40k.bc.player.inventory.Inventory;
import de.linket.rpg.wh40k.bc.skills.Skill;
import de.linket.rpg.wh40k.bc.skills.SkillModifier;
import de.linket.rpg.wh40k.bc.special.Initiative;
import de.linket.rpg.wh40k.bc.special.PsyRating;
import de.linket.rpg.wh40k.bc.special.Wounds;
import de.linket.rpg.wh40k.bc.talents.Talent;
import de.linket.rpg.wh40k.bc.types.AlignmentType;
import de.linket.rpg.wh40k.bc.types.CharacterStateType;
import de.linket.rpg.wh40k.bc.types.CharacteristicType;
import de.linket.rpg.wh40k.bc.types.ClassType;
import de.linket.rpg.wh40k.bc.types.DisgraceType;
import de.linket.rpg.wh40k.bc.types.MotivationType;
import de.linket.rpg.wh40k.bc.types.PrideType;
import de.linket.rpg.wh40k.bc.types.RaceType;
import de.linket.rpg.wh40k.bc.types.SkillStateType;
import de.linket.rpg.wh40k.bc.types.SkillType;
import de.linket.rpg.wh40k.bc.types.SpecialType;
import de.linket.rpg.wh40k.bc.types.TalentType;
import de.linket.rpg.wh40k.bc.util.StringUtil;

@JsonPropertyOrder({ "id", "name", "state", "clazz", "race", "wounds", "psyRating", "initiative", "pride", "disgrace", "motivation",
                "characteristics", "skills", "talents" })
public class Character
{
    private CharacterStateType state;

    @SuppressWarnings("unused")
    private Inventory inventory;

    private AlignmentTracker alignments = new AlignmentTracker();

    private String id;

    private Set<Characteristic> characteristics = new HashSet<>();
    private ClassType clazz = null;
    private DisgraceType disgrace = null;

    private Experience exp = null;

    private Initiative initiative;

    private MotivationType motivation = null;
    private String name;

    private PrideType pride = null;
    private PsyRating psyRating;
    private RaceType race = null;

    private Set<Skill> skills = new HashSet<>();
    private Set<Talent> talents = new HashSet<>();
    private Wounds wounds;

    public Character(RaceType race)
    {
        super();
        this.id = UUID.randomUUID().toString();
        this.state = CharacterStateType.NEW;
        this.inventory = new Inventory(this);
        this.race = race;
        this.exp = race.getStartExperience();

        this.alignments.addAlignments(new Alignment(AlignmentType.UNDIVIDED));
    }

    public String getId()
    {
        return this.id;
    }

    public void setState(CharacterStateType state)
    {
        this.state = state;
    }

    public CharacterStateType getState()
    {
        return this.state;
    }

    public void addCharacteristic(Characteristic characteristic)
    {
        this.characteristics.add(characteristic);
    }

    public void addExp(Experience exp)
    {
        this.exp.addExp(exp.getExp());
    }

    public void addModifier(Modifier<?> modifier)
    {
        if ((modifier == null) || (modifier.getModifierType() == null) || (modifier.getType() == null))
        {
            return;
        }

        switch (modifier.getModifierType())
        {
            case CHARACTERISTIC:
            {
                Characteristic result = this.getCharacteristic((CharacteristicType) modifier.getType());

                if (result != null)
                {
                    result.addModifier(modifier);
                }

                break;
            }
            case CHARACTERISTIC_BONUS:
            {
                Characteristic result = this.getCharacteristic((CharacteristicType) modifier.getType());

                if (result != null)
                {
                    result.addBonusModifiers(modifier);
                }

                break;
            }
            case SKILL:
            {
                Skill result = this.getSkill((SkillType) modifier.getType());

                if ((result == null) && ((SkillModifier) modifier).shouldAddSkill())
                {
                    result = new Skill((SkillType) modifier.getType(), SkillStateType.UNLEARNED);
                    this.addSkill(result);
                }

                if (result != null)
                {
                    result.addModifier(modifier);
                }

                break;
            }
            case SPECIAL:
            {
                if (modifier.getType().equals(SpecialType.PSYRATING))
                {
                    this.getPsyRating().addModifier(modifier);
                }
                else if (modifier.getType().equals(SpecialType.WOUNDS))
                {
                    this.getWounds().addModifier(modifier);
                }
                else if (modifier.getType().equals(SpecialType.INITIATIVE))
                {
                    this.getInitiative().addModifier(modifier);
                }
                break;
            }
            default:
                break;

        }
    }

    public void addSkill(Skill skill)
    {
        if (!this.containsSkill(skill))
        {
            this.skills.add(skill);
        }
    }

    public void addTalent(Talent talent)
    {
        if (!this.containsTalent(talent))
        {
            this.talents.add(talent);
            if (!talent.getModifiers().isEmpty())
            {
                talent.getModifiers().forEach(i -> this.addModifier(i));
            }
        }
    }

    public void advanceCharacteristic(CharacteristicType type)
    {
        Experience cost = this.calculateCosts(type);

        Characteristic result = this.getCharacteristic(type);

        result.advance(cost);
    }

    public void advanceSkill(SkillType type)
    {
        Experience cost = this.calculateCosts(type);

        Skill result = this.getSkill(type);

        result.advance(cost);
    }

    public void advanceTalent(TalentType type)
    {
        Experience cost = this.calculateCosts(type);

        Talent talent = this.getTalent(type);

        if (!talent.getModifiers().isEmpty())
        {
            talent.getModifiers().forEach(i -> this.removeModifier(i));
        }

        talent.advance(cost);

        if (!talent.getModifiers().isEmpty())
        {
            talent.getModifiers().forEach(i -> this.addModifier(i));
        }
    }

    private Experience calculateCosts(GameObject type)
    {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean containsSkill(Skill skill)
    {
        return this.getSkills().contains(skill);
    }

    public boolean containsTalent(Talent talent)
    {
        return this.getTalents().contains(talent);
    }

    public Characteristic getCharacteristic(CharacteristicType type)
    {
        List<Characteristic> result = this.getCharacteristics().stream().filter(i -> i.getType().equals(type)).collect(Collectors.toList());

        if ((result == null) || result.isEmpty())
        {
            return null;
        }
        return result.get(0);
    }

    public Set<Characteristic> getCharacteristics()
    {
        return this.characteristics;
    }

    public ClassType getClazz()
    {
        return this.clazz;
    }

    public DisgraceType getDisgrace()
    {
        return this.disgrace;
    }

    public Experience getExp()
    {
        return this.exp;
    }

    public Initiative getInitiative()
    {
        return this.initiative;
    }

    public MotivationType getMotivation()
    {
        return this.motivation;

    }

    public String getName()
    {
        return this.name;
    }

    public PrideType getPride()
    {
        return this.pride;
    }

    public PsyRating getPsyRating()
    {
        return this.psyRating;
    }

    public RaceType getRace()
    {
        return this.race;
    }

    public Skill getSkill(SkillType type)
    {
        List<Skill> result = this.getSkills().stream().filter(i -> i.getType().equals(type)).collect(Collectors.toList());

        if ((result == null) || result.isEmpty())
        {
            return null;
        }
        return result.get(0);
    }

    public Set<Skill> getSkills()
    {
        return this.skills;
    }

    public Talent getTalent(TalentType type)
    {
        List<Talent> result = this.getTalents().stream().filter(i -> i.getType().equals(type)).collect(Collectors.toList());

        if ((result == null) || result.isEmpty())
        {
            return null;
        }
        return result.get(0);
    }

    public Set<Talent> getTalents()
    {
        return new HashSet<>(this.talents);
    }

    public Wounds getWounds()
    {
        return this.wounds;
    }

    public void learnSkill(SkillType type)
    {
        Experience cost = this.calculateCosts(type);
        this.removeExp(cost);

        Skill skill = new Skill(type);
        if (!this.containsSkill(skill))
        {
            this.addSkill(skill);
        }
    }

    public void learnTalent(TalentType type)
    {
        Experience cost = this.calculateCosts(type);
        this.removeExp(cost);

        Talent talent = new Talent(type);
        if (!this.containsTalent(talent))
        {
            this.addTalent(talent);
        }
    }

    public void removeExp(Experience exp)
    {
        this.exp.removeExp(exp.getExp());
    }

    public void removeModifier(Modifier<?> modifier)
    {
        if ((modifier == null) || (modifier.getModifierType() == null) || (modifier.getType() == null))
        {
            return;
        }

        switch (modifier.getModifierType())
        {
            case CHARACTERISTIC:
            {
                List<Characteristic> result =
                                this.getCharacteristics().stream().filter(i -> i.getType().equals(modifier.getType())).collect(Collectors.toList());

                if (result.size() == 1)
                {
                    result.get(0).removeModifier(modifier);
                }

                break;
            }
            case CHARACTERISTIC_BONUS:
            {
                List<Characteristic> result =
                                this.getCharacteristics().stream().filter(i -> i.getType().equals(modifier.getType())).collect(Collectors.toList());

                if (result.size() == 1)
                {
                    result.get(0).removeBonusModifiers(modifier);
                }

                break;
            }
            case SKILL:
            {
                List<Skill> result = this.getSkills().stream().filter(i -> i.getType().equals(modifier.getType())).collect(Collectors.toList());

                if (result.size() == 1)
                {
                    result.get(0).removeModifier(modifier);
                }

                break;
            }
            case SPECIAL:
            {
                if (modifier.getType().equals(SpecialType.PSYRATING))
                {
                    this.getPsyRating().removeModifier(modifier);
                }
                else if (modifier.getType().equals(SpecialType.WOUNDS))
                {
                    this.getWounds().removeModifier(modifier);
                }
                break;
            }
            default:
                break;

        }
    }

    public void setAlignments(AlignmentTracker alignments)
    {
        this.alignments = alignments;
    }

    public AlignmentTracker getAlignments()
    {
        return this.alignments;
    }

    public void setCharacteristics(Set<Characteristic> characteristics)
    {
        this.characteristics = characteristics;
    }

    public void setClazz(ClassType clazz)
    {
        this.clazz = clazz;
    }

    public void setDisgrace(DisgraceType disgrace)
    {
        this.disgrace = disgrace;
        if (!disgrace.getModifiers().isEmpty())
        {
            disgrace.getModifiers().forEach(i -> this.addModifier(i));
        }
    }

    public void setInitiative(Initiative initiative)
    {
        this.initiative = initiative;
    }

    public void setMotivation(MotivationType motivation)
    {
        this.motivation = motivation;
        if (!motivation.getModifiers().isEmpty())
        {
            motivation.getModifiers().forEach(i -> this.addModifier(i));
        }
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPride(PrideType pride)
    {
        this.pride = pride;
        if (!pride.getModifiers().isEmpty())
        {
            pride.getModifiers().forEach(i -> this.addModifier(i));
        }
    }

    public void setPsyRating(PsyRating psyRating)
    {
        this.psyRating = psyRating;
    }

    public void setRace(RaceType race)
    {
        this.race = race;
    }

    public void setWounds(Wounds wound)
    {
        this.wounds = wound;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("################ Character ################");
        builder.append("\n" + StringUtil.padRight("name", 20) + "= ");
        builder.append(this.name);
        builder.append("\n");

        builder.append("\n" + StringUtil.padRight("race", 20) + "= ");
        builder.append(this.race);
        builder.append("\n" + StringUtil.padRight("class", 20) + "= ");
        builder.append(this.clazz);
        builder.append("\n" + StringUtil.padRight("wounds", 20) + "= ");
        builder.append(this.wounds);
        builder.append("\n" + StringUtil.padRight("psyRating", 20) + "= ");
        builder.append(this.psyRating);
        builder.append("\n" + StringUtil.padRight("initiative", 20) + "= ");
        builder.append(this.initiative);
        builder.append("\n");

        builder.append("\n" + StringUtil.padRight("pride", 20) + "= ");
        builder.append(this.pride);
        builder.append("\n" + StringUtil.padRight("disgrace", 20) + "= ");
        builder.append(this.disgrace);
        builder.append("\n" + StringUtil.padRight("motivation", 20) + "= ");
        builder.append(this.motivation);
        builder.append("\n");

        builder.append("\n" + StringUtil.padRight("exp", 20) + "= ");
        builder.append(this.exp);
        builder.append("\n");

        builder.append("\ncharacteristics:\n");
        this.characteristics.forEach(l -> builder.append("\t").append(l).append("\n"));

        builder.append("skills:\n");
        this.skills.forEach(l -> builder.append("\t").append(l).append("\n"));

        builder.append("talents:\n");
        this.talents.forEach(l -> builder.append("\t").append(l).append("\n"));

        return builder.toString();
    }
}
