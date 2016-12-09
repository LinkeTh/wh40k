package de.linket.rpg.wh40k.bc.jpa.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import de.linket.rpg.wh40k.bc.modifier.ModifierType;

@Entity
@DiscriminatorValue(value = ModifierType.Values.SPECIAL)
public abstract class TextModifierBE extends ModifierBE
{
    private static final long serialVersionUID = 1L;

    @Column(name = "DESCRIPTION", nullable = false, length = 4000)
    private String description;

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}
