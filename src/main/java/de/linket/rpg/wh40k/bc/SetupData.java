package de.linket.rpg.wh40k.bc;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import de.linket.rpg.wh40k.bc.web.service.RaceService;
import de.linket.rpg.wh40k.bc.web.service.SkillService;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class SetupData {
	private static final Logger log = LoggerFactory.getLogger(SetupData.class);

	@Autowired
	private RaceService raceService;

	@Autowired
	private SkillService skillService;

	@PostConstruct
	public void insertData() {
		this.insertSkills();
		this.insertTraits();
		this.insertTalents();
		this.insertRaces();
	}

	private void insertSkills() {
	}

	private void insertTraits() {
	}

	private void insertTalents() {
	}

	private void insertRaces() {
	}
}
