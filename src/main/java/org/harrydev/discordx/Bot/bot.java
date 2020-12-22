package org.harrydev.discordx.Bot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.TextChannel;
import org.harrydev.discordx.Bot.Commands.HelpCommand;
import org.harrydev.discordx.Bot.Commands.PingCommand;
import org.harrydev.discordx.Bot.Commands.ServerCommand;
import org.harrydev.discordx.Bot.Commands.WhitelistCommand;
import org.harrydev.discordx.Bot.Events.DiscordMessage;
import org.harrydev.discordx.DiscordX;
import org.harrydev.discordx.Utils.Logger;

import javax.security.auth.login.LoginException;
import java.awt.*;
import java.util.Objects;

public class bot {

    private static final DiscordX INSTANCE = DiscordX.getInstance();
    private static final String Token = INSTANCE.getConfig().getString("botToken");
    private static JDA jda;

    public static void Start() {

        if(Token.equals("TokenGoesHere")) {
            Logger.warn("Please modify the config.yml!");
            return;
        }
        Logger.info("Starting the discord bot.");
        JDABuilder jdaBuilder = JDABuilder.createDefault(Token);

        try {
            PingCommand pingCommand = new PingCommand();
            ServerCommand serverCommand = new ServerCommand();
            HelpCommand helpCommand = new HelpCommand();
            WhitelistCommand whitelistCommand = new WhitelistCommand();
            jdaBuilder.addEventListeners(pingCommand);
            jdaBuilder.addEventListeners(serverCommand);
            jdaBuilder.addEventListeners(helpCommand);
            jdaBuilder.addEventListeners(whitelistCommand);
            jdaBuilder.setActivity(Activity.playing("Minecraft"));
            jdaBuilder.addEventListeners(new DiscordMessage());
            jda = jdaBuilder.build();
            jda.awaitReady();
            Logger.info("The bot has started!");
            SendStartup();
        } catch (LoginException | InterruptedException e) {
            Logger.error(e.toString());
        }
    }

    public static JDA getBot() {
        return jda;
    }

    public static void SendStartup() {
        EmbedBuilder eb = new EmbedBuilder().setDescription("Server started!").setColor(Color.GREEN);
        Objects.requireNonNull(jda.getTextChannelById(INSTANCE.getConfig().getLong("chatChannel"))).sendMessage(eb.build()).queue();
    }

    public static void SendShutdown() {
        EmbedBuilder eb = new EmbedBuilder().setDescription("Server stopped!").setColor(Color.RED);
        Objects.requireNonNull(jda.getTextChannelById(INSTANCE.getConfig().getLong("chatChannel"))).sendMessage(eb.build()).queue();
    }

}
