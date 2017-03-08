package net.toper;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Sprite {

	private Image origTex, tex;
	private float x, y, offX, offY, scale, origScale, rot;
	private Render r = Game.r;
	boolean flipped = false;

	public Sprite(String tex, float scale) {
		try {
			this.origTex = new Image(tex);
			this.tex = new Image(tex);
			this.origScale = scale;
		} catch (SlickException e) {
			e.printStackTrace();
		}
		this.scale = origScale;
		this.tex = this.tex.getScaledCopy(scale);
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
			r.drawImage(tex, x + offX, y + offY, scale);
		else {
			r.drawImage(tex.getFlippedCopy(true, false), x + offX,
					y + offY, scale);
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
	}

	public void crop(int x, float width, int y, float height) {
		int wa = (int) (width);
		int ha = (int) (height);
		tex = origTex.getSubImage(x, y, wa, ha);
	}

	public int getOrigWidth() {
		return origTex.getWidth();
	}

	public int getOrigHeight() {
		return origTex.getHeight();
	}
}
