package de.linket.rpg.wh40k.bc.dice;

import de.linket.rpg.wh40k.bc.types.DiceType;

public class DefaultBonusRollImpl implements BonusMultiDiceRoll
{

	private DiceType dice;
	private Integer numberOfDice;
	private Integer bonus;

	public DefaultBonusRollImpl()
	{
		super();
	}

	public DefaultBonusRollImpl(DiceType dice, Integer numberOfDice, Integer bonus)
	{
		super();
		this.dice = dice;
		this.numberOfDice = numberOfDice;
		this.bonus = bonus;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(this.numberOfDice);
		sb.append(this.dice);
		if (this.bonus > 0)
		{
			sb.append("+");
		}

		sb.append(this.bonus);
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

	@Override
	public Integer getBonus()
	{
		return this.bonus;
	}

	@Override
	public void setBonus(Integer bonus)
	{
		this.bonus = bonus;
	}

}
