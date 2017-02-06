package net.toper.graphics;

import org.newdawn.slick.TrueTypeFont;

public class Font {

	TrueTypeFont font;
	java.awt.Font awtFont;

	public Font() {
		setSize(16);
		font = new TrueTypeFont(awtFont, true);
	}

	public void setSize(int size) {
		awtFont = new java.awt.Font("Courier New", java.awt.Font.BOLD, size);
	}

	public void drawText(float x, float y, String text) {
		font.drawString(x, y, text);
	}

}
