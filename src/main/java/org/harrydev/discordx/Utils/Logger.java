package org.harrydev.discordx.Utils;

import org.harrydev.discordx.DiscordX;

public class Logger {
    private static final DiscordX INSTANCE = DiscordX.getInstance();

    public static void info(String message) {
        INSTANCE.getLogger().info(StringUtils.translate(message));
    }

    public static void warn(String message) {
        INSTANCE.getLogger().warning(StringUtils.translate(message));
    }

    public static void error(String message) {
        INSTANCE.getLogger().severe(StringUtils.translate(message));
    }
}
