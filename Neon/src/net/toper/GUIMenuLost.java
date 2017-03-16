package net.toper;

public class GUIMenuLost extends GUI {

	public GUIMenuLost() {
		elementIDs.put("title", addElement(new GUIElementText(Main.getWidth() / 2f, 100, "lol nibba git gud", true)));
		elementIDs.put("restart", addElement(new GUIElementText(Main.getWidth() / 2f, 200, "Restart", true)));
		elementIDs.put("quit", addElement(new GUIElementText(Main.getWidth() / 2f, 225, "Quit", true)));
		elementIDs.put("clickRestart", addElement(new GUIElementClickable(this, elementIDs.get("restart"), true)));
		elementIDs.put("clickExit", addElement(new GUIElementClickable(this, elementIDs.get("quit"), true)));
	}

	public void updateMenu() {
		if (((GUIElementClickable) getElement(elementIDs.get("clickRestart"))).clicked()) {
			Game.reset();
		}
		if (((GUIElementClickable) getElement(elementIDs.get("clickExit"))).clicked()) {
			Main.close();
		}
	}
}
