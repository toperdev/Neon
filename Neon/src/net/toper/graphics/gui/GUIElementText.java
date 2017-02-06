package net.toper.graphics.gui;

public class GUIElementText extends GUIElement {

	private String text;

	public GUIElementText(float x, float y, String text) {
		super(x, y, 0, 0);
		this.text = text;
	}

	public void update() {

	}

	public void render() {
		GUI.getFont().drawText(getX(), getY(), text);
	}

}
