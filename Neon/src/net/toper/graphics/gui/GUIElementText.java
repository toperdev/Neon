package net.toper.graphics.gui;

import org.newdawn.slick.Color;

public class GUIElementText extends GUIElement {

	private String text;

	public GUIElementText(float x, float y, String text) {
		super(x, y, GUI.getFont().getWidth(text), GUI.getFont().getHeight(text));
		this.text = text;
	}

	public GUIElementText(int x, int y, String text, int size) {
		super(x, y, GUI.getFont().getWidth(text), GUI.getFont().getHeight(text));
		this.text = text;
		getFont().setSize(size);
	}

	public void update() {

	}

	public void render() {
		getFont().drawText(getX(), getY(), text);
	}

	public void setColor(Color c) {
		getFont().setColor(c);
	}

}
