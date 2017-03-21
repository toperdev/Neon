package net.toper;

import org.newdawn.slick.Color;

public class Background {

<<<<<<< HEAD
	private float offX;
	private float offY;
	private int maxDepth = 3;
	private int numStars = 1500;

	public Background() {
		for (int i = 0; i < numStars; i++) {
			int x = Game.rand.nextInt() % MapGen.getWidth() / 4;
			int y = Game.rand.nextInt() % MapGen.getHeight() / 4;
=======
	private float xOff;
	private float yOff;
	private int maxDepth = 4;
	private int numStars = 5000;

	public Background(float xOff, float yOff) {
		this.xOff = xOff;
		this.yOff = yOff;
		for (int i = 0; i < numStars; i++) {
			int x = Game.rand.nextInt(MapGen.getWidth() * 3);
			int y = Game.rand.nextInt(MapGen.getHeight() * 3);
>>>>>>> dcd9acd00ae5164054b8976f8eca86b63a6840b8
			float z = (Game.rand.nextFloat() * maxDepth) + 1f;
			Game.fx.addEffect(new EffectStar(x - xOff, y - yOff, -z));
		}
	}

	public void offset(float x, float y) {
		this.xOff = x;
		this.yOff = y;
	}

	public void draw() {
		Main.g.setBackground(new Color(0xff001025));
	}

	public float getOffX() {
		return xOff;
	}

	public float getOffY() {
		return yOff;
	}

}
