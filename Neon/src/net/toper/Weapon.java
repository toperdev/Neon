package net.toper;

public class Weapon extends Holdable {

	private float damageAmount;
	private float fireSpeed = 0.075f;
	private float fireCount;
	private Sprite s;
	private boolean isFlipped = false;

	public Weapon(Entity parent, Sprite s, float dmgAmt) {
		super(parent);
		damageAmount = dmgAmt;
		this.s = s;
	}

	public float getDmgAmt() {
		return damageAmount;
	}

	public void render() {
		s.flip(isFlipped);
		s.draw();
	}

	public void update() {
		s.setX(getParent().getWeaponHoldX() + getParent().getScreenX());
		s.setY(getParent().getWeaponHoldY() + getParent().getScreenY());
		updateLogic();
	}

	public void fireLoop() {
		fireCount += fireSpeed * Main.getDelta();
		if (fireCount > 1f) {
			fireCount = 0;
			fire();
		}
	}

	public void fire() {
	}

	public void updateLogic() {
	}

	public float getWidth() {
		return s.getWidth();
	}

	public float getHeight() {
		return s.getHeight();
	}

	public void setFlipped(boolean flip) {
		this.isFlipped = flip;
	}

	public void resetFire() {
		fireCount = 1;
	}
}
