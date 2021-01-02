package org.harrydev.discordx.file;

import org.harrydev.discordx.DiscordX;

public class Config extends AbstractFile {

    public Config() {
        super(DiscordX.getInstance(), "config.yml", "", true);
    }
}
