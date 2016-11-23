package de.linket.rpg.wh40k.bc.types;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import de.linket.rpg.wh40k.bc.common.GameObject;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum SkillType implements GameObject
{
	ACROBATICS(CharacteristicType.AGILITY),
	ATHLETICS(CharacteristicType.STRENGTH),
	AWARENESS(CharacteristicType.PERCEPTION),
	CHARM(CharacteristicType.FELLOWSHIP),
	COMMAND(CharacteristicType.FELLOWSHIP),
	COMMERCE(CharacteristicType.INTELLIGENCE),
	COMMON_LORE(true),
	COMMON_LORE_ADEPTUS_ARBITES(COMMON_LORE, CharacteristicType.INTELLIGENCE),
	COMMON_LORE_ADEPTUS_ASTRA_TELEPATHICA(COMMON_LORE, CharacteristicType.INTELLIGENCE),
	COMMON_LORE_ADEPTUS_MECHANICUS(COMMON_LORE, CharacteristicType.INTELLIGENCE),
	COMMON_LORE_ADMINISTRATUM(COMMON_LORE, CharacteristicType.INTELLIGENCE),
	COMMON_LORE_ECCLESIARCHY(COMMON_LORE, CharacteristicType.INTELLIGENCE),
	COMMON_LORE_IMPERIAL_CREED(COMMON_LORE, CharacteristicType.INTELLIGENCE),
	COMMON_LORE_IMPERIAL_GUARD(COMMON_LORE, CharacteristicType.INTELLIGENCE),
	COMMON_LORE_IMPERIAL_NAVY(COMMON_LORE, CharacteristicType.INTELLIGENCE),
	COMMON_LORE_IMPERIUM(COMMON_LORE, CharacteristicType.INTELLIGENCE),
	COMMON_LORE_JERICHO_REACH(COMMON_LORE, CharacteristicType.INTELLIGENCE),
	COMMON_LORE_SCREAMING_VORTEX(COMMON_LORE, CharacteristicType.INTELLIGENCE),
	COMMON_LORE_TECH(COMMON_LORE, CharacteristicType.INTELLIGENCE),
	COMMON_LORE_TODO_EXPANSE(COMMON_LORE, CharacteristicType.INTELLIGENCE),
	COMMON_LORE_WAR(COMMON_LORE, CharacteristicType.INTELLIGENCE),
	DECEIVE(CharacteristicType.FELLOWSHIP),
	DODGE(CharacteristicType.AGILITY),
	FORBIDDEN_LORE(true),
	FORBIDDEN_LORE_ADEPTUS_ARTARTES(FORBIDDEN_LORE, CharacteristicType.INTELLIGENCE),
	FORBIDDEN_LORE_ADEPTUS_MECHANICUS(FORBIDDEN_LORE, CharacteristicType.INTELLIGENCE),
	FORBIDDEN_LORE_ARCHEOTECH(FORBIDDEN_LORE, CharacteristicType.INTELLIGENCE),
	FORBIDDEN_LORE_CODEX_ASTARTES(FORBIDDEN_LORE, CharacteristicType.INTELLIGENCE),
	FORBIDDEN_LORE_DAEMONOLOGY(FORBIDDEN_LORE, CharacteristicType.INTELLIGENCE),
	FORBIDDEN_LORE_HERESY(FORBIDDEN_LORE, CharacteristicType.INTELLIGENCE),
	FORBIDDEN_LORE_HORUS(FORBIDDEN_LORE, CharacteristicType.INTELLIGENCE),
	FORBIDDEN_LORE_INQUISITION(FORBIDDEN_LORE, CharacteristicType.INTELLIGENCE),
	FORBIDDEN_LORE_MUTANTS(FORBIDDEN_LORE, CharacteristicType.INTELLIGENCE),
	FORBIDDEN_LORE_NAVIGATION(FORBIDDEN_LORE, CharacteristicType.INTELLIGENCE),
	FORBIDDEN_LORE_PIRATES(FORBIDDEN_LORE, CharacteristicType.INTELLIGENCE),
	FORBIDDEN_LORE_PSYKERS(FORBIDDEN_LORE, CharacteristicType.INTELLIGENCE),
	FORBIDDEN_LORE_WARP(FORBIDDEN_LORE, CharacteristicType.INTELLIGENCE),
	FORBIDDEN_LORE_XENOS(FORBIDDEN_LORE, CharacteristicType.INTELLIGENCE),
	INQUIRY(CharacteristicType.INTELLIGENCE),
	INTIMIDATE(CharacteristicType.WILLPOWER),
	LINGUISTICST(true),
	LINGUISTICST_CHAOS_MARKS(LINGUISTICST, CharacteristicType.INTELLIGENCE),
	LINGUISTICST_CHAPTER_RUNES(LINGUISTICST, CharacteristicType.INTELLIGENCE),
	LINGUISTICST_ELDAR(LINGUISTICST, CharacteristicType.INTELLIGENCE),
	LINGUISTICST_HIGH_GOTIC(LINGUISTICST, CharacteristicType.INTELLIGENCE),
	LINGUISTICST_IMPERIAL_CODES(LINGUISTICST, CharacteristicType.INTELLIGENCE),
	LINGUISTICST_KROOT(LINGUISTICST, CharacteristicType.INTELLIGENCE),
	LINGUISTICST_LOW_GOTIC(LINGUISTICST, CharacteristicType.INTELLIGENCE),
	LINGUISTICST_MERCENARY_CANT(LINGUISTICST, CharacteristicType.INTELLIGENCE),
	LINGUISTICST_ORK(LINGUISTICST, CharacteristicType.INTELLIGENCE),
	LINGUISTICST_TAU(LINGUISTICST, CharacteristicType.INTELLIGENCE),
	LINGUISTICST_TECHNA_LINGUA(LINGUISTICST, CharacteristicType.INTELLIGENCE),
	LINGUISTICST_UNDERWORLD(LINGUISTICST, CharacteristicType.INTELLIGENCE),
	LINGUISTICST_XENOS_MARKINGS(LINGUISTICST, CharacteristicType.INTELLIGENCE),
	LOGIC(CharacteristicType.INTELLIGENCE),
	MEDICAE(CharacteristicType.INTELLIGENCE),
	NAVIGATION(true),
	NAVIGATION_STELLAR(NAVIGATION, CharacteristicType.INTELLIGENCE),
	NAVIGATION_SURFACE(NAVIGATION, CharacteristicType.INTELLIGENCE),
	NAVIGATION_WARP(NAVIGATION, CharacteristicType.INTELLIGENCE),
	OPERATE(true),
	OPERATE_AERONAUTICA(OPERATE, CharacteristicType.AGILITY),
	OPERATE_SURFACE(OPERATE, CharacteristicType.AGILITY),
	OPERATE_VOIDSHIP(OPERATE, CharacteristicType.INTELLIGENCE),
	PARRY(CharacteristicType.WEAPON_SKILL),
	PSYNISCIENCE(CharacteristicType.PERCEPTION),
	SCHOLASTIC_LORE(true),
	SCHOLASTIC_LORE_ASTROMANCY(SCHOLASTIC_LORE, CharacteristicType.INTELLIGENCE),
	SCHOLASTIC_LORE_BEASTS(SCHOLASTIC_LORE, CharacteristicType.INTELLIGENCE),
	SCHOLASTIC_LORE_BUREAUCRACY(SCHOLASTIC_LORE, CharacteristicType.INTELLIGENCE),
	SCHOLASTIC_LORE_CHYMISTRY(SCHOLASTIC_LORE, CharacteristicType.INTELLIGENCE),
	SCHOLASTIC_LORE_CRYPTOLOGY(SCHOLASTIC_LORE, CharacteristicType.INTELLIGENCE),
	SCHOLASTIC_LORE_HERALDRY(SCHOLASTIC_LORE, CharacteristicType.INTELLIGENCE),
	SCHOLASTIC_LORE_IMPERIAL_CREED(SCHOLASTIC_LORE, CharacteristicType.INTELLIGENCE),
	SCHOLASTIC_LORE_IMPERIAL_WARRANTS(SCHOLASTIC_LORE, CharacteristicType.INTELLIGENCE),
	SCHOLASTIC_LORE_JUDGEMENT(SCHOLASTIC_LORE, CharacteristicType.INTELLIGENCE),
	SCHOLASTIC_LORE_LEGEND(SCHOLASTIC_LORE, CharacteristicType.INTELLIGENCE),
	SCHOLASTIC_LORE_NAVIS_NOBILITE(SCHOLASTIC_LORE, CharacteristicType.INTELLIGENCE),
	SCHOLASTIC_LORE_NUMEROLOGY(SCHOLASTIC_LORE, CharacteristicType.INTELLIGENCE),
	SCHOLASTIC_LORE_OCCULT(SCHOLASTIC_LORE, CharacteristicType.INTELLIGENCE),
	SCHOLASTIC_LORE_PHILOSOPHY(SCHOLASTIC_LORE, CharacteristicType.INTELLIGENCE),
	SCHOLASTIC_LORE_TACTICA_IMPERIALIS(SCHOLASTIC_LORE, CharacteristicType.INTELLIGENCE),
	SCRUTINY(CharacteristicType.PERCEPTION),
	SECURITY(CharacteristicType.INTELLIGENCE),
	SLEIGHT_OF_HAND(CharacteristicType.AGILITY),
	STEALTH(CharacteristicType.AGILITY),
	SURVIVAL(CharacteristicType.PERCEPTION),
	TECH_USE(CharacteristicType.INTELLIGENCE),
	TRADE(true),
	TRADE_ARCHAEOLOGIST(TRADE, CharacteristicType.INTELLIGENCE),
	TRADE_ARMOURER(TRADE, CharacteristicType.INTELLIGENCE),
	TRADE_ASTROGRAPHER(TRADE, CharacteristicType.INTELLIGENCE),
	TRADE_CHYMIST(TRADE, CharacteristicType.INTELLIGENCE),
	TRADE_CRYPTOGRAPHER(TRADE, CharacteristicType.INTELLIGENCE),
	TRADE_EXPLORATOR(TRADE, CharacteristicType.INTELLIGENCE),
	TRADE_LINGUIST(TRADE, CharacteristicType.INTELLIGENCE),
	TRADE_REMEMBRANCER(TRADE, CharacteristicType.INTELLIGENCE),
	TRADE_SCRIMSHAWER(TRADE, CharacteristicType.INTELLIGENCE),
	TRADE_SHIPWRIGTH(TRADE, CharacteristicType.INTELLIGENCE),
	TRADE_SOOTHSAYER(TRADE, CharacteristicType.INTELLIGENCE),
	TRADE_TECHNOMAT(TRADE, CharacteristicType.INTELLIGENCE),
	TRADE_VOIDFARER(TRADE, CharacteristicType.INTELLIGENCE);

	private CharacteristicType[] characteristics;
	private SkillType parent;
	private boolean specialisable;

	private SkillType(boolean specialisable, CharacteristicType... characteristics)
	{
		this(specialisable, null, characteristics);
	}

	private SkillType(boolean specialisable, SkillType parent, CharacteristicType... characteristics)
	{
		this.characteristics = characteristics;
		this.specialisable = specialisable;
		this.parent = parent;
	}

	private SkillType(CharacteristicType... characteristics)
	{
		this(false, null, characteristics);
	}

	private SkillType(SkillType parent, CharacteristicType... characteristics)
	{
		this(false, parent, characteristics);
	}

	@JsonIgnore
	public List<SkillType> getAvailableSubTypes()
	{
		return Arrays.asList(SkillType.values()).stream().filter(st -> this.equals(st.parent)).collect(Collectors.toList());
	}

	public CharacteristicType[] getCharacteristics()
	{
		return this.characteristics;
	}

	public String getName()
	{
		return this.name();
	}

	@JsonIgnore
	public SkillType getParent()
	{
		return this.parent;
	}

	public boolean isSpecialisable()
	{
		return this.specialisable;
	}


	@JsonCreator
	public static SkillType fromName(@JsonProperty("name") String name)
	{
		if(name == null)
		{
			return null;
		}

		for(SkillType type : SkillType.values())
		{
			if(type.getName().equalsIgnoreCase(name))
			{
				return type;
			}
		}
		return null;
	}
}
