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
	public static ManagerProjectile proj = new ManagerProjectile();

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
			proj.update();
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
			player = new EntityPlayer();
			gen.gen();
			em.init();
			player.init(MapGen.getPlayerSpawnX() * MapGen.getTileSize(), MapGen.getPlayerSpawnY()* MapGen.getTileSize());
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
			fx.draw(0);
			gen.map.draw();
			proj.draw();
			em.draw();
			fx.draw(1);
			break;
		default:
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

	private static void stopGame() {
		em.clear();
		fx.clear();
		proj.clear();
		try {
			p.stop();
			physicsThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void reset() {
		hasGameStarted = false;
		stopGame();
		initGame();
		GUI.setState(GameState.PLAYING);
	}

}
