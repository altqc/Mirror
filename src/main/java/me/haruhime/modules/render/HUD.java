package me.haruhime.modules.render;

import me.haruhime.Mirror;
import me.haruhime.management.ModuleManager;
import me.haruhime.modules.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.input.Keyboard;

import java.util.Collections;
import java.util.Comparator;

public class HUD extends Module {

    public static boolean drawingHUD = false;
    private final Minecraft mc = Minecraft.getMinecraft();

    public HUD() {
        super("HUD");
        this.setKeyCode(Keyboard.KEY_O);
        this.setCategory(Category.RENDER);
        this.setVisible(false);
    }

    public static void draw() {
        ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
        FontRenderer fr = Minecraft.getMinecraft().fontRendererObj;

        Collections.sort(ModuleManager.modules, new ModuleComparator());

        GlStateManager.translate(4, 4, 0);
        GlStateManager.scale(2, 2, 0);
        GlStateManager.translate(-4, -4, 0);
        fr.drawString(Mirror.getClientName(), 4, 4, -1);
        GlStateManager.translate(4, 4, 0);
        GlStateManager.scale(0.5, 0.5, 1);
        GlStateManager.translate(-4, -4, 0);

        int count = 0;
        String displayName;

        for (Module m : ModuleManager.modules) {
            if (!m.toggled)
                continue;
            if (!m.visible)
                continue;

            if (m.falseName.equals("null")) {
                displayName = m.name;
            } else {
                displayName = m.falseName;
            }

            double d = count * (fr.FONT_HEIGHT + 4);
            int offset0 = (int) d;

            fr.drawString(displayName, sr.getScaledWidth() - fr.getStringWidth(displayName) - 4, 4 + offset0, -1);

            count++;
        }

    }

    @Override
    public void onEnable() {
        drawingHUD = true;
    }

    @Override
    public void onDisable() {
        drawingHUD = false;
    }

    public static class ModuleComparator implements Comparator<Module> {

        @Override
        public int compare(Module arg0, Module arg1) {
            Minecraft mc = Minecraft.getMinecraft();
            String toCompare;
            String toCompare1;

            if (arg0.falseName.equals("null")) {
                toCompare = arg0.name;
            } else {
                toCompare = arg0.falseName;
            }

            if (arg1.falseName.equals("null")) {
                toCompare1 = arg1.name;
            } else {
                toCompare1 = arg1.falseName;
            }

            if (mc.fontRendererObj.getStringWidth(toCompare) > mc.fontRendererObj.getStringWidth(toCompare1)) {
                return -1;
            }
            if (mc.fontRendererObj.getStringWidth(toCompare) < mc.fontRendererObj.getStringWidth(toCompare1)) {
                return 1;
            }
            return 0;
        }
    }

}
