package net.toper.graphics.gui.holders;

import net.toper.graphics.gui.GUI;
import net.toper.graphics.gui.GUIElementText;

public class GUIOverlayInGame extends GUI {

	GUIElementText enemies = new GUIElementText(10, 30, "Enemies: ");
	GUIElementText cooldown = new GUIElementText(10, 50, "Timer: ");

	public GUIOverlayInGame() {
		// addElement(enemies);
		// addElement(cooldown);
	}

}
