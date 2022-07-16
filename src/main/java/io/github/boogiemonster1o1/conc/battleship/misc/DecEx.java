package io.github.boogiemonster1o1.conc.battleship.misc;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DecEx {
	public static void main(String[] args) {
		BigDecimal bd = new BigDecimal("1");
		bd = bd.setScale(10000, RoundingMode.HALF_UP);
		bd = bd.divide(new BigDecimal("83").setScale(10000, RoundingMode.HALF_UP), RoundingMode.HALF_UP);
		bd = bd.divide(new BigDecimal("107").setScale(10000, RoundingMode.HALF_UP), RoundingMode.HALF_UP);
		System.out.println(bd.toPlainString());
	}
}
