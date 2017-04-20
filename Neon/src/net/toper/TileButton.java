package net.toper;

import org.newdawn.slick.Color;
import org.newdawn.slick.geom.Rectangle;

public class TileButton extends Tile {

	public static Color mapGenReference = new Color(0xff2255AA);
	public static Color mapGenReference2 = new Color(0xff2255B6);

	private float width = 64;
	private float height = 15;
	private float scale;
	private float tileSize;
	private boolean pushed = false;
	private boolean stayDown = false;

	private Upgrade u;

	public TileButton(float x, float y, float scale, float tileSize, boolean stayDown, int type) {
		super(x, y, tileSize, new Sprite("res/button.png", scale));
		this.tileSize = tileSize;
		this.scale = scale;
		this.stayDown = stayDown;
		getSprite().scale(scale);
		getSprite().crop(0, width * scale, 0, width * scale);
		getBounds().setBounds(x * tileSize, (y * tileSize) + tileSize - height, tileSize, height);
		needsUpdate(true);
		switch (type) {
		case 0:
			u = new UpgradeLowGravity(Game.player);
			break;
		case 1:
			u = new UpgradeRunSpeed(Game.player);
			break;
		}
	}

	public void updateLogic() {
		Rectangle tempBounds = new Rectangle(getBounds().getX(), getBounds().getY() - height, getBounds().getWidth(),
				getBounds().getHeight());
		if (Game.gen.collisionBetween(Game.player.getBounds(), tempBounds)) {
			push();
		} else {
			unpush();
		}
	}

	public void push() {
		if (!pushed) {
			getSprite().crop((int) width, width, 0, width * scale);
			getBounds().setBounds(getX() * tileSize, (getY() * tileSize) + tileSize - 10, tileSize, 10);
			if (!u.isInUse()) {
				Game.player.addUpgrade(u);
				((GUIOverlayInGame) GUI.getCurrentMenu()).addUpgradeInfo(u);
			}
			pushed = true;
		}
	}

	public boolean isPushed() {
		return pushed;
	}

	public void unpush() {
		if (pushed && !stayDown) {
			getSprite().crop(0, width * scale, 0, width * scale);
			pushed = false;
			getBounds().setBounds(getX() * tileSize, (getY() * tileSize) + tileSize - 15, tileSize, 15);
		}
	}

}
