package org.harrydev.discordx;

import org.bukkit.plugin.java.JavaPlugin;
import org.harrydev.discordx.Bot.bot;


public final class DiscordX extends JavaPlugin {

    private static DiscordX instance;

    @Override
    public void onEnable() {
        bot.Start();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Goodbye!");
    }

    public void onLoad(){
        instance = this;
    }

    public static DiscordX getInstance() {
        return instance;
    }
}
