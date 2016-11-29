package de.linket.rpg.wh40k.bc.definition.races.skills;

import java.util.ArrayList;
import java.util.List;

import de.linket.rpg.wh40k.bc.common.selection.MultiComposer;
import de.linket.rpg.wh40k.bc.common.selection.SelectionContainer;
import de.linket.rpg.wh40k.bc.common.selection.SelectionWrapper;
import de.linket.rpg.wh40k.bc.common.selection.SingleComposer;
import de.linket.rpg.wh40k.bc.player.skills.Skill;
import de.linket.rpg.wh40k.bc.types.SkillType;

public class HumanSkillWrapper implements SelectionWrapper<Skill>
{
    @Override
    public List<SelectionContainer<Skill>> getSelectionContainer()
    {
        List<SelectionContainer<Skill>> result = new ArrayList<>();

        SelectionContainer<Skill> c1 = new SingleComposer<Skill>(new Skill(SkillType.LINGUISTICST_LOW_GOTIC));
        SelectionContainer<Skill> c2 = new SingleComposer<Skill>(new Skill(SkillType.TRADE));
        SelectionContainer<Skill> c3 = new MultiComposer<Skill>(new Skill(SkillType.COMMON_LORE), 2);

        result.add(c1);
        result.add(c2);
        result.add(c3);

        return result;
    }
}
