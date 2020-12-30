package org.harrydev.discordx.Events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.TextChannel;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.harrydev.discordx.DiscordX;
import org.harrydev.discordx.Utils.AdvancementTranslator.*;
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
        EmbedBuilder eb = new EmbedBuilder();
        String Avatar = "https://mc-heads.net/avatar/"+event.getPlayer().getName();
        Pattern namespacePattern = Pattern.compile("(/([\\w+]+))");
        Pattern keyPattern = Pattern.compile("([\\w+]+)/");
        Matcher nameMatcher = namespacePattern.matcher(event.getAdvancement().getKey().getKey());
        Matcher keyMatcher = keyPattern.matcher(event.getAdvancement().getKey().getKey());
        String namespace = nameMatcher.replaceAll("");
        String key = keyMatcher.replaceAll("");
        switch (namespace) {
            case "story":
                if(!story.valueOf(key).getChallenge()){
                    eb.setAuthor(event.getPlayer().getDisplayName() + " has completed the Advancement " +  story.valueOf(key).getAdvancement() + "!", null, Avatar);
                } else {
                    eb.setAuthor(event.getPlayer().getDisplayName() + " has completed the Challenge " +  story.valueOf(key).getAdvancement() + "!", null, Avatar);
                }
                eb.setDescription(story.valueOf(key).getDescription());
                break;
            case "nether":
                if(!nether.valueOf(key).getChallenge()){
                    eb.setAuthor(event.getPlayer().getDisplayName() + " has completed the Advancement " +  nether.valueOf(key).getAdvancement() + "!", null, Avatar);
                } else {
                    eb.setAuthor(event.getPlayer().getDisplayName() + " has completed the Challenge " +  nether.valueOf(key).getAdvancement() + "!", null, Avatar);
                }
                eb.setDescription(nether.valueOf(key).getDescription());
                break;
            case "end":
                if(!end.valueOf(key).getChallenge()){
                    eb.setAuthor(event.getPlayer().getDisplayName() + " has completed the Advancement " +  end.valueOf(key).getAdvancement() + "!", null, Avatar);
                } else {
                    eb.setAuthor(event.getPlayer().getDisplayName() + " has completed the Challenge " +  end.valueOf(key).getAdvancement() + "!", null, Avatar);
                }
                eb.setDescription(end.valueOf(key).getDescription());
                break;
            case "adventure":
                if(!adventure.valueOf(key).getChallenge()){
                    eb.setAuthor(event.getPlayer().getDisplayName() + " has completed the Advancement " +  adventure.valueOf(key).getAdvancement() + "!", null, Avatar);
                } else {
                    eb.setAuthor(event.getPlayer().getDisplayName() + " has completed the Challenge " +  adventure.valueOf(key).getAdvancement() + "!", null, Avatar);
                }
                eb.setDescription(adventure.valueOf(key).getDescription());
                break;
            case "husbandry":
                if(!husbandry.valueOf(key).getChallenge()){
                    eb.setAuthor(event.getPlayer().getDisplayName() + " has completed the Advancement " +  husbandry.valueOf(key).getAdvancement() + "!", null, Avatar);
                } else {
                    eb.setAuthor(event.getPlayer().getDisplayName() + " has completed the Challenge " +  husbandry.valueOf(key).getAdvancement() + "!", null, Avatar);
                }
                eb.setDescription(husbandry.valueOf(key).getDescription());
                break;
        }

        eb.setColor(Color.GREEN);
        textChannel.sendMessage(eb.build()).queue();
    }
}
