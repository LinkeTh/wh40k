package de.linket.rpg.wh40k.bc.common.selection;

import java.util.Arrays;
import java.util.List;

public class DecisionComposer<T> implements SelectionContainer<T>
{
    private List<T> values;

    @SafeVarargs
    public DecisionComposer(T... options)
    {
        this.values = Arrays.asList(options);
    }

    @Override
    public List<T> getValues()
    {
        return this.values;
    }

    @Override
    public ContainerType getType()
    {
        return ContainerType.DECISION;
    }
}
