package net.toper.ent;

import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;

import net.toper.Game;
import net.toper.Main;
import net.toper.graphics.Sprite;

public class EntityPlayer extends Entity {

	float playerDeltaX;
	float playerDeltaY;
	float playerScreenX;
	float playerScreenY;

	public static float origScale = 0.25f;
	private static float origX = 0;
	private static float origY = 0f;

	float playerMoveSpeed = 10f * (1 + origScale);
	float jumpSpeed = 15f * (1 + origScale);
	float gravity = 1.35f * (1 + origScale);
	boolean jump = false;
	float jumpBounceAmt = 2f;
	boolean onGround = false;

	float edgePaddingX = 250f;
	float edgePaddingY = 50f;

	Rectangle hitBox;

	float time;

	public EntityPlayer() {
		super(origX, origY, 10, new Sprite("res/lol.png", origScale));
		setScale(origScale);
		setCenter(getWidth() / 2, getHeight());
		setLinkPosAndScreen(false);
		setScreenX(Main.getWidth() / 2 - getWidth() / 2);
		setScreenY(Main.getHeight() / 2 - getHeight() / 2);
	}

	public void update() {
		hitBox = getBounds();
		time += 0.1f * getDelta();
		Input input = Main.gc.getInput();
		// Close game when the escape key is hit
		if (input.isKeyDown(Input.KEY_ESCAPE)) {
			Main.gc.exit();
		}
		boolean isInput = false;
		if (input.isKeyDown(Input.KEY_RIGHT) || input.isKeyDown(Input.KEY_D)) {
			getSprite().flip(false);
			playerDeltaX = playerMoveSpeed;
			isInput = true;

		}
		if (input.isKeyDown(Input.KEY_LEFT) || input.isKeyDown(Input.KEY_A)) {
			getSprite().flip(true);
			playerDeltaX = -playerMoveSpeed;
			isInput = true;
		}
		if (!isInput) {
			playerDeltaX = 0;
		}
		moveX(playerDeltaX * getDelta());
		if (Game.gen.collisionAt(getBounds())) {
			moveX(-playerDeltaX * getDelta());
			playerDeltaX = 0;
		}

		if (input.isKeyDown(Input.KEY_SPACE) || input.isKeyDown(Input.KEY_W) || input.isKeyDown(Input.KEY_UP)) {
			if (!jump && onGround) {
				playerDeltaY = -jumpSpeed;
				jump = true;
			}
		}

		if (!onGround)
			playerDeltaY += gravity;
		moveY(playerDeltaY * getDelta());
		if (Game.gen.collisionAt(getBounds())) {
			moveY(-playerDeltaY * getDelta());
			if (playerDeltaY < 0 && jump && !onGround) {
				playerDeltaY = -playerDeltaY;
			} else {
				playerDeltaY = 0f;
				onGround = true;
			}
			jump = false;
		} else {
			onGround = false;
		}
		if (getSprite().isFlipped()) {
			setRot((float) Math.sin(playerDeltaX * time / 10f) * 20f);
		} else {
			setRot((float) -Math.sin(playerDeltaX * time / 10f) * 20f);
		}
		Game.gen.map.offset(-getX() + Main.getWidth() / 2 - getWidth() / 2, -getY() + Main.getHeight() / 2 - getHeight() / 2);
		Game.bg.offset((Game.gen.map.getOffsetX()/5f), (Game.gen.map.getOffsetY()/5f) -500);
	}

	public static double scale(final double valueIn, final double baseMin, final double baseMax, final double limitMin, final double limitMax) {
		return ((limitMax - limitMin) * (valueIn - baseMin) / (baseMax - baseMin)) + limitMin;
	}

}
