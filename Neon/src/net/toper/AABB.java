package net.toper;

/**
 * The AABB is also very straightforward, it has a Vector as its center point
 * and a float array of size 2 defining its halfWidth and halfHeight which
 * extend from the center itself. The update method simply updates the position
 * of the AABB itself.
 */
public class AABB {
	public Vector center;
	public float r[];

	public AABB(final float width, final float height) {
		center = new Vector();
		r = new float[2];
		r[0] = width * 0.5f;
		r[1] = height * 0.5f;
	}

	public void update(final Vector position) {
		center.x = position.x;
		center.y = position.y;
	}
}