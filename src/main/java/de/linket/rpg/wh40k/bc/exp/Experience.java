package de.linket.rpg.wh40k.bc.exp;

public final class Experience
{
	private long exp;

	public Experience()
	{
		this(0);
	}

	public Experience(long startValue)
	{
		super();
		this.exp = startValue;
	}

	public long getExp()
	{
		return this.exp;
	}

	public void addExp(long value)
	{
		this.exp += value;
	}

	public void removeExp(long value)
	{
		this.exp -= value;
	}


	@Override
	public String toString()
	{
		return String.valueOf(this.exp);
	}

}
