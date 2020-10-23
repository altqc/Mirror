package me.haruhime.utils;

import me.haruhime.wrappers.Wrapper;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;

public class RenderUtils {

    final static Wrapper wrapper = new Wrapper();
    final static FontRenderer mcfr = wrapper.getFontRenderer();
    final static ScaledResolution sr = new ScaledResolution(wrapper.getMinecraft());


}
