package net.toper;

import org.newdawn.slick.Color;

public class Tile {

	private Sprite s;
	private float scale;
	private Vector position = new Vector();
	private boolean collidable = true;
	private boolean needsUpdate = false;
	private AABB bounds;

	public Tile(float x, float y, float tileSize, Sprite s) {
		this.position.x = x * tileSize;
		this.position.y = y * tileSize;
		this.s = s;
		this.s.scale(tileSize / s.getWidth());
		this.s.setX(position.x);
		this.s.setY(position.y);
		System.out.println(getWidth() + " " + getHeight());
		bounds = new AABB(getWidth()/2, getHeight()/2);
		System.out.println(position.x + " " + position.y);
	}

	public void draw() {
		s.draw();
		Game.r.fillRect(bounds.center.x+Game.bg.getOffX(), bounds.center.y+Game.bg.getOffY(), bounds.r[0], bounds.r[1], Color.white);
	}

	public float getX() {
		return position.x;
	}

	public float getY() {
		return position.y;
	}

	public void setOffset(float offX, float offY) {
		s.setOffX(offX);
		s.setOffY(offY);
	}

	public float getWidth() {
		return s.getWidth();
	}

	public float getHeight() {
		return s.getHeight();
	}

	public float getScale() {
		return scale;
	}

	public AABB getAABB() {
		return bounds;
	}

	public void setCollidable(boolean collide) {
		this.collidable = collide;
	}

	public boolean getCollidable() {
		return collidable;
	}

	public void updateLogic() {

	}

	public void update() {
		bounds.update(position);
		if (needsUpdate)
			updateLogic();
	}

	public boolean needsUpdate() {
		return needsUpdate;
	}

	public void needsUpdate(boolean needsUpdate) {
		this.needsUpdate = needsUpdate;
	}

	public void setScale(float scale) {
		this.scale = scale;
	}

	public Sprite getSprite() {
		return s;
	}

}
