package net.toper;

import org.newdawn.slick.Color;

public class EffectStar extends Effect {

	private float width;
	private float maxWidth = 3f;
	private float minWidth = 1f;
	private float time;

	public EffectStar(float x, float y, float z) {
		super(x, y, z, 10, 10);
		time = Game.rand.nextFloat();
	}

	public void updateLogic() {
		time += 0.005f * getDelta();
		width = minWidth + ((float) Math.sin(Math.toRadians(time * 360f)) * maxWidth);
		width /= getZ();
		time %= 1f;
	}

	public void draw() {
		Game.r.fillRect(getFinalX() - width / 2, getFinalY() - width / 2, width, width, Color.white);
	}

}
