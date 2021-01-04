package org.harrydev.discordx.Commands.commands;

import org.bukkit.command.CommandSender;
import org.harrydev.discordx.Bot.bot;
import org.harrydev.discordx.Commands.AbstractCommand;
import org.harrydev.discordx.DiscordX;

import java.util.List;

public class DiscordReloadCommand extends AbstractCommand {
    private static DiscordX INSTANCE = DiscordX.getInstance();

    public DiscordReloadCommand() {
        super("dxreload", "discordx.reload", "Reloads the config and restarts the discord bot", false);
    }

    public void onExecute(CommandSender sender, List<String> args) {
        INSTANCE.getRawConfig().reload();
        bot.restart();
    }
}
