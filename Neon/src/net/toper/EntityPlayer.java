package net.toper;

import java.util.HashMap;

import org.newdawn.slick.Color;
import org.newdawn.slick.Input;

public class EntityPlayer extends Entity {

	// Scale and spawn point color initializer
	public static float origScale = 0.6f;
	private int animWidth = 128;
	private float animStep;
	public static Color mapGenReference = new Color(0xffff0000);

	// Initial values, final to ensure they don't get changed through upgrades
	// or something
	private final float origPlayerMoveSpeed = 20f * origScale;
	private final float origJumpSpeed = 55f * origScale;
	private final float origPlayerAnimSpeed = 0.34f * origScale;

	private HashMap<String, Float> movementValues = new HashMap<String, Float>();

	// Physics reference and gravity class
	private int phys;
	private PhysicsElementGravity movement;

	public EntityPlayer() {
		super(0, 0, 10, new Sprite("res/character animation.png", 1), 1);
		// setScale(origScale);
		getSprite().crop(0, animWidth, 0, getHeight());
		setWidth(animWidth * 2);
		setHeight(256);
		System.out.println(getWidth() + " " + getHeight());
		setLinkPosAndScreen(false);
		setScreenX(Main.getWidth() / 2 - getCenterX());
		setScreenY(Main.getHeight() / 2 - getCenterY());

	}

	public void init(float x, float y) {
		setX(x);
		setY(y);
		phys = Game.p.addElement(new PhysicsElementGravity(this));
		movement = (PhysicsElementGravity) Game.p.getElement(phys);
		movement.setPos(x, y);

		movementValues.put("jump", origJumpSpeed);
		movementValues.put("move", origPlayerMoveSpeed);
		movementValues.put("anim", origPlayerAnimSpeed);

		weaponPos(false);
		setWeapon(new WeaponLaserGun(this));

	}

	public void weaponPos(boolean flip) {
		if (!flip) {
			setWeaponPos(48, 28);
			setWeaponFlip(false);
		} else {
			setWeaponPos(0, 28);
			setWeaponFlip(true);
		}
	}

	public void updateLogic() {
		System.out.println(position.x + " " + position.y + " " + getBounds().r[0] + " " + getBounds().r[1]);
		processLimits();
		processUpgrades();
		Input input = Main.gc.getInput();
		// Close game when the escape key is hit
		if (input.isKeyDown(Input.KEY_ESCAPE)) {
			Main.close();
		}
		if (input.isMouseButtonDown(0) || input.isKeyDown(Input.KEY_E)) {
			if (hasWeapon())
				getCurrentWeapon().fireLoop();
		} else {
			getCurrentWeapon().resetFire();
		}
		if (input.isKeyDown(Input.KEY_RIGHT) || input.isKeyDown(Input.KEY_D)) {
			getSprite().flip(false);
			movement.setHorizontalVelocty(movementValues.get("move"));
		}
		if (input.isKeyDown(Input.KEY_LEFT) || input.isKeyDown(Input.KEY_A)) {
			getSprite().flip(true);
			movement.setHorizontalVelocty(-movementValues.get("move"));
		}

		if (input.isKeyDown(Input.KEY_SPACE) || input.isKeyDown(Input.KEY_W) || input.isKeyDown(Input.KEY_UP)) {
			if (movement.isOnGround())
				movement.setVerticalVelocity(movementValues.get("jump"));
		}

		weaponPos(getSprite().isFlipped());

		if (movement.getDeltaX() != 0)
			animStep += (movementValues.get("move") / 35f) * getDelta();

		int step = (int) animStep;
		step %= getSprite().getOrigWidth() / animWidth;
		animStep %= getSprite().getOrigWidth();
		getSprite().crop((int) ((step * animWidth)), animWidth, 0, getSprite().getOrigHeight());

		Game.gen.map.offset(-getX() + getScreenX(), -getY() + getScreenY());
		Game.bg.offset((Game.gen.map.getOffsetX()), (Game.gen.map.getOffsetY()));
	}

	public void processLimits() {
		if (getY() > 35000f) {
			GUI.setState(GameState.LOST);
		}
	}

	public void processUpgrades() {
		movementValues.put("jump", origJumpSpeed);
		movementValues.put("move", origPlayerMoveSpeed);
		for (int i = 0; i < getNumUpgrades(); i++) {
			if (getUpgrade(i) instanceof UpgradeLowGravity) {
				getUpgrade(i).setValues(movementValues);
			}
			if (getUpgrade(i) instanceof UpgradeRunSpeed) {
				getUpgrade(i).setValues(movementValues);
			}
		}

	}

}
