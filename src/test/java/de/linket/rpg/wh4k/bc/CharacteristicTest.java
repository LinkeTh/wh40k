package de.linket.rpg.wh4k.bc;

import org.junit.Test;

import de.linket.rpg.wh40k.bc.characteristics.Characteristic;
import de.linket.rpg.wh40k.bc.exp.Experience;
import de.linket.rpg.wh40k.bc.types.CharacteristicType;
import de.linket.rpg.wh40k.bc.types.RaceType;

public class CharacteristicTest
{

	@Test
	public void test()
	{

		for (CharacteristicType type : CharacteristicType.values())
		{
			Characteristic c = new Characteristic(type, RaceType.CHAOS_SPACE_MARINE);
			c.roll();
			System.out.println(c.toString());
			c.advance(new Experience(100));
			System.out.println(c.toString());
			c.advance(new Experience(100));
			System.out.println(c.toString());
			// c.advance();
			// System.out.println(c.toString());
			// c.advance();
			// System.out.println(c.toString());
			// c.advance();
			// System.out.println(c.toString());
		}

	}

}
