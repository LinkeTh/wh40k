package de.linket.rpg.wh40k.bc.web.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.linket.rpg.wh40k.bc.jpa.domain.AttributeBE;
import de.linket.rpg.wh40k.bc.jpa.domain.RaceBE;
import de.linket.rpg.wh40k.bc.jpa.repository.AttributeRepository;
import de.linket.rpg.wh40k.bc.jpa.repository.RaceRepository;
import de.linket.rpg.wh40k.bc.types.RaceType;

@Service
public class RaceService {
	private static final Logger log = LoggerFactory.getLogger(RaceService.class);

	@Autowired
	private AttributeRepository attributeRepository;

	@Autowired
	private RaceRepository raceRepository;

	public RaceBE findByName(String name) {
		List<AttributeBE> attributes = this.attributeRepository.findAll();

		log.info("attributes loaded: " + attributes);

		return this.raceRepository.findByName(name);
	}

	public List<RaceType> findAll() {
		List<AttributeBE> attributes = this.attributeRepository.findAll();

		log.info("attributes loaded: " + attributes);
		return Arrays.asList(RaceType.values());
	}

	public void saveRace(RaceBE race) {
		this.raceRepository.saveAndFlush(race);
	}
}
