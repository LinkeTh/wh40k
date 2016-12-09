package de.linket.rpg.wh40k.bc.jpa.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import de.linket.rpg.wh40k.bc.modifier.ModifierType;

@Entity
@DiscriminatorValue(value = ModifierType.Values.ATTRIBUTE_BONUS)
public abstract class AttributeBonusModifierBE extends ModifierBE
{
	private static final long serialVersionUID = 1L;

	@Column(name = "VALUE", nullable = false, precision = 2, scale = 0)
	private Integer value;

	@ManyToOne
	@JoinColumn
	private AttributeBE attribute;

	public Integer getValue()
	{
		return this.value;
	}

	public void setValue(Integer value)
	{
		this.value = value;
	}

	public AttributeBE getAttribute() {
		return this.attribute;
	}

	public void setAttribute(AttributeBE attribute) {
		this.attribute = attribute;
	}
}
