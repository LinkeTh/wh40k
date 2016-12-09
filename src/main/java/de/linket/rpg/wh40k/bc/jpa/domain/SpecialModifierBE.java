package de.linket.rpg.wh40k.bc.jpa.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import de.linket.rpg.wh40k.bc.modifier.ModifierType;
import de.linket.rpg.wh40k.bc.types.SpecialType;

@Entity
@DiscriminatorValue(value = ModifierType.Values.SPECIAL)
public abstract class SpecialModifierBE extends ModifierBE
{
	private static final long serialVersionUID = 1L;

	@Column(name = "VALUE", nullable = false, precision = 2, scale = 0)
	private Integer value;

	@Enumerated(EnumType.STRING)
	@Column(name = "KEY", nullable = false)
	private SpecialType key;

	public Integer getValue()
	{
		return this.value;
	}

	public void setValue(Integer value)
	{
		this.value = value;
	}

	public SpecialType getKey()
	{
		return this.key;
	}

	public void setKey(SpecialType key)
	{
		this.key = key;
	}
}
