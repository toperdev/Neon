package net.toper;

public class UpgradeRunSpeed extends Upgrade {

	public UpgradeRunSpeed(Entity parent) {
		super(parent);
		setLife(100f);
		setDecay(0.75f);
		setNewValue("move", 15f * parent.getScale());
		setName("Run");

	}

}
