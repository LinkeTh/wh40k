package de.linket.rpg.wh40k.bc.definition.classes.skills;

import java.util.ArrayList;
import java.util.List;

import de.linket.rpg.wh40k.bc.common.selection.DecisionComposer;
import de.linket.rpg.wh40k.bc.common.selection.SelectionContainer;
import de.linket.rpg.wh40k.bc.common.selection.SelectionWrapper;
import de.linket.rpg.wh40k.bc.common.selection.SingleComposer;
import de.linket.rpg.wh40k.bc.player.skills.Skill;
import de.linket.rpg.wh40k.bc.types.SkillType;

public class PsykerSkillWrapper implements SelectionWrapper<Skill>
{
    @Override
    public List<SelectionContainer<Skill>> getSelectionContainer()
    {
        List<SelectionContainer<Skill>> result = new ArrayList<>();

        SelectionContainer<Skill> c1 = new SingleComposer<Skill>(new Skill(SkillType.AWARENESS));
        SelectionContainer<Skill> c2 = new SingleComposer<Skill>(new Skill(SkillType.PSYNISCIENCE));
        SelectionContainer<Skill> c3 = new SingleComposer<Skill>(new Skill(SkillType.FORBIDDEN_LORE_PSYKERS));
        SelectionContainer<Skill> c4 = new DecisionComposer<Skill>(new Skill(SkillType.DECEIVE), new Skill(SkillType.INTIMIDATE));
        SelectionContainer<Skill> c5 = new DecisionComposer<Skill>(new Skill(SkillType.DODGE), new Skill(SkillType.PARRY));

        result.add(c1);
        result.add(c2);
        result.add(c3);
        result.add(c4);
        result.add(c5);

        return result;
    }

}
