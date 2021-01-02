package org.harrydev.discordx.api;

import net.dv8tion.jda.api.JDA;

public class API implements DiscordXAPI {
    public JDA jda;

    public API(JDA jda)
    {
        this.jda = jda;
    }

    @Override
    public JDA getJDA() {
        return jda;
    }
}
