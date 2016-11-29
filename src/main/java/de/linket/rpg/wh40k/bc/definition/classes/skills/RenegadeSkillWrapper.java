package de.linket.rpg.wh40k.bc.definition.classes.skills;

import java.util.ArrayList;
import java.util.List;

import de.linket.rpg.wh40k.bc.common.selection.DecisionComposer;
import de.linket.rpg.wh40k.bc.common.selection.SelectionContainer;
import de.linket.rpg.wh40k.bc.common.selection.SelectionWrapper;
import de.linket.rpg.wh40k.bc.common.selection.SingleComposer;
import de.linket.rpg.wh40k.bc.player.skills.Skill;
import de.linket.rpg.wh40k.bc.types.SkillStateType;
import de.linket.rpg.wh40k.bc.types.SkillType;

public class RenegadeSkillWrapper implements SelectionWrapper<Skill>
{
    @Override
    public List<SelectionContainer<Skill>> getSelectionContainer()
    {
        List<SelectionContainer<Skill>> result = new ArrayList<>();

        SelectionContainer<Skill> c1 = new SingleComposer<Skill>(new Skill(SkillType.ATHLETICS));
        SelectionContainer<Skill> c2 = new SingleComposer<Skill>(new Skill(SkillType.AWARENESS));
        SelectionContainer<Skill> c3 = new SingleComposer<Skill>(new Skill(SkillType.DODGE));
        SelectionContainer<Skill> c4 = new SingleComposer<Skill>(new Skill(SkillType.PARRY));
        SelectionContainer<Skill> c5 = new SingleComposer<Skill>(new Skill(SkillType.SCHOLASTIC_LORE_TACTICA_IMPERIALIS));
        SelectionContainer<Skill> c6 = new SingleComposer<Skill>(new Skill(SkillType.COMMON_LORE_WAR));
        SelectionContainer<Skill> c7 = new SingleComposer<Skill>(new Skill(SkillType.OPERATE));
        SelectionContainer<Skill> c8 = new DecisionComposer<Skill>(new Skill(SkillType.COMMAND), new Skill(SkillType.INTIMIDATE));
        SelectionContainer<Skill> c9 = new DecisionComposer<Skill>(new Skill(SkillType.DODGE, SkillStateType.TRAINED),
                        new Skill(SkillType.PARRY, SkillStateType.TRAINED)); // +10
        SelectionContainer<Skill> c10 = new DecisionComposer<Skill>(new Skill(SkillType.SURVIVAL), new Skill(SkillType.STEALTH));
        SelectionContainer<Skill> c11 = new DecisionComposer<Skill>(new Skill(SkillType.TECH_USE), new Skill(SkillType.MEDICAE));

        result.add(c1);
        result.add(c2);
        result.add(c3);
        result.add(c4);
        result.add(c5);
        result.add(c6);
        result.add(c7);
        result.add(c8);
        result.add(c9);
        result.add(c10);
        result.add(c11);

        return result;
    }

}
