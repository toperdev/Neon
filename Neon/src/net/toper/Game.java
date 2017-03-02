package net.toper;

import net.toper.ent.Entity;
import net.toper.ent.EntityPlayer;
import net.toper.graphics.Background;
import net.toper.graphics.Render;
import net.toper.graphics.gui.GUI;
import net.toper.graphics.gui.GameState;
import net.toper.manager.EntityManager;
import net.toper.manager.MapGen;
import net.toper.physics.Physics;

public class Game {

	public static EntityManager em = new EntityManager();
	public static EntityPlayer player;
	public static Render r = new Render();
	public static MapGen gen = new MapGen();
	public static Background bg = new Background();

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
			bg.setX(-300f);
			bg.setY(-800f);
			physicsThread = new Thread(p);
			physicsThread.start();
			hasGameStarted = true;
		}
	}

	public static void render() {
		switch (GUI.getState()) {
		case PLAYING:
			bg.draw();
			gen.map.draw();
			em.draw();
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
