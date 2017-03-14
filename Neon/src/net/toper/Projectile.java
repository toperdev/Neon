package net.toper;

import org.newdawn.slick.Color;
import org.newdawn.slick.geom.Rectangle;

public class Projectile {

	private float x;
	private float y;
	private float globalY;
	private float globalX;
	private float width;
	private float height;
	private int dir;

	private float life = 50f;
	private float decay = 1f;
	private boolean isDead;

	private Color c;
	private Sprite s;
	private boolean useSprite = false;

	private float speed = 15f;

	// Physics reference and gravity class
	private int phys;
	private PhysicsElementProjectile shoot;

	public Projectile(float x, float y, float globalX, float globalY, float width, float height, int dir, Color c) {
		this.globalX = globalX+x;
		this.globalY = globalY+y;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.c = c;
		this.dir = dir;
		initPhys();
	}

	public void initPhys() {
		phys = Game.p.addElement(new PhysicsElementProjectile(this));
		shoot = (PhysicsElementProjectile) Game.p.getElement(phys);
		if (dir == 0)
			shoot.setHorizontalVelocty(speed);
		else
			shoot.setHorizontalVelocty(-speed);
	}

	public Projectile(float x, float y, float globalX, float globalY, Sprite s, int dir) {
		this.x = x;
		this.y = y;
		this.globalX = globalX;
		this.globalY = globalY;
		this.width = s.getWidth();
		this.height = s.getHeight();
		this.s = s;
		this.dir = dir;
		useSprite = true;
		initPhys();
	}

	public void setLife(float life) {
		this.life = life;
	}

	public float getLife() {
		return life;
	}

	public void setLifeDecay(float decay) {
		this.decay = decay;
	}

	public void update() {
		shoot.update(Main.getDelta());
		life -= decay * Main.getDelta();
		if (life <= 0f) {
			isDead = true;
		}
		if (!isDead) {
			isDead = shoot.hasHit();
		}
	}

	public boolean isDead() {
		return isDead;
	}

	public void updateLogic() {

	}

	public void draw() {
		if (useSprite) {
			s.setX(globalX - shoot.getX());
			s.setY(globalY - shoot.getY());
			s.draw();
		} else {
			Game.r.fillRect(shoot.getX() + (Game.bg.getOffX() * 2), shoot.getY() + Game.bg.getOffY() * 2, width, height,
					c);
		}
	}

	public float getScreenX() {
		return x;
	}

	public float getScreenY() {
		return y;
	}

	public float getX() {
		return globalX;
	}

	public float getY() {
		return globalY;
	}

	public Rectangle getHitbox() {
		return new Rectangle(0, 0, width, height);
	}

}
