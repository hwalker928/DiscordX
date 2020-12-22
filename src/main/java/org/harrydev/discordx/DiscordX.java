package org.harrydev.discordx;

import org.bukkit.plugin.java.JavaPlugin;
import org.harrydev.discordx.Bot.bot;
import org.harrydev.discordx.Events.EventManager;


public final class DiscordX extends JavaPlugin {

    private static DiscordX instance;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        bot.Start();
        EventManager.register();
    }

    @Override
    public void onDisable() {
        bot.SendShutdown();
        getLogger().info("Goodbye!");
    }

    public void onLoad(){
        instance = this;
    }

    public static DiscordX getInstance() {
        return instance;
    }
}
