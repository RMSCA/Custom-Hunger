package com.rmsca.customhunger;
import com.rmsca.customhunger.listeners.PlayerConsumeListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.LogRecord;

public final class CustomHunger extends JavaPlugin {
    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Custom-Hunger is enabled!");
        // Register events
        getServer().getPluginManager().registerEvents(new PlayerConsumeListener(), this);
        // Config
        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Custom-Hunger is disabled!");
    }
}
