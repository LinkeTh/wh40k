package de.linket.rpg.wh40k.bc.web.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.linket.rpg.wh40k.bc.jpa.domain.RaceBE;
import de.linket.rpg.wh40k.bc.jpa.repository.RaceRepository;
import de.linket.rpg.wh40k.bc.types.RaceType;

@Service
public class RaceService
{
    @Autowired
    private RaceRepository raceRepository;

    public RaceBE findByName(String name)
    {
        return this.raceRepository.findByName(name);
    }

    public List<RaceType> findAll()
    {
        return Arrays.asList(RaceType.values());
    }

    public void saveRace(RaceBE human)
    {
        this.raceRepository.saveAndFlush(human);
    }
}
