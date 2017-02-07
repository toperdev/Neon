package net.toper.graphics.gui;

import java.util.ArrayList;
import java.util.List;

import net.toper.graphics.FontManager;

public class GUI {

	private List<GUIElement> elements = new ArrayList<GUIElement>();

	private static FontManager font = new FontManager();
	private static GameState state;

	private static GUIMenuMain main = new GUIMenuMain();
	private static GUIMenuLost lost = new GUIMenuLost();
	private static GUIOverlayInGame game = new GUIOverlayInGame();

	private static int fpsCap;
	private static boolean isFPSCapped = false;

	public static void update() {
		GUI current = null;
		switch (state) {
		case MAIN:
			current = main;
			break;
		case LOST:
			current = lost;
			break;
		case PLAYING:
			current = game;
			break;
		default:
			break;
		}
		current.updateLogic();
		for (int i = 0; i < current.elements.size(); i++) {
			current.elements.get(i).update();
		}
	}

	public void draw() {

	}

	public void updateLogic() {

	}

	public static FontManager getFont() {
		return font;
	}

	public int addElement(GUIElement e) {
		elements.add(e);
		return elements.indexOf(e);
	}

	public void clear() {
		elements.clear();
	}

	public void remove(int index) {
		elements.remove(index);
	}

	public static void renderCurrent() {
		GUI current = null;
		switch (state) {
		case MAIN:
			current = main;
			break;
		case LOST:
			current = lost;
			break;
		case PLAYING:
			current = game;
			break;
		default:
			break;
		}
		for (int i = 0; i < current.elements.size(); i++) {
			current.elements.get(i).render();
		}
	}

	public static void setState(GameState playing) {
		state = playing;
	}

	public static GameState getState() {
		return state;
	}

	public void setFPSCap(int fpsCap) {
		isFPSCapped = fpsCap == 0;
		this.fpsCap = fpsCap;
	}

	public static boolean isFPSCapped() {
		return isFPSCapped;
	}

	public static int getFPSCap() {
		return fpsCap;
	}

	public GUIElement getElement(int parentID) {
		if (parentID >= 0 && parentID < elements.size()) {
			return elements.get(parentID);
		} else {
			return null;
		}
	}
}
