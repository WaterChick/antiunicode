package dev.waterchick.antiunicode;

import dev.waterchick.antiunicode.managers.ConfigManager;
import dev.waterchick.antiunicode.managers.CharManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class Antiunicode extends JavaPlugin {

    private ConfigManager configManager;
    private CharManager charManager;

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.configManager = new ConfigManager(this, new File(this.getDataFolder(), "config.yml"));
        this.configManager.load();
        this.charManager = new CharManager();
        this.charManager.load();

        this.getServer().getPluginManager().registerEvents(new Listener(charManager), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
