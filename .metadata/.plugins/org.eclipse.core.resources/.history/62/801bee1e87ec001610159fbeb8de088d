package net.toper;

import net.toper.ent.Entity;
import net.toper.ent.EntityPlayer;
import net.toper.graphics.Background;
import net.toper.graphics.Render;
import net.toper.graphics.gui.GUI;
import net.toper.graphics.gui.GameState;
import net.toper.manager.EntityManager;
import net.toper.manager.MapGen;

public class Game {

	public static EntityManager em = new EntityManager();
	public static EntityPlayer player;
	public static Render r = new Render();
	public static MapGen gen = new MapGen();
	public static Background bg = new Background();

	public Game() {
	}

	public static void hasLost() {
	}

	public static void update() {
		switch (GUI.getState()) {
		case PLAYING:
			em.update();
			gen.map.update();
			break;
		case PAUSE:
			break;
		case LOST:
			break;
		case MAIN:
			break;
		}
	}

	public static void init() {
		GUI.setState(GameState.PLAYING);
		em.init();
		player = new EntityPlayer();
		em.addEntity(player);
		bg.setX(player.getScreenX());
		bg.setY(player.getScreenY() - 350);
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
