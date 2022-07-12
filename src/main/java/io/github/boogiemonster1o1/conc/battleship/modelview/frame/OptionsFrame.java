package io.github.boogiemonster1o1.conc.battleship.modelview.frame;

import static io.github.boogiemonster1o1.conc.battleship.Util.clearScreen;
import static io.github.boogiemonster1o1.conc.battleship.Util.print;
import static io.github.boogiemonster1o1.conc.battleship.Util.println;

public class OptionsFrame{
	public static void render() {
		clearScreen();
		print(" ____________");
		print("0 - Quit");
		print("1 - Play Game");
		print("2 - Change Ship Placement");
		println(2);
	}
}
