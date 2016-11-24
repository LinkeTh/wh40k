package de.linket.rpg.wh40k.bc.common;

import com.fasterxml.jackson.annotation.*;

import de.linket.rpg.wh40k.bc.modifier.Modifier;

import java.util.ArrayList;
import java.util.List;

public abstract class ModifiableGameValue<T extends GameObject> implements GameValue<T> {
	protected T type;
	protected List<Modifier<?>> modifiers = new ArrayList<>();
	protected int startValue;
	protected int value;

	protected ModifiableGameValue() {
	}

	protected ModifiableGameValue(T type) {
		this.type = type;
		this.startValue = 0;
	}

	protected ModifiableGameValue(T type, int startValue) {
		this.type = type;
		this.startValue = startValue;
	}

	@SuppressWarnings("unused")
	private void setStartValue(int startValue) {
		this.startValue = startValue;
	}

	public int getStartValue() {
		return this.startValue;
	}

	@SuppressWarnings("unused")
	private void setType(T type) {
	}

	@Override
	public T getType() {
		return this.type;
	}

	@SuppressWarnings("unused")
	private void setValue(int value) {
		this.value = value;
	}

	@Override
	public int getValue() {
		this.value = this.startValue;

		this.value += this.modifiers.stream().mapToInt(i -> i.getValue()).sum();

		return this.value;
	}

	@JsonIgnore
	public void addModifier(Modifier<?> modifier) {
		this.modifiers.add(modifier);
	}

	@JsonIgnore
	public void removeModifier(Modifier<?> modifier) {
		this.modifiers.remove(modifier);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((this.type == null) ? 0 : this.type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		ModifiableGameValue<?> other = (ModifiableGameValue<?>) obj;
		if (this.type == null) {
			if (other.type != null) {
				return false;
			}
		} else if (!this.type.equals(other.type)) {
			return false;
		}
		return true;
	}

}