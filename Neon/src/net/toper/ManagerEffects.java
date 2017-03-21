package net.toper;

import java.util.HashMap;

public class ManagerEffects {

	HashMap<Integer, Effect> front = new HashMap<Integer, Effect>();
	HashMap<Integer, Effect> back = new HashMap<Integer, Effect>();

	public void addEffect(Effect effect) {
		if (effect.getZ() >= 0)
			front.put(front.size(), effect);
		else
			back.put(back.size(), effect);
	}

	public void update() {
		float delta = Main.getDelta();
		for (Integer e : front.keySet()) {
			front.get(e).setDelta(delta);
			front.get(e).update();
		}
		for (Integer e : back.keySet()) {
			back.get(e).setDelta(delta);
			back.get(e).update();
		}
	}

	public void draw(int call) {
		if (call == 1)
			for (Integer e : front.keySet()) {
				Effect fx = front.get(e);
				if (fx.getFinalX() < Main.getWidth() + Game.bg.getOffX() && fx.getFinalX() > Game.bg.getOffX()) {
					fx.draw();
				}
			}
		else
			for (Integer e : back.keySet()) {
				Effect fx = back.get(e);
				if (fx.getFinalX() < Main.getWidth() && fx.getFinalX() >= 0) {
					fx.draw();
				}
			}
	}

	public void clear() {
		front.clear();
		back.clear();
	}

}
