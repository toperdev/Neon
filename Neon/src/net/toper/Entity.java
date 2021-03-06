package net.toper;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Color;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class Entity {

	private int ID;

	protected Vector position;
	private AABB bounds;

	private float screenX;
	private float screenY;

	private float oldScreenX;
	private float oldScreenY;
	private float changeScreenX;
	private float changeScreenY;
	private float changeX;
	private float changeY;

	private float oldX;
	private float oldY;

	private float origScale;
	private float scale;
	private float rotation;

	private float speed;
	private float delta;

	private float damgAmt;

	private float width;
	private float height;

	private float weaponPosX;
	private float weaponPosY;

	private int type;

	private Sprite s;
	private Sound sound, dieSound;
	private float life, decay;
	private boolean removeIfDead = false;
	private boolean link = true;

	private List<Upgrade> upgrades = new ArrayList<Upgrade>();
	private List<Integer> removeUpgrade = new ArrayList<Integer>();

	private Weapon currentWeapon;
	private boolean hasWeapon = false;

	public Entity(float x, float y, float z, Sprite sprite, int type) {
		position = new Vector();
		this.position.x = x;
		this.position.y = y;
		this.position.z = z;
		setSprite(sprite);
		scale = s.getScale();
		origScale = scale;
		setWidth(sprite.getWidth());
		setHeight(sprite.getHeight());

		position = new Vector();
		bounds = new AABB(width, height);
	}

	public void setID(int id) {
		this.ID = id;
	}

	public void setLinkPosAndScreen(boolean link) {
		this.link = link;
	}

	public void setSprite(Sprite s) {
		this.s = s;
	}

	public void update() {
		bounds.update(position);
		updateLogic();
		updateUpgrades();
		updateWeapon();
	}

	public void updateLogic() {

	}

	public void updateWeapon() {
		if (hasWeapon)
			currentWeapon.update();
	}

	private void updateUpgrades() {
		for (int i = 0; i < upgrades.size(); i++) {
			upgrades.get(i).update(delta);
			if (upgrades.get(i).isCompleted()) {
				removeUpgrade.add(i);
			}
		}
		for (int i : removeUpgrade) {
			if (i < upgrades.size())
				upgrades.remove(i);
		}
		removeUpgrade.clear();
	}

	public void move(float xAmt, float yAmt) {
		moveX(xAmt);
		moveY(yAmt);
	}

	public void draw() {
		float centerY = s.getCenterY();
		float centerX = s.getCenterX();
		s.scale(scale);
		if (link) {
			s.setX(position.x);
			s.setY(position.y);
		} else {
			s.setX(screenX);
			s.setY(screenY);
		}
		s.setCenterOfRot(centerX, centerY);
		s.setRot(rotation);
		s.draw();
		if (hasWeapon) {
			currentWeapon.render();
		}
		Game.r.fillRect(bounds.center.x + Game.bg.getOffX(), bounds.center.y + Game.bg.getOffY(), bounds.r[0],
				bounds.r[1], Color.white);
	}

	public void setRemoveOnDead(boolean remove) {
		removeIfDead = remove;
	}

	public void setDead(boolean remove) {
		if (remove) {
			life = 0;
			removeIfDead = true;
		}
	}

	public void setLife(float life) {
		removeIfDead = true;
		this.life = life;
	}

	public void subtractLife(float amt) {
		life -= amt;
	}

	public void setLifeDecayRate(float rate) {
		decay = rate;
	}

	public boolean isDead() {
		if (removeIfDead) {
			return life <= 0f;
		} else {
			return false;
		}
	}

	public float getLife() {
		return life;
	}

	public float getDecay() {
		return decay;
	}

	public void setSound(String location) {
		try {
			sound = new Sound(location);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	public void playSound() {
		sound.play();
	}

	public Sound getSound() {
		return sound;
	}

	public void stopSound() {
		sound.stop();
	}

	public void setDieSound(String location) {
		try {
			dieSound = new Sound(location);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	public void playDieSound() {
		dieSound.play(1f, 100f);
	}

	public Sound getDieSound() {
		return dieSound;
	}

	public void stopDieSound() {
		dieSound.stop();
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getSpeed() {
		return speed;
	}

	public float getRot() {
		return rotation;
	}

	public void moveRot(float amt) {
		rotation += amt;
	}

	public void setRot(float rot) {
		rotation = rot;
	}

	public void setScale(float scale) {
		this.scale = scale;
		s.scale(scale);
	}

	public void setScale(float scale, float centerX, float centerY) {
		this.scale = scale;
		// offX = ((x - centerX) * scale) + centerX ;
		// offY = ((y - centerY) * scale) + centerY ;
		s.scale(scale);
	}

	public float getScale() {
		return scale;
	}

	public void moveX(float amt) {
		position.x += amt;
		changeX = amt;
	}

	public void moveY(float amt) {
		position.y += amt;
		changeY = amt;
	}

	public void setX(float x) {
		position.x = x;
		changeX = x - oldX;
		oldX = x;
	}

	public float getSpeedX() {
		return (float) (getSpeed() * Math.cos(getRot()));
	}

	public float getSpeedY() {
		return (float) (getSpeed() * Math.sin(getRot()));
	}

	public void setY(float y) {
		position.y = y;
		changeY = y - oldY;
		oldY = y;
	}

	public void setScreenY(float y) {
		this.screenY = y;
		changeScreenY = y - oldScreenY;
		oldScreenY = y;
	}

	public void setScreenX(float x) {
		this.screenX = x;
		changeScreenX = x - oldScreenX;
		oldScreenX = x;
	}

	public float getX() {
		return position.x;
	}

	public float getZ() {
		return position.z;
	}

	public float getY() {
		return position.y;
	}

	public float getScreenX() {
		return screenX;
	}

	public float getScreenY() {
		return screenY;
	}

	public float deltaX() {
		return changeX;
	}

	public float deltaY() {
		return changeY;
	}

	public float deltaScreenX() {
		return changeScreenX;
	}

	public float deltaScreenY() {
		return changeScreenY;
	}

	public void setDelta(float delta) {
		this.delta = delta;
	}

	public float getDelta() {
		return delta;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
		bounds = new AABB(this.width, this.height);
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
		bounds = new AABB(this.width, this.height);
	}

	public void setCenter(float x, float y) {
		s.setCenterOfRot(x, y);
	}

	public float getCenterX() {
		return s.getCenterX();
	}

	public float getCenterY() {
		return s.getCenterY();
	}

	public Sprite getSprite() {
		return s;
	}

	public float getOrigScale() {
		return origScale;
	}

	public void setDamageAmt(float f) {
		damgAmt = f;
	}

	public float getDamageAmt() {
		return damgAmt;
	}

	public void hit(float damgAmt) {
		life -= damgAmt;
	}

	public AABB getBounds() {
		return bounds;
	}

	public int addUpgrade(Upgrade u) {
		upgrades.add(u);
		u.setID(upgrades.indexOf(u));
		return u.getID();
	}

	public Upgrade getUpgrade(int upgrade) {
		if (upgrade < upgrades.size())
			return upgrades.get(upgrade);
		else
			return null;
	}

	public int getNumUpgrades() {
		return upgrades.size();
	}

	public void setWeaponPos(float x, float y) {
		this.weaponPosX = x;
		this.weaponPosY = y;
	}

	public float getWeaponHoldX() {
		return weaponPosX;
	}

	public float getWeaponHoldY() {
		return weaponPosY;
	}

	public void setWeapon(Weapon w) {
		this.currentWeapon = w;
		this.hasWeapon = true;
	}

	public void setWeaponFlip(boolean flip) {
		if (hasWeapon)
			currentWeapon.setFlipped(flip);
	}

	public void removeWeapon() {
		this.hasWeapon = false;
		this.currentWeapon = null;
	}

	public boolean hasWeapon() {
		return hasWeapon;
	}

	public Weapon getCurrentWeapon() {
		return currentWeapon;
	}

	public int getType() {
		return type;
	}

	public int getID() {
		return ID;
	}

	public int getDir() {
		if (s.isFlipped())
			return 1;
		return 0;
	}
}
