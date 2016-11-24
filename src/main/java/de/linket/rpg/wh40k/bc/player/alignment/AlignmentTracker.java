package de.linket.rpg.wh40k.bc.player.alignment;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import de.linket.rpg.wh40k.bc.types.AlignmentType;

public class AlignmentTracker
{
    List<Alignment> alignments = new ArrayList<>();

    public AlignmentTracker()
    {
        super();
    }

    public List<Alignment> getAlignments()
    {
        return this.alignments;
    }

    public void setAlignments(List<Alignment> alignments)
    {
        this.alignments = alignments;
    }

    public void addAlignments(Alignment alignment)
    {
        this.alignments.add(alignment);
    }

    public void advanceAlignment(AlignmentType type)
    {
        this.getAlignment(type).advance(null);
    }

    public Alignment getAlignment(AlignmentType type)
    {
        List<Alignment> result = this.alignments.stream().filter(i -> i.getType().equals(type)).collect(Collectors.toList());

        if ((result == null) || result.isEmpty())
        {
            return null;
        }
        return result.get(0);
    }
}
