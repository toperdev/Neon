package net.toper;

public class Holdable {

	private Entity parent;

	public Holdable(Entity parent) {
		this.parent = parent;
	}

	public Entity getParent() {
		return parent;
	}

}
