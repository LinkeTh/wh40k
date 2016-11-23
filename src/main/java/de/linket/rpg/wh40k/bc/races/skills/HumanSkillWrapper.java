package de.linket.rpg.wh40k.bc.races.skills;

import java.util.ArrayList;
import java.util.List;

import de.linket.rpg.wh40k.bc.common.selection.MultiComposer;
import de.linket.rpg.wh40k.bc.common.selection.SelectionContainer;
import de.linket.rpg.wh40k.bc.common.selection.SelectionWrapper;
import de.linket.rpg.wh40k.bc.common.selection.SingleComposer;
import de.linket.rpg.wh40k.bc.types.SkillType;

public class HumanSkillWrapper implements SelectionWrapper<SkillType>
{
    @Override
    public List<SelectionContainer<SkillType>> getSelectionContainer()
    {
        List<SelectionContainer<SkillType>> result = new ArrayList<>();

        SelectionContainer<SkillType> c1 = new SingleComposer<SkillType>(SkillType.LINGUISTICST_LOW_GOTIC);
        SelectionContainer<SkillType> c2 = new SingleComposer<SkillType>(SkillType.TRADE);
        SelectionContainer<SkillType> c3 = new MultiComposer<SkillType>(SkillType.COMMON_LORE, 2);

        result.add(c1);
        result.add(c2);
        result.add(c3);

        return result;
    }

}
