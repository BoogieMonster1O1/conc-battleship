package io.github.boogiemonster1o1.conc.battleship.modelview;

import static io.github.boogiemonster1o1.conc.battleship.Util.validateCoordinate;
import static io.github.boogiemonster1o1.conc.battleship.modelview.Grid.GRID_SIZE;

public record Vector(int x, int y) {
	public Vector {
		validateCoordinate(GRID_SIZE, x);
		validateCoordinate(GRID_SIZE, y);
	}

	public Vector(char x, int y) {
		this(x - 'A', y);
	}

	public char xChar() {
		return (char) (this.x + 'A');
	}
}
