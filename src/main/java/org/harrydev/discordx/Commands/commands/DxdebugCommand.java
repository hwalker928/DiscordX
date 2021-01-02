package org.harrydev.discordx.Commands.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.event.HandlerList;
import org.harrydev.discordx.Commands.AbstractCommand;
import org.harrydev.discordx.DiscordX;
import org.harrydev.discordx.Utils.Hastebin;
import org.harrydev.discordx.Utils.Lag;
import org.harrydev.discordx.Utils.Logger;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class DxdebugCommand extends AbstractCommand {
    private static DiscordX INSTANCE = DiscordX.getInstance();
    private static String data = "";
    private Hastebin hastebin = new Hastebin();

    public DxdebugCommand() {
        super("dxdebug", "DiscordX.debug", "Debugs DiscordX to help the developers", false);
    }

    @Override
    public void onExecute(CommandSender sender, List<String> args) {
        data += "\n";
        data += "======================== BEGIN DEBUG ========================\n";
        data += INSTANCE.getName() + " » Version " + INSTANCE.getDescription().getVersion() +"\n";
        data += "\n";
        data += "Registered Listeners:\n";
        HandlerList.getRegisteredListeners(INSTANCE).forEach(listener -> {
            data += "├─ " + listener.getListener().getClass().getSimpleName() + "\n";
            data += "│  ├─ " + listener.getPlugin() + "\n";
            data += "│  ├─ " + listener + "\n";
            data += "│  ├─ " + listener.getListener() + "\n";
            data += "│\n";
        });
        data += "│\n";
        data += "Registered Commands:\n";
        INSTANCE.getCommands().forEach(command -> {
            data += "├─ " + command.getName() + "\n";
            data += "│  ├─ " + command + "\n";
            data += "│\n";
        });
        data += "│\n";
        data += "Loaded Plugins:\n";
        Arrays.asList(Bukkit.getPluginManager().getPlugins()).forEach(plugin -> {
            data += "├─ " + plugin.getName() + "\n";
            data += "│  ├─ Enabled: " + plugin.isEnabled() + "\n";
            data += "│  ├─ Authors: \n";
            plugin.getDescription().getAuthors().forEach(author -> data += "│  │  ├─ " + author + "\n");
            data += "│  ├─ Commands: \n";
            plugin.getDescription().getCommands().forEach((s, stringObjectMap) -> data += "│  │  ├─ " + s + "\n");
            data += "│\n";
        });
        data += "│\n";
        data += "Misc Info:\n";
        data += "├─ Server Info\n";
        data += "│  ├─ Server IP: " + Bukkit.getIp() + "\n";
        data += "│  ├─ Server TPS: " + Lag.getTPS() + "\n";
        data += "│  ├─ Server Distro: \n";
        data += "│  │  ├─ Version: " + Bukkit.getVersion() + "\n";
        data += "│  │  ├─ Bukkit Version: " + Bukkit.getBukkitVersion() + "\n";
        data += "│  │  ├─ Alt Version: " + Bukkit.getServer().getVersion() + "\n";
        data += "│  │  ├─ NMS: " + Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3] + "\n";
        data += "│  │  ├─ Motd: " + Bukkit.getServer().getMotd() + "\n";
        data += "├─ Java\n";
        data += "│  ├─ Version: " + System.getProperty("java.version") + "\n";
        data += "│  ├─ Memory: " + (Runtime.getRuntime().maxMemory()/1024/1024/1024) + "\n";
        data += "\n";
        data += "======================== END DEBUG ========================\n";
        data += "\n";
        if(args.contains("nohaste")){
            Arrays.asList(data.split("\n")).forEach(Logger::info);
        } else {
            try {
                String url = hastebin.post(data, false);
                Logger.info("Debug Log: " + url);
                data = "";
            } catch (IOException e) {
                Logger.error("There was an Error: ");
                Logger.error(e.getMessage());
                data = "";
            }
        }
    }
}
