package net.toper.upgrades;

import net.toper.ent.Entity;

public class UpgradeRunSpeed extends Upgrade {

	public UpgradeRunSpeed(Entity parent) {
		super(parent);
		setLife(100f);
		setDecay(0.75f);
		setNewValue("move", 15f * parent.getScale());
		setName("Run");

	}

}
