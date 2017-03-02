package net.toper.graphics;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;

public class FontManager {

	private int size = 20;
	private Color color = Color.white;
	private TrueTypeFont ttf;
	private Font f;

	public FontManager() {
		color = Color.white;
		f = new Font("Verdana", Font.PLAIN, size);
		ttf = (new TrueTypeFont(f, true));
	}

	public void setSize(int size) {
		if (this.size != size) {
			f = new Font("Verdana", Font.PLAIN, size);
			ttf = (new TrueTypeFont(f, true));
			this.size = size;
		}
	}

	public void setColor(Color c) {
		color = c;
	}

	public void drawText(float x, float y, String text) {
		ttf.drawString(x, y, text, color);
	}

	public float getHeight(String text) {
		return ttf.getHeight(text);
	}

	public float getWidth(String text) {
		return ttf.getWidth(text);
	}

}
