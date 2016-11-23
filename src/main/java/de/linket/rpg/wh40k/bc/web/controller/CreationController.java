package de.linket.rpg.wh40k.bc.web.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;

import de.linket.rpg.wh40k.bc.characteristics.Characteristic;
import de.linket.rpg.wh40k.bc.common.selection.SelectionWrapper;
import de.linket.rpg.wh40k.bc.player.Character;
import de.linket.rpg.wh40k.bc.special.PsyRating;
import de.linket.rpg.wh40k.bc.special.Wounds;
import de.linket.rpg.wh40k.bc.types.CharacterStateType;
import de.linket.rpg.wh40k.bc.types.CharacteristicType;
import de.linket.rpg.wh40k.bc.types.ClassType;
import de.linket.rpg.wh40k.bc.types.RaceType;
import de.linket.rpg.wh40k.bc.types.SkillType;
import de.linket.rpg.wh40k.bc.types.TalentType;
import de.linket.rpg.wh40k.bc.web.service.ClassService;
import de.linket.rpg.wh40k.bc.web.service.SkillService;
import de.linket.rpg.wh40k.bc.web.service.TalentService;;

@RestController
@RequestMapping("/api/v1/creation")
@Api(value = "creation", description = "Creation resource endpoint")
public class CreationController {
	private static final Logger log = LoggerFactory.getLogger(CreationController.class);

	private static Map<String, Character> characterMap = new HashMap<>();

	@Autowired
	private TalentService talentService;

	@Autowired
	private SkillService skillService;

	@Autowired
	private ClassService classService;

	@RequestMapping(value = "/character/{id}", method = RequestMethod.GET)
	public Character getCharacter(@PathVariable("id") String id) {

		log.debug("Get character " + id);

		Assert.notNull(id);

		return characterMap.get(id);
	}

	@RequestMapping(value = "/character/{id}/characteristics", method = RequestMethod.PUT)
	public Character addCharacteristics(@PathVariable("id") String id, @RequestBody Characteristic[] characteristics) {

		log.debug("Add characteristics to " + id);

		Assert.notNull(id);
		Assert.notEmpty(characteristics);

		Character character = characterMap.get(id);

		Assert.notNull(character);

		Arrays.asList(characteristics).forEach(i -> character.addCharacteristic(i));

		return character;
	}

	@RequestMapping(value = "/character/{id}/class", method = RequestMethod.PUT)
	public Character addClass(@PathVariable("id") String id, @RequestBody ClassType classType) {

		log.debug("Add class to " + id);

		Assert.notNull(id);
		Assert.notNull(classType);

		Character character = characterMap.get(id);

		Assert.notNull(character);

		character.setClazz(classType);

		character.setPsyRating(this.getPsyRating(classType));

		return character;
	}

	@RequestMapping(value = "/character/{id}/wounds", method = RequestMethod.PUT)
	public Character addWounds(@PathVariable("id") String id, @RequestBody Wounds wound) {

		log.debug("Add wounds to " + id);

		Assert.notNull(id);
		Assert.notNull(wound);

		Character character = characterMap.get(id);

		Assert.notNull(character);

		character.setWounds(wound);;

		return character;
	}


	@RequestMapping(value = "/character", method = RequestMethod.POST)
	public Character createCharacter(@RequestBody RaceType raceType) {

		log.debug("Create new character");

		Assert.notNull(raceType);

		Character pc = new Character(raceType);
		pc.setState(CharacterStateType.IN_CREATION);

		characterMap.put(pc.getId(), pc);

		return pc;
	}

	// @RequestMapping(value = "/character/race/{raceType}", method =
	// RequestMethod.GET)
	// public Character createNewChar(@PathVariable("raceType") RaceType
	// raceType)
	// {
	// Character pc = new Character(raceType);
	// pc.setState(CharacterStateType.IN_CREATION);
	//
	// log.debug("Create new character");
	// return pc;
	// }

	@RequestMapping(value = "/classes/{classType}/psy-rating", method = RequestMethod.GET)
	public PsyRating getPsyRating(@PathVariable("classType") ClassType classType) {
		log.debug("Get psyrating for class " + classType);

		Assert.notNull(classType);

		PsyRating value = classType.getPsyRating();

		return value;
	}

	@RequestMapping(value = "/classes/{classType}/wounds", method = RequestMethod.GET)
	public Wounds getWounds(@PathVariable("classType") ClassType classType) {

		log.debug("Roll wounds for class " + classType);

		Assert.notNull(classType);

		Wounds value = classType.getWound();
		value.roll();

		return value;
	}

	@RequestMapping(value = "/races/{raceType}/characteristics", method = RequestMethod.GET)
	public List<Characteristic> getCharacteristics(@PathVariable("raceType") RaceType raceType) {
		log.debug("Roll characteristics for race " + raceType);

		Assert.notNull(raceType);

		List<Characteristic> characteristics = Arrays.asList(CharacteristicType.values()).stream().map(item -> new Characteristic(item, raceType)).peek(Characteristic::roll).collect(Collectors.toList());

		return characteristics;
	}

	@RequestMapping(value = "/races/{raceType}/classes", method = RequestMethod.GET)
	public List<ClassType> getAvailableClasses(@PathVariable("raceType") RaceType raceType) {
		log.debug("Getting classes for race " + raceType);

		Assert.notNull(raceType);

		return this.classService.findByRace(raceType);
	}

	@RequestMapping(value = "/classes/{classType}/talents", method = RequestMethod.GET)
	public SelectionWrapper<TalentType> getTalentsForClass(@PathVariable("classType") ClassType classType) {
		log.debug("Getting talents for class " + classType);

		Assert.notNull(classType);

		return this.talentService.findByClass(classType);
	}

	@RequestMapping(value = "/classes/{classType}/skills", method = RequestMethod.GET)
	public SelectionWrapper<SkillType> getSkillsForClass(@PathVariable("classType") ClassType classType) {
		log.debug("Getting skills for class " + classType);

		Assert.notNull(classType);

		return this.skillService.findByClass(classType);
	}

	@RequestMapping(value = "/races/{raceType}/talents", method = RequestMethod.GET)
	public SelectionWrapper<TalentType> getTalentsForRace(@PathVariable("raceType") RaceType raceType) {
		log.debug("Getting talents for race " + raceType);
		return this.talentService.findByRace(raceType);
	}

	@RequestMapping(value = "/races/{raceType}/skills", method = RequestMethod.GET)
	public SelectionWrapper<SkillType> getSkillsForRace(@PathVariable("raceType") RaceType raceType) {
		log.debug("Getting skills for race " + raceType);

		Assert.notNull(raceType);

		return this.skillService.findByRace(raceType);
	}

}
