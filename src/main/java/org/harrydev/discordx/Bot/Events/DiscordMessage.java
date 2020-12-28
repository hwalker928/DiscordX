package org.harrydev.discordx.Bot.Events;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.harrydev.discordx.Bot.bot;
import org.harrydev.discordx.DiscordX;

import java.util.Objects;

public class DiscordMessage extends ListenerAdapter {

    private static final DiscordX INSTANCE = DiscordX.getInstance();
    private static final FileConfiguration config = INSTANCE.getConfig();

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        boolean isBot = event.getAuthor().isBot();
        if(!(isBot)) {
            if(event.getChannel().getIdLong() == (config.getLong("chatChannel"))){
                if(!event.getMessage().getContentRaw().isEmpty()){
                    if(event.getMessage().getContentRaw().startsWith(bot.getPrefix()))
                        return;
                    Bukkit.broadcastMessage(Objects.requireNonNull(config.getString("discordToMinecraft")).replace("%player%", event.getAuthor().getName()).replace("%message%", event.getMessage().getContentStripped()).replace("%prefix%", config.getString("prefix")).replace("&", "§"));
                }
            }
        }
    }
}
