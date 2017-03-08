package net.toper;

public class GUIMenuMain extends GUI {

	public GUIMenuMain() {
		getFont().setSize(16);
		elementIDs.put("title", addElement(new GUIElementText(Main.getWidth() / 2f, 100, "It's Not Mario", true)));
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
