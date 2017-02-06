package net.toper.manager;

import net.toper.graphics.Sprite;

public class SpriteManager {

	public static Sprite getStarSprite() {
		return new Sprite("res/star.png", 1f);
	}

	public static Sprite getLaserSprite(boolean upgraded) {
		if (!upgraded) {
			return new Sprite("res/laser.png", 1f);
		} else {
			return new Sprite("res/nanner.png", 0.25f);
		}
	}

	public static Sprite getEnemyCarSprite() {
		return new Sprite("res/dad.png", 1f);
	}

	public static Sprite getEnemyPizzaSprite() {
		return new Sprite("res/toast.png", 1f);
	}

	public static Sprite getExplosionSprite() {
		return new Sprite("res/explosion.png", 1f);
	}
}
