package de.linket.rpg.wh40k.bc.definition.classes.skills;

import java.util.ArrayList;
import java.util.List;

import de.linket.rpg.wh40k.bc.common.selection.DecisionComposer;
import de.linket.rpg.wh40k.bc.common.selection.MultiComposer;
import de.linket.rpg.wh40k.bc.common.selection.SelectionContainer;
import de.linket.rpg.wh40k.bc.common.selection.SelectionWrapper;
import de.linket.rpg.wh40k.bc.common.selection.SingleComposer;
import de.linket.rpg.wh40k.bc.types.SkillType;

public class ApostateSkillWrapper implements SelectionWrapper<SkillType>
{
    @Override
    public List<SelectionContainer<SkillType>> getSelectionContainer()
    {
        List<SelectionContainer<SkillType>> result = new ArrayList<>();

        SelectionContainer<SkillType> c1 = new SingleComposer<SkillType>(SkillType.AWARENESS);
        SelectionContainer<SkillType> c2 = new SingleComposer<SkillType>(SkillType.CHARM);
        SelectionContainer<SkillType> c3 = new SingleComposer<SkillType>(SkillType.COMMAND);
        SelectionContainer<SkillType> c4 = new SingleComposer<SkillType>(SkillType.DECEIVE);
        SelectionContainer<SkillType> c5 = new SingleComposer<SkillType>(SkillType.CHARM);
        SelectionContainer<SkillType> c6 = new MultiComposer<SkillType>(SkillType.SCHOLASTIC_LORE, 3);
        SelectionContainer<SkillType> c7 = new MultiComposer<SkillType>(SkillType.FORBIDDEN_LORE, 3);
        SelectionContainer<SkillType> c8 = new SingleComposer<SkillType>(SkillType.INQUIRY);
        SelectionContainer<SkillType> c9 = new DecisionComposer<SkillType>(SkillType.DODGE, SkillType.PARRY);
        SelectionContainer<SkillType> c10 = new DecisionComposer<SkillType>(SkillType.INTIMIDATE, SkillType.COMMERCE);
        SelectionContainer<SkillType> c11 = new DecisionComposer<SkillType>(SkillType.CHARM, SkillType.DECEIVE); // +10
        SelectionContainer<SkillType> c12 = new DecisionComposer<SkillType>(SkillType.COMMAND, SkillType.INQUIRY); // +10
        SelectionContainer<SkillType> c13 = new DecisionComposer<SkillType>(SkillType.SECURITY, SkillType.STEALTH, SkillType.LOGIC);

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
