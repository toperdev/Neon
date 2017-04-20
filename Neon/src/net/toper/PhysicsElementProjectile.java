package net.toper;

public class PhysicsElementProjectile extends PhysicsElement {

	private float verticalVelocity;
	private float horizontalVelocity;

	private boolean hit = false;

	public PhysicsElementProjectile(Projectile e) {
		super(e.getHitbox().getWidth(), e.getHitbox().getHeight());
		position.x = e.getX();
		position.y = e.getY();
	}

	public void update(float delta) {
		bounds.update(position);
		velocity.y = verticalVelocity * delta;
		velocity.x = horizontalVelocity * delta;

		Tile t1 = Game.gen.getTile(position);
		if (t1 != null && Collision.testAABBAABB(bounds, t1.getAABB())) {
			velocity.x = 0;
			velocity.y = 0;
		} else {
			position.x += velocity.x;
			position.y -= velocity.y;
		}
	}

	public float getDeltaY() {
		return velocity.x;
	}

	public float getDeltaX() {
		return velocity.y;
	}

	public float getX() {
		return position.x;
	}

	public float getY() {
		return position.y;
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
		position.x = x;
		position.y = y;
	}

}
