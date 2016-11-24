package de.linket.rpg.wh40k.bc.player.characteristics;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.linket.rpg.wh40k.bc.common.RollableGameValue;
import de.linket.rpg.wh40k.bc.dice.DefaultBonusRollImpl;
import de.linket.rpg.wh40k.bc.exp.Experience;
import de.linket.rpg.wh40k.bc.modifier.Modifier;
import de.linket.rpg.wh40k.bc.player.advances.AdvanceList;
import de.linket.rpg.wh40k.bc.player.advances.Advanceable;
import de.linket.rpg.wh40k.bc.types.CharacteristicType;
import de.linket.rpg.wh40k.bc.types.RaceType;
import de.linket.rpg.wh40k.bc.util.StringUtil;

public class Characteristic extends RollableGameValue<CharacteristicType, DefaultBonusRollImpl> implements Advanceable
{
    private int bonus;
    private int modifiedBonus;
    private List<Modifier<?>> bonusModifiers = new ArrayList<>();
    private static final int ADVANCE_LIMIT = 4;
    private AdvanceList<CharacteristicAdvance> advances = new AdvanceList<>(ADVANCE_LIMIT);

    @SuppressWarnings("unused")
    private Characteristic()
    {
    }

    public Characteristic(CharacteristicType type, RaceType race)
    {
        super(type, new DefaultBonusRollImpl(type.getDice(), type.getNumberOfDice(), race.getCharacteristicBonus()));

        if (type.getMaxBonus() != null)
        {
            this.getRoll().setBonus(type.getMaxBonus());
        }
    }

    @JsonIgnore
    @Override
    public void advance(Experience cost)
    {
        if (this.advances.hasAdvanceLeft())
        {
            CharacteristicAdvance advance = new CharacteristicAdvance(cost);
            this.addAdvance(advance);
        }
    }

    public List<Modifier<?>> getBonusModifiers()
    {
        return this.bonusModifiers;
    }

    public void setBonusModifiers(List<Modifier<?>> bonusModifiers)
    {
        this.bonusModifiers = bonusModifiers;
    }

    public int getModifiedBonus()
    {
        this.modifiedBonus = this.getBonus();

        this.modifiedBonus += this.bonusModifiers.stream().mapToInt(i -> i.getValue()).sum();

        return this.modifiedBonus;
    }

    public void setModifiedBonus(int modifiedBonus)
    {
    }

    public int getBonus()
    {
        this.bonus = this.getValue() / 10;
        return this.bonus;
    }

    public void setBonus(int bonus)
    {
    }

    public AdvanceList<CharacteristicAdvance> getAdvances()
    {
        return this.advances;
    }

    public void setAdvances(AdvanceList<CharacteristicAdvance> advances)
    {
        this.advances = advances;
    }

    @JsonIgnore
    public void addBonusModifiers(Modifier<?> bonusModifier)
    {
        this.bonusModifiers.add(bonusModifier);
    }

    @JsonIgnore
    public void removeBonusModifiers(Modifier<?> bonusModifier)
    {
        this.bonusModifiers.remove(bonusModifier);
    }

    @JsonIgnore
    private void addAdvance(CharacteristicAdvance advance)
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
        builder.append(this.getValue());
        builder.append(" (");
        builder.append(this.getModifiedBonus());
        builder.append(")");
        builder.append(" | ");
        builder.append(this.getRollValue());
        builder.append(" (");
        builder.append(this.getBonus());
        builder.append(")");

        return builder.toString();
    }
}
