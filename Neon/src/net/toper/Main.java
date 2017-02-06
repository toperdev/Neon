package net.toper;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import net.toper.graphics.Background;
import net.toper.manager.InputManager;

public class Main extends BasicGame {

	public static InputManager i = new InputManager();
	public static GameContainer gc;
	public static Input input;

	long lastTime = System.nanoTime();
	final double ticks = 60D;
	double ns = 1000000000 / ticks;
	static float delta = 0;
	private double updates;

	public Main() {
		super("lel");
	}

	public static void main(String[] args) {
		try {
			AppGameContainer app = new AppGameContainer(new Main());
			app.setDisplayMode(1000, (1000 / 16) * 9, false);
			app.setUpdateOnlyWhenVisible(false);
			// app.setTargetFrameRate(120);
			app.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	public void init(GameContainer container) throws SlickException {
		gc = container;
		Game.init();
		new Background();
		i.setInput(gc.getInput());
		input = gc.getInput();
		delta = 0;
		lastTime = System.nanoTime();
	}

	public void updateLogic() {
		Game.update();
	}

	private void tick() {
		long now = System.nanoTime();
		delta += (now - lastTime) / ns;
		lastTime = now;
		if (delta >= 1f) {
			updateLogic();
			delta--;
			updates++;
		}
		if (updates >= 60) {
			updates = 0;
		}
	}

	public void render(GameContainer gc, Graphics g) throws SlickException {
		g.setAntiAlias(true);
		Game.render();
		tick();
	}

	public static float getDelta() {
		return delta;
	}

	public static float getWidth() {
		return gc.getWidth();
	}

	public static float getHeight() {
		return gc.getHeight();
	}

	public void update(GameContainer gc, int arg1) throws SlickException {

	}
}