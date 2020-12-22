package org.harrydev.discordx.Bot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.TextChannel;
import org.harrydev.discordx.Bot.Commands.PingCommand;
import org.harrydev.discordx.Bot.Commands.ServerCommand;
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
            PingCommand pingPong = new PingCommand();
            jdaBuilder.addEventListeners(pingPong);
            ServerCommand serverCommand = new ServerCommand();
            jdaBuilder.addEventListeners(serverCommand);
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
        EmbedBuilder eb = new EmbedBuilder().setDescription("Server Started!").setColor(Color.GREEN);
        //Objects.requireNonNull(jda.getTextChannelById(INSTANCE.getConfig().getLong("chatChannel"))).sendMessage(eb.build()).queue();
    }

    public static void SendShutdown() {
        EmbedBuilder eb = new EmbedBuilder().setDescription("Server Shutting Down!").setColor(Color.RED);
        //Objects.requireNonNull(jda.getTextChannelById(INSTANCE.getConfig().getLong("chatChannel"))).sendMessage(eb.build()).queue();
    }

}
