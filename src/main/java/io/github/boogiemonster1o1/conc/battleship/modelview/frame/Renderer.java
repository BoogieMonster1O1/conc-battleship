package io.github.boogiemonster1o1.conc.battleship.modelview.frame;

import io.github.boogiemonster1o1.conc.battleship.modelview.Reader;

import static io.github.boogiemonster1o1.conc.battleship.Util.clearScreen;
import static io.github.boogiemonster1o1.conc.battleship.Util.print;
import static io.github.boogiemonster1o1.conc.battleship.Util.println;

public class Renderer {
	private FrameType currentFrame = FrameType.MAIN;

	public void render() {
		clearScreen();
		println(4);
		print(" ____________");
		print("< Battleship >");
		print(" ------------ ");
		print("        \\   ^__^");
		print("         \\  (oo)\\_______");
		print("            (__)\\       )\\/\\");
		print("                ||----w |");
		print("                ||     ||");
		println(2);
		render(currentFrame);
	}

	public void render(FrameType frame) {
		switch (frame) {
			case MAIN -> {
				MainFrame.render();
				while (true) {
					String line = Reader.read();

					if (line.equals("1")) {
						this.currentFrame = FrameType.OPTIONS;
						render();
					} else if (line.equals("0")) {
						System.exit(0);
					}
				}
			}
			case OPTIONS -> {
				OptionsFrame.render();
				while (true) {
					String line = Reader.read();

					if (line.equals("1")) {
						this.currentFrame = FrameType.GAME;
						render();
					} else if (line.equals("0")) {
						System.exit(0);
					} else if (line.equals("2")) {
						this.currentFrame = FrameType.PLACEMENT;
						render();
					}
				}
			}
			case PLACEMENT -> {
				PlacementFrame.render();
				while (true) {
					String line = Reader.read();

					if (line.equals("1")) { // TODO
						this.currentFrame = FrameType.OPTIONS;
						render();
					} else if (line.equals("0")) {
						System.exit(0);
					} else if (line.equals("2")) {
						this.currentFrame = FrameType.OPTIONS;
						render();
					}
				}
			}
		}
	}

	public enum FrameType {
		MAIN,
		OPTIONS,
		PLACEMENT,
		GAME
	}
}
