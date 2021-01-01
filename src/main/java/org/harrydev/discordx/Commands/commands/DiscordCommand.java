package org.harrydev.discordx.Commands.commands;

import net.dv8tion.jda.api.entities.Guild;
import org.bukkit.command.CommandSender;
import org.harrydev.discordx.Bot.bot;
import org.harrydev.discordx.Commands.AbstractCommand;
import org.harrydev.discordx.DiscordX;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class DiscordCommand extends AbstractCommand {
    private static DiscordX INSTANCE = DiscordX.getInstance();

    public DiscordCommand() {
        super("discord", "discordx.discord", "Shows the executor the invite link to the discord", false);
    }

    @Override
    public void onExecute(CommandSender sender, List<String> args) {
        if (bot.getBot().getGuilds().size() == 1) {
            Guild guild = bot.getBot().getGuilds().stream().findFirst().get();
            String invite = Objects.requireNonNull(guild.getSystemChannel()).createInvite().setMaxAge(0).complete().getUrl();
            INSTANCE.getConfig().set("guildInvite", invite);
            INSTANCE.saveConfig();
            sender.sendMessage(INSTANCE.getConfig().getString("discordJoinMessage").replace("%invite%", invite));
        }
        else {
            sender.sendMessage("&cThe discord bot has not been invited to a guild. Please do so before continuing.".replace("&", "§"));
        }
    }
}
