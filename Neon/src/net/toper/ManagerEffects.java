package net.toper;

import java.util.HashMap;

public class ManagerEffects {

	HashMap<Float, Effect> front = new HashMap<Float, Effect>();
	HashMap<Float, Effect> back = new HashMap<Float, Effect>();

	public void addEffect(Effect effect) {
		float pos = effect.getX() + effect.getY() * MapGen.getWidth();
		if (effect.getZ() >= 0)
			front.put(pos, effect);
		else
			back.put(pos, effect);
	}

	public void update() {
		float delta = Main.getDelta();
		for (Float e : front.keySet()) {
			front.get(e).setDelta(delta);
			front.get(e).update();
		}
		for (Float e : back.keySet()) {
			back.get(e).setDelta(delta);
			back.get(e).update();
		}
	}

	public void render(int call) {
		if (call == 1)
			for (Float e : front.keySet()) {
				Effect fx = front.get(e);
				if (fx.getFinalX() < Main.getWidth() + Game.bg.getOffX() && fx.getFinalX() > Game.bg.getOffX()) {
					fx.draw();
				}
			}
		else
			for (Float e : back.keySet()) {
				Effect fx = back.get(e);
				if (fx.getFinalX() < Main.getWidth() && fx.getFinalX() >= 0) {
					fx.draw();
				}
			}
	}

}
