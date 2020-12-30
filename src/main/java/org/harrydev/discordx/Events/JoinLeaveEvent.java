package org.harrydev.discordx.Events;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.harrydev.discordx.Bot.webhook;

import java.awt.*;

public class JoinLeaveEvent implements Listener {
    @EventHandler
    public void OnPlayerJoin(PlayerLoginEvent event) {
        webhook.sendConsoleMessage(event.getPlayer().getName() + " joined the server", Color.GREEN);
    }

    @EventHandler
    public void OnPlayerLeave(PlayerQuitEvent event) {
        webhook.sendConsoleMessage(event.getPlayer().getName() + " left the server", Color.RED);
    }
}
