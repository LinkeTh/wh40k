package de.linket.rpg.wh40k.bc.definition.classes.talents;

import java.util.ArrayList;
import java.util.List;

import de.linket.rpg.wh40k.bc.common.selection.DecisionComposer;
import de.linket.rpg.wh40k.bc.common.selection.SelectionContainer;
import de.linket.rpg.wh40k.bc.common.selection.SelectionWrapper;
import de.linket.rpg.wh40k.bc.common.selection.SingleComposer;
import de.linket.rpg.wh40k.bc.types.TalentType;

public class ChampionTalentWrapper implements SelectionWrapper<TalentType>
{
    @Override
    public List<SelectionContainer<TalentType>> getSelectionContainer()
    {
        List<SelectionContainer<TalentType>> result = new ArrayList<>();

        SelectionContainer<TalentType> c1 = new SingleComposer<TalentType>(TalentType.IRON_DISCIPLE);
        SelectionContainer<TalentType> c2 = new DecisionComposer<TalentType>(TalentType.AIR_OF_AUTHORITY, TalentType.DISTURBING_VOICE);
        SelectionContainer<TalentType> c3 = new DecisionComposer<TalentType>(TalentType.LESSER_MINON_OF_CHAOS, TalentType.SURE_STRIKE);

        result.add(c1);
        result.add(c2);
        result.add(c3);

        return result;
    }
}
