package net.toper;

public class PhysicsElement {

	public AABB bounds;

	public Vector position = new Vector();
	public Vector velocity = new Vector();

	public float time;

	public PhysicsElement(float width, float height) {
		bounds = new AABB(width, height);
	}

	public void update(float delta) {

	}

}
