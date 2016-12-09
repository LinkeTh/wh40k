package de.linket.rpg.wh40k.bc.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import de.linket.rpg.wh40k.bc.types.DiceType;

@Entity
@Table(name = "WH_ATTRIBUTE")
public class AttributeBE extends AbstractPersistable {
	private static final long serialVersionUID = 1L;

	@Column(name = "NAME", length = 150, nullable = false)
	private String name;

	@Column(name = "SHORT_NAME", length = 2, nullable = false)
	private String shortName;

	@Column(name = "BONUS_NAME", length = 3, nullable = false)
	private String bonusName;

	@Enumerated(EnumType.STRING)
	@Column(name = "DICE", nullable = false)
	private DiceType dice;

	@Column(name = "MAX_BONUS")
	private Integer maxBonus;

	@Column(name = "NUMBER_OF_DICE", nullable = false)
	private Integer numberOfDice;

	public AttributeBE() {
		super();
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DiceType getDice() {
		return this.dice;
	}

	public void setDice(DiceType dice) {
		this.dice = dice;
	}

	public Integer getMaxBonus() {
		return this.maxBonus;
	}

	public void setMaxBonus(Integer maxBonus) {
		this.maxBonus = maxBonus;
	}

	public Integer getNumberOfDice() {
		return this.numberOfDice;
	}

	public void setNumberOfDice(Integer numberOfDice) {
		this.numberOfDice = numberOfDice;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AttributeBE [name=");
		builder.append(this.name);
		builder.append(", shortName=");
		builder.append(this.shortName);
		builder.append(", bonusName=");
		builder.append(this.bonusName);
		builder.append(", dice=");
		builder.append(this.dice);
		builder.append(", maxBonus=");
		builder.append(this.maxBonus);
		builder.append(", numberOfDice=");
		builder.append(this.numberOfDice);
		builder.append("]");
		return builder.toString();
	}

}
