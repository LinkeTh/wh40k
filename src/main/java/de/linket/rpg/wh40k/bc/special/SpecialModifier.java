package de.linket.rpg.wh40k.bc.special;

import de.linket.rpg.wh40k.bc.common.AbstractModifier;
import de.linket.rpg.wh40k.bc.common.ModifierType;
import de.linket.rpg.wh40k.bc.types.SpecialType;

public class SpecialModifier extends AbstractModifier<SpecialType> {

	public SpecialModifier(SpecialType type, int value) {
		super();
		this.type = type;
		this.value = value;
	}

	@Override
	public ModifierType getModifierType() {
		return ModifierType.SPECIAL;
	}
}
