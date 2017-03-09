package net.toper;

public class EntityEnemyExample extends EntityEnemy {

	private float origScale = 0.15f;

	// Initialization of enemy, sets position, size, sprite, how much damage it
	// does, life amount, and other stuffs
	public EntityEnemyExample(float x, float y) {
		super(x, y);
		setScale(origScale);
		setLife(100f);
		setDamageAmt(2f);
		// setDieSound("res/die.ogg");
	}

	// Movement stuff and logic
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
