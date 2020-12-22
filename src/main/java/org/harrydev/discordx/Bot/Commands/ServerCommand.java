package org.harrydev.discordx.Bot.Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;
import org.harrydev.discordx.Utils.Lag;

import java.awt.*;

public class ServerCommand extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if (e.getMessage().getContentRaw().equals("!server")) {
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle("Server info").setColor(Color.GREEN);
            embed.addField("Server IP:", Bukkit.getServer().getIp(), true);
            embed.addField("Server TPS:", String.valueOf(Math.round(Lag.getTPS())), true);
            e.getChannel().sendMessage(embed.build()).queue();
        }
    }

}
