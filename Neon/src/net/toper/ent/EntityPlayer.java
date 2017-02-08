package net.toper.ent;

import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;

import net.toper.Game;
import net.toper.Main;
import net.toper.graphics.Sprite;
import net.toper.physics.PhysicsElementGravity;

public class EntityPlayer extends Entity {

	float playerDeltaX;
	float playerDeltaY;
	float playerScreenX;
	float playerScreenY;

	public static float origScale = 0.25f;
	private static float origX = 0;
	private static float origY = 0f;

	float playerMoveSpeed = 10f * (1 + origScale);
	float jumpSpeed = 35f * (1 + origScale);
	float gravity = 1.35f * (1 + origScale);
	boolean jump = false;
	float jumpBounceAmt = 2f;
	boolean onGround = false;

	float edgePaddingX = 250f;
	float edgePaddingY = 50f;

	Rectangle hitBox;

	int phys;
	PhysicsElementGravity movement;

	float time;

	public EntityPlayer() {
		super(origX, origY, 10, new Sprite("res/lol.png", origScale));
		setScale(origScale);
		setCenter(getWidth() / 2, getHeight());
		setLinkPosAndScreen(false);
		setScreenX(Main.getWidth() / 2 - getWidth() / 2);
		setScreenY(Main.getHeight() / 2 - getHeight() / 2);
		phys = Game.p.addElement(new PhysicsElementGravity(this));
		movement = (PhysicsElementGravity) Game.p.getElement(phys);
	}

	public void update() {
		hitBox = getBounds();
		Input input = Main.gc.getInput();
		// Close game when the escape key is hit
		if (input.isKeyDown(Input.KEY_ESCAPE)) {
			Main.close();
		}
		boolean isInput = false;
		if (input.isKeyDown(Input.KEY_RIGHT) || input.isKeyDown(Input.KEY_D)) {
			getSprite().flip(false);
			movement.setHorizontalVelocty(playerMoveSpeed);
			isInput = true;
		}
		if (input.isKeyDown(Input.KEY_LEFT) || input.isKeyDown(Input.KEY_A)) {
			getSprite().flip(true);
			movement.setHorizontalVelocty(-playerMoveSpeed);
			isInput = true;
		}
		if (!isInput) {
			movement.setHorizontalVelocty(0);
		}

		if (input.isKeyDown(Input.KEY_SPACE) || input.isKeyDown(Input.KEY_W) || input.isKeyDown(Input.KEY_UP)) {
			movement.setVerticalVelocity(jumpSpeed);
		}

		setX(movement.getX());
		setY(movement.getY());

		Game.gen.map.offset(-getX() + getScreenX(), -getY() + getScreenY());
		Game.bg.offset((Game.gen.map.getOffsetX() / 5f), (Game.gen.map.getOffsetY() / 5f) - 500);
	}

}
