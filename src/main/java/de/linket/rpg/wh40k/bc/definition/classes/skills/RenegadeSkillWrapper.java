package de.linket.rpg.wh40k.bc.definition.classes.skills;

import java.util.ArrayList;
import java.util.List;

import de.linket.rpg.wh40k.bc.common.selection.DecisionComposer;
import de.linket.rpg.wh40k.bc.common.selection.SelectionContainer;
import de.linket.rpg.wh40k.bc.common.selection.SelectionWrapper;
import de.linket.rpg.wh40k.bc.common.selection.SingleComposer;
import de.linket.rpg.wh40k.bc.types.SkillType;

public class RenegadeSkillWrapper implements SelectionWrapper<SkillType>
{
    @Override
    public List<SelectionContainer<SkillType>> getSelectionContainer()
    {
        List<SelectionContainer<SkillType>> result = new ArrayList<>();

        SelectionContainer<SkillType> c1 = new SingleComposer<SkillType>(SkillType.ATHLETICS);
        SelectionContainer<SkillType> c2 = new SingleComposer<SkillType>(SkillType.AWARENESS);
        SelectionContainer<SkillType> c3 = new SingleComposer<SkillType>(SkillType.DODGE);
        SelectionContainer<SkillType> c4 = new SingleComposer<SkillType>(SkillType.PARRY);
        SelectionContainer<SkillType> c5 = new SingleComposer<SkillType>(SkillType.SCHOLASTIC_LORE_TACTICA_IMPERIALIS);
        SelectionContainer<SkillType> c6 = new SingleComposer<SkillType>(SkillType.COMMON_LORE_WAR);
        SelectionContainer<SkillType> c7 = new SingleComposer<SkillType>(SkillType.OPERATE);
        SelectionContainer<SkillType> c8 = new DecisionComposer<SkillType>(SkillType.COMMAND, SkillType.INTIMIDATE);
        SelectionContainer<SkillType> c9 = new DecisionComposer<SkillType>(SkillType.DODGE, SkillType.PARRY); // +10
        SelectionContainer<SkillType> c10 = new DecisionComposer<SkillType>(SkillType.SURVIVAL, SkillType.STEALTH);
        SelectionContainer<SkillType> c11 = new DecisionComposer<SkillType>(SkillType.TECH_USE, SkillType.MEDICAE);

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

        return result;
    }

}
