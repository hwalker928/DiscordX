package org.harrydev.discordx.Bot;

import club.minnced.discord.webhook.WebhookClient;
import club.minnced.discord.webhook.WebhookClientBuilder;
import club.minnced.discord.webhook.send.WebhookEmbed;
import club.minnced.discord.webhook.send.WebhookEmbedBuilder;
import club.minnced.discord.webhook.send.WebhookMessageBuilder;
import org.bukkit.configuration.file.FileConfiguration;
import org.harrydev.discordx.DiscordX;
import org.harrydev.discordx.Utils.Logger;
import org.harrydev.discordx.Utils.MoreUtils;

import java.awt.*;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class webhook {

    private static final DiscordX INSTANCE = DiscordX.getInstance();
    private static WebhookClient webhook;
    public static final Pattern WEBHOOK_PATTERN = Pattern.compile("(?:https?://)?(?:\\w+\\.)?discord(?:app)?\\.com/api(?:/v\\d+)?/webhooks/(\\d+)/([\\w-]+)(?:/(?:\\w+)?)?");
    public static final Pattern shut = Pattern.compile("(?:https?://)?(?:\\w+\\.)?discord\\.com/api(?:/v\\d+)?/webhooks/(\\d+)/([\\w-]+)(?:/(?:\\w+)?)?");
    private static final FileConfiguration config = INSTANCE.getConfig();
    private static final String noPing = INSTANCE.getConfig().getString("nopingmsg").replace("&", "§").replace("%prefix%", config.getString("prefix"));

    public static void Start() {
        CheckURL();
        FixURL();
        WebhookClientBuilder builder = new WebhookClientBuilder(config.getString("webhookURL"));
        builder.setThreadFactory((job) -> {
            Thread thread = new Thread(job);
            thread.setName("Webhook");
            thread.setDaemon(true);
            return thread;
        });
        webhook = builder.build();
    }

    public static boolean CheckURL() {
        if(config.getString("webhookURL").contains("WebhookURLHere")) {
            Logger.warn("Please Set the webhook URL in the config.yml!");
            Logger.warn("Aborting...");
            return false;
        }
        return true;
    }

    public static void sendMessage(String username, String Avatar, String msg) {
        if ((MoreUtils.testForPing(msg))) {
            msg = noPing;
        }
        WebhookMessageBuilder builder = new WebhookMessageBuilder();
        builder.setUsername(username);
        builder.setAvatarUrl(Avatar);
        builder.setContent(msg);
        webhook.send(builder.build());
    }

    public static void sendConsoleMessage(String msg, Color color) {
        WebhookEmbedBuilder embed = new WebhookEmbedBuilder()
                .setAuthor(new WebhookEmbed.EmbedAuthor(msg, null, null))
                .setColor(color.getRGB());
        WebhookMessageBuilder messageBuilder = new WebhookMessageBuilder();
        messageBuilder.addEmbeds(embed.build());
        messageBuilder.setUsername("Console");
        messageBuilder.setAvatarUrl("https://mc-heads.net/avatar/CONSOLE");
        webhook.send(messageBuilder.build());
    }

    public static void FixURL() {
        Matcher matcher = shut.matcher(config.getString("webhookURL"));
        if(matcher.matches()) {
            String bad = config.getString("webhookURL").replace("discord.com", "discordapp.com");
            config.set("webhookURL", bad);
            INSTANCE.saveConfig();
        }
    }
}
