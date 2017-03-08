package net.toper;

import java.util.HashMap;

import org.newdawn.slick.geom.Rectangle;

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
				Tile t = tiles.get(x + y * MapGen.getWidth());
				if (t != null) {
					t.draw();
				}
			}
		}
	}

	public void update() {
		for (Tile t : tiles.values()) {
			t.setOffset(offX, offY);
			if (t.needsUpdate()) {
				t.update();
			}
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

	public int isInTile(Rectangle bounds) {
		int returnInt = 0;
		for (int ya = ((int) (bounds.getY() / MapGen.getTileSize())); ya < ((int) (bounds.getY() + bounds.getHeight())
				/ MapGen.getTileSize()); ya++) {
			for (int xa = ((int) (bounds.getX() / MapGen.getTileSize())); xa < ((int) (bounds.getX()
					+ bounds.getWidth()) / MapGen.getTileSize()); xa++) {
				Tile t = this.tiles.get(xa + ya * MapGen.getWidth());
				if (t != null) {
					if (!t.getCollidable()) {
						returnInt = 2;
					} else {
						Rectangle bounds2 = t.getBounds();
						if (overlaps(bounds, bounds2)) {
							returnInt = 1;
						}
					}
				}
			}
		}
		return returnInt;
	}

	public boolean overlaps(Rectangle r, Rectangle r2) {
		return r.getX() < r2.getX() + r2.getWidth() && r.getX() + r.getWidth() > r2.getX()
				&& r.getY() < r2.getY() + r2.getHeight() && r.getY() + r.getHeight() > r2.getY();
	}

	public boolean isInTile(Rectangle bounds, Rectangle bounds2) {
		int returnInt = 0;
		if (overlaps(bounds, bounds2)) {
			returnInt = 1;
		}
		return returnInt == 1;
	}

}
