package de.linket.rpg.wh40k.bc.web.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import de.linket.rpg.wh40k.bc.types.ClassType;
import de.linket.rpg.wh40k.bc.types.RaceType;

@Service
public class ClassService
{
    public List<ClassType> findAll()
    {
        return Arrays.asList(ClassType.values());
    }

    public List<ClassType> findByRace(RaceType restriction)
    {
        return ClassType.getAvailableClasses(restriction);
    }
}
