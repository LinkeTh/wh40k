package de.linket.rpg.wh40k.bc.player.alignment;

import de.linket.rpg.wh40k.bc.common.ModifiableGameValue;
import de.linket.rpg.wh40k.bc.exp.Experience;
import de.linket.rpg.wh40k.bc.player.advances.Advanceable;
import de.linket.rpg.wh40k.bc.types.AlignmentType;
import de.linket.rpg.wh40k.bc.util.StringUtil;

public class Alignment extends ModifiableGameValue<AlignmentType> implements Advanceable
{
    private int advances;

    public Alignment(AlignmentType type)
    {
        super(type);
        this.advances = 1;
    }

    @Override
    public void advance(Experience cost)
    {
        this.advances++;
    }

    public int getAdvances()
    {
        return this.advances;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append(StringUtil.padRight(this.getType().name(), 40));

        return builder.toString();
    }
}
