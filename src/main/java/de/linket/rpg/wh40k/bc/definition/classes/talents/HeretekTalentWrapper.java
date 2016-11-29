package de.linket.rpg.wh40k.bc.definition.classes.talents;

import java.util.ArrayList;
import java.util.List;

import de.linket.rpg.wh40k.bc.common.selection.DecisionComposer;
import de.linket.rpg.wh40k.bc.common.selection.SelectionContainer;
import de.linket.rpg.wh40k.bc.common.selection.SelectionWrapper;
import de.linket.rpg.wh40k.bc.common.selection.SingleComposer;
import de.linket.rpg.wh40k.bc.types.TalentType;

public class HeretekTalentWrapper implements SelectionWrapper<TalentType>
{
    @Override
    public List<SelectionContainer<TalentType>> getSelectionContainer()
    {
        List<SelectionContainer<TalentType>> result = new ArrayList<>();

        SelectionContainer<TalentType> c1 = new SingleComposer<TalentType>(TalentType.DIE_HARD);
        SelectionContainer<TalentType> c2 = new SingleComposer<TalentType>(TalentType.TECHNICAL_KNOCK);
        SelectionContainer<TalentType> c3 = new SingleComposer<TalentType>(TalentType.WEAPON_TRAINING_LASER);
        SelectionContainer<TalentType> c4 = new SingleComposer<TalentType>(TalentType.WEAPON_TRAINING_PRIMARY);
        SelectionContainer<TalentType> c5 = new SingleComposer<TalentType>(TalentType.WEAPON_TRAINING_SHOCK);
        SelectionContainer<TalentType> c6 = new DecisionComposer<TalentType>(TalentType.WEAPON_TRAINING_BOLT, TalentType.WEAPON_TRAINING_PLASMA,
                        TalentType.WEAPON_TRAINING_POWER);
        SelectionContainer<TalentType> c7 =
                        new DecisionComposer<TalentType>(TalentType.MECHADENDRITE_TRAINING_WEAPON, TalentType.MECHADENDRITE_TRAINING_UTILITY);
        SelectionContainer<TalentType> c8 = new DecisionComposer<TalentType>(TalentType.MEDITATION, TalentType.TOTAL_RECAL);
        SelectionContainer<TalentType> c9 = new DecisionComposer<TalentType>(TalentType.ARMOUR_MONGER, TalentType.WEAPON_TECH);
        SelectionContainer<TalentType> c10 = new DecisionComposer<TalentType>(TalentType.LESSER_MINON_OF_CHAOS, TalentType.COLD_HEARTED);
        SelectionContainer<TalentType> c11 = new SingleComposer<TalentType>(TalentType.ENEMY_ADEPTUS_MECHANICUS);

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
