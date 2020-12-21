package org.harrydev.discordx.Bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.harrydev.discordx.DiscordX;
import org.harrydev.discordx.Utils.Logger;

import javax.security.auth.login.LoginException;

public class bot {

    private static final DiscordX INSTANCE = DiscordX.getInstance();
    private static final String Token = INSTANCE.getConfig().getString("botToken");

    public static void Start() {

        if(Token.equals("TokenGoesHere")) {
            Logger.warn("The Token Hasnt Changed");
            Logger.info("");
            return;
        }
        Logger.info("Attempting to start the discord bot.");
        JDABuilder jdaBuilder = JDABuilder.createDefault(Token);

        JDA jda = null;
        try {
            jda = jdaBuilder.build();
            jda.awaitReady();
            Logger.info("Bot Has Started!");
        } catch (LoginException | InterruptedException e) {
            Logger.error(e.toString());
        }
    }
}
