package net.toper.graphics;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.opengl.Texture;

import net.toper.Main;

public class Render {

	public void drawImage(Image img, float x, float y, float scale) {
		img.draw(x, y, scale);
	}

	public void drawTexture(Texture tex, float x, float y, float scale) {
		Image img = new Image(tex);
		img.draw(x, y, scale);
	}

	public void drawRect(float x, float y, float width, float height, Color c) {
		Main.gc.getGraphics().setColor(c);
		Main.gc.getGraphics().drawRect(x, y, width, height);
	}

}
