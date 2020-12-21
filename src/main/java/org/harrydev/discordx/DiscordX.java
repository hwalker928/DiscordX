package org.harrydev.discordx;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import javax.security.auth.login.LoginException;
import java.util.Objects;

public final class DiscordX extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("DiscordX is now initializing.");
        saveDefaultConfig();
        getLogger().info("Attempting to start the discord bot.");
        JDABuilder jdaBuilder = JDABuilder.createDefault(getConfig().getString("botToken"));
        JDA jda = null;
        try {
            jda = jdaBuilder.build();
            ((JDA) jda).awaitReady();
            getLogger().info("Discord bot started.");
        } catch (LoginException | InterruptedException e) {
            e.printStackTrace();
            getLogger().severe("An error occurred.");
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Goodbye!");
    }
}
