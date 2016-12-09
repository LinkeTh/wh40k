package de.linket.rpg.wh40k.bc;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import de.linket.rpg.wh40k.bc.jpa.domain.RaceBE;
import de.linket.rpg.wh40k.bc.web.service.RaceService;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class SetupData
{
    private static final Logger log = LoggerFactory.getLogger(SetupData.class);

    @Autowired
    private RaceService raceService;

    @PostConstruct
    public void insertData()
    {
        this.insertSkills();
        this.insertTraits();
        this.insertTalents();
        this.insertRaces();
    }

    private void insertSkills()
    {
    }

    private void insertTraits()
    {
    }

    private void insertTalents()
    {
    }

    private void insertRaces()
    {
        log.debug("Inserting races");

        if (this.raceService.findByName("Jünger des Chaos") == null)
        {
            RaceBE human = new RaceBE();
            human.setName("Jünger des Chaos");
            human.setBaseAttributeValue(25);
            human.setStartExperience(1000L);

            this.raceService.saveRace(human);
        }

        if (this.raceService.findByName("Chaos Space Marine") == null)
        {
            RaceBE csm = new RaceBE();
            csm.setName("Chaos Space Marine");
            csm.setBaseAttributeValue(30);
            csm.setStartExperience(500L);

            this.raceService.saveRace(csm);
        }
    }
}
