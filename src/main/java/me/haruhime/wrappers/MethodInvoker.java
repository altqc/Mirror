package me.haruhime.wrappers;

import net.minecraft.entity.Entity;

public class MethodInvoker {

    private final Wrapper wrapper = new Wrapper();

    public void attackEntity(Entity e) {
        wrapper.getPlayerController().attackEntity(wrapper.getPlayer(), e);
    }

    public double getPosX() {
        return wrapper.getPlayer().posX;
    }

    public double getPosY() {
        return wrapper.getPlayer().posY;
    }

    public double getPosZ() {
        return wrapper.getPlayer().posZ;
    }

}
