package net.toper.graphics.gui.holders;

import org.newdawn.slick.Color;

import net.toper.graphics.gui.GUI;
import net.toper.graphics.gui.GUIElementClickable;
import net.toper.graphics.gui.GUIElementText;
import net.toper.graphics.gui.GameState;

public class GUIMenuMain extends GUI {

	private int startButtonID;

	private int clickStartID;

	public GUIMenuMain() {
		setFPSCap(60);
		addElement(new GUIElementText(460, 100, "SUCC"));
		startButtonID = addElement(new GUIElementText(460, 200, "Start",30));
		clickStartID = addElement(new GUIElementClickable(this, startButtonID));
	}

	public void updateLogic() {
		if (((GUIElementClickable) getElement(clickStartID)).clicked()) {
			GUI.setState(GameState.PLAYING);
		}
		getElement(startButtonID).setColor(Color.white);
		if (((GUIElementClickable) getElement(clickStartID)).hover()) {
			getElement(startButtonID).setColor(Color.red);
		}
	}

}
