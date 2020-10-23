package me.haruhime.modules;

import me.haruhime.events.Event;
import me.haruhime.wrappers.Wrapper;

public class Module {

    public static final Wrapper wrapper = new Wrapper();

    public String name, falseName, desc;
    public boolean toggled, visible;
    public Category category;
    public int keyCode;

    public Module(String name) {
        this.name = name;
        this.falseName = "null";
        this.desc = desc;
        this.toggled = false;
        this.visible = true;
        this.category = Category.MISSINGNO;

    }

    public boolean isEnabled() {
        return toggled;
    }

    public int getKey() {
        return keyCode;
    }

    @SuppressWarnings("rawtypes")
    public void onEvent(Event e) {

    }

    public void toggle() {
        toggled = !toggled;
        if (toggled) {
            onEnable();
        } else {
            onDisable();
        }
    }

    public void onEnable() {

    }

    public void onDisable() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFalseName() {
        return falseName;
    }

    public void setFalseName(String falseName) {
        this.falseName = falseName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isToggled() {
        return toggled;
    }

    public void setToggled(boolean toggled) {
        this.toggled = toggled;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getKeyCode() {
        return keyCode;
    }

    public void setKeyCode(int keyCode) {
        this.keyCode = keyCode;
    }

    public enum Category {
        MOVEMENT, RENDER, MISSINGNO
    }

}
