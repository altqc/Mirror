package me.haruhime.modules.other;

import me.haruhime.Mirror;
import me.haruhime.modules.Module;
import org.lwjgl.input.Keyboard;

public class SelfDestruct extends Module {

    public SelfDestruct() {
        super("Self Destruct");
        this.setCategory(Category.OTHER);
        this.setKeyCode(Keyboard.KEY_DELETE);
        this.setDesc("Bye Moms Client");
    }

    @Override
    public void onEnable() {
        super.onEnable();
        Mirror.setDestucted(true);
    }
}
