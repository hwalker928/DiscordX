package org.harrydev.discordx;

import org.apache.maven.artifact.versioning.DefaultArtifactVersion;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;
import org.harrydev.discordx.Bot.bot;
import org.harrydev.discordx.Commands.AbstractCommand;
import org.harrydev.discordx.Commands.commands.*;
import org.harrydev.discordx.Events.EventManager;
import org.harrydev.discordx.Extentions.loader.DiscordXExtensionLoader;
import org.harrydev.discordx.Extentions.loader.ExtensionLoader;
import org.harrydev.discordx.Utils.Logger;
import org.harrydev.discordx.Utils.Metrics;
import org.harrydev.discordx.Utils.PAPISupport;
import org.harrydev.discordx.Utils.UpdateChecker;
import org.harrydev.discordx.api.API;
import org.harrydev.discordx.api.DiscordXAPI;
import org.harrydev.discordx.file.Config;

import java.util.Arrays;
import java.util.List;


public final class DiscordX extends JavaPlugin {

    private static DiscordX instance;
    private Config config;
    private final ExtensionLoader loader = new DiscordXExtensionLoader();

    @Override
    public void onEnable() {
        new Metrics(this, 9732);
        config = new Config();
        bot.Start();
        if(!bot.tokenIsValid) {
            Logger.warn("Aborting...");
        }
        API api = new API(bot.getBot());
        Bukkit.getServicesManager().register(DiscordXAPI.class, api,this, ServicePriority.Highest);
        EventManager.register();
        this.getCommands().forEach(AbstractCommand::register);
        loadExtensions();
        registerPAPI();

        Bukkit.getScheduler().runTaskLater(this, DiscordX::postLoad, 1);
    }

    private void loadExtensions() {
        //Logger.info("Loading Extensions");
        getExtensionLoader().loadExtensions();

        if(getExtensionLoader().getLoadedExtensions().isEmpty()) {
            //Logger.info("&cNo extensions found");
        } else {
            Logger.info("Loaded Extensions:");
            getExtensionLoader().getLoadedExtensions().forEach((extension) -> Logger.info("- " + extension.getName() + " v" + extension.getVersion()));
        }
    }

    private void registerPAPI() {
        if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null){
            new PAPISupport(this).register();
            Logger.info("Registered with PlaceHolderAPI.");
        }
        else {
            Logger.warn("PlaceHolderAPI is not detected.");
        }
    }


    @Override
    public FileConfiguration getConfig()
    {
        return config.getConfig();
    }


    public Config getRawConfig() {
        return config;
    }


    @Override
    public void onDisable() {
        if(bot.tokenIsValid) {
            bot.shutdown();
        }
        getLogger().info("Goodbye!");
    }


    public void onLoad(){
        instance = this;
    }

    public static void postLoad() {
        new UpdateChecker(DiscordX.getInstance(), 87421).getVersion((version) -> {
            DefaultArtifactVersion currentVersion = new DefaultArtifactVersion(DiscordX.getInstance().getDescription().getVersion());
            DefaultArtifactVersion mostRecentVersion = new DefaultArtifactVersion(version);
            if(!(currentVersion.compareTo(mostRecentVersion) > 0 || currentVersion.equals(mostRecentVersion))) {
                UpdateChecker.setOutdated(true);
                UpdateChecker.setNewVersion(version);
                Bukkit.getScheduler().runTaskTimer(DiscordX.getInstance(), () -> {
                    Logger.info("&cDiscordX is out of date! (Version " + DiscordX.getInstance().getDescription().getVersion() + ")");
                    Logger.info("&cThe newest version is &f " + version);
                    Logger.info("&cGet the latest version here:&f https://www.spigotmc.org/resources/discordx.87421/");
                }, 0, 864000);
            }
        });
    }
    public static DiscordX getInstance() {
        return instance;
    }

    public ExtensionLoader getExtensionLoader() {
        return loader;
    }

    public List<AbstractCommand> getCommands() {
        return Arrays.asList(
                new DiscordCommand(),
                new DiscordXCommand(),
                new DxdebugCommand(),
                new DiscordReloadCommand()
        );
    }
}
