package org.harrydev.discordx.Utils;

import org.bukkit.Bukkit;
import org.harrydev.discordx.Bot.bot;
import org.harrydev.discordx.DiscordX;

import java.util.Objects;

public class OnlinePlayerCheck implements Runnable{
    public void run() {
        //Objects.requireNonNull(bot.getBot().getVoiceChannelById(DiscordX.getInstance().getConfig().getLong("serverPlayerList"))).getManager().setName("Players Online: " + Bukkit.getServer().getOnlinePlayers().size()).queue();
    }
}
