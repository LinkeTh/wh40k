package de.linket.rpg.wh40k.bc.common;

import de.linket.rpg.wh40k.bc.dice.BonusMultiDiceRoll;
import de.linket.rpg.wh40k.bc.modifier.Modifier;

import com.fasterxml.jackson.annotation.*;

public abstract class RollableGameValue<T extends GameObject, R extends BonusMultiDiceRoll> extends ModifiableGameValue<T> implements GameValue<T>
{
	protected int rollValue;
	protected R roll;

	protected RollableGameValue() {
	}

	protected RollableGameValue(T type, R roll)
	{
		super(type);
		this.roll = roll;
	}

	@JsonIgnore
	public void roll()
	{
		this.rollValue = 0;

		for (int i = 0; i < this.roll.getNumberOfDice(); i++)
		{
			this.rollValue += this.roll.getDice().roll();
		}

		this.rollValue += this.roll.getBonus();
	}

	public int getRollValue()
	{
		return this.rollValue;
	}

	@Override
	public int getValue()
	{
		int value = this.rollValue;

		for (Modifier<?> mod : this.modifiers)
		{
			value += mod.getValue();
		}

		return value;
	}

	public R getRoll()
	{
		return this.roll;
	}

	@SuppressWarnings("unused")
	private void setRoll(R roll) {
		this.roll = roll;
	}

	@SuppressWarnings("unused")
	private void setRollValue(int rollValue) {
		this.rollValue = rollValue;

	}
}