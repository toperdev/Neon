package net.toper.graphics.gui.holders;

import java.util.ArrayList;
import java.util.List;

import net.toper.Main;
import net.toper.graphics.gui.GUI;
import net.toper.graphics.gui.GUIElementHealthBar;
import net.toper.graphics.gui.GUIElementText;
import net.toper.upgrades.Upgrade;

public class GUIOverlayInGame extends GUI {

	private int fps;
	private int physFps;
	private List<Integer> upgradeDisplay = new ArrayList<Integer>();

	public GUIOverlayInGame() {
		fps = addElement(new GUIElementText(10, 15, "FPS: ", 15));
		physFps = addElement(new GUIElementText(10, 30, "Physics FPS: ", 15));
	}

	public void updateMenu() {
		((GUIElementText) getElement(fps)).append(Main.getFPS() + "");
		((GUIElementText) getElement(physFps)).append(Main.getPhysicsFPS() + "");
	}

	public void addUpgradeInfo(Upgrade upgrade) {
		upgradeDisplay.add(addElement(
				new GUIElementHealthBar(10, 50, 200f, upgrade.getLife(), upgrade.getID(), upgrade.getName(), 0)));
	}

}
