package org.harrydev.discordx.Commands.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.harrydev.discordx.Commands.AbstractCommand;
import org.harrydev.discordx.DiscordX;
import org.harrydev.discordx.Utils.Logger;

import java.util.List;

public class DiscordXCommand extends AbstractCommand {
    private static DiscordX INSTANCE = DiscordX.getInstance();

    public DiscordXCommand() {
        super("DiscordX", "discordx.discordx", "Shows the Commands for DiscordX", false);
    }

    @Override
    public void onExecute(CommandSender sender, List<String> args) {
        Logger.info("");
        Logger.info(INSTANCE.getName() + " » Version " + INSTANCE.getDescription().getVersion() + " Created By " + INSTANCE.getDescription().getAuthors());
        INSTANCE.getCommands().forEach(command -> {
            Logger.info("- " + command.getName() + " - " + command.getDescription());
        });
        Logger.info("");
    }
}
