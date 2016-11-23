package de.linket.rpg.wh40k.bc.web.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import de.linket.rpg.wh40k.bc.types.ArmorType;
import de.linket.rpg.wh40k.bc.types.MiscItemType;
import de.linket.rpg.wh40k.bc.types.WeaponType;

@Service
public class ItemService
{
    public List<WeaponType> findAllWeapons()
    {
        return Arrays.asList(WeaponType.values());
    }

    public List<ArmorType> findAllArmors()
    {
        return Arrays.asList(ArmorType.values());
    }

    public List<MiscItemType> findAllMiscItems()
    {
        return Arrays.asList(MiscItemType.values());
    }

}
