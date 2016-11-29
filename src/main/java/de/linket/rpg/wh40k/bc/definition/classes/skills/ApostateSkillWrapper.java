package de.linket.rpg.wh40k.bc.definition.classes.skills;

import java.util.ArrayList;
import java.util.List;

import de.linket.rpg.wh40k.bc.common.selection.DecisionComposer;
import de.linket.rpg.wh40k.bc.common.selection.MultiComposer;
import de.linket.rpg.wh40k.bc.common.selection.SelectionContainer;
import de.linket.rpg.wh40k.bc.common.selection.SelectionWrapper;
import de.linket.rpg.wh40k.bc.common.selection.SingleComposer;
import de.linket.rpg.wh40k.bc.player.skills.Skill;
import de.linket.rpg.wh40k.bc.types.SkillStateType;
import de.linket.rpg.wh40k.bc.types.SkillType;

public class ApostateSkillWrapper implements SelectionWrapper<Skill>
{
    @Override
    public List<SelectionContainer<Skill>> getSelectionContainer()
    {
        List<SelectionContainer<Skill>> result = new ArrayList<>();

        SelectionContainer<Skill> c1 = new SingleComposer<Skill>(new Skill(SkillType.AWARENESS));
        SelectionContainer<Skill> c2 = new SingleComposer<Skill>(new Skill(SkillType.CHARM));
        SelectionContainer<Skill> c3 = new SingleComposer<Skill>(new Skill(SkillType.COMMAND));
        SelectionContainer<Skill> c4 = new SingleComposer<Skill>(new Skill(SkillType.DECEIVE));
        SelectionContainer<Skill> c5 = new SingleComposer<Skill>(new Skill(SkillType.CHARM));
        SelectionContainer<Skill> c6 = new MultiComposer<Skill>(new Skill(SkillType.SCHOLASTIC_LORE), 3);
        SelectionContainer<Skill> c7 = new MultiComposer<Skill>(new Skill(SkillType.FORBIDDEN_LORE), 3);
        SelectionContainer<Skill> c8 = new SingleComposer<Skill>(new Skill(SkillType.INQUIRY));
        SelectionContainer<Skill> c9 = new DecisionComposer<Skill>(new Skill(SkillType.DODGE), new Skill(SkillType.PARRY));
        SelectionContainer<Skill> c10 = new DecisionComposer<Skill>(new Skill(SkillType.INTIMIDATE), new Skill(SkillType.COMMERCE));
        SelectionContainer<Skill> c11 = new DecisionComposer<Skill>(new Skill(SkillType.CHARM, SkillStateType.TRAINED),
                        new Skill(SkillType.DECEIVE, SkillStateType.TRAINED)); // +10
        SelectionContainer<Skill> c12 = new DecisionComposer<Skill>(new Skill(SkillType.COMMAND, SkillStateType.TRAINED),
                        new Skill(SkillType.INQUIRY, SkillStateType.TRAINED)); // +10
        SelectionContainer<Skill> c13 =
                        new DecisionComposer<Skill>(new Skill(SkillType.SECURITY), new Skill(SkillType.STEALTH), new Skill(SkillType.LOGIC));

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
        result.add(c11);
        result.add(c12);
        result.add(c13);

        return result;
    }

}
