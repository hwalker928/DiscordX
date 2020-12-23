package org.harrydev.discordx.Bot.Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;
import org.harrydev.discordx.Bot.bot;

import java.awt.*;

public class WhitelistCommand extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if (e.getMessage().getContentRaw().startsWith(bot.getPrefix() + "whitelist")) {
            String[] username = e.getMessage().getContentRaw().split(" ");
            EmbedBuilder eb = new EmbedBuilder();
            String Avatar = "https://cravatar.eu/avatar/"+username[1]+"/256.png";
            eb.setColor(Color.GREEN);
            eb.setAuthor("Whitelisted " + username[1] + "!", null, Avatar);
            e.getChannel().sendMessage(eb.build()).queue();
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "whitelist " + username[1]);
        }
    }

}
