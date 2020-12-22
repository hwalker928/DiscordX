package org.harrydev.discordx.Events;

import org.bukkit.Bukkit;
import org.harrydev.discordx.Bot.bot;
import org.harrydev.discordx.DiscordX;
import org.harrydev.discordx.Utils.Logger;

public class EventManager {
    public static void register() {
        Logger.info("Registering Events...");
        Bukkit.getPluginManager().registerEvents(new JoinLeaveEvent(bot.getBot()), DiscordX.getInstance());
        Bukkit.getPluginManager().registerEvents(new DeathEvent(bot.getBot()), DiscordX.getInstance());
        Bukkit.getPluginManager().registerEvents(new MessageEvent(bot.getBot()), DiscordX.getInstance());
    }
}
