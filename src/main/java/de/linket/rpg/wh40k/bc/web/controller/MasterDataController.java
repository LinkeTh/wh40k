package de.linket.rpg.wh40k.bc.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;

import de.linket.rpg.wh40k.bc.types.ArmorType;
import de.linket.rpg.wh40k.bc.types.ClassType;
import de.linket.rpg.wh40k.bc.types.DisgraceType;
import de.linket.rpg.wh40k.bc.types.MiscItemType;
import de.linket.rpg.wh40k.bc.types.MotivationType;
import de.linket.rpg.wh40k.bc.types.PrideType;
import de.linket.rpg.wh40k.bc.types.RaceType;
import de.linket.rpg.wh40k.bc.types.SkillType;
import de.linket.rpg.wh40k.bc.types.TalentType;
import de.linket.rpg.wh40k.bc.types.WeaponType;
import de.linket.rpg.wh40k.bc.web.service.BackgroundService;
import de.linket.rpg.wh40k.bc.web.service.ClassService;
import de.linket.rpg.wh40k.bc.web.service.ItemService;
import de.linket.rpg.wh40k.bc.web.service.RaceService;
import de.linket.rpg.wh40k.bc.web.service.SkillService;
import de.linket.rpg.wh40k.bc.web.service.TalentService;;

@RestController
@RequestMapping("/api/v1/data")
@Api(value = "data", description = "Master data resource endpoint")
public class MasterDataController
{
    private static final Logger log = LoggerFactory.getLogger(MasterDataController.class);

    @Autowired
    private TalentService talentService;

    @Autowired
    private RaceService raceService;

    @Autowired
    private SkillService skillService;

    @Autowired
    private ClassService classService;

    @Autowired
    private BackgroundService bgService;

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/weapons", method = RequestMethod.GET)
    public List<WeaponType> getAllWeapons()
    {
        log.debug("Getting all weapons");
        return this.itemService.findAllWeapons();
    }

    @RequestMapping(value = "/misc-item", method = RequestMethod.GET)
    public List<MiscItemType> getAllMiscItems()
    {
        log.debug("Getting all misc items");
        return this.itemService.findAllMiscItems();
    }

    @RequestMapping(value = "/armors", method = RequestMethod.GET)
    public List<ArmorType> getAllArmors()
    {
        log.debug("Getting all armors");
        return this.itemService.findAllArmors();
    }

    @RequestMapping(value = "/prides", method = RequestMethod.GET)
    public List<PrideType> getAllPrides()
    {
        log.debug("Getting all prides");
        return this.bgService.findAllPrides();
    }

    @RequestMapping(value = "/disgraces", method = RequestMethod.GET)
    public List<DisgraceType> getAllDisgraces()
    {
        log.debug("Getting all disgraces");
        return this.bgService.findAllDisgraces();
    }

    @RequestMapping(value = "/motivations", method = RequestMethod.GET)
    public List<MotivationType> getAllMotiviations()
    {
        log.debug("Getting all motivations");
        return this.bgService.findAllMotivations();
    }

    @RequestMapping(value = "/talents", method = RequestMethod.GET)
    public List<TalentType> getAllTalents()
    {
        log.debug("Getting all talents");
        return this.talentService.findAll();
    }

    @RequestMapping(value = "/races", method = RequestMethod.GET)
    public List<RaceType> getRaces()
    {
        log.debug("Getting all races");
        return this.raceService.findAll();
    }

    @RequestMapping(value = "/classes", method = RequestMethod.GET)
    public List<ClassType> getClasses()
    {
        log.debug("Getting all classes");
        return this.classService.findAll();
    }

    @RequestMapping(value = "/skills", method = RequestMethod.GET)
    public List<SkillType> getSkills()
    {
        log.debug("Getting all skills");
        return this.skillService.findAll();
    }

    @RequestMapping(value = "/talents/{talentType}/sub-talents", method = RequestMethod.GET)
    public List<TalentType> getSubTalents(@PathVariable("talentType") TalentType talentType)
    {
        log.debug("Getting sub talents for " + talentType);

        if (talentType.isSpecialisable())
        {
            return talentType.getAvailableSubTypes();
        }
        return null;
    }

    @RequestMapping(value = "/skills/{skillType}/sub-skills", method = RequestMethod.GET)
    public List<SkillType> getSubSkills(@PathVariable("skillType") SkillType skillType)
    {
        log.debug("Getting sub skills for " + skillType);

        if (skillType.isSpecialisable())
        {
            return skillType.getAvailableSubTypes();
        }
        return null;
    }
}
