package net.toper;

import java.util.HashMap;

public class Map {

	private float offX, offY;
	public HashMap<Integer, Tile> tiles = new HashMap<Integer, Tile>();

	public void addTile(float x, float y, Tile t) {
		tiles.put((int) (x + y * MapGen.getWidth()), t);
	}

	public void draw() {
		for (int y = (int) (-offY / MapGen.getTileSize()); y < (-offY + Main.getWidth()) / MapGen.getTileSize(); y++) {
			for (int x = (int) (-offX / MapGen.getTileSize()); x < (-offX + Main.getWidth())
					/ MapGen.getTileSize(); x++) {
				Tile t = tiles.get((x * MapGen.getTileSize()) + (y * MapGen.getTileSize()) * MapGen.getWidth());
				if (t != null) {
					t.draw();
				}
			}
		}
	}

	public void update() {
		for (Tile t : tiles.values()) {
			t.setOffset(offX, offY);
			t.update();
		}
	}

	public void offset(float x, float y) {
		offX = x;
		offY = y;
	}

	public float getOffsetX() {
		return offX;
	}

	public float getOffsetY() {
		return offY;
	}

}
