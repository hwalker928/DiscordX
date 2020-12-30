package org.harrydev.discordx.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.harrydev.discordx.Bot.webhook;

import java.awt.*;

public class DeathEvent implements Listener {
    @EventHandler
    public void OnPlayerDeath(PlayerDeathEvent event) {
        webhook.sendConsoleMessage(event.getDeathMessage(), Color.BLACK);
    }
}
