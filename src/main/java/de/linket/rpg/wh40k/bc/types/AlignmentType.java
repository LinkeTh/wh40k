package de.linket.rpg.wh40k.bc.types;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import de.linket.rpg.wh40k.bc.common.GameObject;
import de.linket.rpg.wh40k.bc.modifier.Modifier;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum AlignmentType implements GameObject
{
    UNDIVIDED,
    SLANEESH,
    KHORNE,
    NURGLE,
    TZECHN;

    private List<Modifier<?>> modifiers;

    private AlignmentType(Modifier<?>... modifiers)
    {
        this.modifiers = Arrays.asList(modifiers);
    }

    public String getName()
    {
        return this.name();
    }

    public List<Modifier<?>> getModifiers()
    {
        return this.modifiers;
    }
}
