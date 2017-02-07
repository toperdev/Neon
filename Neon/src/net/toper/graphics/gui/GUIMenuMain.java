package net.toper.graphics.gui;

import org.newdawn.slick.Color;

public class GUIMenuMain extends GUI {

	private int startButtonID;

	private int clickStartID;

	public GUIMenuMain() {
		setFPSCap(60);
		addElement(new GUIElementText(460, 100, "SUCC"));
		startButtonID = addElement(new GUIElementText(460, 200, "Start"));
		clickStartID = addElement(new GUIMouseInteract(this, startButtonID));
	}

	public void updateLogic() {
		if (((GUIMouseInteract) getElement(clickStartID)).clicked()) {
			GUI.setState(GameState.PLAYING);
		}
		if (((GUIMouseInteract) getElement(clickStartID)).hover()) {
			getElement(clickStartID).getFont().setColor(new Color(1, 0, 0));
		} else {
			getElement(clickStartID).getFont().setColor(Color.white);
		}
	}

}
