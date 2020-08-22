package org.harrydev.discordlink;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import javax.security.auth.login.LoginException;
import java.util.Objects;

public class DiscordLink extends JavaPlugin {

    private static Permission perms = null;

    @Override
    public void onEnable() {

        setupPermissions();

        saveDefaultConfig();
        if(Objects.equals(getConfig().getString("botToken"), "TokenGoesHere")) {
            Bukkit.getConsoleSender().sendMessage("The config has not been changed. The plugin will now kick out some errors! Have fun! :)");
            //getServer().getPluginManager().disablePlugin(this);
        }
        Bukkit.getConsoleSender().sendMessage("Attempting to start the discord bot.");
        JDABuilder jdaBuilder = JDABuilder.createDefault(getConfig().getString("botToken"));
        if(getConfig().getBoolean("botStatusEnabled")) {
            if (Objects.equals(getConfig().getString("botType"), "playing")) {
                jdaBuilder.setActivity(Activity.playing(Objects.requireNonNull(getConfig().getString("botStatus"))));
            }
            if (Objects.equals(getConfig().getString("botType"), "listening")) {
                jdaBuilder.setActivity(Activity.listening(Objects.requireNonNull(getConfig().getString("botStatus"))));
            }
            if (Objects.equals(getConfig().getString("botType"), "watching")) {
                jdaBuilder.setActivity(Activity.watching(Objects.requireNonNull(getConfig().getString("botStatus"))));
            }
        }
        JDA jda = null;
        try {
            PingCommand pingPong = new PingCommand(this);
            DiscordToMC DiscordToMC = new DiscordToMC(this);
            jdaBuilder.addEventListeners(pingPong);
            if(getConfig().getBoolean("chatEnabled")) {
                jdaBuilder.addEventListeners(DiscordToMC);
            }
            jda = jdaBuilder.build();
            jda.awaitReady();
            Bukkit.getConsoleSender().sendMessage("Discord bot started.");
        } catch (LoginException | InterruptedException e) {
            e.printStackTrace();
            Bukkit.getConsoleSender().sendMessage("An error occurred.");
        }
        assert jda != null;
        if(getConfig().getBoolean("punishmentEnabled")) {
            getServer().getPluginManager().registerEvents(new PunishmentListener(jda, this), this);
        }
        if(getConfig().getBoolean("chatEnabled")) {
            getServer().getPluginManager().registerEvents(new MCToDiscord(jda, this), this);
            //getServer().getPluginManager().registerEvents(new DiscordToMC(this), this);
        }
        if(getConfig().getBoolean("commandWatcherEnabled")) {
            getServer().getPluginManager().registerEvents(new CommandToDiscord(jda, this), this);
            //getServer().getPluginManager().registerEvents(new DiscordToMC(this), this);
        }
        if(getConfig().getBoolean("oreEnabled")) {
            getServer().getPluginManager().registerEvents(new OreAlert(jda, this), this);
            //getServer().getPluginManager().registerEvents(new DiscordToMC(this), this);
        }

    }

    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        assert rsp != null;
        perms = rsp.getProvider();
        return true;
    }

    public static Permission getPermissions() {
        return perms;
    }

}
