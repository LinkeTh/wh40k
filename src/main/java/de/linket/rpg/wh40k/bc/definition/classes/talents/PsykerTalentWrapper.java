package de.linket.rpg.wh40k.bc.definition.classes.talents;

import java.util.ArrayList;
import java.util.List;

import de.linket.rpg.wh40k.bc.common.selection.DecisionComposer;
import de.linket.rpg.wh40k.bc.common.selection.SelectionContainer;
import de.linket.rpg.wh40k.bc.common.selection.SelectionWrapper;
import de.linket.rpg.wh40k.bc.common.selection.SingleComposer;
import de.linket.rpg.wh40k.bc.types.TalentType;

public class PsykerTalentWrapper implements SelectionWrapper<TalentType>
{
    @Override
    public List<SelectionContainer<TalentType>> getSelectionContainer()
    {
        List<SelectionContainer<TalentType>> result = new ArrayList<>();

        SelectionContainer<TalentType> c1 = new SingleComposer<TalentType>(TalentType.JADED);
        SelectionContainer<TalentType> c2 = new SingleComposer<TalentType>(TalentType.WEAPON_TRAINING_PRIMARY);
        SelectionContainer<TalentType> c3 = new DecisionComposer<TalentType>(TalentType.WEAPON_TRAINING_LASER, TalentType.WEAPON_TRAINING_SHOCK,
                        TalentType.WEAPON_TRAINING_SOLID_PROJECTILE);
        SelectionContainer<TalentType> c4 = new DecisionComposer<TalentType>(TalentType.WARP_SENSE, TalentType.CHILD_OF_THE_WARP);

        result.add(c1);
        result.add(c2);
        result.add(c3);
        result.add(c4);

        return result;
    }
}
