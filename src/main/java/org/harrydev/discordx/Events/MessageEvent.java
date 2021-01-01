package org.harrydev.discordx.Events;

import net.dv8tion.jda.api.entities.TextChannel;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.harrydev.discordx.Bot.bot;
import org.harrydev.discordx.DiscordX;

import java.util.Objects;

public class MessageEvent implements Listener {
    private static final DiscordX INSTANCE = DiscordX.getInstance();

    TextChannel textChannel = bot.getBot().getTextChannelById(INSTANCE.getConfig().getLong("chatChannel"));
    FileConfiguration config = INSTANCE.getConfig();

    @EventHandler
    public void OnPlayerMessage(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String Avatar = "https://cravatar.eu/helmavatar/"+event.getPlayer().getName()+"/256.png";
        String message = event.getMessage();
        textChannel.sendMessage(Objects.requireNonNull(config.getString("minecraftToDiscord")).replace("%player%", event.getPlayer().getName()).replace("%message%", event.getMessage()).replace("%prefix%", config.getString("prefix"))).queue();    }
}
