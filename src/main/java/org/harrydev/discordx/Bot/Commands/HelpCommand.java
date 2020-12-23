package org.harrydev.discordx.Bot.Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;
import org.harrydev.discordx.Bot.bot;
import org.harrydev.discordx.Utils.Lag;

import java.awt.*;

public class HelpCommand extends ListenerAdapter {
    private static String commands = "";
    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if (e.getMessage().getContentRaw().equals(bot.getPrefix() + "help")) {
            bot.getListeners().forEach(listener -> {
                commands += "`" + listener.getClass().getSimpleName().replaceAll("Command", "") + "`\n";
            });
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle("About DiscordX").setColor(Color.ORANGE);
            embed.setDescription("DiscordX is a Spigot plugin that connects Discord to Minecraft.");
            embed.addField("__Commands:__", commands, false);
            embed.addField("__Spigot resource:__", "https://example.com", false);
            embed.addField("__Github repo:__", "https://github.com/hwalker928/DiscordX", false);
            e.getChannel().sendMessage(embed.build()).queue();
        }
    }

}
