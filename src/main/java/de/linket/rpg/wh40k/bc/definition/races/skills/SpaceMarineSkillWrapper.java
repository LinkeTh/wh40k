package de.linket.rpg.wh40k.bc.definition.races.skills;

import java.util.ArrayList;
import java.util.List;

import de.linket.rpg.wh40k.bc.common.selection.SelectionContainer;
import de.linket.rpg.wh40k.bc.common.selection.SelectionWrapper;
import de.linket.rpg.wh40k.bc.common.selection.SingleComposer;
import de.linket.rpg.wh40k.bc.player.skills.Skill;
import de.linket.rpg.wh40k.bc.types.SkillType;

public class SpaceMarineSkillWrapper implements SelectionWrapper<Skill>
{
    @Override
    public List<SelectionContainer<Skill>> getSelectionContainer()
    {
        List<SelectionContainer<Skill>> result = new ArrayList<>();
        SelectionContainer<Skill> c1 = new SingleComposer<Skill>(new Skill(SkillType.ATHLETICS));
        SelectionContainer<Skill> c2 = new SingleComposer<Skill>(new Skill(SkillType.AWARENESS));
        SelectionContainer<Skill> c3 = new SingleComposer<Skill>(new Skill(SkillType.COMMON_LORE_WAR));
        SelectionContainer<Skill> c4 = new SingleComposer<Skill>(new Skill(SkillType.DODGE));
        SelectionContainer<Skill> c5 = new SingleComposer<Skill>(new Skill(SkillType.FORBIDDEN_LORE_ADEPTUS_ARTARTES));
        SelectionContainer<Skill> c6 = new SingleComposer<Skill>(new Skill(SkillType.FORBIDDEN_LORE_HORUS));
        SelectionContainer<Skill> c7 = new SingleComposer<Skill>(new Skill(SkillType.LINGUISTICST_LOW_GOTIC));
        SelectionContainer<Skill> c8 = new SingleComposer<Skill>(new Skill(SkillType.NAVIGATION_SURFACE));
        SelectionContainer<Skill> c9 = new SingleComposer<Skill>(new Skill(SkillType.OPERATE_SURFACE));
        SelectionContainer<Skill> c10 = new SingleComposer<Skill>(new Skill(SkillType.PARRY));

        result.add(c1);
        result.add(c2);
        result.add(c3);
        result.add(c4);
        result.add(c5);
        result.add(c6);
        result.add(c7);
        result.add(c8);
        result.add(c9);
        result.add(c10);

        return result;
    }
}
