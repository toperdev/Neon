package net.toper.upgrades;

import net.toper.ent.Entity;

public class UpgradeLowGravity extends Upgrade {

	// Just put new traits that the upgrade has here
	public UpgradeLowGravity(Entity parent) {
		super(parent);
		setLife(100f);
		setDecay(0.5f);
		setNewValue(120f);
		setName("Low Gravity");
	}

}
