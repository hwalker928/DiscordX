package org.harrydev.discordx.Extentions.loader;

import com.google.common.base.Strings;
import org.bukkit.configuration.file.YamlConfiguration;
import org.harrydev.discordx.DiscordX;
import org.harrydev.discordx.Extentions.Extension;
import org.harrydev.discordx.Extentions.MalformedExtensionException;
import org.harrydev.discordx.Utils.Logger;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DiscordXExtensionLoader implements ExtensionLoader{
    private final Set<Extension> extensions = new HashSet<>();

    @Override
    public void loadExtensions() {
        File dir = new File(DiscordX.getInstance().getDataFolder(), "/extensions");
        if(!dir.exists()) {
            dir.mkdirs();
        }

        File[] extensionFiles = dir.listFiles();

        if(extensionFiles == null)
            return;

        for (File extensionFile : extensionFiles) {
            if(!extensionFile.isFile()) continue;

            try {
                loadExtension(extensionFile);
            } catch (MalformedExtensionException e) {
                Logger.error(extensionFile.getName() + " caused MalformedExtensionException: " + e.getMessage());
            }
        }
    }

    private void loadExtension(File extensionFile) throws MalformedExtensionException {
        URL url = null;
        try {
            url = extensionFile.toURI().toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        ClassLoader cl = new URLClassLoader(new URL[]{url}, DiscordX.class.getClassLoader());

        InputStream ymlIn = cl.getResourceAsStream("extension.yml");

        if(ymlIn == null) {
            throw new MalformedExtensionException("No extension.yml found in " + extensionFile.getName());
        }

        File file;
        YamlConfiguration extensionYml = YamlConfiguration.loadConfiguration(new InputStreamReader(ymlIn));

        Set<String> keys = extensionYml.getKeys(false);
        ArrayList<String> required = new ArrayList<>(Arrays.asList("main", "name", "version"));
        required.removeAll(keys);
        if(!required.isEmpty()) {
            throw new MalformedExtensionException("Invalid extension.yml found in " + extensionFile.getName() + " - Missing " + String.join(", ", required));
        }

        String mainClass = extensionYml.getString("main");
        String name = extensionYml.getString("name");
        String version = extensionYml.getString("version");
        Extension.ExtensionMetadata metadata = new Extension.ExtensionMetadata(version, name);

        Class<?> cls;
        Object object = null;
        try {
            cls = cl.loadClass(mainClass);
            object = cls.newInstance();
        } catch (IllegalAccessException | ClassNotFoundException | InstantiationException e) {
            e.printStackTrace();
        }

        if(!(object instanceof Extension))
            throw new MalformedExtensionException(extensionFile.getName() + " is invalid");

        Extension extension = (Extension) object;
        extension.setMetadata(metadata);
        extension.enable();
        extensions.add(extension);
    }

    @Override
    public void unloadExtensions() {
        extensions.forEach(Extension::disable);
        extensions.clear();
    }

    @Override
    public void reloadExtensions() {
        unloadExtensions();
        loadExtensions();
    }

    @Override
    public Set<Extension> getLoadedExtensions() {
        return extensions;
    }
}
