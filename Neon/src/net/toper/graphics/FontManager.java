package net.toper.graphics;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.TrueTypeFont;

import net.toper.Main;

public class FontManager {

	private int size;
	private Color color;
	Graphics g;

	public FontManager() {
		g = Main.gc.getGraphics();
		color = Color.white;

	}

	public void setSize(int size) {
		if (this.size != size) {
			g.setFont(new TrueTypeFont(new java.awt.Font("Times New Roman", 0, size), true));
			this.size = size;
		}
	}

	public void setColor(Color c) {
		color = c;
	}

	public void drawText(float x, float y, String text) {
		g.setColor(color);
		g.drawString(text, x, y);
	}

	public float getHeight(String text) {
		return g.getFont().getHeight(text);
	}

	public float getWidth(String text) {
		return g.getFont().getWidth(text);
	}

}
