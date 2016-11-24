package de.linket.rpg.wh40k.bc.common.selection;

import java.util.ArrayList;
import java.util.List;

public class MultiComposer<T> implements SelectionContainer<T>
{
    private T value;
    private int number;

    public MultiComposer(T option, int number)
    {
        this.value = option;
        this.number = number;
    }

    @Override
    public List<T> getValues()
    {
        List<T> result = new ArrayList<>(this.number);

        for (int i = 0; i < this.number; i++)
        {
            result.add(this.value);
        }

        return result;
    }

    @Override
    public SelectionType getType()
    {
        return SelectionType.MULTI;
    }
}
