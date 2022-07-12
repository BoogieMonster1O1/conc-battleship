package io.github.boogiemonster1o1.conc.battleship.modelview;

import java.util.Arrays;

import io.github.boogiemonster1o1.conc.battleship.Util;

import static io.github.boogiemonster1o1.conc.battleship.Util.validateVector;

public class Grid {
	public static final int GRID_SIZE = Integer.parseInt(System.getProperty("grid.size", "10"));
	private final Square[][] squares;

	public Grid() {
		this.squares = new Square[GRID_SIZE][GRID_SIZE];
		Util.fill(this.squares, Square.BLANK);
	}

	public Square get(Vector vector) {
		validateVector(GRID_SIZE, vector);
		return this.squares[vector.x()][vector.y()];
	}

	public void set(Vector vector, Square square) {
		validateVector(GRID_SIZE, vector);
		this.squares[vector.x()][vector.y()] = square == null ? Square.BLANK : square;
	}

	public int getShipSquares() {
		return (int) Arrays.stream(this.squares).flatMap(Arrays::stream).filter(Square::isShip).count();
	}

	public enum Square {
		BLANK,
		MISS,
		SHIP,
		HIT,
		;

		public boolean isShip() {
			return this == SHIP;
		}
	}
}
