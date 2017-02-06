package net.toper.manager;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import net.toper.graphics.tiles.WallTile;

public class MapGen {
	public Map map = new Map();
	private static float mapScale = 1f;
	private static float tileSize = 32f;
	private static int mapWidth = 1000;
	Image mapSource;

	public MapGen() {
		try {
			mapSource = new Image("res/mapgen.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
		for (int y = 0; y < mapSource.getHeight(); y++) {
			for (int x = 0; x < mapSource.getWidth(); x++) {
				if (mapSource.getColor(x, y).equals(WallTile.mapGenReference)) {
					map.addTile(x, y, new WallTile(x, y, mapScale, tileSize));
				}
			}
		}
	}

	public boolean collisionAt(Rectangle bounds) {
		return map.isInTile(bounds);
	}

	public static float getTileSize() {
		return tileSize;
	}

	public static int getWidth() {
		return mapWidth;
	}

}
