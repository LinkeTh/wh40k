package de.linket.rpg.wh40k.bc.definition.classes.traits;

import java.util.ArrayList;
import java.util.List;

import de.linket.rpg.wh40k.bc.common.selection.SelectionContainer;
import de.linket.rpg.wh40k.bc.common.selection.SelectionWrapper;
import de.linket.rpg.wh40k.bc.common.selection.SingleComposer;
import de.linket.rpg.wh40k.bc.types.TraitType;

public class HeretekTraitWrapper implements SelectionWrapper<TraitType>
{
    @Override
    public List<SelectionContainer<TraitType>> getSelectionContainer()
    {
        List<SelectionContainer<TraitType>> result = new ArrayList<>();

        SelectionContainer<TraitType> c1 = new SingleComposer<TraitType>(TraitType.TRAITOR_TO_MARS);
        SelectionContainer<TraitType> c2 = new SingleComposer<TraitType>(TraitType.HERETEK_CLASS);
        SelectionContainer<TraitType> c3 = new SingleComposer<TraitType>(TraitType.MECHANICUS_IMPLANTS);

        result.add(c1);
        result.add(c2);
        result.add(c3);

        return result;
    }

}
