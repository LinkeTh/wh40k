package de.linket.rpg.wh40k.bc.definition.classes.skills;

import java.util.ArrayList;
import java.util.List;

import de.linket.rpg.wh40k.bc.common.selection.DecisionComposer;
import de.linket.rpg.wh40k.bc.common.selection.SelectionContainer;
import de.linket.rpg.wh40k.bc.common.selection.SelectionWrapper;
import de.linket.rpg.wh40k.bc.common.selection.SingleComposer;
import de.linket.rpg.wh40k.bc.player.skills.Skill;
import de.linket.rpg.wh40k.bc.types.SkillType;

public class SorcererSkillWrapper implements SelectionWrapper<Skill>
{
    @Override
    public List<SelectionContainer<Skill>> getSelectionContainer()
    {
        List<SelectionContainer<Skill>> result = new ArrayList<>();

        SelectionContainer<Skill> c1 = new SingleComposer<Skill>(new Skill(SkillType.PSYNISCIENCE));
        SelectionContainer<Skill> c2 = new SingleComposer<Skill>(new Skill(SkillType.SCHOLASTIC_LORE_OCCULT));
        SelectionContainer<Skill> c3 = new DecisionComposer<Skill>(new Skill(SkillType.DECEIVE), new Skill(SkillType.SCRUTINY));
        SelectionContainer<Skill> c4 =
                        new DecisionComposer<Skill>(new Skill(SkillType.FORBIDDEN_LORE_DAEMONOLOGY), new Skill(SkillType.FORBIDDEN_LORE_PSYKERS));

        result.add(c1);
        result.add(c2);
        result.add(c3);
        result.add(c4);

        return result;
    }

}
