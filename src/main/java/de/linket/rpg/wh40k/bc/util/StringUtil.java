package de.linket.rpg.wh40k.bc.util;

public class StringUtil {
	public static String padRight(String s, int n) {
		return String.format("%1$-" + n + "s", s);
	}
}
