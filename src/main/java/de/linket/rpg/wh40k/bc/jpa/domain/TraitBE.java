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
@Table(name = "WH_TRAIT")
public class TraitBE extends AbstractPersistable
{
	private static final long serialVersionUID = 1L;

	@Column(name = "NAME", length = 150, nullable = false)
	private String name;

	@OneToMany
	@JoinTable(name = "WH_TRAIT_MODIFIER", joinColumns = { @JoinColumn(name = "TRAIT_ID", referencedColumnName = "id") },
	inverseJoinColumns = { @JoinColumn(name = "MODIFIER_ID", referencedColumnName = "id") })
	private List<ModifierBE> modifiers = new ArrayList<>();

	public TraitBE()
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

	public List<ModifierBE> getModifiers()
	{
		return this.modifiers;
	}

	public void setModifiers(List<ModifierBE> modifiers)
	{
		this.modifiers = modifiers;
	}
}
