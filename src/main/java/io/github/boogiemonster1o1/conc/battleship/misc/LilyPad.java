package io.github.boogiemonster1o1.conc.battleship.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class LilyPad {
	public static void main(String[] args) {
		List<Pair> possibilities = new ArrayList<>();
		for (int k = 0; k < 1000; k++) {
			double cases = 100000;
			double favorables = 0;
			for (int i = 1; i <= cases; i++) {
				if (hits2000()) {
					favorables++;
				}
			}
			double probability = favorables / cases;
//			System.out.println("Expected probability: " + probability);
			coPrimes(1, 1000).forEach(pair -> {
				double division = pair.a() / pair.b();
				if (Math.abs(division - probability) <= 0.0001) {
					possibilities.add(pair);
				}
			});
		}
		possibilities.stream().distinct().map(pair -> {
			return new StringPair(count(possibilities, pair), "(" + pair.a() + ", " + pair.b() + "), prob=" + (pair.a() / pair.b()) + ", axb=" + (pair.a() * pair.b()));
		}).sorted().filter(p -> p.count() > 10).forEach(p -> {
			System.out.println("Count: " + p.count() + " " + p.str());
		});
	}

	public static int count(List<Pair> pairs, Pair pair) {
		long count = 0L;
		for (Pair p : pairs) {
			if (p.equals(pair)) {
				count++;
			}
		}
		return (int) count;
	}

	public static boolean hits2000() {
		int number = 1;
		while (true) {
			if (number == 2000) {
				return true;
			}
			number += ThreadLocalRandom.current().nextInt(1, 2022-number);
			if (number > 2000) {
				return false;
			}
		}
	}

	public static List<Pair> coPrimes(int from, int to) {
		List<Pair> pairs = new ArrayList<>();
		for (int i = from; i <= to; i++) {
			for (int j = i; j <= to; j++) {
				if (gcd(i, j) == 1) {
					pairs.add(new Pair(i, j));
				}
			}
		}
		return pairs;
	}

	public static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}

	public record Pair(double a, double b) {
	}

	public record StringPair(int count, String str) implements Comparable<StringPair> {
		@Override
		public int compareTo(StringPair o) {
			return Integer.compare(count, o.count);
		}
	}
}
