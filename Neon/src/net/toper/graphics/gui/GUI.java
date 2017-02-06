package net.toper.graphics.gui;

import java.util.ArrayList;
import java.util.List;

import net.toper.graphics.Font;

public class GUI {

	private List<GUIElement> elements = new ArrayList<GUIElement>();

	private static Font font = new Font();
	private static GameState state;

	private static GUIMenuMain main = new GUIMenuMain();
	private static GUIMenuLost lost = new GUIMenuLost();
	private static GUIOverlayInGame game = new GUIOverlayInGame();

	public void update() {

	}

	public static void draw() {

	}

	public static Font getFont() {
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

}
