package net.toper.graphics.gui.holders;

import org.newdawn.slick.Color;

import net.toper.Main;
import net.toper.graphics.gui.GUI;
import net.toper.graphics.gui.GUIElementClickable;
import net.toper.graphics.gui.GUIElementText;
import net.toper.graphics.gui.GameState;

public class GUIMenuMain extends GUI {

	private int startID;
	private int titleID;
	private int clickStartID;

	public GUIMenuMain() {
		titleID = addElement(new GUIElementText(Main.getWidth()/2f, 100, "SUCC", true));
		startID = addElement(new GUIElementText(Main.getWidth()/2f, 200, "Start", true));
		clickStartID = addElement(new GUIElementClickable(this, startID));
		getElement(titleID).setColor(Color.white);
	}

	public void updateMenu() {
		if (((GUIElementClickable) getElement(clickStartID)).clicked()) {
			GUI.setState(GameState.PLAYING);
		}
		getElement(startID).setColor(Color.white);
		if (((GUIElementClickable) getElement(clickStartID)).hover()) {
			getElement(startID).setColor(Color.red);
		}
	}

}
