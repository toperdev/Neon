package net.toper.graphics.gui.holders;

import net.toper.Main;
import net.toper.graphics.gui.GUI;
import net.toper.graphics.gui.GUIElementText;

public class GUIOverlayInGame extends GUI {

	private int fps;
	private int physFps;

	public GUIOverlayInGame() {
		fps = addElement(new GUIElementText(10, 15, "FPS: "));
		physFps = addElement(new GUIElementText(10, 30, "Physics FPS: "));
	}

	public void updateMenu() {
		((GUIElementText) getElement(fps)).append(Main.getFPS() + "");
		((GUIElementText) getElement(physFps)).append(Main.getPhysicsFPS() + "");
	}

}
