package me.haruhime.utils;

import me.haruhime.wrappers.Wrapper;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.util.BlockPos;

public class GhostUtils {

    private final Wrapper wrapper = new Wrapper();
    private final Minecraft mc = wrapper.getMinecraft();

    private int leftClickCounter;

    public void clickMouse() {
        if (leftClickCounter <= 0) {
            mc.thePlayer.swingItem();

            if (mc.objectMouseOver == null) {

                if (mc.playerController.isNotCreative()) {
                    leftClickCounter = 10;
                }
            } else {
                switch (mc.objectMouseOver.typeOfHit) {
                    case ENTITY:
                        mc.playerController.attackEntity(mc.thePlayer, mc.objectMouseOver.entityHit);
                        break;

                    case BLOCK:
                        BlockPos blockpos = mc.objectMouseOver.getBlockPos();

                        if (mc.theWorld.getBlockState(blockpos).getBlock().getMaterial() != Material.air) {
                            mc.playerController.clickBlock(blockpos, mc.objectMouseOver.sideHit);
                            break;
                        }

                    case MISS:
                    default:
                        if (mc.playerController.isNotCreative()) {
                            leftClickCounter = 10;
                        }
                }
            }
        }
    }

}
