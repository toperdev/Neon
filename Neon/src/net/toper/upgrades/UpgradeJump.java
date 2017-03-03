package net.toper.upgrades;

import net.toper.ent.Entity;

public class UpgradeJump extends Upgrade {

	// Just put new traits that the upgrade has here
	public UpgradeJump(Entity parent) {
		super(parent);
		setLife(100f);
		setDecay(0.5f);
		setNewValue(80f);
		setName("Jump");
	}

}
