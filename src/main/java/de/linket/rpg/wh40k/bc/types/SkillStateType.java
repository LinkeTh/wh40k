package de.linket.rpg.wh40k.bc.types;

import com.fasterxml.jackson.annotation.JsonFormat;

import de.linket.rpg.wh40k.bc.common.GameObject;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum SkillStateType implements GameObject
{
    UNLEARNED(-20, 0),
    KNOWN(0, 1),
    TRAINED(10, 2),
    EXPERIENCED(20, 3),
    VETERAN(30, 4),
    UNDEFINED(-9999, 0);

    private int value;
    private int advance;

    private SkillStateType(int modifier, int advance)
    {
        this.value = modifier;
        this.advance = advance;
    }

    public int getAdvance()
    {
        return this.advance;
    }

    public String getName()
    {
        return this.name();
    }

    public int getValue()
    {
        return this.value;
    }

    public static SkillStateType getByValue(int modifier)
    {
        for (SkillStateType item : SkillStateType.values())
        {
            if (item.getValue() == modifier)
            {
                return item;
            }
        }
        return UNDEFINED;
    }
}
