package net.toper.ent;

import net.toper.manager.SpriteManager;

public class EntityEnemyExample extends EntityEnemy {

	private float origScale = 0.15f;

	// Initialization of enemy, sets position, size, sprite, how much damage it
	// does, life amount, and other stuffs
	public EntityEnemyExample(float x, float y) {
		super(x, y, 0, SpriteManager.getEnemyCarSprite());
		setScale(origScale);
		setLife(100f);
		setDamageAmt(2f);
		// setDieSound("res/die.ogg");
	}

	// Movement stuff and logic, updates 60 times a second.
	public void update() {
		if (isDead()) {
			// do some animation or something
		}
		// Movement
		moveX(getSpeed() * getDelta());
		moveY(getSpeed() * getDelta());
	}

	// What happens when the entity is hit by something
	public void hit(float damgAmt) {
		subtractLife(damgAmt);
	}

}
