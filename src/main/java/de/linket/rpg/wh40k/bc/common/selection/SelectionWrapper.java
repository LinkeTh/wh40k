package de.linket.rpg.wh40k.bc.common.selection;

import java.util.List;

public interface SelectionWrapper<T>
{
    public List<SelectionContainer<T>> getSelectionContainer();
}
