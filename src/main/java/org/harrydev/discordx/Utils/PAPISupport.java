package org.harrydev.discordx.Utils;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.harrydev.discordx.Bot.bot;
import org.harrydev.discordx.DiscordX;
import org.jetbrains.annotations.NotNull;

public class PAPISupport extends PlaceholderExpansion {
    private final DiscordX plugin;

    public PAPISupport(DiscordX plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean persist(){
        return true;
    }

    @Override
    public boolean canRegister(){
        return true;
    }

    @Override
    public @NotNull String getAuthor(){
        return plugin.getDescription().getAuthors().toString();
    }

    @Override
    public @NotNull String getIdentifier(){
        return "discordx";
    }

    @Override
    public @NotNull String getVersion(){
        return plugin.getDescription().getVersion();
    }

    @Override
    public String onPlaceholderRequest(Player player, @NotNull String identifier){

        // %someplugin_placeholder1%
        if(identifier.equals("members")){
            return "Coming soon";
            //return String.valueOf((long) bot.getBot().getUsers().size());
            //return "pog";
        }

        return null;
    }
}
