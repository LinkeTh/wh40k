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

public class HeretekSkillWrapper implements SelectionWrapper<Skill>
{
    @Override
    public List<SelectionContainer<Skill>> getSelectionContainer()
    {
        List<SelectionContainer<Skill>> result = new ArrayList<>();

        SelectionContainer<Skill> c1 = new SingleComposer<Skill>(new Skill(SkillType.LOGIC));
        SelectionContainer<Skill> c2 = new SingleComposer<Skill>(new Skill(SkillType.COMMON_LORE_ADEPTUS_MECHANICUS));
        SelectionContainer<Skill> c3 = new SingleComposer<Skill>(new Skill(SkillType.COMMON_LORE_TECH));
        SelectionContainer<Skill> c4 = new SingleComposer<Skill>(new Skill(SkillType.TECH_USE));
        SelectionContainer<Skill> c5 = new DecisionComposer<Skill>(new Skill(SkillType.DODGE), new Skill(SkillType.PARRY));
        SelectionContainer<Skill> c6 =
                        new DecisionComposer<Skill>(new Skill(SkillType.SECURITY), new Skill(SkillType.TECH_USE, SkillStateType.TRAINED) /* +10 */);
        SelectionContainer<Skill> c7 =
                        new DecisionComposer<Skill>(new Skill(SkillType.SCHOLASTIC_LORE_ASTROMANCY), new Skill(SkillType.SCHOLASTIC_LORE_CHYMISTRY));
        SelectionContainer<Skill> c8 =
                        new DecisionComposer<Skill>(new Skill(SkillType.FORBIDDEN_LORE_ARCHEOTECH), new Skill(SkillType.FORBIDDEN_LORE_XENOS),
                                        new Skill(SkillType.FORBIDDEN_LORE_WARP));

        result.add(c1);
        result.add(c2);
        result.add(c3);
        result.add(c4);
        result.add(c5);
        result.add(c6);
        result.add(c7);
        result.add(c8);

        return result;
    }

}
