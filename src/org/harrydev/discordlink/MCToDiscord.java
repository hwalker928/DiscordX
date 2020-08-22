package org.harrydev.discordlink;

import me.leoko.advancedban.bukkit.event.PunishmentEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.TextChannel;
import net.milkbowl.vault.Vault;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.Objects;

public class MCToDiscord implements Listener {

    private FileConfiguration config;
    private DiscordLink plugin;

    JDA bot;
    TextChannel textChannel;


    public MCToDiscord(JDA jda, DiscordLink plugin) {
        this.bot = jda;
        this.plugin = plugin;
        this.config = plugin.getConfig();
        textChannel = jda.getTextChannelById(config.getLong("chatChannel"));
    }

    @EventHandler
    public void onMessage(AsyncPlayerChatEvent e) {
        String message = e.getMessage();
        String player = e.getPlayer().getName();
        Permission perm = null;
        textChannel.sendMessage(Objects.requireNonNull(config.getString("minecraftToDiscord")).replace("%player%", player).replace("%message%", message).replace("%rank%", DiscordLink.getPermissions().getPrimaryGroup(e.getPlayer()))).queue();
    }

}
