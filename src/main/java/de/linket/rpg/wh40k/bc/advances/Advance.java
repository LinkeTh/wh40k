package de.linket.rpg.wh40k.bc.advances;

import de.linket.rpg.wh40k.bc.common.Modifier;
import de.linket.rpg.wh40k.bc.exp.Experience;

public interface Advance<T extends Modifier<?>> {

	public T getModifier();

	public Experience getCosts();
}
