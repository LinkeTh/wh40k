package de.linket.rpg.wh40k.bc.modifier;

import de.linket.rpg.wh40k.bc.common.GameObject;
import de.linket.rpg.wh40k.bc.common.GameValue;

public interface Modifier<T extends GameObject> extends GameValue<T>
{
	public ModifierType getModifierType();
}
