package me.haruhime.modules.render;

import me.haruhime.modules.Module;
import org.lwjgl.input.Keyboard;

public class Fullbright extends Module {

    private float lastgamma;

    public Fullbright() {
        super("Fullbright");
        this.setCategory(Category.RENDER);
        this.setKeyCode(Keyboard.KEY_J);
    }

    @Override
    public void onEnable() {
        super.onEnable();
        this.lastgamma = wrapper.getGameSettings().gammaSetting;
        wrapper.getGameSettings().gammaSetting = 1000;
    }

    @Override
    public void onDisable() {
        super.onDisable();
        wrapper.getGameSettings().gammaSetting = this.lastgamma;
    }
}
