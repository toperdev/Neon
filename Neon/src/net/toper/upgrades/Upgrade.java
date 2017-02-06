package net.toper.upgrades;

import java.util.ArrayList;
import java.util.List;

public class Upgrade {

	public List<Integer> originalValues = new ArrayList<Integer>();
	public List<Integer> newValues = new ArrayList<Integer>();
	private float life = 1f;
	private float lifeDecay = 1f;
	private boolean completed = false;
	private float changedValue = 0f;

	/**
	 * @param newValue - The new value that the upgrade will have
	 */
	public void setNewValue(float newValue) {
		changedValue = newValue;
	}

	/**
	 * @param life - How long the upgrade will last, default 1f
	 */
	public void setLife(float life) {
		this.life = life;
	}
	
	/**
	 * @param decay - How quickly the life will decay, default 1f
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
		life -= lifeDecay * delta;
		if (life <= 0) {
			completed = true;
		}
	}

	public boolean isCompleted() {
		return completed;
	}

	public float upgradeValue() {
		return changedValue;
	}

}
