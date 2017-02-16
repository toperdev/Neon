package net.toper.graphics.gui.holders;

import net.toper.Main;
import net.toper.graphics.gui.GUI;
import net.toper.graphics.gui.GUIElementClickable;
import net.toper.graphics.gui.GUIElementText;
import net.toper.graphics.gui.GameState;

public class GUIMenuMain extends GUI {

	public GUIMenuMain() {
		elementIDs.put("title",
				addElement(new GUIElementText(Main.getWidth() / 2f, 100, "Mario's Autistic Brother", true)));
		elementIDs.put("start", addElement(new GUIElementText(Main.getWidth() / 2f, 200, "Start", true)));
		elementIDs.put("quit", addElement(new GUIElementText(Main.getWidth() / 2f, 225, "Quit", true)));
		elementIDs.put("clickStart", addElement(new GUIElementClickable(this, elementIDs.get("start"), true)));
		elementIDs.put("clickExit", addElement(new GUIElementClickable(this, elementIDs.get("quit"), true)));
	}

	public void updateMenu() {
		if (((GUIElementClickable) getElement(elementIDs.get("clickStart"))).clicked()) {
			GUI.setState(GameState.PLAYING);
		}
		if (((GUIElementClickable) getElement(elementIDs.get("clickExit"))).clicked()) {
			Main.close();
		}
	}

}
