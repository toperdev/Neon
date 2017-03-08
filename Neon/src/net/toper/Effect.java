package net.toper;

public class Effect {

	private float delta;
	private float x;
	private float y;
	private float z;
	private float offX;
	private float offY;
	private float width;
	private float height;

	public Effect(float x, float y, float z, float width, float height) {
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public float getX() {
		return x;
	}

	public float getFinalX() {
		return x + offX;
	}

	public float getFinalY() {
		return y + offY;
	}

	public float getY() {
		return y;
	}

	public float getZ() {
		return z;
	}

	public float getDelta() {
		return delta;
	}

	public void setDelta(float delta) {
		this.delta = delta;
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

	public void update() {
		offX = Game.bg.getOffX() / -getZ();
		offY = Game.bg.getOffY() / -getZ();
		updateLogic();
	}

	public void updateLogic() {

	}

	public void draw() {

	}

}
