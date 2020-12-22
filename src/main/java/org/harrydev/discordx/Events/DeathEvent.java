package org.harrydev.discordx.Events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.TextChannel;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.harrydev.discordx.DiscordX;

import java.awt.Color;

public class DeathEvent implements Listener {
    private static final DiscordX INSTANCE = DiscordX.getInstance();

    FileConfiguration config;
    JDA bot;
    TextChannel textChannel;

    public DeathEvent(JDA jda) {
        this.bot = jda;
        this.config = INSTANCE.getConfig();
        textChannel = jda.getTextChannelById(INSTANCE.getConfig().getLong("chatChannel"));
    }

    @EventHandler
    public void OnPlayerDeath(PlayerDeathEvent event) {
        EmbedBuilder eb = new EmbedBuilder();
        String Avatar = "https://mc-heads.net/avatar/"+event.getEntity().getName();
        eb.setColor(Color.BLACK);
        eb.setAuthor(event.getDeathMessage(), Avatar, Avatar);
        textChannel.sendMessage(eb.build()).queue();
    }
}
