package org.harrydev.discordlink;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.TextChannel;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.awt.*;

public class CommandToDiscord implements Listener {

    private FileConfiguration config;
    private DiscordLink plugin;

    JDA bot;
    TextChannel textChannel;


    public CommandToDiscord(JDA jda, org.harrydev.discordlink.DiscordLink plugin) {
        this.bot = jda;
        this.plugin = plugin;
        this.config = plugin.getConfig();
        textChannel = jda.getTextChannelById(config.getLong("commandWatcherChannel"));
    }


    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle(e.getPlayer().getName() + " executed " + e.getMessage() + ".");
        embed.setColor(Color.GRAY);
        textChannel.sendMessage(embed.build()).queue();
    }

}
