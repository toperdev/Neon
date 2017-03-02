package net.toper.graphics.gui;

import javax.print.attribute.standard.MediaSize.NA;

import org.newdawn.slick.Color;

import net.toper.Game;
import net.toper.upgrades.Upgrade;

public class GUIElementHealthBar extends GUIElement {

	private float health;
	private int id, parentID;
	private int parentType;
	private float origHealth;
	private String name;

	public GUIElementHealthBar(float x, float y, float width) {
		super(x, y, width, 10);
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
		float width = (float) scale(health, 0, origHealth, 0, getWidth());
		Game.r.drawRect(getX(), getY() + 25, width, 10, Color.green);
		getFont().setSize(15);
		getFont().drawText(getX(), getY(), name);
	}

	public static double scale(final double valueIn, final double baseMin, final double baseMax, final double limitMin,
			final double limitMax) {
		return ((limitMax - limitMin) * (valueIn - baseMin) / (baseMax - baseMin)) + limitMin;
	}

	public void setInfoParent(Upgrade upgrade) {
		this.name = upgrade.getName();
		this.health = upgrade.getLife();
		this.origHealth = health;
		this.id = upgrade.getID();
		this.parentType = upgrade.getType();
		done = false;
	}
}
