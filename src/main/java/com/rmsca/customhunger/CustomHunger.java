package com.rmsca.customhunger;

import com.rmsca.customhunger.commands.CommandManager;
import com.rmsca.customhunger.listeners.PlayerConsumeListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomHunger extends JavaPlugin {
    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Custom-Hunger is enabled!");
        // Register event
        getServer().getPluginManager().registerEvents(new PlayerConsumeListener(), this);
        // Register command
        getCommand("ch").setExecutor(new CommandManager());
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
