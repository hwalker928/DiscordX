package org.harrydev.discordx.Events;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.TextChannel;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.harrydev.discordx.DiscordX;
import org.harrydev.discordx.Utils.MoreUtils;

import java.awt.*;
import java.util.Objects;

public class MessageEvent implements Listener {
    private static final DiscordX INSTANCE = DiscordX.getInstance();

    FileConfiguration config;
    JDA bot;
    TextChannel textChannel;
    String noPing = INSTANCE.getConfig().getString("nopingmsg").replace("&", "§").replace("%prefix%", config.getString("prefix"));
        //String noPing = ChatColor.AQUA+"Please do not ping people from the game!";

    public MessageEvent(JDA jda) {
        this.bot = jda;
        this.config = INSTANCE.getConfig();
        textChannel = jda.getTextChannelById(INSTANCE.getConfig().getLong("chatChannel"));
    }

    @EventHandler
    public void OnPlayerMessage(AsyncPlayerChatEvent event) {
        if (!(MoreUtils.testForPing(event.getMessage()))) {
            textChannel.sendMessage(Objects.requireNonNull(config.getString("minecraftToDiscord")).replace("%player%", event.getPlayer().getName()).replace("%message%", event.getMessage()).replace("%prefix%", config.getString("prefix"))).queue();
        }
        else{
            event.getPlayer().sendMessage(noPing);
        }
    }
}
