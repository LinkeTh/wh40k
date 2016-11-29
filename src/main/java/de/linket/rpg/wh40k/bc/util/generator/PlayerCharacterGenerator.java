package de.linket.rpg.wh40k.bc.util.generator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import de.linket.rpg.wh40k.bc.common.GameObject;
import de.linket.rpg.wh40k.bc.common.selection.SelectionContainer;
import de.linket.rpg.wh40k.bc.common.selection.SelectionWrapper;
import de.linket.rpg.wh40k.bc.player.Character;
import de.linket.rpg.wh40k.bc.player.characteristics.Characteristic;
import de.linket.rpg.wh40k.bc.player.skills.Skill;
import de.linket.rpg.wh40k.bc.player.special.Initiative;
import de.linket.rpg.wh40k.bc.player.special.Wounds;
import de.linket.rpg.wh40k.bc.player.talents.Talent;
import de.linket.rpg.wh40k.bc.types.CharacterStateType;
import de.linket.rpg.wh40k.bc.types.CharacteristicType;
import de.linket.rpg.wh40k.bc.types.ClassType;
import de.linket.rpg.wh40k.bc.types.DisgraceType;
import de.linket.rpg.wh40k.bc.types.MotivationType;
import de.linket.rpg.wh40k.bc.types.PrideType;
import de.linket.rpg.wh40k.bc.types.RaceType;
import de.linket.rpg.wh40k.bc.types.SkillType;
import de.linket.rpg.wh40k.bc.types.TalentType;

public class PlayerCharacterGenerator
{
    private Character pc = null;
    private Scanner scanner = new Scanner(System.in);;

    public static void main(String[] args)
    {
        PlayerCharacterGenerator pcg = new PlayerCharacterGenerator();
        pcg.phase1();
        pcg.phase2();
        pcg.phase3();
        pcg.phase4();

        System.out.println(pcg.pc);
    }

    private void phase1()
    {
        RaceType race = (RaceType) this.handleSingleOption(Arrays.asList(RaceType.values()), "Please select your race: ");
        this.pc = new Character(race);
        this.pc.setState(CharacterStateType.IN_CREATION);
    }

    private void phase2()
    {
        List<Characteristic> characteristics = this.generateCharacteristics();
        characteristics.forEach(i -> this.pc.addCharacteristic(i));

        ClassType clazz = (ClassType) this.handleSingleOption(ClassType.getAvailableClasses(this.pc.getRace()), "Please select your class: ");
        this.pc.setClazz(clazz);

        this.pc.setPsyRating(clazz.getPsyRating());

        this.pc.setInitiative(new Initiative(this.pc.getCharacteristic(CharacteristicType.AGILITY).getModifiedBonus()));

        this.pc.setWounds(this.generateWounds());
    }

    private void phase3()
    {
        this.handleSkills(this.pc.getRace().getSkillWrapper());
        this.handleTalents(this.pc.getRace().getTalentWrapper());

        this.handleSkills(this.pc.getClazz().getSkillWrapper());
        this.handleTalents(this.pc.getClazz().getTalentWrapper());
    }

    private void phase4()
    {
        String name = this.handleTextInput("Please enter your name: ");
        this.pc.setName(name);

        PrideType pride = (PrideType) this.handleSingleOption(Arrays.asList(PrideType.values()), "Please select your pride: ");
        this.pc.setPride(pride);

        DisgraceType disgrace = (DisgraceType) this.handleSingleOption(Arrays.asList(DisgraceType.values()), "Please select your disgrace: ");
        this.pc.setDisgrace(disgrace);

        MotivationType motivation =
                        (MotivationType) this.handleSingleOption(Arrays.asList(MotivationType.values()), "Please select your motiviation: ");
        this.pc.setMotivation(motivation);
    }

    private Wounds generateWounds()
    {
        boolean accepted = false;
        Wounds value = null;

        while (!accepted)
        {
            try
            {
                value = this.pc.getClazz().getWound();
                value.roll();
                System.out.println("\t" + value);

                System.out.println("1.) accept");
                System.out.println("2.) decline");

                System.out.println("Accept or decline wounds: ");

                int selected = this.scanner.nextInt();

                this.scanner.nextLine();

                if (selected == 1)
                {
                    accepted = true;
                }
            }
            catch (Exception e)
            {
                this.scanner.nextLine();
            }
        }
        return value;
    }

    private List<Characteristic> generateCharacteristics()
    {
        boolean accepted = false;
        List<Characteristic> values = null;

        while (!accepted)
        {
            try
            {
                values = Arrays.asList(CharacteristicType.values()).stream().map(item -> new Characteristic(item, this.pc.getRace()))
                                .peek(Characteristic::roll).peek(i -> System.out.println("\t" + i))
                                .collect(Collectors.toList());

                System.out.println("1.) accept");
                System.out.println("2.) decline");

                System.out.println("Accept or decline characteristics: ");

                int selected = this.scanner.nextInt();

                this.scanner.nextLine();

                if (selected == 1)
                {
                    accepted = true;
                }
            }
            catch (Exception e)
            {
                this.scanner.nextLine();
            }
        }

        return values;
    }

    private String handleTextInput(String msg)
    {
        System.out.println(msg);

        String selected = this.scanner.nextLine();

        return selected;
    }

    private void handleSkills(SelectionWrapper<SkillType> wrapper)
    {
        for (SelectionContainer<SkillType> skillContainer : wrapper.getSelectionContainer())
        {
            Skill skill = null;

            switch (skillContainer.getType())
            {
                case SINGLE:
                case MULTI:
                {
                    SkillType st = skillContainer.getValues().get(0);
                    if (!st.isSpecialisable())
                    {
                        skill = new Skill(st);
                        this.pc.addSkill(skill);
                        break;
                    }

                    for (int i = 0; i < skillContainer.getValues().size(); i++)
                    {
                        skill = null;

                        List<SkillType> subTypes = st.getAvailableSubTypes();

                        int index = 1;

                        for (SkillType subType : subTypes)
                        {
                            System.out.println((index++) + ".) " + subType);
                        }

                        while (skill == null)
                        {
                            try
                            {
                                System.out.println("Enter Skill ID:");

                                int selected = this.scanner.nextInt();

                                this.scanner.nextLine();

                                skill = new Skill(subTypes.get(selected - 1));
                            }
                            catch (Exception e)
                            {
                                this.scanner.nextLine();

                                System.err.println("Skill ID not found!\n");
                                skill = null;
                            }
                        }

                        if (skill != null)
                        {
                            if (this.pc.containsSkill(skill))
                            {
                                System.err.println("Skill " + skill.getType() + " already added!\n");
                                i--;
                                continue;
                            }

                            this.pc.addSkill(skill);
                        }
                    }
                    break;
                }
                case DECISION:
                {
                    int index = 1;

                    for (SkillType subType : skillContainer.getValues())
                    {
                        System.out.println((index++) + ".) " + subType);
                    }

                    while (skill == null)
                    {
                        try
                        {
                            System.out.println("Please choose one Skill ID:");

                            int selected = this.scanner.nextInt();

                            this.scanner.nextLine();

                            skill = new Skill(skillContainer.getValues().get(selected - 1));
                        }
                        catch (Exception e)
                        {
                            this.scanner.nextLine();
                            System.err.println("Skill ID not found!\n");
                            skill = null;
                        }
                    }

                    if (skill != null)
                    {
                        this.pc.addSkill(skill);
                    }

                    break;
                }
                default:
                    break;
            }
        }
    }

    private void handleTalents(SelectionWrapper<TalentType> wrapper)
    {
        for (SelectionContainer<TalentType> talentContainer : wrapper.getSelectionContainer())
        {
            Talent talent = null;

            switch (talentContainer.getType())
            {
                case SINGLE:
                case MULTI:
                {
                    TalentType st = talentContainer.getValues().get(0);
                    talent = new Talent(st);
                    this.pc.addTalent(talent);
                    break;
                }
                case DECISION:
                {
                    int index = 1;

                    for (TalentType type : talentContainer.getValues())
                    {
                        System.out.println((index++) + ".) " + type);
                    }

                    while (talent == null)
                    {
                        try
                        {
                            System.out.println("Please choose one Talent ID:");

                            int selected = this.scanner.nextInt();

                            this.scanner.nextLine();

                            talent = new Talent(talentContainer.getValues().get(selected - 1));
                        }
                        catch (IndexOutOfBoundsException e)
                        {
                            System.err.println("Skill ID not found!\n");
                            talent = null;
                        }
                    }

                    if (talent != null)
                    {
                        this.pc.addTalent(talent);
                    }

                    break;
                }
                default:
                    break;
            }
        }
    }

    private GameObject handleSingleOption(List<? extends GameObject> data, String msg)
    {
        int index = 1;

        for (GameObject entry : data)
        {
            System.out.println((index++) + ".) " + entry);
        }

        GameObject result = null;

        while (result == null)
        {
            try
            {
                System.out.println(msg);

                int selected = this.scanner.nextInt();

                this.scanner.nextLine();

                result = data.get(selected - 1);
            }
            catch (Exception e)
            {
                System.err.println("ID not found!\n");
                this.scanner.nextLine();
            }
        }

        return result;
    }
}
