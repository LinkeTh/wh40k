package de.linket.rpg.wh40k.bc.jpa.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.domain.Persistable;

import com.fasterxml.jackson.annotation.JsonIgnore;

@MappedSuperclass
public abstract class AbstractPersistable implements Serializable, Persistable<Long>
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Override
    public Long getId()
    {
        return this.id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    @Override
    @JsonIgnore
    public boolean isNew()
    {
        return null == this.getId();
    }

    @Override
    public boolean equals(Object obj)
    {
        if (null == obj)
        {
            return false;
        }

        if (this == obj)
        {
            return true;
        }

        if (!this.getClass().equals(obj.getClass()))
        {
            return false;
        }

        AbstractPersistable that = (AbstractPersistable) obj;

        return (null != this.getId()) && this.getId().equals(that.getId());
    }

    @Override
    public int hashCode()
    {
        int hashCode = 17;
        hashCode += null == this.getId() ? 0 : this.getId().hashCode() * 31;

        return hashCode;
    }
}
