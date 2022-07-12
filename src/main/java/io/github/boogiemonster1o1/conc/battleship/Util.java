package io.github.boogiemonster1o1.conc.battleship;

import java.util.Arrays;
import java.util.stream.IntStream;

import io.github.boogiemonster1o1.conc.battleship.modelview.Vector;

public class Util {
	public static <T> void fill(T[][] array, T element) {
		for (T[] ts : array) {
			Arrays.fill(ts, element);
		}
	}

	public static void validateCoordinate(int max, int coordinate) {
		if (coordinate < 0 || coordinate >= max) {
			throw new IllegalArgumentException("Coordinate out of bounds");
		}
	}

	public static void validateVector(int max, Vector vector) {
		validateCoordinate(max, vector.x());
		validateCoordinate(max, vector.y());
	}

	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public static void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void print(String text, int length, boolean centered, char filler) {
		while (text.length() > length) { // Split text into lines
			String line = text.substring(0, length);
			text = text.substring(length);
			print(line, length, centered, filler);
		}

		if (centered) {
			int spaces = (length - text.length()) / 2;

			if (spaces > 0) {
				System.out.printf("%" + spaces + "s %s %" + spaces + "s%n", filler, text, filler);
			} else {
				System.out.printf(" %" + length + "s %n", text);
			}
		} else {
			System.out.println(text);
		}
	}

	public static void print(String text) {
		print(text, false);
	}

	public static void print(String text, boolean centered) {
		print(text, 80, centered);
	}

	public static void print(String text, int length) {
		print(text, length, false);
	}

	public static void print(String text, int length, boolean centered) {
		print(text, length, centered, ' ');
	}

	public static void println() {
		System.out.println();
	}

	public static void println(int n) {
		for (int i = 0; i < n; i++) {
			System.out.println();
		}
	}
}
