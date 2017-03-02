package net.toper.graphics.gui;

import org.newdawn.slick.Color;

import net.toper.Game;

public class GUIElementHealthBar extends GUIElement {

	private float health;
	private int id, parentID;
	private int parentType;
	private float width;
	private float origHealth;
	private String name;

	public GUIElementHealthBar(float x, float y, float health, int id, int parentType) {
		super(x, y, health, 10);
		this.health = health;
		this.origHealth = health;
		this.id = id;
		this.parentType = parentType;
	}

	public GUIElementHealthBar(float x, float y, float width, float health, int id, String name, int parentType) {
		super(x, y, width, 10);
		this.health = health;
		this.origHealth = health;
		this.id = id;
		this.parentType = parentType;
		this.name = name;
		this.width = width;
	}

	public void update() {
		switch (parentType) {
		case 0:
			if (Game.em.getUpgrade(id, parentID) == null) {
				done = true;
			} else
				health = Game.em.getUpgrade(id, parentID).getLife();
			break;
		case 1:
			if (Game.em.getEntity(id) == null) {
				done = true;
			} else
				health = Game.em.getEntity(id).getLife();
			break;
		}
		if (health <= 0f) {
			done = true;
		}
	}

	public void render() {
		float width = (float) scale(health, 0, origHealth, 0, this.width);
		Game.r.drawRect(getX(), getY() + 25, width, 10, Color.green);
		GUI.getFont().drawText(getX(), getY(), name);
	}

	public static double scale(final double valueIn, final double baseMin, final double baseMax, final double limitMin,
			final double limitMax) {
		return ((limitMax - limitMin) * (valueIn - baseMin) / (baseMax - baseMin)) + limitMin;
	}
}
