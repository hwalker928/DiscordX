package org.harrydev.discordlink;


import me.leoko.advancedban.bukkit.event.PunishmentEvent;
import me.leoko.advancedban.bukkit.event.RevokePunishmentEvent;
import me.leoko.advancedban.utils.PunishmentType;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.TextChannel;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;

import java.awt.*;


public class PunishmentListener implements @NotNull Listener {

    private FileConfiguration config;
    private DiscordLink plugin;

    JDA bot;
    TextChannel textChannel;


    public PunishmentListener(JDA jda, DiscordLink plugin) {
        this.bot = jda;
        this.plugin = plugin;
        this.config = plugin.getConfig();
        textChannel = jda.getTextChannelById(config.getLong("punishmentChannel"));
    }

    @EventHandler
    public void onPunishment(PunishmentEvent e) {
        String reason = e.getPunishment().getReason().toString();
        String mod = e.getPunishment().getOperator().toString();
        if(e.getPunishment().getType().equals(PunishmentType.BAN)) {
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle(e.getPunishment().getName().toString() + " was banned!");
            embed.addField("Reason:", reason, true);
            embed.addField("Punished by:", mod, true);
            embed.setColor(Color.RED);
            textChannel.sendMessage(embed.build()).queue();
        }
        else if(e.getPunishment().getType().equals(PunishmentType.IP_BAN)) {
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle(e.getPunishment().getName().toString() + " was IP banned!");
            embed.addField("Reason:", reason, true);
            embed.addField("Punished by:", mod, true);
            embed.setColor(Color.RED);
            textChannel.sendMessage(embed.build()).queue();
        }
        else if(e.getPunishment().getType().equals(PunishmentType.KICK)) {
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle(e.getPunishment().getName().toString() + " was kicked!");
            embed.addField("Reason:", reason, true);
            embed.addField("Punished by:", mod, true);
            embed.setColor(Color.ORANGE);
            textChannel.sendMessage(embed.build()).queue();
        }
        else if(e.getPunishment().getType().equals(PunishmentType.MUTE)) {
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle(e.getPunishment().getName().toString() + " was muted!");
            embed.addField("Reason:", reason, true);
            embed.addField("Punished by:", mod, true);
            embed.setColor(Color.YELLOW);
            textChannel.sendMessage(embed.build()).queue();
        }
        else if(e.getPunishment().getType().equals(PunishmentType.TEMP_BAN)) {
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle(e.getPunishment().getName().toString() + " was tempbanned!");
            embed.addField("Reason:", reason, true);
            embed.addField("Punished by:", mod, true);
            embed.addField("Expiry:", e.getPunishment().getDate(e.getPunishment().getEnd()), false);
            embed.setColor(Color.RED);
            textChannel.sendMessage(embed.build()).queue();
        }
        else if(e.getPunishment().getType().equals(PunishmentType.TEMP_IP_BAN)) {
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle(e.getPunishment().getName().toString() + " was temp IP banned!");
            embed.addField("Reason:", reason, true);
            embed.addField("Punished by:", mod, true);
            embed.addField("Expiry:", e.getPunishment().getDate(e.getPunishment().getEnd()), false);
            embed.setColor(Color.RED);
            textChannel.sendMessage(embed.build()).queue();
        }
        else if(e.getPunishment().getType().equals(PunishmentType.TEMP_MUTE)) {
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle(e.getPunishment().getName().toString() + " was tempmuted!");
            embed.addField("Reason:", reason, true);
            embed.addField("Punished by:", mod, true);
            embed.addField("Expiry:", e.getPunishment().getDate(e.getPunishment().getEnd()), false);
            embed.setColor(Color.YELLOW);
            textChannel.sendMessage(embed.build()).queue();
        }
        else if(e.getPunishment().getType().equals(PunishmentType.TEMP_WARNING)) {
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle(e.getPunishment().getName().toString() + " was tempwarned!");
            embed.addField("Reason:", reason, true);
            embed.addField("Punished by:", mod, true);
            embed.addField("Expiry:", e.getPunishment().getDate(e.getPunishment().getEnd()), false);
            embed.setColor(Color.GRAY);
            textChannel.sendMessage(embed.build()).queue();
        }
        else if(e.getPunishment().getType().equals(PunishmentType.WARNING)) {
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle(e.getPunishment().getName().toString() + " was warned!");
            embed.addField("Reason:", reason, true);
            embed.addField("Punished by:", mod, false);
            embed.setColor(Color.GRAY);
            textChannel.sendMessage(embed.build()).queue();
        }

    }

    @EventHandler
    public void onRevoke(RevokePunishmentEvent e) {
        String mod = e.getPunishment().getOperator().toString();
        if(e.getPunishment().getType().equals(PunishmentType.BAN)) {
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle(e.getPunishment().getName().toString() + " was unbanned!");
            embed.addField("Action by:", mod, true);
            embed.setColor(Color.RED);
            textChannel.sendMessage(embed.build()).queue();
        }
        else if(e.getPunishment().getType().equals(PunishmentType.IP_BAN)) {
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle(e.getPunishment().getName().toString() + " was unbanned!");
            embed.addField("Action by:", mod, true);
            embed.setColor(Color.RED);
            textChannel.sendMessage(embed.build()).queue();
        }
        else if(e.getPunishment().getType().equals(PunishmentType.MUTE)) {
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle(e.getPunishment().getName().toString() + " was unmuted!");
            embed.addField("Action by:", mod, true);
            embed.setColor(Color.YELLOW);
            textChannel.sendMessage(embed.build()).queue();
        }
        else if(e.getPunishment().getType().equals(PunishmentType.TEMP_BAN)) {
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle(e.getPunishment().getName().toString() + " was unbanned!");
            embed.addField("Action by:", mod, true);
            //embed.addField("Expiry:", e.getPunishment().getDate(e.getPunishment().getEnd()), false);
            embed.setColor(Color.RED);
            textChannel.sendMessage(embed.build()).queue();
        }
        else if(e.getPunishment().getType().equals(PunishmentType.TEMP_IP_BAN)) {
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle(e.getPunishment().getName().toString() + " was unbanned!");
            embed.addField("Action by:", mod, true);
            //embed.addField("Expiry:", e.getPunishment().getDate(e.getPunishment().getEnd()), false);
            embed.setColor(Color.RED);
            textChannel.sendMessage(embed.build()).queue();
        }
        else if(e.getPunishment().getType().equals(PunishmentType.TEMP_MUTE)) {
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle(e.getPunishment().getName().toString() + " was unmuted!");
            embed.addField("Action by:", mod, true);
            //embed.addField("Expiry:", e.getPunishment().getDate(e.getPunishment().getEnd()), false);
            embed.setColor(Color.YELLOW);
            textChannel.sendMessage(embed.build()).queue();
        }
        else if(e.getPunishment().getType().equals(PunishmentType.TEMP_WARNING)) {
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle(e.getPunishment().getName().toString() + " was unwarned!");
            embed.addField("Action by:", mod, true);
            //embed.addField("Expiry:", e.getPunishment().getDate(e.getPunishment().getEnd()), false);
            embed.setColor(Color.GRAY);
            textChannel.sendMessage(embed.build()).queue();
        }
        else if(e.getPunishment().getType().equals(PunishmentType.WARNING)) {
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle(e.getPunishment().getName().toString() + " was unwarned!");
            embed.addField("Action by:", mod, false);
            embed.setColor(Color.GRAY);
            textChannel.sendMessage(embed.build()).queue();
        }

    }

}
