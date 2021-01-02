package org.harrydev.discordx.Events;


import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.harrydev.discordx.Bot.bot;
import org.harrydev.discordx.DiscordX;

import java.awt.*;

public class JoinLeaveEvent implements Listener {
    private static final DiscordX INSTANCE = DiscordX.getInstance();

    TextChannel textChannel = bot.getBot().getTextChannelById(INSTANCE.getConfig().getLong("chatChannel"));

    @EventHandler
    public void OnPlayerJoin(PlayerJoinEvent event) {
        String Avatar = "https://cravatar.eu/helmavatar/" + event.getPlayer().getName() + "/256.png";
        EmbedBuilder eb = new EmbedBuilder().setColor(Color.GREEN).setAuthor(event.getPlayer().getName() + " joined the server", null, Avatar);
        textChannel.sendMessage(eb.build()).queue();
    }

    @EventHandler
    public void OnPlayerLeave(PlayerQuitEvent event) {
        String Avatar = "https://cravatar.eu/helmavatar/" + event.getPlayer().getName() + "/256.png";
        EmbedBuilder eb = new EmbedBuilder().setColor(Color.RED).setAuthor(event.getPlayer().getName() + " left the server", null, Avatar);
        textChannel.sendMessage(eb.build()).queue();
    }
}
