package net.toper;

import java.util.HashMap;

public class Upgrade {

	public HashMap<String, Float> newValues = new HashMap<String, Float>();
	private float life = 1f;
	private float origLife;
	private float lifeDecay = 1f;
	private boolean completed = false;
	private String name;

	private int id;
	private Entity parent;

	private boolean isInUse = false;

	public Upgrade(Entity parent) {
		this.parent = parent;
	}

	/**
	 * @param newValue
	 *            - The new value that the upgrade will have
	 */
	public void setNewValue(String name, float newValue) {
		newValues.put(name, newValue);
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
		boolean complete = completed;
		if (completed)
			if (life <= 0f) {
				reset();
			}
		return complete;
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
		isInUse = false;
	}

	public boolean isInUse() {
		return isInUse;
	}

	public Entity getParent() {
		return parent;
	}

	public int getType() {
		return 0;
	}

	public void setValues(HashMap<String, Float> values) {
		for (String key : newValues.keySet()) {
			values.put(key, values.get(key) + newValues.get(key));
		}
	}

}
