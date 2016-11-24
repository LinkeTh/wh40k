package de.linket.rpg.wh40k.bc.skills;

import de.linket.rpg.wh40k.bc.modifier.AbstractModifier;
import de.linket.rpg.wh40k.bc.modifier.ModifierType;
import de.linket.rpg.wh40k.bc.types.SkillType;

public class SkillModifier extends AbstractModifier<SkillType> {

	private boolean addSkill = true;

	public SkillModifier(SkillType type, int value) {
		super();
		this.type = type;
		this.value = value;
	}

	@Override
	public ModifierType getModifierType() {
		return ModifierType.SKILL;
	}

	public boolean shouldAddSkill() {
		return this.addSkill;
	}

}
