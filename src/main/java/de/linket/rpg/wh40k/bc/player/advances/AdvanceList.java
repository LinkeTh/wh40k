package de.linket.rpg.wh40k.bc.player.advances;

import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AdvanceList<T extends Advance<?>>
{
    private List<T> advances = new LinkedList<>();

    private int limit;

    public AdvanceList()
    {
        super();
    }

    public AdvanceList(int limit)
    {
        super();
        this.limit = limit;
    }

    public List<T> getAdvances()
    {
        return this.advances;
    }

    public void setAdvances(List<T> advances)
    {
        this.advances = advances;
    }

    @JsonIgnore
    public int size()
    {
        return this.advances.size();
    }

    @JsonIgnore
    public boolean isFirstAdvance()
    {
        return this.advances.isEmpty();
    }

    @JsonIgnore
    public boolean hasAdvanceLeft()
    {
        if (this.limit == 0)
        {
            return true;
        }

        return this.advances.size() < this.limit;
    }

    @JsonIgnore
    public T addAdvance(T advance)
    {
        if (this.hasAdvanceLeft())
        {
            this.advances.add(advance);
            return advance;
        }
        return null;
    }
}
