package io.github.boogiemonster1o1.conc.battleship.modelview;

import java.util.Scanner;

public class Reader {
	private static final Scanner sc = new Scanner(System.in);

	public static String read() {
		while (true) {
			System.out.print("> ");
			String line = sc.nextLine();

			if (!line.isEmpty()) {
				return line;
			}
		}
	}
}
