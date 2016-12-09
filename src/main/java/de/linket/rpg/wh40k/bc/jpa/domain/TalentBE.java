package de.linket.rpg.wh40k.bc.jpa.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "WH_TALENT")
public class TalentBE extends AbstractPersistable
{
    private static final long serialVersionUID = 1L;

    @Column(name = "NAME", length = 150, nullable = false)
    private String name;

    @Column(name = "SPECIALISABLE", nullable = false)
    private Boolean specialisable = false;

    @Column(name = "ADVANCEABLE", nullable = false)
    private Boolean advanceable = false;

    @Column(name = "DESCRIPTION", length = 4000, nullable = false)
    public String description;

    @ManyToOne
    @JoinColumn(name = "PARENT_TALENT")
    public TalentBE parentTalent;

    @OneToMany(mappedBy = "parentTalent")
    public List<TalentBE> subTalents = new ArrayList<>();

    public TalentBE()
    {
        super();
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Boolean getSpecialisable()
    {
        return this.specialisable;
    }

    public void setSpecialisable(Boolean specialisable)
    {
        this.specialisable = specialisable;
    }

    public Boolean getAdvanceable()
    {
        return this.advanceable;
    }

    public void setAdvanceable(Boolean advanceable)
    {
        this.advanceable = advanceable;
    }

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public TalentBE getParentTalent()
    {
        return this.parentTalent;
    }

    public void setParentTalent(TalentBE parentTalent)
    {
        this.parentTalent = parentTalent;
    }

    public List<TalentBE> getSubTalents()
    {
        return this.subTalents;
    }

    public void setSubTalents(List<TalentBE> subTalents)
    {
        this.subTalents = subTalents;
    }
}
