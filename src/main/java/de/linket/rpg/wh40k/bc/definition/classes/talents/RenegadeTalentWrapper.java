package de.linket.rpg.wh40k.bc.definition.classes.talents;

import java.util.ArrayList;
import java.util.List;

import de.linket.rpg.wh40k.bc.common.selection.DecisionComposer;
import de.linket.rpg.wh40k.bc.common.selection.SelectionContainer;
import de.linket.rpg.wh40k.bc.common.selection.SelectionWrapper;
import de.linket.rpg.wh40k.bc.common.selection.SingleComposer;
import de.linket.rpg.wh40k.bc.types.TalentType;

public class RenegadeTalentWrapper implements SelectionWrapper<TalentType>
{
    @Override
    public List<SelectionContainer<TalentType>> getSelectionContainer()
    {
        List<SelectionContainer<TalentType>> result = new ArrayList<>();

        SelectionContainer<TalentType> c1 = new SingleComposer<TalentType>(TalentType.JADED);
        SelectionContainer<TalentType> c2 = new SingleComposer<TalentType>(TalentType.QUICK_DRAW);
        SelectionContainer<TalentType> c3 = new SingleComposer<TalentType>(TalentType.RAPID_RELOAD);
        SelectionContainer<TalentType> c4 = new SingleComposer<TalentType>(TalentType.WEAPON_TRAINING_CHAIN);
        SelectionContainer<TalentType> c5 = new SingleComposer<TalentType>(TalentType.WEAPON_TRAINING_LASER);
        SelectionContainer<TalentType> c6 = new SingleComposer<TalentType>(TalentType.WEAPON_TRAINING_PRIMARY);
        SelectionContainer<TalentType> c7 = new SingleComposer<TalentType>(TalentType.WEAPON_TRAINING_SOLID_PROJECTILE);
        SelectionContainer<TalentType> c8 = new SingleComposer<TalentType>(TalentType.WEAPON_TRAINING_HEAVY);
        SelectionContainer<TalentType> c9 = new DecisionComposer<TalentType>(TalentType.WEAPON_TRAINING_BOLT, TalentType.WEAPON_TRAINING_SHOCK);
        SelectionContainer<TalentType> c10 = new DecisionComposer<TalentType>(TalentType.CATFALL, TalentType.COMBAT_SENSE);
        SelectionContainer<TalentType> c11 = new DecisionComposer<TalentType>(TalentType.SURE_STRIKE, TalentType.DEADEYE_SHOT, TalentType.MARKSMAN);
        SelectionContainer<TalentType> c12 = new DecisionComposer<TalentType>(TalentType.DOUBLE_TEAM, TalentType.DISARM, TalentType.TAKEDOWN);
        SelectionContainer<TalentType> c13 = new DecisionComposer<TalentType>(TalentType.AMBIDEXTROUS, TalentType.HIP_SHOOTING);

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
