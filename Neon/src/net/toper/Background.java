package net.toper;

import org.newdawn.slick.Color;

public class Background {

	private float offX;
	private float offY;
	private int maxDepth = 3;
	private int numStars = 1500;

	public Background() {
		for (int i = 0; i < numStars; i++) {
			int x = Game.rand.nextInt() % MapGen.getWidth() / 4;
			int y = Game.rand.nextInt() % MapGen.getHeight() / 4;
			float z = (Game.rand.nextFloat() * maxDepth) + 1f;
			Game.fx.addEffect(new EffectStar(x, y, -z));
		}
	}

	public void offset(float x, float y) {
		this.offX = x;
		this.offY = y;
	}

	public void draw() {
		Main.g.setBackground(new Color(0xff001025));
	}

	public float getOffX() {
		return offX;
	}

	public float getOffY() {
		return offY;
	}

}
