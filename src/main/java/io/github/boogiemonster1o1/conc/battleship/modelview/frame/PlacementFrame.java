package io.github.boogiemonster1o1.conc.battleship.modelview.frame;

import static io.github.boogiemonster1o1.conc.battleship.Util.clearScreen;
import static io.github.boogiemonster1o1.conc.battleship.Util.print;
import static io.github.boogiemonster1o1.conc.battleship.Util.println;

public class PlacementFrame {
	public static void render() {
		clearScreen();
		print(" ____________");
		print("0 - Quit");
		print("1 - Automatic Ship Placement");
		print("2 - Manual Ship Placement");
		println(5);
	}
}
