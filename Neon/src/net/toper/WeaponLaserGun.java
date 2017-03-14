package net.toper;

public class WeaponLaserGun extends Weapon {

	public WeaponLaserGun(Entity parent) {
		super(parent, new Sprite("res/gun 1.png", 0.275f), 1f);
	}

	public void fire() {
		Game.proj.addProjectle(new ProjectileLaser(getParent().getWeaponHoldX(), getParent().getWeaponHoldY() + 10,
				getParent().getX(), getParent().getY(), getParent().getDir()));
	}

}
