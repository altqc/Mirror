package me.haruhime;

import me.haruhime.events.EventType;
import me.haruhime.events.listeners.EventUpdate;
import me.haruhime.management.DiscordRPCManager;
import me.haruhime.management.ModuleManager;
import me.haruhime.modules.render.HUD;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

@Mod(name = Mirror.NAME, modid = Mirror.MODID, version = Mirror.VERSION)
public class Mirror {
    public static final String NAME = "Mirror Client Base", MODID = "mirror", VERSION = "1.0";
    private static final Boolean discordRPCOnStartup = true, discordRPCEnabled = true;
    private static String clientName = "Mirror", clientVersion = "b1", clientAuthor = "iTrqPss", discordAppID = "500703204137500715";
    double c = 0;

    public static String getClientName() {
        return clientName;
    }

    public static void setClientName(String str) {
        Mirror.clientName = str;
    }

    public static String getClientVersion() {
        return clientVersion;
    }

    public static void setClientVersion(String str) {
        Mirror.clientVersion = str;
    }

    public static String getClientAuthor() {
        return clientAuthor;
    }

    public static void setClientAuthor(String str) {
        Mirror.clientAuthor = str;
    }

    public static String getDiscordAppID() {
        return discordAppID;
    }

    public static void setDiscordAppID(String str) {
        Mirror.discordAppID = discordAppID;
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        System.out.println(Mirror.getClientName() + " | " + Mirror.getClientVersion() + " Started");
        MinecraftForge.EVENT_BUS.register(this);
        ModuleManager.initModules();


        if (discordRPCOnStartup && discordRPCEnabled)
            DiscordRPCManager.drpcInit();
        DiscordRPCManager.clientPresClient();
    }

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        int k = Keyboard.getEventKey() == 0 ? Keyboard.getEventCharacter() + 256 : Keyboard.getEventKey();
        if (c % 2 == 0) {
            ModuleManager.keyPress(k);
            c++;
        } else {
            c++;
        }
    }

    @SubscribeEvent
    public void onRenderTick(TickEvent.RenderTickEvent event) {
        if (HUD.drawingHUD) {
            HUD.draw();
        }
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        EventUpdate e = new EventUpdate();
        e.setType(EventType.PRE);
        ModuleManager.onEvent(e);
    }

    @SubscribeEvent
    public void onPlayerJoinWorld(EntityJoinWorldEvent event) {
        if (event.entity instanceof EntityPlayer && !event.entity.worldObj.isRemote) {
            if (discordRPCEnabled) {
                if (Minecraft.getMinecraft().isSingleplayer())
                    DiscordRPCManager.clientPresSinglePlayer();
                else
                    DiscordRPCManager.clientPresMultiPlayer();
            }
        }
    }

    @SubscribeEvent
    public void onMainMenuOpen(GuiScreenEvent.InitGuiEvent event) {
        if (Minecraft.getMinecraft().currentScreen instanceof GuiMainMenu) {
            if (discordRPCEnabled)
                DiscordRPCManager.clientInMenus();
        }
    }

}