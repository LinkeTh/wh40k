package de.linket.rpg.wh40k.bc.web.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import de.linket.rpg.wh40k.bc.common.selection.SelectionWrapper;
import de.linket.rpg.wh40k.bc.types.ClassType;
import de.linket.rpg.wh40k.bc.types.RaceType;
import de.linket.rpg.wh40k.bc.types.TalentType;

@Service
public class TalentService
{
    public SelectionWrapper<TalentType> findByClass(ClassType classType)
    {
        return classType.getTalentWrapper();
    }

    public SelectionWrapper<TalentType> findByRace(RaceType raceType)
    {
        return raceType.getTalentWrapper();
    }

    public List<TalentType> findAll()
    {
        return Arrays.asList(TalentType.values()).stream().filter(i -> i.getParent() == null).collect(Collectors.toList());
    }
}
