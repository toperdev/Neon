package net.toper.graphics;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import net.toper.Game;

public class Sprite {

	private Image origTex, tex, mirror;
	private float x, y, offX, offY, scale, origScale, rot;
	private Render r = Game.r;
	boolean flipped = false;

	public Sprite(String tex, float scale) {
		try {
			this.origTex = new Image(tex);
			this.tex = new Image(tex);
			this.mirror = origTex.getFlippedCopy(true, false);
			this.origScale = scale;
		} catch (SlickException e) {
			e.printStackTrace();
		}
		this.scale = origScale;
		this.tex = this.tex.getScaledCopy(scale);
		this.mirror = this.mirror.getScaledCopy(scale);
	}

	public float getScale() {
		return scale;
	}

	public float getWidth() {
		return tex.getWidth();
	}

	public float getHeight() {
		return tex.getHeight();
	}

	public void setX(float x) {
		this.x = x;
	}

	public void addX(double d) {
		this.x += d;
	}

	public void setY(float y) {
		this.y = y;
	}

	public void addY(double d) {
		this.y += d;
	}

	public void setOffX(float offX) {
		this.offX = offX;
	}

	public void setOffY(float offY) {
		this.offY = offY;
	}

	public void addRot(float changeRot) {
		rot += changeRot;
	}

	public void setRot(float rot) {
		this.rot = rot;
	}

	public void draw() {
		tex.setRotation(-rot);
		if (!flipped)
			r.drawImage(tex, x + offX, y + offY, 1f);
		else {
			mirror.setRotation(-rot);
			r.drawImage(mirror, x + offX, y + offY, 1f);
		}
	}

	public Image getTex() {
		return tex;
	}

	public void flip(boolean flip) {
		flipped = flip;
	}

	public void setCenterOfRot(float x, float y) {
		tex.setCenterOfRotation(x, y);
		origTex.setCenterOfRotation(x, y);
		mirror.setCenterOfRotation(x, y);
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getCenterX() {
		return tex.getCenterOfRotationX();
	}

	public float getCenterY() {
		return tex.getCenterOfRotationY();
	}

	public boolean isFlipped() {
		return flipped;
	}

	public void scale(float scale2) {
		this.scale = scale2;
		tex = origTex.getScaledCopy(scale2);
		mirror = origTex.getScaledCopy(scale2).getFlippedCopy(true, false);
	}

	public void crop(int x, float width, int y, float height) {
		int wa = (int) (width / scale);
		int ha = (int) (height / scale);
		tex = origTex.getSubImage(x, y, wa, ha);
		mirror = origTex.getSubImage(x, y, wa, ha).getFlippedCopy(true, false);
	}

}
