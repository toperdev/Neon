package net.toper;

import java.util.ArrayList;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class ManangerSound {

	Music engine;
	ArrayList<Sound> loops = new ArrayList<Sound>();

	public ManangerSound() throws SlickException {
		engine = new Music("res/engine.ogg");
	}

}
