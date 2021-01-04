package org.harrydev.discordx.Extentions.loader;

import org.harrydev.discordx.Extentions.Extension;

import java.util.Set;

public interface ExtensionLoader {
    void loadExtensions();

    void unloadExtensions();

    void reloadExtensions();

    Set<Extension> getLoadedExtensions();
}
