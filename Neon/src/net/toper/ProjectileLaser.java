package net.toper;

import org.newdawn.slick.Color;

public class ProjectileLaser extends Projectile {

	public ProjectileLaser(float x, float y, float globalX, float globalY, int dir) {
		super(x, y, globalX, globalY, 60, 4, dir, Color.red);
		setSpeed(15f);
	}

}
