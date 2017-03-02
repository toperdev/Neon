package net.toper.graphics.gui;

import org.newdawn.slick.Color;
import org.newdawn.slick.geom.Rectangle;

import net.toper.graphics.FontManager;

public class GUIElement {

	private boolean isUpdatable = false;
	private boolean isClickable = false;
	private float x;
	private float y;
	private float width;
	private float height;
	protected Color c;
	private FontManager f;
	protected boolean done = false;

	public GUIElement(float x, float y, float width, float height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		f = new FontManager();
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

	public void setClickable(boolean clickable) {
		this.isClickable = clickable;
	}

	public boolean isClickable() {
		return isClickable;
	}

	public FontManager getFont() {
		return f;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}

	public void updateElements() {

	}

	public void update() {

	}

	public void setColor(Color c) {

	}

	public boolean isDone() {
		return done;
	}

}
