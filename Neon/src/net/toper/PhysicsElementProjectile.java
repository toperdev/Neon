package net.toper;

import org.newdawn.slick.geom.Rectangle;

public class PhysicsElementProjectile extends PhysicsElement {

	private float x;
	private float y;
	private float deltaX;
	private float deltaY;

	private float verticalVelocity;
	private float horizontalVelocity;

	private boolean hit = false;

	private Rectangle bounds;

	public PhysicsElementProjectile(Projectile e) {
		x = e.getX();
		y = e.getY();
		bounds = e.getHitbox();
	}

	public void update(float delta) {
		deltaY = verticalVelocity * delta;
		deltaX = horizontalVelocity * delta;

		if (Game.gen.collisionAt(new Rectangle(getX(), getY(), bounds.getWidth(), bounds.getHeight()))) {
			hit = true;
		} else {
			x += deltaX;
			y += deltaY;
		}
	}

	public float getDeltaY() {
		return deltaY;
	}

	public float getDeltaX() {
		return deltaX;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public void setHorizontalVelocty(float speed) {
		horizontalVelocity = speed;
	}

	public void setVerticalVelocity(float speed) {
		verticalVelocity = speed;
	}

	public boolean hasHit() {
		return hit;
	}

	public void setPos(float x, float y) {
		this.x = x;
		this.y = y;
	}

}
