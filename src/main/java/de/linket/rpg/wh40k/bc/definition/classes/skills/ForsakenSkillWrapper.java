package de.linket.rpg.wh40k.bc.definition.classes.skills;

import java.util.ArrayList;
import java.util.List;

import de.linket.rpg.wh40k.bc.common.selection.DecisionComposer;
import de.linket.rpg.wh40k.bc.common.selection.SelectionContainer;
import de.linket.rpg.wh40k.bc.common.selection.SelectionWrapper;
import de.linket.rpg.wh40k.bc.common.selection.SingleComposer;
import de.linket.rpg.wh40k.bc.player.skills.Skill;
import de.linket.rpg.wh40k.bc.types.SkillStateType;
import de.linket.rpg.wh40k.bc.types.SkillType;

public class ForsakenSkillWrapper implements SelectionWrapper<Skill>
{
    @Override
    public List<SelectionContainer<Skill>> getSelectionContainer()
    {
        List<SelectionContainer<Skill>> result = new ArrayList<>();

        SelectionContainer<Skill> c1 = new SingleComposer<Skill>(new Skill(SkillType.ACROBATICS));
        SelectionContainer<Skill> c2 = new SingleComposer<Skill>(new Skill(SkillType.SURVIVAL));
        SelectionContainer<Skill> c3 = new DecisionComposer<Skill>(new Skill(SkillType.COMMERCE), new Skill(SkillType.SECURITY));
        SelectionContainer<Skill> c4 = new DecisionComposer<Skill>(new Skill(SkillType.COMMON_LORE),
                        new Skill(SkillType.SURVIVAL, SkillStateType.TRAINED) /* +10 */);

        result.add(c1);
        result.add(c2);
        result.add(c3);
        result.add(c4);

        return result;
    }

}
