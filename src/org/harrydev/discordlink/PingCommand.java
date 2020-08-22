package org.harrydev.discordlink;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.configuration.file.FileConfiguration;

import java.awt.*;

public class PingCommand extends ListenerAdapter {

    private FileConfiguration config;
    private DiscordLink plugin;


    public PingCommand(DiscordLink plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if (e.getMessage().getContentRaw().equals(config.getString("botPrefix") + "ping")) {
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle("Ping: " + e.getJDA().getGatewayPing() + "ms");
            embed.setColor(Color.GRAY);
            e.getChannel().sendMessage(embed.build()).queue();

        }
    }

}
