package de.linket.rpg.wh40k.bc.common;

public interface Modifier<T extends GameObject> extends GameValue<T>
{
	public ModifierType getModifierType();
}
