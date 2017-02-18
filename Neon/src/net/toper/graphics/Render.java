package net.toper.graphics;

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

}
