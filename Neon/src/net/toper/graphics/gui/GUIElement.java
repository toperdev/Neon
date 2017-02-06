package net.toper.graphics.gui;

import org.newdawn.slick.Color;

public class GUIElement {

	private boolean isUpdatable = false;
	private float x, y, width, height;
	protected Color c;

	public GUIElement(float x, float y, float width, float height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public void update() {
	}

	public void render() {
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

	public void setUpdatable(boolean update) {
		this.isUpdatable = update;
	}

	public boolean isUpdatable() {
		return isUpdatable;
	}

}
