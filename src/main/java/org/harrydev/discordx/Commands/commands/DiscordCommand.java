package org.harrydev.discordx.Commands.commands;

import net.dv8tion.jda.api.entities.Guild;
import org.bukkit.command.CommandSender;
import org.harrydev.discordx.Bot.bot;
import org.harrydev.discordx.Commands.AbstractCommand;
import org.harrydev.discordx.DiscordX;

import java.util.List;
import java.util.regex.Pattern;

public class DiscordCommand extends AbstractCommand {
    private static DiscordX INSTANCE = DiscordX.getInstance();

    public DiscordCommand() {
        super("discord", "DiscordX.discord", "Shows the executor the invite link to the discord", false);
    }

    @Override
    public void onExecute(CommandSender sender, List<String> args) {
        Guild guild = bot.getBot().getGuilds().stream().findFirst().get();
        String invite;
        Pattern invitePattern = Pattern.compile("https://discord.gg/[a-zA-Z0-9]{8}");
        if(INSTANCE.getConfig().getString("GuildInvite") != null){
            invite = INSTANCE.getConfig().getString("GuildInvite");
            if(!invitePattern.matcher(invite).matches()){
                invite = guild.getSystemChannel().createInvite().complete().getUrl();
                INSTANCE.getConfig().set("GuildInvite", invite);
                INSTANCE.saveConfig();
            }
        } else {
            invite = guild.getSystemChannel().createInvite().complete().getUrl();
            INSTANCE.getConfig().set("GuildInvite", invite);
            INSTANCE.saveConfig();
        }
        sender.sendMessage(INSTANCE.getConfig().getString("discordJoinMessage").replace("%invite%", invite));
    }
}
