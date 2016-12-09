package de.linket.rpg.wh40k.bc.jpa.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import de.linket.rpg.wh40k.bc.modifier.ModifierType;

@Entity
@DiscriminatorValue(value = ModifierType.Values.SKILL)
public abstract class SkillModifierBE extends ModifierBE
{
	private static final long serialVersionUID = 1L;

	@Column(name = "VALUE", nullable = false, precision = 2, scale = 0)
	private Integer value;

	@Column(name = "KEY", nullable = false)
	private Long skillId;

	public Integer getValue()
	{
		return this.value;
	}

	public void setValue(Integer value)
	{
		this.value = value;
	}

	public Long getSkillId()
	{
		return this.skillId;
	}

	public void setSkillId(Long skillId)
	{
		this.skillId = skillId;
	}
}
