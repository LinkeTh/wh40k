package de.linket.rpg.wh40k.bc.web.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import de.linket.rpg.wh40k.bc.types.RaceType;

@Service
public class RaceService
{
    public List<RaceType> findAll()
    {
        return Arrays.asList(RaceType.values());
    }

}
