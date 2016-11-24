package de.linket.rpg.wh40k.bc.definition.races.talents;

import java.util.ArrayList;
import java.util.List;

import de.linket.rpg.wh40k.bc.common.selection.SelectionContainer;
import de.linket.rpg.wh40k.bc.common.selection.SelectionWrapper;
import de.linket.rpg.wh40k.bc.common.selection.SingleComposer;
import de.linket.rpg.wh40k.bc.types.TalentType;

public class HumanTalentWrapper implements SelectionWrapper<TalentType>
{
	@Override
	public List<SelectionContainer<TalentType>> getSelectionContainer()
	{
		List<SelectionContainer<TalentType>> result = new ArrayList<>();

		SelectionContainer<TalentType> c1 = new SingleComposer<TalentType>(TalentType.BLA);

		result.add(c1);

		return result;
	}

}
