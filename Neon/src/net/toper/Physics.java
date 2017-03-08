package net.toper;

import java.util.ArrayList;
import java.util.List;

public class Physics implements Runnable {

	final double ticks = 60D;
	double ticksUpdates = 60D;
	double ns = 1000000000 / ticks;
	static float delta = 0;
	private boolean running = true;

	List<PhysicsElement> elements = new ArrayList<PhysicsElement>();

	public void run() {
		long lastTime = System.nanoTime();
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			while (delta >= 1f && running) {
				updateElements();
				Main.addPhysicsFPS();
				delta--;
			}
			lastTime = now;
		}

	}

	public void updateElements() {
		for (PhysicsElement e : elements) {
			e.update(delta);
		}
	}

	public int addElement(PhysicsElement e) {
		elements.add(e);
		return elements.indexOf(e);
	}

	public void stop() {
		running = false;
	}

	public PhysicsElement getElement(int parentID) {
		if (parentID >= 0 && parentID < elements.size()) {
			return elements.get(parentID);
		} else {
			return null;
		}
	}

}
