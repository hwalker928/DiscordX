package org.harrydev.discordlink;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

import java.awt.*;
import java.util.Objects;

public class DiscordToMC extends ListenerAdapter {

    private FileConfiguration config;
    private DiscordLink plugin;


    public DiscordToMC(DiscordLink plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        boolean isBot = e.getAuthor().isBot();
        if(!(isBot)) {
            if (e.getChannel().getId().equals(config.getString("chatChannel"))) {
                if(!(e.getMessage().getContentStripped().equals(""))) {
                    Bukkit.broadcastMessage(Objects.requireNonNull(config.getString("discordToMinecraft")).replace("%player%", e.getAuthor().getName()).replace("%message%", e.getMessage().getContentStripped()));
                }
            }
        }
    }
    
}
