package de.linket.rpg.wh40k.bc.dice;

import de.linket.rpg.wh40k.bc.types.DiceType;

public class DefaultRollImpl implements MultiDiceRoll
{
    private DiceType dice;
    private Integer numberOfDice;

    public DefaultRollImpl(DiceType dice, Integer numberOfDice)
    {
        super();
        this.dice = dice;
        this.numberOfDice = numberOfDice;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.numberOfDice);
        sb.append(this.dice);
        return sb.toString();
    }

    @Override
    public DiceType getDice()
    {
        return this.dice;
    }

    @Override
    public void setDice(DiceType dice)
    {
        this.dice = dice;
    }

    @Override
    public Integer getNumberOfDice()
    {
        return this.numberOfDice;
    }

    @Override
    public void setNumberOfDice(Integer numberOfDice)
    {
        this.numberOfDice = numberOfDice;
    }
}
