package net.toper;

import org.newdawn.slick.Color;

public class TileWall extends Tile {
	public static Color mapGenReference = new Color(0xffFF00D4);

	public TileWall(float x, float y, float scale, float tileSize) {
		super(x, y, tileSize, new Sprite("res/wall.png", scale));
	}

}
