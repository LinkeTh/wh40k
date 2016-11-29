package de.linket.rpg.wh40k.bc.definition.classes.skills;

import java.util.ArrayList;
import java.util.List;

import de.linket.rpg.wh40k.bc.common.selection.DecisionComposer;
import de.linket.rpg.wh40k.bc.common.selection.SelectionContainer;
import de.linket.rpg.wh40k.bc.common.selection.SelectionWrapper;
import de.linket.rpg.wh40k.bc.common.selection.SingleComposer;
import de.linket.rpg.wh40k.bc.types.SkillType;

public class HeretekSkillWrapper implements SelectionWrapper<SkillType>
{
    @Override
    public List<SelectionContainer<SkillType>> getSelectionContainer()
    {
        List<SelectionContainer<SkillType>> result = new ArrayList<>();

        SelectionContainer<SkillType> c1 = new SingleComposer<SkillType>(SkillType.LOGIC);
        SelectionContainer<SkillType> c2 = new SingleComposer<SkillType>(SkillType.COMMON_LORE_ADEPTUS_MECHANICUS);
        SelectionContainer<SkillType> c3 = new SingleComposer<SkillType>(SkillType.COMMON_LORE_TECH);
        SelectionContainer<SkillType> c4 = new SingleComposer<SkillType>(SkillType.TECH_USE);
        SelectionContainer<SkillType> c5 = new DecisionComposer<SkillType>(SkillType.DODGE, SkillType.PARRY);
        SelectionContainer<SkillType> c6 = new DecisionComposer<SkillType>(SkillType.SECURITY, SkillType.TECH_USE /* +10 */);
        SelectionContainer<SkillType> c7 = new DecisionComposer<SkillType>(SkillType.SCHOLASTIC_LORE_ASTROMANCY, SkillType.SCHOLASTIC_LORE_CHYMISTRY);
        SelectionContainer<SkillType> c8 = new DecisionComposer<SkillType>(SkillType.FORBIDDEN_LORE_ARCHEOTECH, SkillType.FORBIDDEN_LORE_XENOS,
                        SkillType.FORBIDDEN_LORE_WARP);

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
