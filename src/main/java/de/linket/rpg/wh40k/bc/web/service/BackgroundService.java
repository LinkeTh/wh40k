package de.linket.rpg.wh40k.bc.web.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import de.linket.rpg.wh40k.bc.types.DisgraceType;
import de.linket.rpg.wh40k.bc.types.MotivationType;
import de.linket.rpg.wh40k.bc.types.PrideType;

@Service
public class BackgroundService
{
    public List<DisgraceType> findAllDisgraces()
    {
        return Arrays.asList(DisgraceType.values());
    }

    public List<MotivationType> findAllMotivations()
    {
        return Arrays.asList(MotivationType.values());
    }

    public List<PrideType> findAllPrides()
    {
        return Arrays.asList(PrideType.values());
    }
}
