package net.toper;

import java.util.ArrayList;
import java.util.List;

public class ManagerProjectile {
	private List<Projectile> projectiles = new ArrayList<Projectile>();
	private List<Projectile> temp = new ArrayList<Projectile>();

	public void addProjectle(Projectile projectile) {
		temp.add(projectile);
	}

	public void draw() {
		for (Projectile p : projectiles) {
			p.draw();
		}
	}

	public void update() {
		// Move entities in from the temporary array, used to prevent errors
		// from editing list while writing to it
		for (int i = 0; i < temp.size(); i++) {
			projectiles.add(temp.get(i));
		}
		temp.clear();
		int size = projectiles.size();
		for (int i = 0; i < size; i++) {
			Projectile p = projectiles.get(i);
			p.update();
			if (p.isDead()) {
				projectiles.remove(i);
				//i--;
				size--;
			}
		}
	}

}
