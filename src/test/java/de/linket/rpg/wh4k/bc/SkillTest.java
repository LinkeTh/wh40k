package de.linket.rpg.wh4k.bc;

import org.junit.Test;

import de.linket.rpg.wh40k.bc.exp.Experience;
import de.linket.rpg.wh40k.bc.player.skills.Skill;
import de.linket.rpg.wh40k.bc.types.SkillType;

public class SkillTest
{

    @Test
    public void test()
    {

        for (SkillType type : SkillType.values())
        {
            Skill c = new Skill(type);
            System.out.println(c.toString());
            c.advance(new Experience(100));
            System.out.println(c.toString());
            c.advance(new Experience(100));
            System.out.println(c.toString());
        }

    }

}
