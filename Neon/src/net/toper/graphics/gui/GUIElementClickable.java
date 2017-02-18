package net.toper.graphics.gui;

import org.newdawn.slick.Color;
import org.newdawn.slick.geom.Rectangle;

import net.toper.Main;

public class GUIElementClickable extends GUIElement {

	private boolean isClicked = false;
	private boolean hover = false;
	private Color origColor = Color.white;
	private Color hovColor = Color.red;
	private int parentID;
	private GUI parentGUI;

	public GUIElementClickable(GUI gui, int parentID, boolean colorOnHover) {
		super(gui.getElement(parentID).getX(), gui.getElement(parentID).getY(), gui.getElement(parentID).getWidth(),
				gui.getElement(parentID).getHeight());
		this.parentID = parentID;
		parentGUI = gui;
	}

	public void update() {
		if (getBounds().intersects(new Rectangle(Main.input.getMouseX(), Main.input.getMouseY(), 1, 1))) {
			hover = true;
			parentGUI.getElement(parentID).setColor(hovColor);
			if (Main.input.isMouseButtonDown(0)) {
				isClicked = true;
			} else {
				isClicked = false;
			}
		} else {
			parentGUI.getElement(parentID).setColor(origColor);
			hover = false;
			isClicked = false;
		}
	}

	public boolean clicked() {
		return isClicked;
	}

	public boolean hover() {
		return hover;
	}
}
