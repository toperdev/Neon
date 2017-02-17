package net.toper.graphics.tiles;

import org.newdawn.slick.Color;
import org.newdawn.slick.geom.Rectangle;

import net.toper.Game;
import net.toper.Main;
import net.toper.graphics.Sprite;

public class ButtonTile extends Tile {

	public static Color mapGenReference = new Color(0xff2255AA);
	private static Sprite s = new Sprite("res/button.png", 1f);
	private float width = 64;
	private boolean pushed = false;

	public ButtonTile(float x, float y, float scale, float tileSize) {
		super(x, y, tileSize, s);
		// setCollidable(false);
		s.scale(scale);
		s.crop(0, width * scale, 0, width * scale);
		getBounds().setBounds(x * tileSize, (y * tileSize) + tileSize - 15, tileSize, 15);
		needsUpdate(true);
	}

	public void update() {
		Rectangle tempBounds = new Rectangle(getBounds().getX(), getBounds().getY() - 1f, getBounds().getWidth(),
				getBounds().getHeight());
		if (Game.gen.collisionBetween(Game.player.getBounds(), tempBounds)) {
			push();
		} else {
			unpush();
		}
	}

	public void push() {
		if (!pushed) {
			s.crop((int) (16 * getScale()), (16) * getScale(), 0, 16 * getScale());
			pushed = true;
		}
	}

	public void unpush() {
		if (pushed) {
			s.crop(0, width * getScale(), 0, width * getScale());
			pushed = false;
		}
	}

}
