package org.harrydev.discordx.Events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.TextChannel;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.harrydev.discordx.DiscordX;
import org.harrydev.discordx.Utils.Logger;

import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdvancementEvent implements Listener {
    private static final DiscordX INSTANCE = DiscordX.getInstance();

    FileConfiguration config;
    JDA bot;
    TextChannel textChannel;

    public AdvancementEvent(JDA jda) {
        this.bot = jda;
        this.config = INSTANCE.getConfig();
        textChannel = jda.getTextChannelById(INSTANCE.getConfig().getLong("chatChannel"));
    }

    @EventHandler
    public void OnPlayerAdvancement(PlayerAdvancementDoneEvent event) {
        Pattern advancementName = Pattern.compile("([\\w+]+)/");
        Matcher advancementNameMatcher = advancementName.matcher(event.getAdvancement().getKey().getKey());
        String name = advancementNameMatcher.replaceAll("");

        name = name.replaceAll("_", " ");

        EmbedBuilder eb = new EmbedBuilder();
        String Avatar = "https://mc-heads.net/avatar/"+event.getPlayer().getName();

        eb.setColor(Color.GREEN);
        eb.setAuthor(event.getPlayer().getDisplayName() + " has completed the advancement " + name + "!", null, Avatar);
        textChannel.sendMessage(eb.build()).queue();
    }
}
