package de.linket.rpg.wh40k.bc.common;

public interface GameValue<T extends GameObject> extends GameItem<T>
{
	public int getValue();

}
