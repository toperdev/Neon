package net.toper.graphics.tiles;

import org.newdawn.slick.geom.Rectangle;

import net.toper.graphics.Sprite;

public class Tile {

	private Sprite s;
	private float scale;
	private float x;
	private float y;
	private boolean collidable = true;
	private boolean needsUpdate = false;
	private Rectangle bounds;

	public Tile(float x, float y, float tileSize, Sprite s) {
		this.x = x;
		this.y = y;
		this.s = s;
		this.s.scale(tileSize / s.getWidth());
		this.s.setX(x * tileSize);
		this.s.setY(y * tileSize);
		bounds = new Rectangle(x * tileSize, y * tileSize, s.getWidth(), s.getHeight());
	}

	public void draw() {
		s.draw();
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
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

	public Rectangle getBounds() {
		return bounds;
	}

	public void setCollidable(boolean collide) {
		this.collidable = collide;
	}

	public boolean getCollidable() {
		return collidable;
	}

	public void update() {

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
	
	public Sprite getSprite(){
		return s;
	}

}
