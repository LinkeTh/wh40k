package de.linket.rpg.wh40k.bc.web.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import de.linket.rpg.wh40k.bc.common.selection.SelectionWrapper;
import de.linket.rpg.wh40k.bc.types.ClassType;
import de.linket.rpg.wh40k.bc.types.RaceType;
import de.linket.rpg.wh40k.bc.types.TraitType;

@Service
public class TraitService
{
    public SelectionWrapper<TraitType> findByClass(ClassType classType)
    {
        return classType.getTraitWrapper();
    }

    public SelectionWrapper<TraitType> findByRace(RaceType raceType)
    {
        return raceType.getTraitWrapper();
    }

    public List<TraitType> findAll()
    {
        return Arrays.asList(TraitType.values());
    }

}
