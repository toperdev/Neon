package net.toper.ent;

import org.newdawn.slick.Color;
import org.newdawn.slick.Input;

import net.toper.Game;
import net.toper.Main;
import net.toper.graphics.Sprite;
import net.toper.physics.PhysicsElementGravity;
import net.toper.upgrades.UpgradeLowGravity;

public class EntityPlayer extends Entity {

	// Scale and spawn point color initializer
	public static float origScale = 0.6f;
	private int animWidth = 128;
	private int hitWidth = 64;
	private float animStep;
	public static Color mapGenReference = Color.red;

	// Initial values, final to ensure they don't get changed through upgrades
	// or something
	private final float origPlayerMoveSpeed = 20f * origScale;
	private final float origJumpSpeed = 55f * origScale;

	// Current, modifiable movement speed values
	private float playerMoveSpeed = origPlayerMoveSpeed;
	private float jumpSpeed = origJumpSpeed;

	// Physics reference and gravity class
	private int phys;
	private PhysicsElementGravity movement;

	public EntityPlayer(float x, float y) {
		super(x, y, 10, new Sprite("res/character animation.png", origScale), 1);
		setScale(origScale);
		getSprite().crop(0, animWidth, 0, getHeight());
		setWidth(animWidth);
		setHitBoxWidth(hitWidth);
		setLinkPosAndScreen(false);
		setScreenX(Main.getWidth() / 2 - getCenterX());
		setScreenY(Main.getHeight() / 2 - getCenterY());
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

		if (movement.getDeltaX() != 0)
			animStep += 0.35f * getDelta();

		setX(movement.getX());
		setY(movement.getY());

		animStep %= getSprite().getOrigWidth() / animWidth;
		int step = (int) animStep;
		getSprite().crop((int) ((step * animWidth)), animWidth, 0, getSprite().getOrigHeight());

		Game.gen.map.offset(-getX() + getScreenX(), -getY() + getScreenY());
		Game.bg.offset((Game.gen.map.getOffsetX() / 2f), (Game.gen.map.getOffsetY() / 2f));
	}

	public void processUpgrades() {
		if (getNumUpgrades() == 0) {
			jumpSpeed = origJumpSpeed;
			playerMoveSpeed = origPlayerMoveSpeed;
		} else
			for (int i = 0; i < getNumUpgrades(); i++) {
				if (getUpgrade(i) instanceof UpgradeLowGravity) {
					jumpSpeed = getUpgrade(i).upgradeValue() * getScale();
				} else {
					jumpSpeed = origJumpSpeed;
				}
			}
	}

}
