package net.toper;

import org.newdawn.slick.Color;

public class ProjectileLaser extends Projectile {

	public ProjectileLaser(float x, float y, float globalX, float globalY, int dir) {
		super(x, y, globalX, globalY, 30, 4, dir, Color.red);
	}

}
