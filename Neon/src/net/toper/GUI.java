package net.toper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GUI {

	private List<GUIElement> elements = new ArrayList<GUIElement>();
	protected HashMap<String, Integer> elementIDs = new HashMap<String, Integer>();

	private static ManagerFont font = new ManagerFont();
	private static GameState state;

	private static GUIMenuMain main = new GUIMenuMain();
	private static GUIMenuLost lost = new GUIMenuLost();
	private static GUIOverlayInGame game = new GUIOverlayInGame();

	public static void update() {
		GUI current = getCurrentMenu();
		for (int i = 0; i < current.elements.size(); i++) {
			current.elements.get(i).update();
			if (current.elements.get(i).done) {
				current.elements.remove(i);
			}
		}
		current.updateMenu();
	}

	public void draw() {

	}

	public void updateMenu() {

	}

	public static ManagerFont getFont() {
		return font;
	}

	public int addElement(GUIElement e) {
		elements.add(e);
		return elements.indexOf(e);
	}

	public void clear() {
		elements.clear();
	}

	public void removeElement(int index) {
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

	public GUIElement getElement(int parentID) {
		if (parentID >= 0 && parentID < elements.size()) {
			return elements.get(parentID);
		} else {
			return null;
		}
	}

	public static GUI getCurrentMenu() {
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
		return current;
	}
}
