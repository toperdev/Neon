package net.toper.physics;

import org.newdawn.slick.geom.Rectangle;

import net.toper.Game;
import net.toper.ent.Entity;

public class PhysicsElementGravity extends PhysicsElement {

	private float gravity = -9.8f;
	private float terminalVelocity = 250f;

	private float x;
	private float y;
	private float deltaX;
	private float deltaY;

	private float verticalVeloctiy;
	private float horizontalVelocity;

	private float yTime;

	private boolean isOnGround = false;

	private Rectangle bounds;

	public PhysicsElementGravity(Entity e) {
		x = e.getX();
		y = e.getY();
		bounds = e.getHitbox();
		gravity *= e.getScale();
	}

	public void update(float delta) {
		yTime += delta;
		deltaY = ((verticalVeloctiy) + (0.5f * gravity * yTime)) * delta;
		if (deltaY < -terminalVelocity) {
			deltaY = -terminalVelocity;
		}
		deltaX = horizontalVelocity * delta;

		if (Game.gen.collisionAt(new Rectangle(getX(), getY(), bounds.getWidth() + deltaX, bounds.getHeight()))) {
			deltaX = 0;
		}
		if (Game.gen.collisionAt(new Rectangle(getX() + deltaX, getY(), bounds.getWidth(), bounds.getHeight()))) {
			deltaX = 0;
		}
		if (Game.gen.collisionAt(new Rectangle(getX(), getY(), bounds.getWidth(), bounds.getHeight() - deltaY))) {
			deltaY = 0;
			verticalVeloctiy = 0;
			yTime = 0;
			isOnGround = true;
		} else {
			isOnGround = false;
		}
		if (Game.gen.collisionAt(new Rectangle(getX(), getY() - deltaY, bounds.getWidth(), bounds.getHeight()))) {
			deltaY = 0;
			verticalVeloctiy = -verticalVeloctiy / 10f;
			yTime = 0;
		}

		x += deltaX;
		y -= deltaY;
		horizontalVelocity = 0;
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

	public boolean isOnGround() {
		return isOnGround;
	}

	public void setHorizontalVelocty(float speed) {
		horizontalVelocity = speed;
	}

	public void setVerticalVelocity(float speed) {
		verticalVeloctiy = speed;
	}

	public void setScale(float scale) {
		gravity *= scale;
	}

	public void setPos(float x, float y) {
		this.x = x;
		this.y = y;
	}

}
