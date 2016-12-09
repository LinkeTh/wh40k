package de.linket.rpg.wh40k.bc.jpa.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import de.linket.rpg.wh40k.bc.modifier.ModifierType;
import de.linket.rpg.wh40k.bc.types.AttributeType;

@Entity
@DiscriminatorValue(value = ModifierType.Values.ATTRIBUTE)
public abstract class AttributeModifierBE extends ModifierBE
{
    private static final long serialVersionUID = 1L;

    @Column(name = "VALUE", nullable = false, precision = 2, scale = 0)
    private Integer value;

    @Column(name = "KEY", nullable = false)
    private AttributeType attribute;

    public Integer getValue()
    {
        return this.value;
    }

    public void setValue(Integer value)
    {
        this.value = value;
    }

    public AttributeType getAttribute()
    {
        return this.attribute;
    }

    public void setAttribute(AttributeType attribute)
    {
        this.attribute = attribute;
    }
}
