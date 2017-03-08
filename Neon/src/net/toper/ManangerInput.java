package net.toper;

import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;

public class ManangerInput implements MouseListener {

	private float mouseWheel;

	public void inputEnded() {

	}

	public void inputStarted() {

	}

	public boolean isAcceptingInput() {
		return false;
	}

	public void setInput(Input arg0) {

	}

	public void mouseClicked(int arg0, int arg1, int arg2, int arg3) {

	}

	public void mouseDragged(int arg0, int arg1, int arg2, int arg3) {

	}

	public void mouseMoved(int arg0, int arg1, int arg2, int arg3) {

	}

	public void mousePressed(int arg0, int arg1, int arg2) {

	}

	public void mouseReleased(int arg0, int arg1, int arg2) {

	}

	public void mouseWheelMoved(int arg0) {
		mouseWheel = arg0;
	}

	public float getMouseWheel() {
		return mouseWheel;
	}

}
