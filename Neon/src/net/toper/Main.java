package net.toper;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Main extends BasicGame {

	public static ManangerInput i = new ManangerInput();
	public static GameContainer gc;
	public static Graphics g;
	public static Input input;

	private long lastTime = System.nanoTime();
	private final double ticks = 60D;
	private double ns = 1000000000 / ticks;
	private static float delta = 0;

	private final static int width = 1000;

	private double updates;
	private static float fps;
	private static float physicsFPS;
	private static float showFPS;
	private static float showPhysFPS;

	private static AppGameContainer app;
	private static boolean shouldClose = false;

	public Main() {
		super("lel");
	}

	public static void main(String[] args) {
		try {
			app = new AppGameContainer(new Main());
			app.setDisplayMode(width, (width / 16) * 9, false);
			app.setShowFPS(false);
			app.setAlwaysRender(true);
			app.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	public void init(GameContainer container) throws SlickException {
		gc = container;
		container.setAlwaysRender(true);
		g = gc.getGraphics();
		i.setInput(gc.getInput());
		input = gc.getInput();
		delta = 0;
		Game.init();
		lastTime = System.nanoTime();
	}

	public void updateLogic() {
		Game.update();
	}

	private void logic() {
		if (shouldClose) {
			closeRequested();
		} else {
			calculateDelta();
			while (delta >= 1f) {
				updateLogic();
				delta--;
				updates++;
			}
			if (updates >= 60) {
				showFPS = fps;
				showPhysFPS = physicsFPS;
				fps = 0;
				updates = 0;
				physicsFPS = 0;
			}
		}
	}

	private void calculateDelta() {
		long now = System.nanoTime();
		delta += (now - lastTime) / ns;
		lastTime = now;
	}

	public void render(GameContainer gc, Graphics g) throws SlickException {
		logic();
		render();
	}

	private void render() {
		Game.render();
		fps++;
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

	public static int getPhysicsFPS() {
		return (int) showPhysFPS;
	}

	public static int getFPS() {
		return (int) showFPS;
	}

}