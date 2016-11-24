package de.linket.rpg.wh40k.bc.types;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import de.linket.rpg.wh40k.bc.characteristics.CharacteristicModifier;
import de.linket.rpg.wh40k.bc.common.GameObject;
import de.linket.rpg.wh40k.bc.modifier.Modifier;
import de.linket.rpg.wh40k.bc.skills.SkillModifier;
import de.linket.rpg.wh40k.bc.special.SpecialModifier;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TalentType implements GameObject
{
	BLA(new SpecialModifier(SpecialType.WOUNDS, 3)),
	FAST(new CharacteristicModifier(CharacteristicType.AGILITY, 2)),
	// FAT(new CharacteristicBonusModifier(CharacteristicType.INTELLIGENCE, 3)),
	FAT(new SkillModifier(SkillType.MEDICAE, 10)),
	TODO(new SkillModifier(SkillType.DODGE, 10));

	private List<Modifier<?>> modifiers;
	private boolean advancable;

	private TalentType(Modifier<?>... modifiers)
	{
		this(false, modifiers);
	}

	private TalentType(boolean advancable, Modifier<?>... modifiers)
	{
		this.advancable = advancable;
		this.modifiers = Arrays.asList(modifiers);
	}

	public String getName()
	{
		return this.name();
	}

	public boolean isAdvancable()
	{
		return this.advancable;
	}

	public List<Modifier<?>> getModifiers()
	{
		return this.modifiers;
	}

	@JsonCreator
	public static TalentType fromName(@JsonProperty("name") String name)
	{
		if(name == null)
		{
			return null;
		}

		for(TalentType type : TalentType.values())
		{
			if(type.getName().equalsIgnoreCase(name))
			{
				return type;
			}
		}
		return null;
	}
}
