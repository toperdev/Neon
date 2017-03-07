package net.toper.graphics;

import org.newdawn.slick.Color;

import net.toper.Game;
import net.toper.Main;
import net.toper.ent.EffectStar;
import net.toper.manager.MapGen;

public class Background {

	private float offX;
	private float offY;
	private int maxDepth = 10;
	private int numStars = 1000;

	public Background() {
		for (int i = 0; i < numStars; i++) {
			int x = Game.rand.nextInt(MapGen.getWidth());
			int y = Game.rand.nextInt(MapGen.getWidth());
			int z = Game.rand.nextInt(maxDepth) + 1;
			Game.fx.addEffect(new EffectStar(x, y, -z));
		}
	}

	public void offset(float x, float y) {
		this.offX = x;
		this.offY = y;
	}

	public void draw() {
		Main.g.setBackground(new Color(0xff001025));
		/*
		 * bg.draw(0, 0, Main.getWidth(), Main.getHeight(), -x - offX, -y -
		 * offY, -x - offX + Main.getWidth(), -y - offY + Main.getHeight());
		 */
	}

	public float getOffX() {
		return offX;
	}

	public float getOffY() {
		return offY;
	}

}
