package net.toper.manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import net.toper.Main;
import net.toper.ent.Entity;

public class EntityManager {

	private List<Entity> entities = new ArrayList<Entity>();
	private List<Entity> temp = new ArrayList<Entity>();
	private List<Entity> remove = new ArrayList<Entity>();
	private int score;

	public void init() {
	}

	public void draw() {
		for (Entity e : entities) {
				e.draw();
		}
	}

	public void update() {
		float delta = Main.getDelta();
		// Move entities in from the temporary array, used to prevent errors
		// from editing list while writing to it
		for (int i = 0; i < temp.size(); i++) {
			entities.add(temp.get(i));
		}
		temp.clear();
		/*
		 * for (Entity e : entities) { // Where the logic goes for getting hit
		 * and things like that }
		 */
		// Update entities and remove dead entities from the array. Created this
		// way just in case something changes in the array while accessing it
		int size = entities.size();
		for (int i = 0; i < size; i++) {
			Entity e = entities.get(i);
			e.setDelta(delta);
			e.update();
			if (e.isDead()) {
				entities.remove(i);
				i--;
				size--;
			}
		}
		// Sort the leftover entities by x and y locations, easier to parse
		// through and check
		Collections.sort(entities, new Comparator<Entity>() {
			public int compare(Entity z1, Entity z2) {
				if (z1.getY() > z2.getY())
					return -1;
				if (z1.getY() < z2.getY())
					return 1;
				return 0;
			}
		});
		Collections.sort(entities, new Comparator<Entity>() {
			public int compare(Entity z1, Entity z2) {
				if (z1.getZ() > z2.getZ())
					return 1;
				if (z1.getZ() < z2.getZ())
					return -1;
				return 0;
			}
		});
	}

	// Add an entity to the temporary holding array, will be added in the next
	// logic call
	public void addEntity(Entity e) {
		temp.add(e);
	}

	// Remove entity from the current entity array
	public void removeEntity(int index) {
		entities.remove(index);
	}

	// Get all entities in the game
	public Entity getEntity(int i) {
		return entities.get(i);
	}

	// Returns score that's calculated from the update logic
	public int getScore() {
		return score;
	}

	// Essentially a reset command, clears all lists and resets score
	public void clear() {
		entities.clear();
		remove.clear();
		score = 0;
	}

	// Get the total entities currently in the list
	public int getNum() {
		return entities.size();
	}

}
