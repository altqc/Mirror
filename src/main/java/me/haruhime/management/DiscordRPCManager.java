package me.haruhime.management;

import me.haruhime.Mirror;
import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;
import net.minecraft.client.Minecraft;

public class DiscordRPCManager {

    final static Minecraft mc = Minecraft.getMinecraft();

    public static void drpcInit() {
        DiscordEventHandlers handlers = new DiscordEventHandlers.Builder().build();
        DiscordRPC.discordInitialize(Mirror.getDiscordAppID(), handlers, true);
    }

    public static void clientPresClient() {
        DiscordRichPresence rich = new DiscordRichPresence.Builder("Mirror Client Base").setBigImage("harusad", "Created by Haruhime").build();
        DiscordRPC.discordUpdatePresence(rich);
    }

    public static void clientPresMultiPlayer() {
        DiscordRichPresence rich = new DiscordRichPresence.Builder(mc.getCurrentServerData().serverIP).setDetails("Currently Playing On:").setBigImage("harusad", "Created by Haruhime").build();
        DiscordRPC.discordUpdatePresence(rich);
    }

    public static void clientPresSinglePlayer() {
        DiscordRichPresence rich = new DiscordRichPresence.Builder("Single Player").setDetails("Currently Playing:").setBigImage("harusad", "Created by Haruhime").build();
        DiscordRPC.discordUpdatePresence(rich);
    }

    public static void clientInMenus() {
        DiscordRichPresence rich = new DiscordRichPresence.Builder("Currently in the Menus").setBigImage("harusad", "Created by Haruhime").build();
        DiscordRPC.discordUpdatePresence(rich);
    }

}
