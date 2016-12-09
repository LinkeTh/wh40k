package de.linket.rpg.wh40k.bc.web.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.linket.rpg.wh40k.bc.common.selection.SelectionWrapper;
import de.linket.rpg.wh40k.bc.jpa.domain.SkillBE;
import de.linket.rpg.wh40k.bc.jpa.repository.SkillRepository;
import de.linket.rpg.wh40k.bc.player.skills.Skill;
import de.linket.rpg.wh40k.bc.types.ClassType;
import de.linket.rpg.wh40k.bc.types.RaceType;
import de.linket.rpg.wh40k.bc.types.SkillType;

@Service
public class SkillService
{
	@Autowired
	private SkillRepository skillRepository;

	public SkillBE findByName(String name)
	{
		return this.skillRepository.findByName(name);
	}

	public SelectionWrapper<Skill> findByClass(ClassType classType)
	{
		return classType.getSkillWrapper();
	}

	public SelectionWrapper<Skill> findByRace(RaceType raceType)
	{
		return raceType.getSkillWrapper();
	}

	public List<SkillType> findAll()
	{
		return Arrays.asList(SkillType.values()).stream().filter(i -> i.getParent() == null).collect(Collectors.toList());
	}

	public void saveSkill(SkillBE skill)
	{
		this.skillRepository.saveAndFlush(skill);
	}
}
