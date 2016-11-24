package de.linket.rpg.wh40k.bc.common;

public class TextObject implements GameObject
{
    private String text;

    public TextObject(String text)
    {
        this.text = text;
    }

    public String getText()
    {
        return this.text;
    }

    public void setText(String text)
    {
        this.text = text;
    }
}
