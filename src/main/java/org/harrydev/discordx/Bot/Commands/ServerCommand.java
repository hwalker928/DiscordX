package org.harrydev.discordx.Bot.Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class ServerCommand extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if (e.getMessage().getContentRaw().equals("!server")) {
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle("Server info").setColor(Color.GREEN);
            embed.addField("Server IP:", "needstobecod.ed", true);
            embed.addField("Server TPS:", "needstobecod.ed", true);
            embed.setThumbnail("https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/120/emojidex/112/file-cabinet_1f5c4.png");
            e.getChannel().sendMessage(embed.build()).queue();
        }
    }

}
