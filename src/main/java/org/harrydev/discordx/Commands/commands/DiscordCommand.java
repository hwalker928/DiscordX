package org.harrydev.discordx.Commands.commands;

import net.dv8tion.jda.api.entities.Guild;
import org.bukkit.command.CommandSender;
import org.harrydev.discordx.Bot.bot;
import org.harrydev.discordx.Commands.AbstractCommand;
import org.harrydev.discordx.DiscordX;

import java.util.List;

public class DiscordCommand extends AbstractCommand {
    private static DiscordX INSTANCE = DiscordX.getInstance();

    public DiscordCommand() {
        super("discord", "DiscordX.discord", false);
    }

    @Override
    public void onExecute(CommandSender sender, List<String> args) {
        Guild guild = bot.getBot().getGuilds().stream().findFirst().get();
        String invite = guild.getSystemChannel().createInvite().complete().getUrl();
        sender.sendMessage(INSTANCE.getConfig().getString("discordJoinMessage").replace("%invite%", invite));
    }
}
