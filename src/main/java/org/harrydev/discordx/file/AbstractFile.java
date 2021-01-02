package org.harrydev.discordx.file;


import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.harrydev.discordx.DiscordX;

import java.io.File;
import java.io.IOException;

public class AbstractFile {
    protected DiscordX plugin;
    private File file;
    protected FileConfiguration configuration;
    protected Boolean save;


    public AbstractFile(DiscordX main,String filename,String datafolder,Boolean save)
    {
        this.plugin = main;
        File file1 = new File(main.getDataFolder() + datafolder);

        if(!file1.exists())
        {
            file1.mkdirs();
        }

        file = new File(file1,filename);
        if(!file.exists())
        {
            if(save)
            {
                DiscordX.getInstance().saveResource(filename,false);
                configuration = YamlConfiguration.loadConfiguration(file);
                return;
            }

            try
            {
                file.createNewFile();
            }catch (Exception exp)
            {
                exp.printStackTrace();
            }
        }

        configuration = YamlConfiguration.loadConfiguration(file);
    }

    public void save(){
        try{
            configuration.save(file);
        }catch(IOException e){
            DiscordX.getInstance().getLogger().info("[DiscordX] Unable to save configuration file. filename: " + file.getName());
        }
    }
    public FileConfiguration getConfig(){
        return configuration;
    }

    public void reload(){
        configuration = YamlConfiguration.loadConfiguration(file);
    }

    public void delete() {
        file.delete();
    }
}
