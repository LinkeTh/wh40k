package de.linket.rpg.wh40k.bc.common;

public class SimpleIntegerValue {

	private int value;

	public SimpleIntegerValue(int value) {
		super();

		if ((value > 0) && (value < 10)) {
			this.value = value;
		}
	}

	public int getValue() {
		return this.value;
	}

	@Override
	public String toString() {
		return String.valueOf( this.value);
	}
}
