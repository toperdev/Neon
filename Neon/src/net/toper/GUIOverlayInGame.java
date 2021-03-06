package net.toper;

public class GUIOverlayInGame extends GUI {

	private int fps;
	private int physFps;
	private GUIElementHealthBar bar = new GUIElementHealthBar(10, 50, 200f);

	public GUIOverlayInGame() {
		fps = addElement(new GUIElementText(10, 15, "FPS: ", 15));
		physFps = addElement(new GUIElementText(10, 30, "Physics FPS: ", 15));
	}

	public void updateMenu() {
		((GUIElementText) getElement(fps)).append(Main.getFPS() + "");
		((GUIElementText) getElement(physFps)).append(Main.getPhysicsFPS() + "");
	}

	public void addUpgradeInfo(Upgrade upgrade) {
		bar.setInfoParent(upgrade);
		addElement(bar);
	}

}
