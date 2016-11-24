package de.linket.rpg.wh40k.bc.common.selection;

import java.util.List;

public interface SelectionContainer<T>
{
    public SelectionType getType();

    public List<T> getValues();
}
