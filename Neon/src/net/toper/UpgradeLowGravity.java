package net.toper;

public class UpgradeLowGravity extends Upgrade {

	// Just put new traits that the upgrade has here
	public UpgradeLowGravity(Entity parent) {
		super(parent);
		setLife(100f);
		setDecay(0.65f);
		setNewValue("jump", 100f * parent.getScale());
		setName("Low Gravity");
	}

}
