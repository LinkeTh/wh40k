package de.linket.rpg.wh40k.bc.types;

import de.linket.rpg.wh40k.bc.common.GameObject;

public enum AttributeType implements GameObject
{
    AGILITY(DiceType.W10, 2),
    BALLISTIC_SKILL(DiceType.W10, 2),
    FELLOWSHIP(DiceType.W10, 2),
    INFAMY(DiceType.W5, 1, 19),
    INTELLIGENCE(DiceType.W10, 2),
    PERCEPTION(DiceType.W10, 2),
    STRENGTH(DiceType.W10, 2),
    TOUGHNESS(DiceType.W10, 2),
    WEAPON_SKILL(DiceType.W10, 2),
    WILLPOWER(DiceType.W10, 2);

    private DiceType dice;
    private Integer maxBonus;
    private Integer numberOfDice;

    private AttributeType(DiceType dice, Integer numberOfDice)
    {
        this(dice, numberOfDice, null);
    }

    private AttributeType(DiceType dice, Integer numberOfDice, Integer maxBonus)
    {
        this.dice = dice;
        this.numberOfDice = numberOfDice;
        this.maxBonus = maxBonus;
    }

    public DiceType getDice()
    {
        return this.dice;
    }

    public Integer getMaxBonus()
    {
        return this.maxBonus;
    }

    public Integer getNumberOfDice()
    {
        return this.numberOfDice;
    }
}
