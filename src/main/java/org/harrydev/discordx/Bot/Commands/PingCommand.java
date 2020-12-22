package org.harrydev.discordx.Bot.Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.harrydev.discordx.Bot.bot;

import java.awt.*;

public class PingCommand extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if (e.getMessage().getContentRaw().equals(bot.getPrefix() + "ping")) {
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle("Ping: " + e.getJDA().getGatewayPing() + "ms").setColor(Color.ORANGE);
            embed.setThumbnail("https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/120/facebook/230/table-tennis-paddle-and-ball_1f3d3.png");
            e.getChannel().sendMessage(embed.build()).queue();
        }
    }

}
