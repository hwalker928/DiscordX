package org.harrydev.discordx.Events;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.TextChannel;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.harrydev.discordx.Bot.webhook;
import org.harrydev.discordx.DiscordX;
import org.harrydev.discordx.Utils.MoreUtils;

import java.awt.*;
import java.util.Objects;

public class MessageEvent implements Listener {
    @EventHandler
    public void OnPlayerMessage(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String Avatar = "https://cravatar.eu/helmavatar/"+event.getPlayer().getName()+"/256.png";
        String message = event.getMessage();
        webhook.sendMessage(player.getName(), Avatar, message);
    }
}
