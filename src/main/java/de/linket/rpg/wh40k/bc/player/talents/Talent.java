package de.linket.rpg.wh40k.bc.player.talents;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import de.linket.rpg.wh40k.bc.common.GameObject;
import de.linket.rpg.wh40k.bc.exp.Experience;
import de.linket.rpg.wh40k.bc.modifier.Modifier;
import de.linket.rpg.wh40k.bc.player.advances.Advanceable;
import de.linket.rpg.wh40k.bc.types.TalentType;
import de.linket.rpg.wh40k.bc.util.StringUtil;

public class Talent implements GameObject, Advanceable
{
    private int advances;
    private List<Modifier<?>> modifiers = new ArrayList<>();

    private TalentType type;

    public Talent(TalentType type)
    {
        super();
        this.type = type;
        this.modifiers = type.getModifiers();
        this.advances = 1;
    }

    @Override
    public void advance(Experience cost)
    {
        if (this.getType().isAdvancable())
        {
            this.advances++;
            this.modifiers = this.modifiers.stream().flatMap(m -> Stream.generate(() -> m).limit(this.getAdvances())).collect(Collectors.toList());
            // this.modifiers.addAll(this.modifiers.stream().flatMap(m -> Stream.generate(() ->
            // m).limit(this.getAdvances())).collect(Collectors.toList()));
        }
    }

    public int getAdvances()
    {
        return this.advances;
    }

    public TalentType getType()
    {
        return this.type;
    }

    public List<Modifier<?>> getModifiers()
    {
        return this.modifiers;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append(StringUtil.padRight(this.getType().name(), 40));
        builder.append(" = ");

        this.modifiers.forEach(l -> builder.append(l).append(" "));

        return builder.toString();
    }
}
