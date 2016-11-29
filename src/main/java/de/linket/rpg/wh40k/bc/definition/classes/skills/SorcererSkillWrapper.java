package de.linket.rpg.wh40k.bc.definition.classes.skills;

import java.util.ArrayList;
import java.util.List;

import de.linket.rpg.wh40k.bc.common.selection.DecisionComposer;
import de.linket.rpg.wh40k.bc.common.selection.SelectionContainer;
import de.linket.rpg.wh40k.bc.common.selection.SelectionWrapper;
import de.linket.rpg.wh40k.bc.common.selection.SingleComposer;
import de.linket.rpg.wh40k.bc.types.SkillType;

public class SorcererSkillWrapper implements SelectionWrapper<SkillType>
{
    @Override
    public List<SelectionContainer<SkillType>> getSelectionContainer()
    {
        List<SelectionContainer<SkillType>> result = new ArrayList<>();

        SelectionContainer<SkillType> c1 = new SingleComposer<SkillType>(SkillType.PSYNISCIENCE);
        SelectionContainer<SkillType> c2 = new SingleComposer<SkillType>(SkillType.SCHOLASTIC_LORE_OCCULT);
        SelectionContainer<SkillType> c3 = new DecisionComposer<SkillType>(SkillType.DECEIVE, SkillType.SCRUTINY);
        SelectionContainer<SkillType> c4 = new DecisionComposer<SkillType>(SkillType.FORBIDDEN_LORE_DAEMONOLOGY, SkillType.FORBIDDEN_LORE_PSYKERS);

        result.add(c1);
        result.add(c2);
        result.add(c3);
        result.add(c4);

        return result;
    }

}
