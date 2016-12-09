package de.linket.rpg.wh40k.bc.jpa.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "WH_RACE")
public class RaceBE extends AbstractPersistable
{
	private static final long serialVersionUID = 1L;

	@Column(name = "NAME", length = 50, nullable = false)
	private String name;

	@Column(name = "START_EXPERIENCE", precision = 10, scale = 0)
	private Long startExperience;

	@Column(name = "BASE_ATTRIBUTE_VALUE", precision = 2, scale = 0, nullable = false)
	private Integer baseAttributeValue;

	@OneToMany
	@JoinTable(name = "WH_RACE_SKILL", joinColumns = { @JoinColumn(name = "RACE_ID", referencedColumnName = "id") },
	inverseJoinColumns = { @JoinColumn(name = "SKILL_ID", referencedColumnName = "id") })
	private List<SkillBE> skills = new ArrayList<>();

	@OneToMany
	@JoinTable(name = "WH_RACE_TALENT", joinColumns = { @JoinColumn(name = "RACE_ID", referencedColumnName = "id") },
	inverseJoinColumns = { @JoinColumn(name = "TALENT_ID", referencedColumnName = "id") })
	private List<TalentBE> talents = new ArrayList<>();

	@OneToMany
	@JoinTable(name = "WH_RACE_TRAIT", joinColumns = { @JoinColumn(name = "RACE_ID", referencedColumnName = "id") },
	inverseJoinColumns = { @JoinColumn(name = "TRAIT_ID", referencedColumnName = "id") })
	private List<TraitBE> traits = new ArrayList<>();

	public RaceBE()
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

	public Long getStartExperience()
	{
		return this.startExperience;
	}

	public void setStartExperience(Long startExperience)
	{
		this.startExperience = startExperience;
	}

	public Integer getBaseAttributeValue()
	{
		return this.baseAttributeValue;
	}

	public void setBaseAttributeValue(Integer baseAttributeValue)
	{
		this.baseAttributeValue = baseAttributeValue;
	}

	public List<SkillBE> getSkills()
	{
		return this.skills;
	}

	public void setSkills(List<SkillBE> skills)
	{
		this.skills = skills;
	}

	public List<TalentBE> getTalents()
	{
		return this.talents;
	}

	public void setTalents(List<TalentBE> talents)
	{
		this.talents = talents;
	}

	public List<TraitBE> getTraits()
	{
		return this.traits;
	}

	public void setTraits(List<TraitBE> traits)
	{
		this.traits = traits;
	}
}
