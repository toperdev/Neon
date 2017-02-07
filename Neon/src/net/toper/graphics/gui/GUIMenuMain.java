package net.toper.graphics.gui;

import org.newdawn.slick.Color;

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
