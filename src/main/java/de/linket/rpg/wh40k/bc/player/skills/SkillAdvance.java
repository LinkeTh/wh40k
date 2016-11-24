package de.linket.rpg.wh40k.bc.player.skills;

import de.linket.rpg.wh40k.bc.exp.Experience;
import de.linket.rpg.wh40k.bc.player.advances.Advance;

public class SkillAdvance implements Advance<SkillModifier>
{
    private Experience cost;

    public SkillAdvance(Experience cost)
    {
        this.cost = cost;
    }

    @Override
    public SkillModifier getModifier()
    {
        return new SkillModifier(null, 10);
    }

    @Override
    public Experience getCosts()
    {
        return this.cost;
    }
}
