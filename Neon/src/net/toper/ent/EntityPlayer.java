package net.toper.ent;

import org.newdawn.slick.Input;

import net.toper.Game;
import net.toper.Main;
import net.toper.graphics.Sprite;
import net.toper.physics.PhysicsElementGravity;

public class EntityPlayer extends Entity {

	public static float origScale = 0.5f;
	private static float origX = 0;
	private static float origY = 0f;

	private float time;

	float playerMoveSpeed = 25f * origScale;
	float jumpSpeed = 60f * origScale;

	int phys;
	PhysicsElementGravity movement;

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
		time += getDelta();
		Input input = Main.gc.getInput();
		// Close game when the escape key is hit
		if (input.isKeyDown(Input.KEY_ESCAPE)) {
			Main.close();
		}
		setRot(0);
		if (input.isKeyDown(Input.KEY_RIGHT) || input.isKeyDown(Input.KEY_D)) {
			getSprite().flip(false);
			movement.setHorizontalVelocty(playerMoveSpeed);
			setRot((float) Math.sin((time / 7f)) * 15f);
		}
		if (input.isKeyDown(Input.KEY_LEFT) || input.isKeyDown(Input.KEY_A)) {
			getSprite().flip(true);
			movement.setHorizontalVelocty(-playerMoveSpeed);
			setRot((float) -Math.sin((time / 7f)) * 15f);
		}

		if (input.isKeyDown(Input.KEY_SPACE) || input.isKeyDown(Input.KEY_W) || input.isKeyDown(Input.KEY_UP)) {
			if (movement.isOnGround())
				movement.setVerticalVelocity(jumpSpeed);
		}

		setX(movement.getX());
		setY(movement.getY());

		Game.gen.map.offset(-getX() + getScreenX(), -getY() + getScreenY());
		Game.bg.offset((Game.gen.map.getOffsetX() / 2f), (Game.gen.map.getOffsetY() / 2f));
	}

}
