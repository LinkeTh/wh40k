package de.linket.rpg.wh40k.bc.types;

import java.util.Random;

import de.linket.rpg.wh40k.bc.common.GameObject;

public enum DiceType implements GameObject
{
    W5(1, 5),
    W6(1, 6),
    W10(1, 10),
    W100(1, 100);

    private int min;
    private int max;

    private DiceType(int min, int max)
    {
        this.min = min;
        this.max = max;
    }

    public int getMax()
    {
        return this.max;
    }

    public int getMin()
    {
        return this.min;
    }

    public int roll()
    {
        Random rand = new Random();
        int randomNum = rand.nextInt((this.max - this.min) + 1) + this.min;
        return randomNum;
    }
}
