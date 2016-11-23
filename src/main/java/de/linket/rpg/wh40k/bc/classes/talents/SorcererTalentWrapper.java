package de.linket.rpg.wh40k.bc.classes.talents;

import java.util.ArrayList;
import java.util.List;

import de.linket.rpg.wh40k.bc.common.selection.SelectionContainer;
import de.linket.rpg.wh40k.bc.common.selection.SelectionWrapper;
import de.linket.rpg.wh40k.bc.common.selection.SingleComposer;
import de.linket.rpg.wh40k.bc.types.TalentType;

public class SorcererTalentWrapper implements SelectionWrapper<TalentType>
{
	@Override
	public List<SelectionContainer<TalentType>> getSelectionContainer()
	{
		List<SelectionContainer<TalentType>> result = new ArrayList<>();

		SelectionContainer<TalentType> c1 = new SingleComposer<TalentType>(TalentType.FAST);
		SelectionContainer<TalentType> c2 = new SingleComposer<TalentType>(TalentType.FAT);
		SelectionContainer<TalentType> c3 = new SingleComposer<TalentType>(TalentType.TODO);

		result.add(c1);
		result.add(c2);
		result.add(c3);

		return result;
	}

}
