package net.toper.physics;

import java.util.ArrayList;
import java.util.List;

public class Physics implements Runnable {

	List<PhysicsElement> elements = new ArrayList<PhysicsElement>();

	public void run() {

	}

	public int addElement(PhysicsElement e) {
		elements.add(e);
		return elements.indexOf(e);
	}

}
