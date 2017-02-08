package net.toper;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import net.toper.manager.InputManager;

public class Main extends BasicGame {

	public static InputManager i = new InputManager();
	public static GameContainer gc;
	public static Graphics g;
	public static Input input;

	long lastTime = System.nanoTime();
	final double ticks = 60D;
	double ns = 1000000000 / ticks;
	static float delta = 0;
	private double updates;
	private float fps;
	private static float physicsFPS;

	private static AppGameContainer app;
	private static boolean shouldClose = false;

	public Main() {
		super("lel");
	}

	public static void main(String[] args) {
		try {
			app = new AppGameContainer(new Main());
			app.setDisplayMode(1000, (1000 / 16) * 9, false);
			app.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	public void init(GameContainer container) throws SlickException {
		gc = container;
		i.setInput(gc.getInput());
		input = gc.getInput();
		Game.init();
		delta = 0;
		lastTime = System.nanoTime();
	}

	public void updateLogic() {
		Game.update();
	}

	private void logic() {
		if (shouldClose) {
			closeRequested();
		}
		long now = System.nanoTime();
		delta += (now - lastTime) / ns;
		lastTime = now;
		while (delta >= 1f) {
			updateLogic();
			delta--;
			updates++;
		}
		if (updates >= 60) {
			System.out.println("Game FPS: " + fps + " Physics FPS: " + physicsFPS);
			fps = 0;
			updates = 0;
			physicsFPS = 0;
		}
	}

	public void render(GameContainer gc, Graphics g) throws SlickException {
		logic();
		render();
		fps++;
	}

	private void render() {
		Game.render();
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

	public void update(GameContainer arg0, int arg1) throws SlickException {

	}

	public boolean closeRequested() {
		Game.close();
		gc.exit();
		System.exit(0);
		return true;
	}

	public static void close() {
		shouldClose = true;
	}

	public static void addPhysicsFPS() {
		physicsFPS++;
	}

}