package net.toper;

import java.util.Random;

public class Game {

	public static ManagerEntity em = new ManagerEntity();
	public static EntityPlayer player;
	public static Render r = new Render();
	public static MapGen gen = new MapGen();
	public static Background bg;
	public static Random rand = new Random();
	public static ManagerEffects fx = new ManagerEffects();

	public static Physics p;
	private static Thread physicsThread;

	private static boolean hasGameStarted = false;

	public Game() {
	}

	public static void hasLost() {
	}

	public static void update() {
		GUI.update();
		switch (GUI.getState()) {
		case PLAYING:
			initGame();
			em.update();
			fx.update();
			gen.map.update();
			break;
		default:
			break;
		}
	}

	public static void init() {
		GUI.setState(GameState.MAIN);
	}

	public static void close() {
		if (hasGameStarted) {
			p.stop();
			try {
				physicsThread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private static void initGame() {
		if (!hasGameStarted) {
			p = new Physics();
			player = new EntityPlayer(MapGen.getPlayerSpawnX(), MapGen.getPlayerSpawnY());
			gen.gen();
			em.init();
			em.addEntity(player);
			bg = new Background();
			physicsThread = new Thread(p);
			physicsThread.start();
			hasGameStarted = true;
		}
	}

	public static void render() {
		switch (GUI.getState()) {
		case PLAYING:
			bg.draw();
			fx.render(0);
			gen.map.draw();
			em.draw();
			fx.render(1);
			break;
		case PAUSE:
			break;
		case LOST:
			break;
		case MAIN:
			break;
		}
		GUI.renderCurrent();
	}

	public static void addEntity(Entity entity) {
		em.addEntity(entity);
	}

	public static int getScore() {
		return em.getScore();
	}

}
