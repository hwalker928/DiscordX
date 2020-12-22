package org.harrydev.discordx.Utils;

import org.bukkit.Bukkit;

public class Functions {

    public static boolean executeConsoleCommand(String command) {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
        return true;
    }
}

