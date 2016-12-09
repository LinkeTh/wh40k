package de.linket.rpg.wh40k.bc.jpa.domain;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", discriminatorType = DiscriminatorType.STRING)
@Table(name = "WH_MODIFIER")
public abstract class ModifierBE extends AbstractPersistable
{
    private static final long serialVersionUID = 1L;

    // @Column(name = "MODIFIER_TYPE", nullable = false)
    // private ModifierType type;
    //
    // @Column(name = "VALUE", nullable = false)
    // private Long value;
    //
    // @Column(name = "KEY", nullable = false)
    // private String key;
    //
    // public ModifierBE()
    // {
    // super();
    // }
    //
    // public ModifierType getType()
    // {
    // return this.type;
    // }
    //
    // public void setType(ModifierType type)
    // {
    // this.type = type;
    // }
    //
    // public Long getValue()
    // {
    // return this.value;
    // }
    //
    // public void setValue(Long value)
    // {
    // this.value = value;
    // }
    //
    // public String getKey()
    // {
    // return this.key;
    // }
    //
    // public void setKey(String key)
    // {
    // this.key = key;
    // }

}
