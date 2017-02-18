package net.toper.graphics.tiles;

import org.newdawn.slick.Color;
import org.newdawn.slick.geom.Rectangle;

import net.toper.Game;
import net.toper.graphics.Sprite;

public class ButtonTile extends Tile {

	public static Color mapGenReference = new Color(0xff2255AA);
	public static Color mapGenReference2 = new Color(0xff4E3EA8);
	private static Sprite s = new Sprite("res/button.png", 1f);
	private float width = 64;
	private float scale;
	private float tileSize;
	private boolean pushed = false;
	private boolean stayDown = false;

	public ButtonTile(float x, float y, float scale, float tileSize, boolean stayDown) {
		super(x, y, tileSize, s);
		this.tileSize = tileSize;
		this.scale = scale;
		this.stayDown = stayDown;
		s.scale(scale);
		s.crop(0, width * scale, 0, width * scale);
		getBounds().setBounds(x * tileSize, (y * tileSize) + tileSize - 15, tileSize, 15);
		needsUpdate(true);
	}

	public void update() {
		Rectangle tempBounds = new Rectangle(getBounds().getX(), getBounds().getY() - 3f, getBounds().getWidth(),
				getBounds().getHeight());
		if (Game.gen.collisionBetween(Game.player.getBounds(), tempBounds)) {
			push();
		} else {
			unpush();
		}
	}

	public void push() {
		if (!pushed) {
			s.crop((int) width, width, 0, width * scale);
			pushed = true;
			getBounds().setBounds(getX() * tileSize, (getY() * tileSize) + tileSize - 10, tileSize, 10);
		}
	}

	public boolean isPushed() {
		return pushed;
	}

	public void unpush() {
		if (pushed && !stayDown) {
			s.crop(0, width * scale, 0, width * scale);
			pushed = false;
			getBounds().setBounds(getX() * tileSize, (getY() * tileSize) + tileSize - 15, tileSize, 15);
		}
	}

}
