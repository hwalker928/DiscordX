package org.harrydev.discordx.Bot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.harrydev.discordx.Bot.Commands.*;
import org.harrydev.discordx.Bot.Events.DiscordMessage;
import org.harrydev.discordx.DiscordX;
import org.harrydev.discordx.Utils.Logger;

import javax.security.auth.login.LoginException;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

@SuppressWarnings("BooleanMethodIsAlwaysInverted")
public class bot {

    private static final DiscordX INSTANCE = DiscordX.getInstance();
    private static final String Token = INSTANCE.getConfig().getString("botToken");
    private static JDA jda;
    private static final String prefix = INSTANCE.getConfig().getString("botPrefix");
    public static boolean tokenIsValid;

    public static void Start() {
        if(!CheckToken(Token)) {
            return;
        }
        Logger.info("Starting the discord bot.");
        JDABuilder jdaBuilder = JDABuilder.createDefault(Token);

        try {
            jdaBuilder.addEventListeners(new DiscordMessage());
            getListeners().forEach(jdaBuilder::addEventListeners);
            jdaBuilder.setActivity(Activity.playing("Minecraft"));
            jda = jdaBuilder.build();
            jda.awaitReady();
            Logger.info("The bot has started!");
            tokenIsValid = true;
            SendStartup();
        } catch (LoginException | InterruptedException e) {
            Logger.error(e.toString());
        }
    }
    public static void shutdown() {
        if(!CheckToken(Token)) {
            return;
        }
        jda.shutdownNow();
    }

    public static JDA getBot() {
        return jda;
    }

    public static String getPrefix() {
        return prefix;
    }

    public static void SendStartup() {
        EmbedBuilder eb = new EmbedBuilder().setDescription("Server started!").setColor(Color.GREEN);
        Objects.requireNonNull(jda.getTextChannelById(INSTANCE.getConfig().getLong("chatChannel"))).sendMessage(eb.build()).queue();
    }

    public static void SendShutdown() {
        EmbedBuilder eb = new EmbedBuilder().setDescription("Server stopped!").setColor(Color.RED);
        Objects.requireNonNull(jda.getTextChannelById(INSTANCE.getConfig().getLong("chatChannel"))).sendMessage(eb.build()).queue();
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        shutdown();
                    }
                },
                2500
        );
    }

    public static boolean CheckToken(String Token) {
        Pattern tokenPattern = Pattern.compile("[a-zA-Z0-9\\-_.]{59}");
        if(Token.equals("TokenGoesHere")) {
            Logger.warn("Please Set the bot token in the config.yml!");
            tokenIsValid = false;
            return false;
        }
        if(!tokenPattern.matcher(Token).matches()){
            Logger.warn("Your Token is Incorrect or Malformed");
            tokenIsValid = false;
            return false;
        }
        return true;
    }

    public static List<ListenerAdapter> getListeners() {
        return Arrays.asList(
                new PingCommand(),
                new ServerCommand(),
                new HelpCommand(),
                new WhitelistCommand(),
                new ListCommand()
        );
    }
}
