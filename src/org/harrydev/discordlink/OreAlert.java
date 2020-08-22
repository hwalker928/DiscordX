package org.harrydev.discordlink;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.TextChannel;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.awt.*;
import java.util.Objects;

public class OreAlert implements Listener {

    private FileConfiguration config;
    private DiscordLink plugin;

    JDA bot;
    TextChannel textChannel;


    public OreAlert(JDA jda, DiscordLink plugin) {
        this.bot = jda;
        this.plugin = plugin;
        this.config = plugin.getConfig();
        textChannel = jda.getTextChannelById(config.getLong("oreChannel"));
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        if (e.getBlock().getType() == Material.DIAMOND_ORE) {
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle(e.getPlayer().getName().toString() + " just broke Diamond Ore!");
            embed.addField("Location:", "X: " + e.getBlock().getLocation().getX() + "\nY: " + e.getBlock().getLocation().getY() + "\nZ: " + e.getBlock().getLocation().getZ(), false);
            embed.addField("World:", Objects.requireNonNull(e.getBlock().getLocation().getWorld()).getName(), false);
            embed.setColor(Color.BLUE);
            textChannel.sendMessage(embed.build()).queue();
        }
    }

}
