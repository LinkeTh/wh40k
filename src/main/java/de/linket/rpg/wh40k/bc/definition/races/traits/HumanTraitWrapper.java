package de.linket.rpg.wh40k.bc.definition.races.traits;

import java.util.ArrayList;
import java.util.List;

import de.linket.rpg.wh40k.bc.common.selection.SelectionContainer;
import de.linket.rpg.wh40k.bc.common.selection.SelectionWrapper;
import de.linket.rpg.wh40k.bc.common.selection.SingleComposer;
import de.linket.rpg.wh40k.bc.types.TraitType;

public class HumanTraitWrapper implements SelectionWrapper<TraitType>
{
    @Override
    public List<SelectionContainer<TraitType>> getSelectionContainer()
    {
        List<SelectionContainer<TraitType>> result = new ArrayList<>();

        SelectionContainer<TraitType> c1 = new SingleComposer<TraitType>(TraitType.FAT);
        result.add(c1);

        return result;
    }

}
