package net.toper.ent;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.geom.Rectangle;

import net.toper.graphics.Sprite;
import net.toper.upgrades.Upgrade;

public class Entity {

	private int ID;
	private float posX;
	private float posY;
	private float screenX;
	private float screenY;
	private float oldScreenX;
	private float oldScreenY;
	private float changeScreenX;
	private float changeScreenY;
	private float z;
	private float changeX;
	private float changeY;
	private float oldX;
	private float oldY;
	private float scale;
	private float rotation;
	private float speed;
	private float origScale;
	private float delta;
	private float damgAmt;
	private int type;

	private Sprite s;
	private Sound sound, dieSound;
	private float life, decay;
	private boolean removeIfDead = false;
	private boolean link = true;

	private List<Upgrade> upgrades = new ArrayList<Upgrade>();

	public Entity(float x, float y, float z, Sprite sprite, int type) {
		this.posX = x;
		this.posY = y;
		this.z = z;
		setSprite(sprite);
		scale = s.getScale();
		origScale = scale;
	}

	public void setID(int id) {
		this.ID = id;
	}

	public void setLinkPosAndScreen(boolean link) {
		this.link = link;
	}

	public void update() {
	}

	public void move(float xAmt, float yAmt) {
		moveX(xAmt);
		moveY(yAmt);
	}

	public void setSprite(Sprite s) {
		this.s = s;
	}

	public void draw() {
		float centerY = s.getCenterY();
		float centerX = s.getCenterX();
		s.scale(scale);
		if (link) {
			s.setX(posX);
			s.setY(posY);
		} else {
			s.setX(screenX);
			s.setY(screenY);
		}
		s.setCenterOfRot(centerX, centerY);
		s.setRot(rotation);
		s.draw();
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
		posX += amt;
		changeX = amt;
	}

	public void moveY(float amt) {
		posY += amt;
		changeY = amt;
	}

	public void setX(float x) {
		this.posX = x;
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
		this.posY = y;
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
		return posX;
	}

	public float getZ() {
		return z;
	}

	public float getY() {
		return posY;
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
		return s.getWidth();
	}

	public float getHeight() {
		return s.getHeight();
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

	public Rectangle getBounds() {
		return new Rectangle(getX(), getY(), s.getWidth(), s.getHeight());
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

	List<Integer> remove = new ArrayList<Integer>();

	public void updateUpgrades() {
		for (int i = 0; i < upgrades.size(); i++) {
			upgrades.get(i).update(delta);
			if (upgrades.get(i).isCompleted()) {
				remove.add(i);
			}
		}
		for (int i : remove) {
			if (i < upgrades.size())
				upgrades.remove(i);
		}
		remove.clear();
	}

	public int getNumUpgrades() {
		return upgrades.size();
	}

	public int getType() {
		return type;
	}

	public int getID() {
		return ID;
	}
}
