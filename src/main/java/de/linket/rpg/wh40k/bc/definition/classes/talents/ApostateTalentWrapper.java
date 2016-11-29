package de.linket.rpg.wh40k.bc.definition.classes.talents;

import java.util.ArrayList;
import java.util.List;

import de.linket.rpg.wh40k.bc.common.selection.DecisionComposer;
import de.linket.rpg.wh40k.bc.common.selection.SelectionContainer;
import de.linket.rpg.wh40k.bc.common.selection.SelectionWrapper;
import de.linket.rpg.wh40k.bc.common.selection.SingleComposer;
import de.linket.rpg.wh40k.bc.types.TalentType;

public class ApostateTalentWrapper implements SelectionWrapper<TalentType>
{
    @Override
    public List<SelectionContainer<TalentType>> getSelectionContainer()
    {
        List<SelectionContainer<TalentType>> result = new ArrayList<>();

        SelectionContainer<TalentType> c1 = new SingleComposer<TalentType>(TalentType.AIR_OF_AUTHORITY);
        SelectionContainer<TalentType> c2 = new SingleComposer<TalentType>(TalentType.HATRED);
        SelectionContainer<TalentType> c3 = new SingleComposer<TalentType>(TalentType.PEER);
        SelectionContainer<TalentType> c4 = new SingleComposer<TalentType>(TalentType.TOTAL_RECAL);
        SelectionContainer<TalentType> c5 = new SingleComposer<TalentType>(TalentType.UNSHAKEABLE_WILL);
        SelectionContainer<TalentType> c6 = new SingleComposer<TalentType>(TalentType.WEAPON_TRAINING_LASER);
        SelectionContainer<TalentType> c7 = new SingleComposer<TalentType>(TalentType.WEAPON_TRAINING_PRIMARY);
        SelectionContainer<TalentType> c8 = new DecisionComposer<TalentType>(TalentType.DISTURBING_VOICE, TalentType.RADIANT_PRESENCE);
        SelectionContainer<TalentType> c9 = new DecisionComposer<TalentType>(TalentType.POLYGLOT, TalentType.MIMIC);
        SelectionContainer<TalentType> c10 =
                        new DecisionComposer<TalentType>(TalentType.INSPIRE_WRATH, TalentType.IRON_DISCIPLE, TalentType.LESSER_MINON_OF_CHAOS);

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
