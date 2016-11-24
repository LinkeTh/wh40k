package de.linket.rpg.wh40k.bc.common.selection;

import java.util.ArrayList;
import java.util.List;

public class SingleComposer<T> implements SelectionContainer<T>
{
    private T value;

    public SingleComposer(T option)
    {
        this.value = option;
    }

    @Override
    public List<T> getValues()
    {
        List<T> result = new ArrayList<>(1);

        result.add(this.value);

        return result;
    }

    @Override
    public SelectionType getType()
    {
        return SelectionType.SINGLE;
    }
}
