package org.harrydev.discordx.Events;

import org.bukkit.Bukkit;
import org.harrydev.discordx.Bot.bot;
import org.harrydev.discordx.DiscordX;
import org.harrydev.discordx.Utils.Lag;
import org.harrydev.discordx.Utils.Logger;

public class EventManager {
    public static void register() {
        if(!bot.tokenIsValid){
            return;
        }
        Logger.info("Registering Events...");
        Bukkit.getScheduler().scheduleSyncRepeatingTask(DiscordX.getInstance(), new Lag(), 100L, 1L);
        Bukkit.getPluginManager().registerEvents(new JoinLeaveEvent(bot.getBot()), DiscordX.getInstance());
        Bukkit.getPluginManager().registerEvents(new DeathEvent(bot.getBot()), DiscordX.getInstance());
        Bukkit.getPluginManager().registerEvents(new MessageEvent(bot.getBot()), DiscordX.getInstance());
    }
}
