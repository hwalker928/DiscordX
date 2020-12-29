package org.harrydev.discordx;

import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.java.JavaPlugin;
import org.harrydev.discordx.Bot.bot;
import org.harrydev.discordx.Bot.webhook;
import org.harrydev.discordx.Commands.AbstractCommand;
import org.harrydev.discordx.Commands.commands.DiscordCommand;
import org.harrydev.discordx.Commands.commands.DiscordXCommand;
import org.harrydev.discordx.Events.EventManager;

import java.util.Arrays;
import java.util.List;


public final class DiscordX extends JavaPlugin {

    private static DiscordX instance;

    @Override
    public void onEnable() {
        new Metrics(this, 9732);
        saveDefaultConfig();
        bot.Start();
        webhook.Start();
        EventManager.register();
        this.getCommands().forEach(AbstractCommand::register);
    }

    @Override
    public void onDisable() {
        if(bot.tokenIsValid) {
            bot.SendShutdown();
        }
        getLogger().info("Goodbye!");
    }

    public void onLoad(){
        instance = this;
    }

    public static DiscordX getInstance() {
        return instance;
    }

    public List<AbstractCommand> getCommands() {
        return Arrays.asList(
                new DiscordCommand(),
                new DiscordXCommand()
        );
    }
}
