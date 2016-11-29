package de.linket.rpg.wh40k.bc.definition.races.talents;

import java.util.ArrayList;
import java.util.List;

import de.linket.rpg.wh40k.bc.common.selection.SelectionContainer;
import de.linket.rpg.wh40k.bc.common.selection.SelectionWrapper;
import de.linket.rpg.wh40k.bc.common.selection.SingleComposer;
import de.linket.rpg.wh40k.bc.types.TalentType;

public class SpaceMarineTalentWrapper implements SelectionWrapper<TalentType>
{
    @Override
    public List<SelectionContainer<TalentType>> getSelectionContainer()
    {
        List<SelectionContainer<TalentType>> result = new ArrayList<>();

        SelectionContainer<TalentType> c1 = new SingleComposer<TalentType>(TalentType.AMBIDEXTROUS);
        SelectionContainer<TalentType> c2 = new SingleComposer<TalentType>(TalentType.BULGING_BICEPS);
        SelectionContainer<TalentType> c3 = new SingleComposer<TalentType>(TalentType.HEIGHTENED_SENSES_HEARING);
        SelectionContainer<TalentType> c4 = new SingleComposer<TalentType>(TalentType.HEIGHTENED_SENSES_SIGHT);
        SelectionContainer<TalentType> c5 = new SingleComposer<TalentType>(TalentType.LEGION_WEAPON_TRAINING);
        SelectionContainer<TalentType> c6 = new SingleComposer<TalentType>(TalentType.NERVES_OF_STEEL);
        SelectionContainer<TalentType> c7 = new SingleComposer<TalentType>(TalentType.QUICK_DRAW);
        SelectionContainer<TalentType> c8 = new SingleComposer<TalentType>(TalentType.RESISTANCE_COLD);
        SelectionContainer<TalentType> c9 = new SingleComposer<TalentType>(TalentType.RESISTANCE_HEAT);
        SelectionContainer<TalentType> c10 = new SingleComposer<TalentType>(TalentType.RESISTANCE_POISON);
        SelectionContainer<TalentType> c11 = new SingleComposer<TalentType>(TalentType.UNARMED_WARRIOR);

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
