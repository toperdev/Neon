package net.toper.manager;

import java.util.ArrayList;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class SoundManager {

	Music engine;
	ArrayList<Sound> loops = new ArrayList<Sound>();

	public SoundManager() throws SlickException {
		engine = new Music("res/engine.ogg");
	}

}
