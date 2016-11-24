package de.linket.rpg.wh40k.bc.definition.races.skills;

import java.util.ArrayList;
import java.util.List;

import de.linket.rpg.wh40k.bc.common.selection.SelectionContainer;
import de.linket.rpg.wh40k.bc.common.selection.SelectionWrapper;
import de.linket.rpg.wh40k.bc.common.selection.SingleComposer;
import de.linket.rpg.wh40k.bc.types.SkillType;

public class SpaceMarineSkillWrapper implements SelectionWrapper<SkillType>
{
    @Override
    public List<SelectionContainer<SkillType>> getSelectionContainer()
    {
        List<SelectionContainer<SkillType>> result = new ArrayList<>();
        SelectionContainer<SkillType> c1 = new SingleComposer<SkillType>(SkillType.ATHLETICS);
        SelectionContainer<SkillType> c2 = new SingleComposer<SkillType>(SkillType.AWARENESS);
        SelectionContainer<SkillType> c3 = new SingleComposer<SkillType>(SkillType.COMMON_LORE_WAR);
        SelectionContainer<SkillType> c4 = new SingleComposer<SkillType>(SkillType.DODGE);
        SelectionContainer<SkillType> c5 = new SingleComposer<SkillType>(SkillType.FORBIDDEN_LORE_ADEPTUS_ARTARTES);
        SelectionContainer<SkillType> c6 = new SingleComposer<SkillType>(SkillType.FORBIDDEN_LORE_HORUS);
        SelectionContainer<SkillType> c7 = new SingleComposer<SkillType>(SkillType.LINGUISTICST_LOW_GOTIC);
        SelectionContainer<SkillType> c8 = new SingleComposer<SkillType>(SkillType.NAVIGATION_SURFACE);
        SelectionContainer<SkillType> c9 = new SingleComposer<SkillType>(SkillType.OPERATE_SURFACE);
        SelectionContainer<SkillType> c10 = new SingleComposer<SkillType>(SkillType.PARRY);

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

        return result;
    }
}
