package net.toper;

public class PhysicsElementGravity extends PhysicsElement {

	private float gravity = -9.8f;
	private float terminalVelocity = 50f;

	private float verticalVelocity;
	private float horizontalVelocity;

	private Entity e;

	private float yTime;

	private boolean isOnGround = true;

	public PhysicsElementGravity(Entity e) {
		super(e.getBounds().r[0], e.getBounds().r[1]);
		position.x = e.getBounds().center.x;
		position.y = e.getBounds().center.y;
		gravity *= e.getScale();
		this.e = e;
	}

	public void update(float delta) {
		yTime += delta;
		velocity.y = ((verticalVelocity) + (0.5f * gravity * yTime)) * delta;
		if (velocity.y < -terminalVelocity) {
			velocity.y = -terminalVelocity;
		}
		velocity.x = horizontalVelocity * delta;
		if (checkTile(new Vector(velocity.x, 0))) {
			velocity.x = 0;
		}
		if (checkTile(new Vector(0, -velocity.y))) {
			velocity.y = 0;
			isOnGround = true;
		}else{
			isOnGround = false;
		}
		e.position.x += velocity.x;
		e.position.y -= velocity.y;
		horizontalVelocity = 0;
		bounds.update(e.position);
	}

	public boolean checkTile(Vector v) {
		AABB bounds2 = bounds;
		bounds2.update(e.position.add(v));
		for (int y = 0; y < MapGen.getHeight()/MapGen.getTileSize(); y++) {
			for (int x = 0; x < MapGen.getWidth()/MapGen.getTileSize(); x++) {
				Tile t = Game.gen.getTile(new Vector(x * MapGen.getTileSize(), y * MapGen.getTileSize()));
				if (t != null) {
					if (Collision.testAABBAABB(bounds2, t.getAABB())) {
						System.out.println("m");
						return true;
					}
				}
			}
		}
		return false;

	}

	public float getDeltaY() {
		return velocity.y;
	}

	public float getDeltaX() {
		return velocity.x;
	}

	public boolean isOnGround() {
		return isOnGround;
	}

	public void setHorizontalVelocty(float speed) {
		horizontalVelocity = speed;
	}

	public void setVerticalVelocity(float speed) {
		verticalVelocity = speed;
		yTime = 0;
	}

	public void setScale(float scale) {
		gravity *= scale;
	}

	public void setPos(float x, float y) {
		e.position.x = x;
		e.position.y = y;
	}

}
