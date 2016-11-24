package de.linket.rpg.wh40k.bc.traits;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import de.linket.rpg.wh40k.bc.advances.Advanceable;
import de.linket.rpg.wh40k.bc.common.GameObject;
import de.linket.rpg.wh40k.bc.exp.Experience;
import de.linket.rpg.wh40k.bc.modifier.Modifier;
import de.linket.rpg.wh40k.bc.types.TraitType;
import de.linket.rpg.wh40k.bc.util.StringUtil;

public class Trait implements GameObject, Advanceable
{
    private int advances;
    private List<Modifier<?>> modifiers = new ArrayList<>();

    private TraitType type;

    public Trait(TraitType type)
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

    public TraitType getType()
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
