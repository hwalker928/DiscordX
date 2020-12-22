package org.harrydev.discordx.Bot.Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;
import org.harrydev.discordx.Bot.bot;
import org.harrydev.discordx.DiscordX;
import org.harrydev.discordx.Utils.Lag;

import java.awt.*;

public class ServerCommand extends ListenerAdapter {
    private static final DiscordX INSTANCE = DiscordX.getInstance();

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if (e.getMessage().getContentRaw().equals(bot.getPrefix() + "server")) {
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle("Server info").setColor(Color.GREEN);
            embed.addField("Server IP:", INSTANCE.getConfig().getString("serverIP"), true);
            embed.setThumbnail("https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/120/emojidex/112/file-cabinet_1f5c4.png");
            embed.addField("Server TPS:", String.valueOf(Math.round(Lag.getTPS())), true);
            e.getChannel().sendMessage(embed.build()).queue();
        }
    }

}
