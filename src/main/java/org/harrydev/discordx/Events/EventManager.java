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
        Bukkit.getPluginManager().registerEvents(new JoinLeaveEvent(), DiscordX.getInstance());
        Bukkit.getPluginManager().registerEvents(new DeathEvent(), DiscordX.getInstance());
        Bukkit.getPluginManager().registerEvents(new MessageEvent(), DiscordX.getInstance());
        try {
            Class<?> achievementAwardedEventClass = Class.forName("org.bukkit.event.player.PlayerAchievementAwardedEvent");
            if(achievementAwardedEventClass.isAnnotationPresent(Deprecated.class)) return;
            Logger.error("§4§l====================================");
            Logger.error("");
            Logger.error("§4§lYou are using a unsupported version");
            Logger.error("§4§lAchievement events will not work and have been disabled");
            Logger.error("§4§lEverything should work as normal.");
            Logger.error("");
            Logger.error("§4l====================================");

        } catch (ClassNotFoundException e) {
            Bukkit.getPluginManager().registerEvents(new AdvancementEvent(bot.getBot()), DiscordX.getInstance());
        }
    }
}
