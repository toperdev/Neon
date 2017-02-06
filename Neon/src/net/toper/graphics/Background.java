package net.toper.graphics;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import net.toper.Main;

public class Background {

	private float x, y;
	private Image bg;

	public Background() {
		try {
			bg = new Image("res/bg.png");
			bg = bg.getScaledCopy(1.5f);
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
		this.x = x;
		this.y = y;
	}

	public void draw() {
		bg.draw(0, 0, Main.getWidth(), Main.getHeight(), -x, -y, -x + Main.getWidth(), -y + Main.getHeight());
	}

}
