package net.toper;

public class Vector {
	public float x;
	public float y;
	public float z;

	public Vector() {
		x = 0.0f;
		y = 0.0f;
		z = 0.0f;
	}

	public Vector(float x, float y) {
		this.x = x;
		this.y = y;
	}

	// returns the (squared) distance between this Vector and another
	public float distSQ(final Vector vec) {
		float distX = x - vec.x;
		float distY = y - vec.y;

		return distX * distX + distY * distY;
	}

	public Vector add(float x, float y) {
		Vector v = new Vector();
		v.x = this.x + x;
		v.y = this.y + y;
		return v;
	}

	public Vector add(Vector va) {
		Vector v = new Vector();
		v.x = this.x + va.x;
		v.y = this.y + va.y;
		return v;
	}
}
