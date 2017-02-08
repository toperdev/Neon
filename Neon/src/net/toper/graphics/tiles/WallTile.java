package net.toper.graphics.tiles;

import org.newdawn.slick.Color;

import net.toper.graphics.Sprite;

public class WallTile extends Tile {
	public static Color mapGenReference = new Color(0xffFF00D4);

	public WallTile(float x, float y, float scale, float tileSize) {
		super(x, y, tileSize, new Sprite("res/wall.png", scale));
	}

}
