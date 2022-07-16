package io.github.boogiemonster1o1.conc.battleship.misc;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.cbrt;
import static java.lang.Math.cos;

public class PrimeABCD {
	public static void main(String[] args) {
		double output = cbrt(cos(2 * Math.PI / 7)) + cbrt(cos(4 * Math.PI / 7)) + cbrt(cos(6 * Math.PI / 7));
		System.out.println("Expected Output: " + output);
		List<Double> primes = primes(100);
		primes.forEach(a -> {
			primes.forEach(b -> {
				primes.forEach(c -> {
					primes.forEach(d -> {
						double f = cbrt((a - b * cbrt(c)) / d);
						if ((Math.abs(f - output) <= 0.01) && (a + b + c + d) < 100) {
							System.out.print("a=" + a + " str=" + b + " c=" + c + " d=" + d + " sum=" + (a + b + c +d) + " : ");
							System.out.println(f);
						}
					});
				});
			});
		});
	}

	public static List<Double> primes(int to) {
		boolean[] possiblePrimes = new boolean[to + 1];
		for (int i = 2; i <= to; i++) {
			possiblePrimes[i] = true;
		}
		for (int i = 2; i <= to; i++) {
			if (possiblePrimes[i]) {
				for (int j = i * 2; j <= to; j += i) {
					possiblePrimes[j] = false;
				}
			}
		}
		List<Double> primes = new ArrayList<>();
		for (int i = 2; i <= to; i++) {
			if (possiblePrimes[i]) {
				primes.add((double) i);
			}
		}
		return primes;
	}
}
