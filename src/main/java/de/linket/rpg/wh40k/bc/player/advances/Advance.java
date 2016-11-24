package de.linket.rpg.wh40k.bc.player.advances;

import de.linket.rpg.wh40k.bc.exp.Experience;
import de.linket.rpg.wh40k.bc.modifier.Modifier;

public interface Advance<T extends Modifier<?>>
{

    public T getModifier();

    public Experience getCosts();
}
