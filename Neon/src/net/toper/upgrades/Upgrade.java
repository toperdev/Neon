package net.toper.upgrades;

import java.util.ArrayList;
import java.util.List;

public class Upgrade {

	public List<Integer> originalValues = new ArrayList<Integer>();
	public List<Integer> newValues = new ArrayList<Integer>();
	private float life = 1f;
	private float origLife;
	private float lifeDecay = 1f;
	private boolean completed = false;
	private float changedValue = 0f;
	private String name;
	private int id;
	private boolean isInUse = false;

	/**
	 * @param newValue
	 *            - The new value that the upgrade will have
	 */
	public void setNewValue(float newValue) {
		changedValue = newValue;
	}

	/**
	 * @param life
	 *            - How long the upgrade will last, default 1f
	 */
	public void setLife(float life) {
		this.life = life;
		this.origLife = life;
	}

	/**
	 * @param decay
	 *            - How quickly the life will decay, default 1f
	 */
	public void setDecay(float decay) {
		this.lifeDecay = decay;
	}

	/**
	 * @return life
	 */
	public float getLife() {
		return life;
	}

	public void update(float delta) {
		isInUse = true;
		if (!completed) {
			life -= lifeDecay * delta;
			if (life <= 0f) {
				life = 0f;
				completed = true;
			}
		}
	}

	public boolean isCompleted() {
		return completed;
	}

	public float upgradeValue() {
		return changedValue;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setID(int id) {
		this.id = id;
	}

	public int getID() {
		return id;
	}

	public void reset() {
		completed = false;
		life = origLife;
	}

	public boolean isInUse() {
		return isInUse;
	}

}
