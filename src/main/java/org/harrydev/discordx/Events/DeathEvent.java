package org.harrydev.discordx.Events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.harrydev.discordx.Bot.bot;
import org.harrydev.discordx.DiscordX;

import java.awt.*;

public class DeathEvent implements Listener {
    private static final DiscordX INSTANCE = DiscordX.getInstance();

    TextChannel textChannel = bot.getBot().getTextChannelById(INSTANCE.getConfig().getLong("chatChannel"));

    @EventHandler
    public void OnPlayerDeath(PlayerDeathEvent event) {
        EmbedBuilder eb = new EmbedBuilder();
        String Avatar = "https://mc-heads.net/avatar/"+event.getEntity().getName();
        eb.setColor(Color.BLACK);
        eb.setAuthor(event.getDeathMessage(), null, Avatar);
        textChannel.sendMessage(eb.build()).queue();
    }
}
