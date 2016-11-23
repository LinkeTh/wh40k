package de.linket.rpg.wh40k.bc.web.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import de.linket.rpg.wh40k.bc.common.selection.SelectionWrapper;
import de.linket.rpg.wh40k.bc.types.ClassType;
import de.linket.rpg.wh40k.bc.types.RaceType;
import de.linket.rpg.wh40k.bc.types.SkillType;

@Service
public class SkillService
{
    public SelectionWrapper<SkillType> findByClass(ClassType classType)
    {
        return classType.getSkillWrapper();
    }

    public SelectionWrapper<SkillType> findByRace(RaceType raceType)
    {
        return raceType.getSkillWrapper();
    }

    public List<SkillType> findAll()
    {
        return Arrays.asList(SkillType.values()).stream().filter(i -> i.getParent() == null).collect(Collectors.toList());

        // return Arrays.asList(SkillType.values());
    }

}
