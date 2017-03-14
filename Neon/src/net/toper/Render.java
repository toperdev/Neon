package net.toper;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.opengl.Texture;

public class Render {

	public void drawImage(Image img, float x, float y, float scale) {
		img.draw((int) x, (int) y, scale);
	}

	public void drawTexture(Texture tex, float x, float y, float scale) {
		Image img = new Image(tex);
		img.draw((int) x, (int) y, scale);
	}

	public void fillRect(float x, float y, float width, float height, Color c) {
		Main.g.setColor(c);
		Main.g.fillRect(x, y, width, height);
	}

}
