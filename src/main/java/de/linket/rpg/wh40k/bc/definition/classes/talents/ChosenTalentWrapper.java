package de.linket.rpg.wh40k.bc.definition.classes.talents;

import java.util.ArrayList;
import java.util.List;

import de.linket.rpg.wh40k.bc.common.selection.DecisionComposer;
import de.linket.rpg.wh40k.bc.common.selection.SelectionContainer;
import de.linket.rpg.wh40k.bc.common.selection.SelectionWrapper;
import de.linket.rpg.wh40k.bc.common.selection.SingleComposer;
import de.linket.rpg.wh40k.bc.types.TalentType;

public class ChosenTalentWrapper implements SelectionWrapper<TalentType>
{
    @Override
    public List<SelectionContainer<TalentType>> getSelectionContainer()
    {
        List<SelectionContainer<TalentType>> result = new ArrayList<>();

        SelectionContainer<TalentType> c1 = new SingleComposer<TalentType>(TalentType.LIGHTNING_REFLEXES);
        SelectionContainer<TalentType> c2 = new DecisionComposer<TalentType>(TalentType.QUICK_DRAW, TalentType.RAPID_RELOAD);
        SelectionContainer<TalentType> c3 = new DecisionComposer<TalentType>(TalentType.DISARM, TalentType.DOUBLE_TEAM);
        SelectionContainer<TalentType> c4 = new DecisionComposer<TalentType>(TalentType.SURE_STRIKE, TalentType.DEADEYE_SHOT);

        result.add(c1);
        result.add(c2);
        result.add(c3);
        result.add(c4);

        return result;
    }

}
