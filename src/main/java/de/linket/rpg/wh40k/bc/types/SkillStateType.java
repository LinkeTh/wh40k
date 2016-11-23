package de.linket.rpg.wh40k.bc.types;

import com.fasterxml.jackson.annotation.JsonFormat;

import de.linket.rpg.wh40k.bc.common.GameObject;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum SkillStateType implements GameObject
{
    UNLEARNED(-20),
    KNOWN(0),
    TRAINED(10),
    EXPERIENCED(20),
    VETERAN(30),
    UNDEFINED(-9999);

    private int value;

    private SkillStateType(int modifier)
    {
        this.value = modifier;
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
