package de.linket.rpg.wh40k.bc.common;

public abstract class AbstractModifier<T extends GameObject> implements  Modifier<T>{

	protected T type;
	protected int value;

	public AbstractModifier() {
		super();
	}

	@Override
	public int getValue() {
		return this.value;
	}

	@Override
	public T getType() {
		return this.type;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.getType());
		builder.append(" +");
		builder.append(this.getValue());
		builder.append(" (");
		builder.append(this.getModifierType());
		builder.append(")");


		return builder.toString();
	}

}