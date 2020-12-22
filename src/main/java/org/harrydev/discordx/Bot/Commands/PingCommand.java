package org.harrydev.discordx.Bot.Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class PingCommand extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if (e.getMessage().getContentRaw().equals("!ping")) {
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle("Ping: " + e.getJDA().getGatewayPing() + "ms").setColor(Color.GRAY);
            e.getChannel().sendMessage(embed.build()).queue();
        }
    }

}
