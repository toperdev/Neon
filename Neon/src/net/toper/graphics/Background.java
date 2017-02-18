package net.toper.graphics;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import net.toper.Main;

public class Background {

	private float x, y, offX, offY;
	private Image bg;

	public Background() {
		try {
			bg = new Image("res/bg.png");
			bg = bg.getScaledCopy(3);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

	public void offset(float x, float y) {
		this.offX = x;
		this.offY = y;
	}

	public void draw() {
		bg.draw(0, 0, Main.getWidth(), Main.getHeight(), -x - offX, -y - offY, -x - offX + Main.getWidth(),
				-y - offY + Main.getHeight());
	}

}
