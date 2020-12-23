package org.harrydev.discordx.Bot.Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.harrydev.discordx.Bot.bot;

import java.awt.*;

public class ListCommand extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if (e.getMessage().getContentRaw().equals(bot.getPrefix() + "list")) {
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle("There are " + Bukkit.getOnlinePlayers().size() + " players currently online!").setColor(Color.GREEN);
            embed.setThumbnail("https://i.pinimg.com/originals/85/78/bf/8578bfd439ef6ee41e103ae82b561986.png");
            e.getChannel().sendMessage(embed.build()).queue();
        }
    }
    // hello
}
