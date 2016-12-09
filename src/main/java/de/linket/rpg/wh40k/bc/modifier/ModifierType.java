package de.linket.rpg.wh40k.bc.modifier;

public enum ModifierType
{
    SKILL(Values.SKILL),
    CHARACTERISTIC_BONUS(Values.ATTRIBUTE_BONUS),
    SPECIAL(Values.SPECIAL),
    TEXT(Values.TEXT),
    ATTRIBUTE(Values.ATTRIBUTE),
    ATTRIBUTE_BONUS(Values.ATTRIBUTE_BONUS),
    CHARACTERISTIC(Values.ATTRIBUTE);

    private String value;

    ModifierType(String value)
    {
        this.value = value;
    }

    public String getValue()
    {
        return this.value;
    }

    public static class Values
    {
        public static final String SKILL = "SKILL";
        public static final String ATTRIBUTE_BONUS = "ATTRIBUTE_BONUS";
        public static final String SPECIAL = "SPECIAL";
        public static final String TEXT = "TEXT";
        public static final String ATTRIBUTE = "ATTRIBUTE";
    }
}
