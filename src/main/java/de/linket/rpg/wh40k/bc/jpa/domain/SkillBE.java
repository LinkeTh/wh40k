package de.linket.rpg.wh40k.bc.jpa.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import de.linket.rpg.wh40k.bc.types.AttributeType;

@Entity
@Table(name = "WH_SKILL")
public class SkillBE extends AbstractPersistable
{
    private static final long serialVersionUID = 1L;

    @Column(name = "NAME", length = 150, nullable = false)
    private String name;

    @Column(name = "ATTRIBUTE", nullable = false)
    public AttributeType attribute;

    @Column(name = "SPECIALISABLE", nullable = false)
    private Boolean specialisable = false;

    @ManyToOne
    @JoinColumn(name = "PARENT_SKILL")
    public SkillBE parentSkill;

    @OneToMany(mappedBy = "parentSkill")
    public List<SkillBE> subSkills = new ArrayList<>();

    public SkillBE()
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

    public SkillBE getParentSkill()
    {
        return this.parentSkill;
    }

    public void setParentSkill(SkillBE parentSkill)
    {
        this.parentSkill = parentSkill;
    }

    public List<SkillBE> getSubSkills()
    {
        return this.subSkills;
    }

    public void setSubSkills(List<SkillBE> subSkills)
    {
        this.subSkills = subSkills;
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
