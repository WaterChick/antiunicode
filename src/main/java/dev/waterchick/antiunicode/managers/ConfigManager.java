package dev.waterchick.antiunicode.managers;

import dev.waterchick.antiunicode.Antiunicode;
import dev.waterchick.antiunicode.enums.ConfigValue;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ConfigManager {

    private final Antiunicode plugin;
    private final File file;
    private YamlConfiguration config;

    public ConfigManager(Antiunicode plugin, File file){
        this.file = file;
        this.plugin = plugin;
    }

    public void reload(){
        load();
    }

    public void load(){
        createCustomConfig();

        this.config = new YamlConfiguration();
        try {
            this.config.load(file);
            loadConfigValues();
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    private void createCustomConfig() {
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            plugin.saveResource("config.yml", false);
        }
    }

    private void loadConfigValues(){
        for(String key : config.getKeys(false)){
            String upperKey = key.toUpperCase();
            try{
                ConfigValue configValue = ConfigValue.valueOf(upperKey);
                List<String> stringList = config.getStringList(key);
                if(stringList.isEmpty()){
                    configValue.setValue(config.getString(key));
                }else{
                    configValue.setValueList(stringList);
                }
                //System.out.println(key + " " + stringList);
            }catch (IllegalArgumentException ignored){ continue; };
        }
    }

}
