package net.toper.graphics.gui;

import org.newdawn.slick.Color;

public class GUIElementText extends GUIElement {

	private String origText = "";
	private String appendText = "";

	public GUIElementText(float x, float y, String text) {
		super(x, y, GUI.getFont().getWidth(text), GUI.getFont().getHeight(text));
		this.origText = text;
	}

	public GUIElementText(float x, float y, String text, boolean b) {
		super(x - (GUI.getFont().getWidth(text) / 2f), y, GUI.getFont().getWidth(text), GUI.getFont().getHeight(text));
		this.origText = text;
	}

	public GUIElementText(int x, int y, String text, int size) {
		super(x, y, GUI.getFont().getWidth(text), GUI.getFont().getHeight(text));
		this.origText = text;
		getFont().setSize(size);
	}

	public void update() {

	}

	public void append(String text) {
		appendText = text;
	}

	public void render() {
		getFont().drawText(getX(), getY(), origText + appendText);
	}

	public void setColor(Color c) {
		getFont().setColor(c);
	}

}
