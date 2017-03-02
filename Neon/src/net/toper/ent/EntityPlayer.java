package net.toper.ent;

import org.newdawn.slick.Color;
import org.newdawn.slick.Input;

import net.toper.Game;
import net.toper.Main;
import net.toper.graphics.Sprite;
import net.toper.physics.PhysicsElementGravity;
import net.toper.upgrades.UpgradeJump;

public class EntityPlayer extends Entity {

	// Scale and spawn point color initializer
	public static float origScale = 0.35f;
	public static Color mapGenReference = Color.red;

	// Initial values, final to ensure they don't get changed through upgrades
	// or something
	private final float origPlayerMoveSpeed = 25f * origScale;
	private final float origJumpSpeed = 60f * origScale;

	// Current, modifiable movement speed values
	private float playerMoveSpeed = origPlayerMoveSpeed;
	private float jumpSpeed = origJumpSpeed;

	// Physics reference and gravity class
	private int phys;
	private PhysicsElementGravity movement;

	public EntityPlayer(float x, float y) {
		super(x, y, 10, new Sprite("res/lol.png", origScale), 1);
		setScale(origScale);
		setCenter(getWidth() / 2, getHeight());
		setLinkPosAndScreen(false);
		setScreenX(Main.getWidth() / 2 - getWidth() / 2);
		setScreenY(Main.getHeight() / 2 - getHeight() / 2);
		phys = Game.p.addElement(new PhysicsElementGravity(this));
		movement = (PhysicsElementGravity) Game.p.getElement(phys);
		movement.setPos(x, y);
	}

	public void update() {
		processUpgrades();
		Input input = Main.gc.getInput();
		// Close game when the escape key is hit
		if (input.isKeyDown(Input.KEY_ESCAPE)) {
			Main.close();
		}
		setRot(0);
		if (input.isKeyDown(Input.KEY_RIGHT) || input.isKeyDown(Input.KEY_D)) {
			getSprite().flip(false);
			movement.setHorizontalVelocty(playerMoveSpeed);
		}
		if (input.isKeyDown(Input.KEY_LEFT) || input.isKeyDown(Input.KEY_A)) {
			getSprite().flip(true);
			movement.setHorizontalVelocty(-playerMoveSpeed);
		}

		if (input.isKeyDown(Input.KEY_SPACE) || input.isKeyDown(Input.KEY_W) || input.isKeyDown(Input.KEY_UP)) {
			if (movement.isOnGround())
				movement.setVerticalVelocity(jumpSpeed);
		}

		float rot = movement.getDeltaY() / 1.5f;
		if (getSprite().isFlipped()) {
			setRot(-rot);
		} else {
			setRot(rot);
		}
		setX(movement.getX());
		setY(movement.getY());

		Game.gen.map.offset(-getX() + getScreenX(), -getY() + getScreenY());
		Game.bg.offset((Game.gen.map.getOffsetX() / 2f), (Game.gen.map.getOffsetY() / 2f));
	}

	public void processUpgrades() {
		if (getNumUpgrades() == 0) {
			jumpSpeed = origJumpSpeed;
			playerMoveSpeed = origPlayerMoveSpeed;
		} else
			for (int i = 0; i < getNumUpgrades(); i++) {
				if (getUpgrade(i) instanceof UpgradeJump) {
					jumpSpeed = getUpgrade(i).upgradeValue() * getScale();
				} else {
					jumpSpeed = origJumpSpeed;
				}
			}
	}

}
